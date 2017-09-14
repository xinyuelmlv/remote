<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="edge" />
<title>订单详情</title>
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
<script type="text/javascript">
 var userIdValue=${sessionScope.userId};
	function doSearch() {
		var type = $("#timType").combobox('getValue');
		var queryParams = $('#dg').datagrid('options').queryParams;
		//queryParams.userId =userIdValue.toString();
		queryParams.userId =userIdValue;
		queryParams.timeType = type;
		queryParams.startTime = $("#StartTime").datebox("getValue");
		queryParams.endTime = $("#EndTime").datebox("getValue");
		$('#dg').datagrid('options').queryParams = queryParams;
		$("#dg").datagrid('reload');
	}
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
<script type="text/javascript">
	function onClickCell(index, row) {
		editorderCost(row);
	}
</script>
<script type="text/javascript">
	var url1;
	function editorderCost(row) {
		if (row) {
			$("#dlgorder").dialog("open").dialog('setTitle', '');
			$('#OrderCode').val(row.id);
			$('#orderName').val(row.title);
			$('#orderPrice').val(row.price);
			$('#orderCost').val(row.cost);
			$('#orderID').val(row.tid);
			url1 = '${path}' + '/trade/update';
		} else {
			$.messager.alert("提示信息", "请先选中要操作的行！");
		}
	}
	function saveorder() {
		var OrderCode = $('#OrderCode').val();
		var orderCost = $('#orderCost').val();
		var orderID = $('#orderID').val();
		$("#fm").form(
				"submit",
				{
					url : url1 + '?id=' + OrderCode + '&cost=' + orderCost
							+ '&tid=' + orderID,
					onsubmit : function() {
						return $(this).form("validate");
					},
					success : function(result) {
						if (result == "1") {
							$.messager.alert("提示信息", "操作成功");
							$("#dlgorder").dialog("close");
							$("#Detail").datagrid("load");
						} else {
							$.messager.alert("提示信息", "操作失败");
						}
					}
				});
	}
</script>
</head>
<body> 
<div class="bg"></div>
<div class="content">
<p>1.通过设置时间条件可以进行查询 </p>
<p>2.每行代表一条交易，点击一条交易可以看到该条交易下包含的订单的详细信息。</p>
</div>
</body>
<body class="easyui-layout" data-options="fit:true,border:false" onload="doSearch();">
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
				onclick="doSearch()" iconcls="icon-search">查询</a>
			<a href="#" plain="true" iconcls="icon-help" class="easyui-linkbutton" id="helpbutton">帮助</a>
		</div>
		<table id="dg" class="easyui-datagrid" fitColumns="true"
			data-options="singleSelect:true,
       collapsible:true,
       pagination:true,
       url:'${path}/trade/list',
       rownumbers : true,
       striped : true,
       method:'get',
       onClickRow : showDetail,
       pageSize:10,
       queryParams: 
       {userId:userIdValue,
        startTime:'1901',
        endTime:'2199',
        timeType:'created'
       },
      ">
			<thead>
				<tr>
					<th data-options="field:'tid',width:'15%'">交易ID</th>
					<th data-options="field:'created',width:'12%'">创建日期</th>
					<th data-options="field:'payTime',width:'12%'">付款日期</th>
					<th data-options="field:'modifiedTime',width:'12%'">修改时间</th>
					<th data-options="field:'endTime',width:'12%'">结束日期</th>
					<th data-options="field:'status',width:'12%'">状态</th>
					<th data-options="field:'totalFee',width:'12%'">价格</th>
					<th data-options="field:'userId',width:'12%'">用户标识</th>
				</tr>
			</thead>
		</table>
		<table id="Detail" class="easyui-datagrid">
		</table>
		<div id="dlgorder" class="easyui-dialog"
			style="width: 400px; height: 280px; padding: 10px 20px;"
			closed="true" buttons="#dlg-buttons">
			<div class="ftitle">配置订单成本</div>
			<form id="fm" method="post">
				<div class="fitem">
					<label> 订单编号 </label> <input name="OrderCode" id="OrderCode"
						class="easyui-validatebox" readonly="readonly" />
				</div>
				<div class="fitem">
					<label> 订单名称 </label> <input name="orderName" id="orderName"
						class="easyui-validatebox" readonly="readonly" />
				</div>
				<div class="fitem">
					<label> 订单价格 </label> <input name="orderPrice" id="orderPrice"
						class="easyui-validatebox" readonly="readonly" />
				</div>
				<div class="fitem">
					<label> 订单成本</label> <input name="orderCost" id="orderCost"
						class="easyui-validatebox" required="true" />
				</div>
				<div class="fitem">
					<label>订单标识</label> <input name="orderID" id="orderID"
						class="easyui-validatebox" readonly="readonly" />
				</div>
			</form>
		</div>
		<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="saveorder()" iconcls="icon-save">保存</a> <a
				href="javascript:void(0)" class="easyui-linkbutton"
				onclick="javascript:$('#dlgorder').dialog('close')"
				iconcls="icon-cancel">取消</a>
		</div>
	</div>
</body>
</html>