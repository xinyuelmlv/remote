<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="edge" />
<title>到账记录</title>
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
	var len;
	function doSearch() {
		var queryParams = $('#dataGrid').datagrid('options').queryParams;
		queryParams.userId =userIdValue;
		queryParams.startTime = $("#StartTime").datebox("getValue");
		queryParams.endTime = $("#EndTime").datebox("getValue");
		$('#dataGrid').datagrid('options').queryParams = queryParams;
		$("#dataGrid").datagrid('reload');
	}
	function onClickCell(index, row) {
		$("#detail").datagrid({
			url : '${path}/trade/getHistory?tid='+row.tid+'&userId='+userIdValue,
			fitColumns : true,
			singleSelect : true,
			rownumbers : true,
			pagination : true,
			pageSize : 20,
			loadMsg : '',
			method : 'get',
			height : 'auto',
			queryParams : {},
		    rowStyler: function(index,row){
					if (row.shuoldpayment!=row.realpayment){
						return 'color:#FF4500;font-weight:bold;';
					}
					else{
						return 'color:#449d44;font-weight:bold;';
					}
				},
			columns : [ [ {
				field : 'changetime',
				title : '到账时间',
				width : 20
			}, {
				field : 'postfee',
				title : '邮费',
				width : 20
			}, {
				field : 'shuoldpayment',
				title : '应收金额',
				width : 25
			}, {
				field : 'realpayment',
				title : '当前到账',
				width : 20
			} ] ]
		});
	}
	$(function(){
	    $('#helpbutton').click(function(){
	        $('.bg').fadeIn(200);
	        $('.content').fadeIn(400);
	});
	$('.bg').click(function(){
	    $('.bg').fadeOut(800);
	    $('.content').fadeOut(800);
	});
	});
</script>

</head>
<body> 
<div class="bg"></div>
<div class="content">
<p>1.到账次数代表当前该条交易中包含订单的到账情况，如3代表交易中有三笔订单费用已经到账</p>
<p>2.点击一条交易，可以查看该条交易的到账情况的详细信息</p>
<p>3.红色代表当前交易尚有订单费用未到账，绿色代表到账完成</p>
</div>
</body>
<body class="easyui-layout" data-options="fit:true,border:false" onload="doSearch();">
	<div data-options="region:'center',fit:true,border:false">
		<div id="tb" style="padding: 3px">
			<span>开始日期:</span> <input name="StartTime" id="StartTime"
				class="easyui-datetimebox" type="text" /> <span>结束日期:</span> <input
				name="EndTime" id="EndTime" class="easyui-datetimebox" type="text" />
			 <a href="#" class="easyui-linkbutton" plain="true"
				onclick="doSearch()" iconcls="icon-search">查询</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<label style="color:#DC143C;">注：红色代表到账未完成；绿色代表到账完成</label>
			<a href="#" plain="true" iconcls="icon-help" class="easyui-linkbutton" id="helpbutton">帮助</a>
			
		</div>
		<table class="easyui-datagrid" id="dataGrid" title="交易到账"
			data-options="
       singleSelect:true,
       collapsible:true,  
       rownumbers : true,
       pagination:true,
       onClickRow: onClickCell,
       url:'${path}/trade/incomHistiry',
       method:'get',
       pageSize:10,
        queryParams: {userId:userIdValue,startTime:'1901',endTime:'2199',orderStatus:'all'},
      ">
			<thead>
				<tr>
					<th data-options="field:'tid',width:'20%'">交易编号</th>
					<th data-options="field:'title',width:'20%'">交易名称</th>
					<th data-options="field:'status',width:'15%'">交易状态</th>
					<th data-options="field:'shuoldpayment',width:'15%'">应到账金额</th>
					<th data-options="field:'id',width:'10%'">到账次数</th>
				</tr>
			</thead>
		</table>
		<table class="easyui-datagrid" id="detail" title="到账记录详情">
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