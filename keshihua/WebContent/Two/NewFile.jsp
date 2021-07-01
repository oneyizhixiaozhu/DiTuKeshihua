<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script src="${pageContext.request.contextPath}/js/echarts.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
<script src="http://echarts.baidu.com/build/dist/echarts.js"></script>
<div id="mainMap" style="height:300px;width:600px;"></div>


<form action="${pageContext.request.contextPath}/TwoServlet"method="post"style="margin-top:450px">
    	<p>请按照给定的样例输入<input type="text"placeholder="2020-02-08 02:28:59"name="date"style="width:300px;height:80"><span><input type="submit" value="查询"style="width:120px;height:35px;margin-left:400px;background-color:#bdd7f2"></span></p>
    </form>
    
    
    
    
    
<script type="text/javascript">
    var mapDataJson='${mapDataJson}';
    var json=JSON.parse(mapDataJson);
    var quezhen;
    var yisi;
    var zhiyu;
    var siwang;
    // 路径配置
    require.config({
        paths: {
            echarts: 'http://echarts.baidu.com/build/dist'
        }
    });
    // 使用
    require(
            [
                'echarts',
                'echarts/chart/map' // 使用柱状图就加载bar模块，按需加载
            ],
            function (ec) {
                // 基于准备好的dom，初始化echarts图表
                var myChart_map = ec.init(document.getElementById('mainMap'));

                var itemStyle = {
                    normal:{label:{
                        show:true,
                        formatter:'{b}',
                        textStyle: {fontSize: 10,fontWeight : 'bold'}
                    }},
                    emphasis:{label:{show:true}}
                };

                var option_map = {
                    title : {
                        text: '',
                        subtext: '应用使用次数',
                        x:'center'
                    },
                    tooltip : {
                        trigger: 'item'
                    },
                    legend: {
                        orient: 'vertical',
                        x:'left',
                        data:['次数']
                    },
                    dataRange: {
                        min: 0,
                        max: 2500,
                        x: 'left',
                        y: 'bottom',
                        text:['高','低'],           // 文本，默认为数值文本
                        calculable : true
                    },

                    series : [
                        {
                            name: '总数',
                            type: 'map',
                            mapType: 'china',
                            roam: false,
//                            itemStyle:{
//                                normal:{label:{show:true}},
//                                emphasis:{label:{show:true}}
//                            },
                            itemStyle: itemStyle,
                            data:getData()
                        }

                    ]
                };

                //option_map.series[0].data=json;  
				
              

                
                // 为echarts对象加载数据
                myChart_map.setOption(option_map);
                myChart_map.on('click', function (params) {
                    var city = params.name;
                    alert(city);
                    var now=new Date().getTime(); 
                    var params = {};
                    params["shenfen"] = city;
                    $.getJSON("Message", { shengfen: city}, function(json){
                    	  alert("确诊人数："+json.quezhen+" 疑似人数："+json.yisi+" 治愈人数："+json.zhiyu+" 死亡人数："+json.siwang);
                    	});
                    
                    
                    
                    
                    
                });
            }
    );
    function getData(){
        return json;
        }
</script>

</body>
</html>