<template>
  <div style ="margin-top:20px">
    <apexchart
      width="600"
      height = "400px"
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

      var tempVals = [];
      var tempLabels = [];

      for (var i = 0; i < days.value.length; i++) {
        var cnt = 0;
        for (var j = 0; j < days.value[i].habits.length; j++) {
          if (
            days.value[i].habits[j].status >= days.value[i].habits[j].target
          ) {
            cnt += 1;
          }
        }
        tempVals.push(parseInt(cnt, 10));
        var date = new Date(days.value[i].date);
        tempLabels.push(date.getMonth() + 1 + "/" + date.getDate());
      }

      this.series = [
        {
          name: "Completed",
          data: tempVals,
        },
      ];

      this.chartOptions = {
        xaxis: {
          dataLabels: false,
          categories: tempLabels,
        },
      };
    },
  },
  data: function () {
    return {
      chartOptions: {
        chart: {
          id: "area",
        },
        xaxis: {
          categories: [],
        },
        dataLabels: {
          enabled: true,
        },

        //
        tooltip: {
          custom: function ({ series, seriesIndex, dataPointIndex, w }) {
            return (
              '<div class="arrow_box">' +
              "<span>" +
              series[seriesIndex][dataPointIndex] +
              "</span>" +
              "</div>"
            );
          },
        },
      },
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