import React from 'react';
import echarts from 'echarts/lib/echarts' 
import 'echarts/lib/chart/line'
// 引入柱状图
import  'echarts/lib/chart/bar';
// 引入提示框和标题组件
import 'echarts/lib/component/tooltip';
import 'echarts/lib/component/title';

import {getTraceByDay,getTraceOfIps} from '../../services/monitor'

class Chart extends React.Component {

  state = {
    legend: {},
    categoryData: [],
    series: []
  }

  componentDidMount() {
    this.createData()
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));
    // 绘制图表
    myChart.setOption({
      title: {
        text: '折线图堆叠'
      },
      tooltip: {
          trigger: 'axis'
      },
      legend: {
          data:['邮件营销','联盟广告','视频广告','直接访问','搜索引擎']
      },
      grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
          containLabel: true
      },
      toolbox: {
          feature: {
              saveAsImage: {}
          }
      },
      xAxis: {
          type: 'category',
          boundaryGap: false,
          data: ['周一','周二','周三','周四','周五','周六','周日']
      },
      yAxis: {
          type: 'value'
      },
      series: [
          {
              name:'邮件营销',
              type:'line',
              stack: '总量',
              data:[120, 132, 101, 134, 90, 230, 210]
          },
          {
              name:'联盟广告',
              type:'line',
              stack: '总量',
              data:[220, 182, 191, 234, 290, 330, 310]
          },
          {
              name:'视频广告',
              type:'line',
              stack: '总量',
              data:[150, 232, 201, 154, 190, 330, 410]
          },
          {
              name:'直接访问',
              type:'line',
              stack: '总量',
              data:[320, 332, 301, 334, 390, 330, 320]
          },
          {
              name:'搜索引擎',
              type:'line',
              stack: '总量',
              data:[820, 932, 901, 934, 1290, 1330, 1320]
          }
      ]
    });
  }

  createData = async () => {
    const ips = await getTraceOfIps()
    console.log('ips',ips)
    if(ips) {
      this.setState({
        legend: {
          data: ips
        }
      })
    }
    const trace = await getTraceByDay()
    console.log('trace',trace)
    // todo
    // 这个其实不应该放在前端处理
    
  }



  render() {
    return (
      <div>
        Chart
        <div id="main" style={{ width: '100%', height: 400 }}></div>
      </div>
    )
  }
}

export default Chart