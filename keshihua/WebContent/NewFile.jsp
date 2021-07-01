<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <title>ECharts</title>
    <script src="./js/jquery-3.4.1.min.js"></script>
    <script src="./js/echarts.min.js"></script>
</head>
 
<body>
    <div id="main" style="width: 600px;height:400px;"></div>
    <script>
 
    //取得json的样式，读取json文件
        $.getJSON("./js/city.json/heilongjiang.json", "", function(data) {
            //生成地图
            createMap(data);
        })
        //生成地图
        function createMap(data){
            echarts.registerMap('demo',data);
            var chart = echarts.init(document.getElementById('main'));
            chart.setOption({
                dataRange: {
                min: 0,   //颜色区间的最小值
                max: 200,   //颜色区间的最大值，和data中的最大值一致
                x: 'left',
                y: 'bottom',
                text:['高','低'],
                calculable : true,
                inRange: {
                    //颜色区间
                    color: ['lightskyblue','yellow', 'orangered','red']
                }
            },
            tooltip : {
                show:true,
                formatter: '{b} <br/>value: {c}'
            },
            series: [{
                type: 'map',
                map: 'demo',
                itemStyle:{
                    normal:{label:{show:false}},
                    emphasis:{label:{show:false}}
                },
                data:[
                    {name:'大兴安岭地区',value:120},
                    {name:'黑河市',value:110},
                    {name:'齐齐哈尔市',value:180},
                    {name:'鸡西市',value:160},
                    {name:'鹤岗市',value:120},
                    {name:'双鸭山市',value:80},
                    {name:'大庆市',value:8},
                    {name:'伊春市',value:60},
                    {name:'佳木斯市',value:40},
                    {name:'七台河市',value:50},
                    {name:'牡丹江市',value:40},
                    {name:'绥化市',value:30},
                    {name:'哈尔滨市',value:10}
                ],
                markPoint:{
                symbolSize: 45,
                itemStyle: {
                    normal: {
                    borderColor: '#33CBFF',
                    color:'#33CBFF',
                    borderWidth: 1,            // 标注边线线宽，单位px，默认为1
                    label: {
                        show: true
                    }
                }
            }
        }
    }]
});
}
 
    </script>
</body>
