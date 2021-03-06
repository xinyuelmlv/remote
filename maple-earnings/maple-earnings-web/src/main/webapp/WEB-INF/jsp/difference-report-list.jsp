<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="edge" />
<title>对账报表</title>
<style type="text/css">
.bg {
	display: none;
	position: fixed;
	width: 100%;
	height: 100%;
	background: #EAEAEA;
	z-index: 2;
	top: 0;
	left: 0;
	opacity: 0.7;
}
.content {
	display: none;
	width: 500px;
	height: 300px;
	position: fixed;
	top: 50%;
	margin-top: -150px;
	background: #fff;
	z-index: 3;
	left: 50%;
	margin-left: -250px;
}
</style>
<script type="text/javascript">
var userIdValue=${sessionScope.userId};
var TradeSuccess=[];//交易成功全局变量
var TradeYiFahuo=[];//已发货全局变量
var TradeWeiFahuo=[];//未发货全局变量
function doSearch(){
    var queryParams = $('#dataGrid').datagrid('options').queryParams;  
    queryParams.userId =userIdValue;  
    queryParams.startTime = $("#StartTime").datebox("getValue"); 
    queryParams.endTime = $("#EndTime").datebox("getValue");    
    queryParams.orderStatus = $("#orderStatus").datebox("getValue"); 
    $('#dataGrid').datagrid('options').queryParams=queryParams;        
    $("#dataGrid").datagrid('reload'); 
}
function SumTrade(){
    var startTime = $("#StartTime").datebox("getValue"); 
    var endTime = $("#EndTime").datebox("getValue");    
    if(startTime==null||startTime==""){
    	alert('请输入要统计的开始时间！');
        return;
    }
    if(endTime==null||endTime==""){
    	alert('请输入要统计的结束时间！');
    	return;
    }
    $.ajax({
        url: '${path}/report/SumTrade',
        type: "GET",
        dataType: 'json',
        data: {//请求携带参数
        	userId:userIdValue,
        	startTime:startTime,
        	endTime:endTime,
        	orderStatus :'all'
        },
        success: function (data) {
        	 TradeSuccess=[];//清空交易成功全局变量
        	 TradeYiFahuo=[];//清空已发货全局变量
        	 TradeWeiFahuo=[];//清空未发货全局变量
        	 TradeSuccess=data[0];
        	 TradeYiFahuo=data[1];
        	 TradeWeiFahuo=data[2];
        	 var a = [ {
        			value :TradeSuccess,
        			name : '交易成功'
        		}, {
        			value :TradeYiFahuo ,
        			name : '已发货'
        		}, {
        			value :TradeWeiFahuo,
        			name : '已付款未发货'
        		}];
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
        					text : '交易状态概况',
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
        					data : [ '交易成功', '已发货', '已付款未发货' ]
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
        					name : '交易状态概况',
        					type : 'pie',
        					radius : '55%',
        					center : [ '50%', '60%' ],
        					data : a,
        					itemStyle : {
        						  normal: {  
      	                            label: {  
      	                                show: true,//是否展示  
      	                                textStyle: {  
      	                                    fontWeight:'bolder',  
      	                                    fontSize : '12',  
      	                                    fontFamily : '微软雅黑',  
      	                                }  
      	                            }  
      	                        } ,
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
        },
        error:function(data){
        	alert("查询过程出错！");
        }
    });    
	
	$("#dlg").dialog("open").dialog('setTitle', ''); 
}
function exportReport(){
	 var queryParams = $('#dataGrid').datagrid('options').queryParams;  
	    queryParams.userId =userIdValue;  
	    queryParams.startTime = $("#StartTime").datebox("getValue"); 
	    queryParams.endTime = $("#EndTime").datebox("getValue");    
	    queryParams.orderStatus = $("#orderStatus").datebox("getValue"); 
	window.open('${path}/report/diffrenceReportListExport?userId='+ queryParams.userId+'&startTime='
			+queryParams.startTime+'&endTime='+queryParams.endTime+'&orderStatus='+queryParams.orderStatus);
}
function onClickCell(index, row){
	$("#detail").datagrid({
		url:'${path}/report/reportDetail?tid='+row.tid,
		fitColumns:true,
		singleSelect:true,
		rownumbers:true,
		loadMsg:'',
		method:'get',
		height:'auto',
		queryParams: {userId:userIdValue},
		columns:[[
			{field:'id',title:'订单编号',width:'4%'},
			{field:'payTime',title:'付款时间',width:'8%'},
			{field:'modifiedTime',title:'修改时间',width:'8%'},
			{field:'title',title:'订单名称',width:'12%'},
			{field:'price',title:'订单价格',width:'4%'},
			{field:'cost',title:'订单成本',width:'4%'},
			{field:'refundStatus',title:'退货状态',width:'12%'},
			{field:'status',title:'订单状态',width:'7%'},
			{field:'tid',title:'订单标识',width:'6%'},

	    	 {field:'goodStatus',title:'货物状态',width:'4%',
                formatter:function(value,rec){
                 return rec.eRefund.goodStatus;
                }
            },
	    	 {field:'refundFee',title:'退款金额',width:'4%',
                formatter:function(value,rec){
                 return rec.eRefund.refundFee;
                }
            },

			{field:'numIid',title:'商品编号',width:'7%'},
			{field:'num',title:'商品数量',width:'4%'},
			{field:'productCost',title:'商品成本',width:'4%'}
		]],
		onResize:function(){
			$('#dataGrid').datagrid('fixDetailRowHeight',index);
		},
		onLoadSuccess:function(){
			setTimeout(function(){
				$('#dataGrid').datagrid('fixDetailRowHeight',index);
			},0);
		}
	});
}
</script>
</head>
<body> 
<div class="bg"></div>
<div class="content">
<p>1.红色代表交易到账未完成，绿色代表交易到账完成</p>
<p>2.通过导出报表可以将当前的报表导出</p>
<p>3.选择开始日期、结束日期，点击交易状态饼图，可以以饼图形式查看交易统计</p>
</div>
</body>
<body class="easyui-layout" data-options="fit:true,border:false" onload="doSearch();">
	<div data-options="region:'center',fit:true,border:false">
		<div id="tb" style="padding: 3px">
			<span>开始日期:</span> <input name="StartTime" id="StartTime"
				class="easyui-datebox" type="text" /> <span>结束日期:</span> <input
				name="EndTime" id="EndTime" class="easyui-datebox" type="text" /> <span>订单状态:</span>
			<select class="easyui-combobox" name="orderStatus" id="orderStatus"
				style="width: 130px;">
				<option value="unfinished">未完成</option>
				<option value="all">所有</option>
				<option value="WAIT_SELLER_SEND_GOODS">已付款</option>
				<option value="WAIT_BUYER_CONFIRM_GOODS">已发货</option>
				<option value="TRADE_FINISHED">已完成</option>
			</select> <a href="#" class="easyui-linkbutton" plain="true"
				onclick="doSearch()" iconcls="icon-search">查询</a>
			</select> <a href="#" class="easyui-linkbutton" plain="true"
				onclick="exportReport()" iconcls="icon-export">导出报表</a>
			</select> <a href="#" class="easyui-linkbutton" plain="true"
				onclick="SumTrade()" iconcls="icon-reload">交易状态饼图</a>
			</select> 
				<a href="#" plain="true" iconcls="icon-help" class="easyui-linkbutton" id="helpbutton">帮助</a>
		</div>
		<table class="easyui-datagrid" id="dataGrid" title="对账报表"
			data-options="
       singleSelect:true,
       collapsible:true,  
       rownumbers : true,
       pagination:true,
       onClickRow: onClickCell,
       url:'${path}/report/diffrenceReportList',
       method:'get',
       pageSize:10,
        queryParams: {userId: userIdValue,startTime:'1901',endTime:'2199',orderStatus:'unfinished'},
       rowStyler: function(index,row){
					if (row.status != '交易成功'){
						return 'color:#FF4500;font-weight:bold;';
					}
					else{
					return 'color:#449d44;font-weight:bold;';
					}
				}
      ">
			<thead>
				<tr>
					<th data-options="field:'tid',width:'10%'">交易编号</th>
					<th data-options="field:'reportDate',width:'10%'">交易日期</th>
					<th data-options="field:'status',width:'10%'">状态</th>
					<th data-options="field:'totalFee',width:'10%'">付款金额</th>
<!-- 					<th data-options="field:'productCost',width:'8%'">商品成本</th> -->
					<th data-options="field:'commission',width:'10%'">佣金</th>
					<th data-options="field:'refundFee',width:'10%'">退款金额</th>
					<th data-options="field:'index',width:'18%',
					formatter: function (value, row, index) {
                          return (row.totalFee)-(row.commission)-(row.refundFee);
} 
					">
					应收金额(付款金额 -佣金 - 退款金额)</th>
					<th data-options="field:'realReceive',width:'18%'">实际到账</th>
				</tr>
			</thead>
		</table>
		<table class="easyui-datagrid" id="detail" title="交易详情">
		</table>
		<div id="dlg" class="easyui-dialog"
			style="width: 430px; height: 350px; padding: 15px" closed="true"
			buttons="#dlg-buttons">
			<div id="main" style="height: 280px; width: 340px"></div>
		</div>
	</div>
	<div id="toolbar" style="display: none;"></div>
</body>
</html>