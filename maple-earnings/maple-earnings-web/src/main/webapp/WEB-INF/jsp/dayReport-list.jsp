<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="edge" />
<title>单日利润报表</title>
<script type="text/javascript">
    var userIdValue=${sessionScope.userId};
	var date = [];//日期全局变量
	var fukuan = [];//付款金额全局变量
	var lirun = [];//利润全局变量
	function showGainZheXian() {
		$.ajax({
			url : '${path}/report/dayReportList',
			type : "GET",
			dataType : 'json',
			data : {//请求携带参数
				userId : userIdValue
			},
			success : function(data) {
				date = [];//清空全局变量数据
				fukuan = [];//清空数据
				lirun = [];//清空数据
				chengben = [];//清空数据
				jiaoyiyongjin = [];//清空数据
				for ( var i in data) {
					date.push(data[i]['date']);
					fukuan.push(data[i]['payment']);
					lirun.push(data[i]['earnings']);
				}
			}
		});
		require.config({
			paths : {
				echarts : '${staticPath }/static/dist'
			}
		});
		require([ 'echarts', 'echarts/chart/line' ], function(ec) {
			var myChart = ec.init(document.getElementById('mainview'));
			option = {
				title : {
					text : '销售利润走势图'
				},
				tooltip : {
					trigger : 'axis'
				},
				legend : {
					data : [ '销售利润' ]
				},
				toolbox : {
					show : true,
					feature : {
						dataView : {
							show : true,
							readOnly : false
						},
						restore : {
							show : true
						},
						saveAsImage : {
							show : true
						}
					}
				},
				grid : {
					left : '3%',
					right : '4%',
					bottom : '3%',
					containLabel : true
				},

				xAxis : {
					type : 'category',
					boundaryGap : false,
					data : date
				},
				yAxis : {
					type : 'value'
				},
				series : [ {
					name : '销售利润',
					type : 'line',
					stack : '总量',
					data : lirun
				} ]
			};
			myChart.setOption(option);
		});
		$("#diaglog").dialog("open").dialog('setTitle', '');
	}
	function showGainCount() {
		$.ajax({
			url : '${path}/report/dayReportList',
			type : "GET",
			dataType : 'json',
			data : {//请求携带参数
				userId : userIdValue
			},
			success : function(data) {
				date = [];//清空全局变量数据
				fukuan = [];//清空数据
				lirun = [];//清空数据
				for ( var i in data) {
					date.push(data[i]['date']);
					fukuan.push(data[i]['payment']);
					lirun.push(data[i]['earnings']);
				}
			}
		});
		require.config({
			paths : {
				echarts : '${staticPath }/static/dist'
			}
		});
		require([ 'echarts', 'echarts/chart/bar' ], function(ec) {
			var myChart = ec.init(document.getElementById('main'));
			option = {
				title : {
					text : '销售金额与利润对比',
					subtext : ''
				},
				tooltip : {
					trigger : 'axis'
				},
				legend : {
					data : [ '成交金额', '利润' ]
				},
				toolbox : {
					show : true,
					feature : {
						dataView : {
							show : true,
							readOnly : false
						},
						restore : {
							show : true
						},
						saveAsImage : {
							show : true
						}
					}
				},
				calculable : true,
				xAxis : [ {
					type : 'category',
					data : date
				} ],
				yAxis : [ {
					type : 'value'
				} ],
				series : [ {
					name : '成交金额',
					type : 'bar',
					data : fukuan,
					itemStyle : {
						normal : {
							label : {
								show : true,//是否展示  
								textStyle : {
									fontWeight : 'bolder',
									fontSize : '12',
									fontFamily : '微软雅黑',
								}
							}
						}
					},
				}, {
					name : '利润',
					type : 'bar',
					data : lirun,
					itemStyle : {
						normal : {
							label : {
								show : true,//是否展示  
								textStyle : {
									fontWeight : 'bolder',
									fontSize : '12',
									fontFamily : '微软雅黑',
								}
							}
						}
					},
				} ]
			};
			myChart.setOption(option);
		});
		$("#dlg").dialog("open").dialog('setTitle', '');
	}
	function onClickCell(index, row) {
		$("#detail").datagrid({
			url : '${path}/report/reportList?date=' + row.date,
			fitColumns : true,
			singleSelect : true,
			rownumbers : true,
			pagination : true,
			pageSize : 20,
			loadMsg : '',
			method : 'get',
			height : 'auto',
			queryParams : {
				userId : userIdValue
			},
			columns : [ [ {
				field : 'tid',
				title : '订单编号',
				width : 20
			}, {
				field : 'reportDate',
				title : '交易日期',
				width : 20
			}, {
				field : 'totalFee',
				title : '付款金额',
				width : 25
			}, {
				field : 'extraCost',
				title : '订单费用',
				width : 20
			}, {
				field : 'productCost',
				title : '商品成本',
				width : 20
			}, {
				field : 'gain',
				title : '利润',
				width : 80
			} ] ]

		});

	}
</script>
</head>
<div data-options="region:'center',fit:true,border:false">
	<a href="#" class="easyui-linkbutton" plain="true"
		onclick="showGainCount()" iconcls="icon-search">销售金额与利润对比图</a> <a
		href="#" class="easyui-linkbutton" plain="true"
		onclick="showGainZheXian()" iconcls="icon-search">销售利润走势图</a>
	<table class="easyui-datagrid" id="dataGrid" title="利润报表"
		data-options="
       singleSelect:true,
       collapsible:true,  
       rownumbers : true,
       onClickRow: onClickCell,
       url:'${path}/report/dayReportList',
       method:'get',
       queryParams: {userId: userIdValue},
      ">
		<thead>
			<tr>
				<th data-options="field:'date',width:'20%'">交易日期</th>
				<th data-options="field:'payment',width:'13%'">付款金额</th>
				<th data-options="field:'orderCost',width:'10%'">订单费用</th>
				<th data-options="field:'productCost',width:'13%'">商品成本</th>
				<th data-options="field:'earnings',width:'10%'">利润</th>
				<th data-options="field:'commission',width:'10%'">交易佣金</th>
				<th data-options="field:'alCost',width:'13%'">平台费用</th>
				<th data-options="field:'userId',width:'5%'">订单数量</th>
			</tr>
		</thead>
	</table>
	<table class="easyui-datagrid" id="detail" title="单日详情"></table>
	<div id="dlg" class="easyui-dialog"
		style="width: 800px; height: 450px; padding: 15px" closed="true"
		buttons="#dlg-buttons">
		<div id="main" style="height: 350px; width: 750px"></div>
	</div>
	<div id="diaglog" class="easyui-dialog"
		style="width: 800px; height: 450px; padding: 15px" closed="true"
		buttons="#dlg-buttons">
		<div id="mainview" style="height: 350px; width: 750px"></div>
	</div>
</div>
<div id="toolbar" style="display: none;"></div>
</body>
</html>