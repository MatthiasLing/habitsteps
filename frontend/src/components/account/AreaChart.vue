<template>
  <div>
    <apexchart
      width="600"
      type="area"
      :options="chartOptions"
      :series="series"
    ></apexchart>
    <button @click="this.updateChart">EDIT</button>
  </div>
</template>

<script>
import VueApexCharts from "vue-apexcharts";
export default {
  name: "AreaChart",
  methods: {
    toolTip({series, seriesIndex, dataPointIndex, w}) {
    return '<div class="arrow_box">' +
      '<span>' + series[seriesIndex][dataPointIndex] + ":"+ w.globals.labels[dataPointIndex] + '</span>' +
      '</div>'
  },
    updateChart() {
      const max = 90;
      const min = 20;
      const newData = this.series[0].data.map(() => {
        return Math.floor(Math.random() * (max - min + 1)) + min;
      });
      // In the same way, update the series option
      this.series = [
        {
          data: newData,
        },
      ];
      this.chartOptions = {
        xaxis: {
          dataLabels: false,
          categories: [1991, 1992, 1993, 1994, 1995, 1996, 1997, 1999],
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
          enabled: false,
        },

        // 
        tooltip: {
          enabled: true,
          enabledOnSeries: undefined,
          shared: true,
          followCursor: false,
          intersect: false,
          inverseOrder: false,
  custom: this.toolTip ,       fillSeriesColor: true,
          theme: false,
          style: {
            fontSize: "12px",
            fontFamily: undefined,
            color: "white"
          },
          onDatasetHover: {
            highlightDataSeries: true,
          },
          x: {
            show: false,
            // format: "dd MMM",
            // this is what goes on the x axis
            formatter: null,
          },
          y: {
            formatter: undefined,
            title: {
              formatter: (seriesName) => "Habits completed: ",
            },
          },
          z: {
            formatter: (seriesName) => "Habits completed: ",

          },
          marker: {
            show: true,
          },
          // items: {
          //    display: flex,
          // },
          fixed: {
            enabled: false,
            position: "topRight",
            offsetX: 0,
            offsetY: 0,
          },
        },
      },
      series: [
        {
          name: "series-1",
          data: [
            30,
            40,
            35,
            50,
            49,
            60,
            70,
            91,
            92,
            93,
            94,
            95,
            96,
            97,
            98,
            99,
          ],
        },
      ],
    };
  },
};
</script>