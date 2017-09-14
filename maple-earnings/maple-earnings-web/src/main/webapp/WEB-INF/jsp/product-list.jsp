<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="edge" />
<title>商品成本</title>
    <script type="text/javascript"> 
    function importEmp(){   
        //检验导入的文件是否为Excel文件   
        var excelPath=document.getElementById("excelPath").value;
  
        if(excelPath == null || excelPath == ''){   
            alert("请选择要上传的Excel文件");   
            return;   
        }else{   
            var fileExtend = excelPath.substring(excelPath.lastIndexOf('.')).toLowerCase();    
            if(fileExtend == '.xls'){   
            }else{   
                alert("文件格式需为'.xls'格式");   
                return;   
            }   
        }   
        //提交表单   
        document.getElementById("empForm").action='${path }'+'/product/sub?excelPath='+encodeURI("D:\product.xls");     
        document.getElementById("empForm").submit();   
        alert('导入成功!');

    }  
           </script>
<script type="text/javascript">
var userIdValue=${sessionScope.userId};
	function doSearch() {
		var queryParams = $('#dataGrid').datagrid('options').queryParams;
		var productNam = $("#productName").val();
		var productName = "%" + productNam + "%";
		queryParams.userId = userIdValue;
		queryParams.title = productName;
		$('#dataGrid').datagrid('options').queryParams = queryParams;
		$("#dataGrid").datagrid('reload');
	}
</script>

<script type="text/javascript">
	var url;
	var type;
	function edituser() {
		var row = $("#dataGrid").datagrid("getSelected");
		if (row) {
			$("#dlg").dialog("open").dialog('setTitle', '');
			$('#AccountCode').val(row.numIid);
			$('#cost').val(row.eProductCost.cost);
			$("#fm").form("load", row);
			url = '${path }' + '/product/add?numIid=' + row.numIid;
		} else {
			$.messager.alert("提示信息", "请先选中要操作的行！");
		}
	}
	function downloadMode() {
		window.open('${path}/product/getProductExport');
	}
	
	function importProduit() {
		$("#importProduct").dialog("open").dialog('setTitle', '商品批量导入');
	}
	function saveuser() {
		var cost = $('#cost').val();
		$("#fm").form("submit", {
			url : url + '&cost=' + cost,
			onsubmit : function() {
				return $(this).form("validate");
			},
			success : function(result) {
				if (result == "1") {
					$.messager.alert("提示信息", "操作成功");
					$("#dlg").dialog("close");
					$("#dataGrid").datagrid("load");
				} else {
					$.messager.alert("提示信息", "操作失败");
				}
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
 var userIdValue=${sessionScope.userId};
	var dataGrid;
	$(function() {
		dataGrid = $('#dataGrid').datagrid({
			queryParams : {
				userId :userIdValue,
				title : '%%'
			},
			url : '${path }' + '/product/list',
			striped : true,
			rownumbers : true,
			pagination : true,
			singleSelect : true,
			idField : 'numIid',
			sortName : 'numIid',
			sortOrder : 'asc',
			pageSize : 20,
			pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
			frozenColumns : [ [ {
				width : '150',
				title : '商品编号',
				field : 'numIid',
				sortable : true
			}, {
				width : '100',
				title : '状态',
				field : 'apprroveStatus',
				sortable : true
			}, {
				width : '100',
				title : '数量',
				field : 'num',
				sortable : true
			}, {
				width : '120',
				title : '商品价格',
				field : 'price',
				sortable : true
			},

			{
				field : 'eProductCost',
				title : '商品成本',
				width : 120,
				formatter : function(value, rec) {
					return rec.eProductCost.cost;
				}
			}, {
				width : '200',
				title : '名称',
				field : 'title',
				sortable : true
			} ] ],

			toolbar : '#toolbar'
		});
	});

	function saverow(target) {
	}
</script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
	<div id="toolbar">
		<span>名称:</span> <input name="productName" id="productName"
			class="easyui-text" required="true" type="text" /> <a href="#"
			class="easyui-linkbutton" plain="true" onclick="doSearch()"
			iconcls="icon-search">查询</a> <a href="javascript:void(0)"
			class="easyui-linkbutton" iconcls="icon-edit" onclick="edituser()"
			plain="true">配置商品成本</a> <a href="javascript:void(0)"
			class="easyui-linkbutton" iconcls="icon-import"
			onclick="downloadMode()" plain="true">商品成本模板下载</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			iconcls="icon-add" onclick="importProduit()" plain="true">商品成本批量导入</a>
	</div>
	<div data-options="region:'center',fit:true,border:false">
		<table id="dataGrid" data-options="fit:true,border:false"></table>
	</div>
	<div id="importProduct" class="easyui-dialog"
		style="width: 400px; height: 250px; padding: 10px 20px;" closed="true">
		<div style="margin: 30px 0;"></div>
			<div style="margin-bottom: 20px">
<!-- 			<form id="questionTypesManage"  method="post" enctype="multipart/form-data">   -->
<!--    选择文件：　<input id="uploadExcel" name="uploadExcel" class="easyui-filebox" style="width:200px" data-options="prompt:'请选择文件...'">   -->
     
<!--        　　<a href="#" class="easyui-linkbutton" style="width:122px" onclick="uploadExcel()" >导入题库</a> 　　     　　　　　       -->
  
<!-- </form>   -->
<form id="empForm"  method="post" enctype="multipart/form-data">  

<input type="file" id="excelPath" name="excelPath"/>&nbsp;&nbsp;   

<input type="button"  value="导入Excel" onclick="importEmp()"/> 
</form>
			</div>			
	</div>
	<div id="dlg" class="easyui-dialog"
		style="width: 400px; height: 280px; padding: 10px 20px;" closed="true"
		buttons="#dlg-buttons">
		<div class="ftitle">配置商品成本</div>
		<form id="fm" method="post">
			<div class="fitem">
				<label> 商品编号</label> <input name="AccountCode" id="AccountCode"
					class="easyui-validatebox" required="true" />
			</div>
			<div class="fitem">
				<label>成本</label> <input name="cost" id="cost"
					class="easyui-validatebox" required="true" />
			</div>
			<!--        <div class="fitem"> -->
			<!--            <label> -->
			<!--                创建时间</label> -->
			<!--            <input name="CreateTime" class="easyui-datebox" required="true" /> -->
			<!--        </div>  -->
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="saveuser()" iconcls="icon-save">保存</a> <a
			href="javascript:void(0)" class="easyui-linkbutton"
			onclick="javascript:$('#dlg').dialog('close')" iconcls="icon-cancel">取消</a>
	</div>
	<div id="toolbar" style="display: none;"></div>
</body>
</html>