<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="main" style="height:400px"></div>
<script src="http://echarts.baidu.com/build/dist/echarts.js"></script>
<script type="text/javascript">
    require.config({
        paths: {
            echarts: 'http://echarts.baidu.com/build/dist'
        }
    });
    // 使用
    require
    (
            [
                'echarts',
                'echarts/chart/line' ,
                'echarts/chart/bar' // 使用柱状图就加载bar模块，按需加载
            ],
            function (ec)
            {
                // 基于准备好的dom，初始化echarts图表
                var myChart = ec.init(document.getElementById('main'));
                var option = {
                    title : {
                        text: '测试',
                        subtext: '纯属测试'
                    },
                    tooltip : {
                        trigger: 'axis'
                    },
                    legend: {
                        data:['1', '2']
                    },
                    toolbox: {
                        show : true,
                        feature : {
                            mark : {show: true},
                            dataView : {show: true, readOnly: false},
                            magicType : {show: true, type: ['line', 'bar']},
                            restore : {show: true},
                            saveAsImage : {show: true}
                        }
                    },
                    dataZoom : {
                        show : false,
                        start : 0,
                        end : 100
                    },
                    xAxis : [
                        {
                            type : 'category',
                            boundaryGap : true,
                            data : (function (){
                                var now = new Date();
                                var res = [];
                                var len = 4;
                                while (len--) {
                                    res.unshift(now.toLocaleTimeString().replace(/^\D*/,''));
                                    now = new Date(now - 2000);
                                }
                                return res;
                            })()
                        },
                        {
                            type : 'category',
                            boundaryGap : true,
                            data : (function (){
                                var res = [];
                                var len = 200;
                                while (len--) {
                                    res.push(len + 1);
                                }
                                return res;
                            })()
                        }
                    ],
                    yAxis : [
                        {
                            type : 'value',
                        },
                        {
                            type : 'value',
                        }
                    ],
                    series : [
                        {
                            name:'aaa',
                            type:'bar',
                            xAxisIndex: 1,
                            yAxisIndex: 1,
                            data:(function (){
                                var res = [];
                                var len = 200;
                                while (len--) {
                                    res.push(Math.round(Math.random() * 1000));
                                }
                                return res;
                            })()
                        },
                    ]
                };;
                myChart.setOption(option);
                var timeTicket;
                clearInterval(timeTicket);
                timeTicket = setInterval(function (){
                    // 动态数据接口 addData
                    myChart.addData([
                        [
                            0,        // 系列索引
                            {
                                value:Math.round(Math.random() * 1000), // 新增数据
                            },
                            true,     // 新增数据是否从队列头部插入
                            false     // 是否增加队列长度，false则自定删除原有数据，队头插入删队尾，队尾插入删队头
                        ],
                    ]);
                }, 2100);
 
            }
    );
</script>

</body>
</html> --%>