<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="edge" />
<title>利润报表</title>
<script type="text/javascript">
   var userIdValue=${sessionScope.userId};
	var len;
	function doSearch() {
		var queryParams = $('#dataGrid').datagrid('options').queryParams;
		queryParams.userId =userIdValue;
		queryParams.startTime = $("#StartTime").datebox("getValue");
		queryParams.endTime = $("#EndTime").datebox("getValue");
		queryParams.orderStatus = $("#orderStatus").datebox("getValue");
		$('#dataGrid').datagrid('options').queryParams = queryParams;
		$("#dataGrid").datagrid('reload');
	}
	function onClickCell(index, row) {
		var status=document.getElementById("useFenxi");
		 if(status.checked){
			 
		
		var a = [ {
			value : row.extraCost,
			name : '平台费用'
		}, {
			value : row.productCost,
			name : '商品成本'
		}, {
			value : row.commission,
			name : '佣金'
		}, {
			value : row.gain,
			name : '利润'
		} ];
		// 路径配置
		require.config({
			paths : {
				echarts : '${staticPath }/static/dist'
			}
		});
		// 使用
		require([ 'echarts', 'echarts/chart/pie' ], function(ec) {
			var myChart = ec.init(document.getElementById('main'));
			option = {
				title : {
					text : '利润分析',
					subtext : '',
					x : 'center'
				},
				tooltip : {
					trigger : 'item',
					formatter : "{a} <br/>{b} : {c} ({d}%)"
				},
				legend : {
					orient : 'vertical',
					x : 'left',
					data : [ '平台费用', '商品成本', '佣金', '利润' ]
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
				series : [ {
					name : '利润分析',
					type : 'pie',
					radius : '55%',
					center : [ '50%', '60%' ],
					data : a,
					itemStyle : {
						emphasis : {
							shadowBlur : 10,
							shadowOffsetX : 0,
							shadowColor : 'rgba(0, 0, 0, 0.5)'
						}
					}
				} ]
			};
			myChart.setOption(option);
		});
		$("#dlg").dialog("open").dialog('setTitle', ''); 
		}
		$("#detail").datagrid({
			url : '${path}/report/reportDetail?tid=' + row.tid,
			fitColumns : true,
			singleSelect : true,
			rownumbers : true,
			loadMsg : '数据加载中',
			method : 'get',
			height : 'auto',
			queryParams : {
				userId : userIdValue
			},
			columns : [ [ {
				field : 'id',
				title : '订单编号',
				width : 100
			}, {
				field : 'title',
				title : '订单名称',
				width : 100
			}, {
				field : 'price',
				title : '订单价格',
				width : 100
			}, {
				field : 'cost',
				title : '订单成本',
				width : 100
			}, {
				field : 'refundStatus',
				title : '退货状态',
				width : 100
			}, {
				field : 'status',
				title : '订单状态',
				width : 100
			}, {
				field : 'tid',
				title : '订单标识',
				width : 100
			},

			{
				field : 'goodStatus',
				title : '货物状态',
				width : 100,
				formatter : function(value, rec) {
					return rec.eRefund.goodStatus;
				}
			}, {
				field : 'refundFee',
				title : '退款金额',
				width : 100,
				formatter : function(value, rec) {
					return rec.eRefund.refundFee;
				}
			},

			{
				field : 'numIid',
				title : '商品编号',
				width : 100
			}, {
				field : 'num',
				title : '商品数量',
				width : 100
			}, {
				field : 'productCost',
				title : '商品成本',
				width : 100
			} ] ],
			onResize : function() {
				$('#dataGrid').datagrid('fixDetailRowHeight', index);
			},
			onLoadSuccess : function() {
				setTimeout(function() {
					$('#dataGrid').datagrid('fixDetailRowHeight', index);
				}, 0);
			}
		});
	}
</script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false" onload="doSearch();">
	<div data-options="region:'center',fit:true,border:false">
		<div id="tb" style="padding: 3px">
			<span>开始日期:</span> <input name="StartTime" id="StartTime"
				class="easyui-datetimebox" type="text" /> <span>结束日期:</span> <input
				name="EndTime" id="EndTime" class="easyui-datetimebox" type="text" />
			<span>订单状态:</span> <select class="easyui-combobox" name="orderStatus"
				id="orderStatus" style="width: 200px;">
				<option value="all">所有</option>
				<option value="WAIT_SELLER_SEND_GOODS">已付款</option>
				<option value="WAIT_BUYER_CONFIRM_GOODS">已发货</option>
				<option value="TRADE_FINISHED">已完成</option>
			</select> <a href="#" class="easyui-linkbutton" plain="true"
				onclick="doSearch()" iconcls="icon-search">查询</a> <input id=useFenxi
				name="sub" type="checkbox" value="选中">启用利润分析</input>
		</div>
		<table class="easyui-datagrid" id="dataGrid" title="利润报表"
			data-options="
       singleSelect:true,
       collapsible:true,  
       rownumbers : true,
       pagination:true,
       onClickRow: onClickCell,
       url:'${path}/report/list',
       method:'get',
       pageSize:10,
        queryParams: {userId:userIdValue,startTime:'1901',endTime:'2199',orderStatus:'all'},
      ">
			<thead>
				<tr>
					<th data-options="field:'tid',width:'10%'">交易编号</th>
					<th data-options="field:'reportDate',width:'10%'">交易日期</th>
					<th data-options="field:'status',width:'10%'">状态</th>
					<th data-options="field:'totalFee',width:'10%'">付款金额</th>
					<th data-options="field:'extraCost',width:'9%'">平台费用</th>
					<th data-options="field:'productCost',width:'9%'">商品成本</th>
					<th data-options="field:'commission',width:'9%'">佣金</th>
					<th data-options="field:'refundFee',width:'9%'">退款金额</th>
					<th data-options="field:'realReceive',width:'9%'">实际到账</th>
					<th data-options="field:'gain',width:'9%'">利润</th>
				</tr>
			</thead>
		</table>
		<table class="easyui-datagrid" id="detail" title="交易详情">
		</table>
		<div id="dlg" class="easyui-dialog"
			style="width: 400px; height: 330px; padding: 15px" closed="true"
			buttons="#dlg-buttons">
			<div id="main" style="height: 260px; width: 350px"></div>
		</div>
	</div>
	<div id="toolbar" style="display: none;"></div>
</body>
</html>