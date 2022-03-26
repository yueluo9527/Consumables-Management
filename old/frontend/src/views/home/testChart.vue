<!--    test chart.js-->
<template>
  <div class="testChart">
    <!--    <canvas id="myChart" width="400px" height="400px"></canvas>-->
    <div id="vender" style="width: 600px;height: 600px"></div>
  </div>
</template>
<!--    test chart.js end-->
<script>
export default {
  name: "testChart",

  data() {
    return {}
  },
  mounted() {
    this.drawVenderChart();

  },
  methods: {
    drawVenderChart() {
      //this.vender= this.$echarts.init(document.getElementById("vender"));
      this.vender = this.$echarts.init(document.getElementById("vender"));
      this.vender.setOption({
        //设置标题,副标题,以及标题位置居中
        title: {
          text: '(柱形图)',
          //subtext: '纯属虚构',
          x: 'center'
        },
        //具体点击某一项触发的样式内容
        tooltip: {
          trigger: 'item',
          formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        //左上侧分类条形符
        legend: {
          orient: 'vertical',
          left: 'left',
          data: []
        },
        xAxis: [
          {
            type: 'category',
            data: ['ex1', 'ex2', 'ex3', 'ex4', 'ex5']
          }
        ],
        yAxis: [
          {
            type: 'value',
            axisLabel: {
              formatter: '{value} '
            },
            splitNumber: 10
          }
        ],
        //饼状图类型以及数据源
        series: [
          {
            name: '统计数量',
            type: 'bar',
            data: [11, 15, 13, 12, 11],
            //radius: '70%',
            //center: ['50%', '60%'],
            //设置饼状图扇形区域的样式
            itemStyle: {
              emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
              }
            },
          }
        ],

      });
    }
  }
}
</script>

<style scoped>

</style>
