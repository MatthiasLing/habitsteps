<template>
  <div style="margin-top: 20px">
    <apexchart
      width="600"
      height="400px"
      type="area"
      style="margin-left: 20px"
      :options="chartOptions"
      :series="series"
    ></apexchart>
  </div>
</template>

<script>
import VueApexCharts from "vue-apexcharts";
import userStuff from "../../modules/user";
import moment from "moment";

var { updateHabit, days } = userStuff();

export default {
  name: "AreaChart",
  created() {
    this.init();
  },
  methods: {
    toolTip({ series, seriesIndex, dataPointIndex, w }) {
      return (
        '<div class="arrow_box">' +
        "<span>" +
        series[seriesIndex][dataPointIndex] +
        ":" +
        w.globals.labels[dataPointIndex] +
        "</span>" +
        "</div>"
      );
    },

    init() {

      days.value.sort((a, b) => (a.date > b.date ? 1 : -1));
      console.log(days.value);

      const daySum = (accumulator, currentValue) => { 
        if (currentValue.status >= currentValue.target){ 
            accumulator += 1
        }
        return accumulator;
      };


      var tempVals = [];
      var tempLabels = [];

      for (var i = days.value.length-1; i >=0; i-=1) {
        var cnt = days.value[i].habits.reduce(daySum,0)

        tempVals.push(parseInt(cnt, 10));
        var date = new Date(days.value[i].date);
        tempLabels.push(date);

        if (i > 0){
          var temp = new Date(date - 1000*60*60*24)
          var prev = new Date(days.value[i-1].date);

          while (temp - prev > 0){
            tempVals.push(0);
            tempLabels.push(temp);
            temp = new Date(temp - 1000*60*60*24)
          }
        }

        if (tempVals.length > 100){
          break;
        }
      }

      tempVals.reverse();
      tempLabels.reverse();
      var arr = []

      for (var j=0;j<tempVals.length;j++){
        arr.push([tempLabels[j].getTime(), tempVals[j]])
      }

      this.series = [
        {
          name: "Completed",
          data: arr,
        },
      ];

      this.chartOptions= {
            chart: {
              id: 'area-datetime',
              type: 'area',
              height: 350,
              zoom: {
                autoScaleYaxis: true
              }
            },

            dataLabels: {
              enabled: false
            },
            markers: {
              size: 0,
              style: 'hollow',
            },
            xaxis: {
              type: 'datetime',
              tickAmount: 6,
            },
            tooltip: {
              x: {
                format: 'dd MMM yyyy'
              }
            }
          };



    },
  },
  data: function () {
    return {
     
      series: [
        {
          name: "Habits completed",
          data: [],
        },
      ],
    };
  },
};





</script>