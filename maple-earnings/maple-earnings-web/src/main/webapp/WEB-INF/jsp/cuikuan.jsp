<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="edge" />
<title>等待催款</title>
<script type="text/javascript">
	var userIdValue = ${sessionScope.userId};
	function showDetail(index, row) {
		$('#Detail').datagrid({
			url : '${path}/trade/orderList?tid=' + row.tid,
			fitColumns : true,
			singleSelect : true,
			rownumbers : true,
			onClickRow : onClickCell,
			loadMsg : '',
			height : 'auto',
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
				field : 'status',
				title : '订单状态',
				width : 100
			}, {
				field : 'tid',
				title : '订单标识',
				width : 100
			}, {
				field : 'numIid',
				title : '商品编号',
				width : 100
			} ] ],
			onResize : function() {
				$('#dg').datagrid('fixDetailRowHeight', index);
			},
			onLoadSuccess : function() {
				setTimeout(function() {
					$('#dg').datagrid('fixDetailRowHeight', index);
				}, 0);
			}
		});
	}
</script>
<style type="text/css">
#fm {
	margin: 0;
	padding: 10px 30px;
}

.ftitle {
	font-size: 14px;
	font-weight: bold;
	padding: 5px 0;
	margin-bottom: 10px;
	border-bottom: 1px solid #ccc;
}

.fitem {
	margin-bottom: 5px;
}

.fitem label {
	display: inline-block;
	width: 80px;
}
</style>
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
	function onClickCell(index, row) {
		editorderCost(row);
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
<p>1.绿色代表未超时；红色代表超时 </p>
<p>2.买家收到货物后，超过3天没有主动点击确认收货，则会标记为超时。</p>
<p>3.可以根据条件检索相应的交易</p>
</div>
</body>
<body class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',fit:true,border:false">
		<div id="tb" style="padding: 3px">
			<span>日期:</span> <select class="easyui-combobox" style="width: 8%"
				id="timType">
				<option value="">全部</option>
				<option value="created">创建日期</option>
				<option value="payTime">付款日期</option>
				<option value="modifiedTime">修改日期</option>
				<option value="endTime">结束日期</option>
			</select> <span>开始:</span> <input name="StartTime" id="StartTime"
				class="easyui-datetimebox" type="text" /> <span>结束:</span> <input
				name="EndTime" id="EndTime" class="easyui-datetimebox" type="text" />
			<a href="#" class="easyui-linkbutton" plain="true"
				onclick="doSearch()" iconcls="icon-search">查询</a> <label style="color:#DC143C;">注：绿色代表未超时；红色代表超时</label>
			<a href="#" plain="true" iconcls="icon-help" class="easyui-linkbutton" id="helpbutton">帮助</a>
		</div>
		<table id="dg" class="easyui-datagrid" fitColumns="true"
			data-options="singleSelect:true,
       collapsible:true, 
       pagination:true, 
       url:'${path}/trade/tradeTimeOut',
        rownumbers : true, 
        striped : true, 
        method:'get', 
        pageSize:10, 
        queryParams:  
        {userId:userIdValue, 
        },  
        rowStyler: function(index,row){ 
					if (row.timeout=='1'){ 
 						return 'color:#FF4500;font-weight:bold'; 
 					} 
 					else{ 
 						return 'color:#449d44;font-weight:bold'; 
 					} 
 				}, 
      ">
			<thead>
				<tr>
					<th data-options="field:'tid',width:'15%'">交易ID</th>
					<th data-options="field:'time',width:'15%'">签收时间</th>
					<th data-options="field:'action',width:'15%'">物流状态</th>
					<th data-options="field:'descript',width:'20%'">描述信息</th>
					<th data-options="field:'timeout',width:'10%', formatter : function(value,row,index){
                     if(value=='0'){return '未超时'}   
                     else if(value=='1'){return '超时'}                         
                 } ">是否超时</th> 
				</tr>
			</thead>
		</table>
		<table id="Detail" class="easyui-datagrid">
		</table>
	</div>
</body>
</html>