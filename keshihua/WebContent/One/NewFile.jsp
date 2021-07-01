<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <title>ECharts</title>
    <!-- 引入 echarts.js -->
    <script src="${pageContext.request.contextPath}/js/echarts.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
</head>
<body>



    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="width: 1300px;height:400px;"></div>
    
    
    <form action="${pageContext.request.contextPath}/OneServlet?method=biao"method="post">
    	<p>请按照给定的样例输入<input type="text"placeholder="2020-02-08 02:28:59"name="date"style="width:300px;height:80">&nbsp;&nbsp;&nbsp;&nbsp;<span><input type="submit" value="查询"style="width:120px;height:35px;margin-left:40%;background-color:#bdd7f2"></span></p>
    </form>
    
    
    
    
    <table align="center" border="1"id="tbl">
    <thead>
<tr>
<td>省份</td>
<td>城市</td>
<td>确诊人数</td>
<td>疑似人数</td>
<td>治愈人数</td>
<td>死亡人数</td>

</tr>
</thead>
<tbody>
<c:forEach  var="stu" items="${all}" >
	       <tr>
	       <td>${stu.getShengfen() }</td>
	        <td>${stu.getChengshi() }</td>
	         <td>${stu.getQuezhen() }</td>
	          <td>${stu.getYisi() }</td>
	           <td>${stu.getZhiyu() }</td>
	            <td>${stu.getSiwang() }</td>
		   </tr>
</c:forEach>
</tbody>
</table>
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    <script type="text/javascript">
    
    
    
    window.onload = function()
	{
		var tbl=document.getElementById("tbl");
		var len=tbl.tBodies[0].rows.length;
		for(var i=0;i<len;i++)
			{
				if(i%2==0)
					{
						tbl.tBodies[0].rows[i].style.backgroundColor="pink";
					}
				else
					{
					 	tbl.tBodies[0].rows[i].style.backgroundColor="gold";
					}
			}
	
    
    
    
    
    
    
    
    
  
        // 基于准备好的dom，初始化echarts实例
        var sheng=new Array();
        var renshu=new Array();
        var now=new Date().getTime();  
        //alert(now);
        $.getJSON("${pageContext.request.contextPath}/Servlet?now="+now, null)  //"registerServlet"是目标网址要换成你的，data是要提交的数据,要求是json格式
            .done(function(message) { //成功时接收返回的message，只有json格式数据能传到这里，所以在传过来之前就要构造好json数据
        	$.each(message,function(i,value){
       			sheng.push(value.shengfen);
       			renshu.push(value.renshu);
    	    });   
        //alert("wobuhao");
         console.log(sheng);
         console.log(renshu);
 			var myChart = echarts.init(document.getElementById('main'));
 			var option = {
 		            title: {
 		                text: '该时间内信息'
 		            },
 		            tooltip: {
 		            	show: true
 		            },
 		            legend: {
 		                data:['人数']
 		            },
 		            xAxis: {
 		            	

 		                data:sheng,
 		               "axisLabel":{
 	 		           		interval: 0,
 	 		           	    rotate:50  
 	 		           	}
 		                
 		            },
 		            yAxis: {},
 		            series: [{
 		                name: '人数',
 		                type: 'bar',
 		                data:renshu,
 		               itemStyle: {
 		                   normal: {
 		                       label: {
 		                           show: true,		//开启显示
 		                           position: 'top',	//在上方显示
 		                           textStyle: {	    //数值样式
 		                               color: 'black',
 		                               fontSize: 16
 		                           }
 		                       }
 		                   }
 		               }
 		
 	
 		            }]
 		        };
         myChart.setOption(option,true);
         
        	
        	    })
            .fail(function(fail) {  //失败时的事件，这个失败是访问目标网址失败
                alert("获取信息失败");
        });
        //alert("结束");
        
	}
    

        // 使用刚指定的配置项和数据显示图表。
    </script>
    
</body>
</html>

