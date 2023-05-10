<template >
  <div  >
    <div >
      <el-row :gutter="20">
        <el-col :span="6">
          <el-card>
            <div style="color: dodgerblue ;text-align: center"><strong>用户总数</strong></div>
            <div style="padding: 10px 0;text-align: center;font-weight: bold">
              100
            </div>
          </el-card>
        </el-col>
        <el-col :span="6">
          <el-card>
            <div style="color: dodgerblue ;text-align: center"><strong>日访问数</strong></div>
            <div style="padding: 10px 0;text-align: center;font-weight: bold">
              100
            </div>
          </el-card>
        </el-col>
        <el-col :span="6">
          <el-card>
            <div style="color: dodgerblue ;text-align: center"><strong>日刷题数</strong></div>
            <div style="padding: 10px 0;text-align: center;font-weight: bold">
              100
            </div>
          </el-card>
        </el-col>
        <el-col :span="6">
          <el-card>
            <div style="color: dodgerblue ;text-align: center"><strong>试题总数</strong></div>
            <div style="padding: 10px 0;text-align: center;font-weight: bold">
              100
            </div>
          </el-card>
        </el-col>
      </el-row>
    </div>

    <div id="main" style="width: 500px;height: 400px"></div>
  </div>
</template>

<script>
import * as echarts from 'echarts';
export default {
  name: "Home",
  data() {
    return {
      like: true,
      value1: 4154.564,
      value2: '1',
      title: '今年的增长',
    };
  },
  mounted() {
    var chartDom = document.getElementById('main');
    var myChart = echarts.init(chartDom);
    var option= {
      xAxis: {
        type: 'category',
        data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
      },
      yAxis: {
        type: 'value'
      },
      series: [
        {
          data: [150, 230, 224, 218, 135, 147, 260],
          type: 'line'
        },
        {
          data: [150, 230, 224, 218, 135, 147, 260],
          type: 'bar'
        }
      ]
    };
    myChart.setOption(option);
  }
}
</script>
<style scoped >

</style>