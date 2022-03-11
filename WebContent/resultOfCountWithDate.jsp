<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>考勤分布图</title>
<!-- 使用单文件引入的方式使用ECharts.JS -->
<script src="echarts.js"></script>
</head>
<body>

     <div align="center">
        <h1 style="color: black;">考勤分布列表</h1>
        <table class="tb">
            <tr>
                <td>日期</td>
                <td>出勤人数</td>
            </tr>
            <c:forEach items="${list}" var="item">
                <tr>
                    <td>${item.date}</td>
                    <td>${item.count}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
<div id="main" style="width: 600px;height:400px;"></div>
  <script type="text/javascript">
      // 基于准备好的dom，初始化echarts实例
      var myChart = echarts.init(document.getElementById('main'));

      var arr = new Array();
      var index = 0;
      <c:forEach items="${list}" var="yi">
          arr[index++] = ${yi.count};
      </c:forEach>

      // 指定图表的配置项和数据
      var option = {
          title: {
              text: '考勤分布图'
          },
          tooltip: {
              show: true
          },
          legend: {
              data:['每天考勤记录数']
          },
          xAxis : [
              {
                  type : 'category',
                  data : [
                      <c:forEach items="${list}" var="y">
                      ["${y.date}"],
                      </c:forEach>
                  ],
                  "axisLabel":{
              		interval: 0
              	}
              }
          ],
          yAxis : [
              {
                  type : 'value'
              }
          ],
          series : [
              {
                  name:'count',
                  type:'bar',
                  data: arr
              }
          ]
      };
       
      // 使用刚指定的配置项和数据显示图表。
      myChart.setOption(option);
  </script>

</body>
</html>