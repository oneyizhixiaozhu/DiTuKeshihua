<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset=utf-8>
    <meta name=viewport content="width=device-width,initial-scale=1">
    <title>Echarts Map</title>
    <style>
        #app{
            width: 1000px;
            height: 500px;
        }
    </style>
</head>

<body>
    <div id="app"></div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/echarts/4.1.0/echarts.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.18.0/axios.min.js"></script>
    <script>
    var mapDataJson='${mapDataJson}';
    var json=JSON.parse(mapDataJson);
    var province='<%=request.getAttribute("province")%>';
    
    
    
        axios.get('json/'+province+'.json').then((data) => {
            echarts.registerMap(province, data.data)
            let chart = echarts.init(document.getElementById('app'))
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
                    subtext: '确诊人数',
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
                        map: province,
                        roam: false,
//                        itemStyle:{
//                            normal:{label:{show:true}},
//                            emphasis:{label:{show:true}}
//                        },
                        itemStyle: itemStyle,
                        data:getData()
                        
                    }

                ]
            };

            //option_map.series[0].data=json;  
			
          

            
            // 为echarts对象加载数据
            chart.setOption(option_map);
        });
        
        
        
        function getData(){
        return json;
        }
    </script>
</body>
</html>
