<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="edge" />
<title>用户管理</title>
<script type="text/javascript">
function formatStatusShow(value,row,index){
	if(value==1){
	    return "正常";
	    }
	if(value==2){
        return "即将到期";
    }
	if(value==3){
        return "逾期禁止使用";
    }
	}
	//退出
function logout(){
    $.messager.confirm('提示','确定要退出?',function(r){
        if (r){
            progressLoad();
                    window.location.href='http://www.fengling-tech.com.cn';
                    progressClose();
        }
    });
}
</script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',fit:true,border:false">
		<div id="tb" style="padding: 3px">
			<span>用户名:</span> <input name="StartTime" id="StartTime"
				class="easyui-datetimebox" type="text" /> <span>接入时间:</span> <input
				name="StartTime" id="StartTime" class="easyui-datetimebox"
				type="text" /> <span>当前状态:</span> <select class="easyui-combobox"
				name="orderStatus" id="orderStatus" style="width: 200px;">
				<option value="all">所有</option>
			</select> <a href="#" class="easyui-linkbutton" plain="true"
				onclick="doSearch()" iconcls="icon-search">查询</a>
				<a
					href="javascript:void(0)" onclick="logout()"
					class="easyui-linkbutton" plain="true" icon="icon-clear">安全退出</a>
		</div>
		<table class="easyui-datagrid" id="dataGrid" title="用户管理"
			data-options="
       singleSelect:true,
       collapsible:true,  
       rownumbers : true,
       pagination:true,
       url:'${path}/AuthCheck/listUser',
       method:'get',
       pageSize:10,
        queryParams: {},
      ">
			<thead>
				<tr>
					<th data-options="field:'taobao_user_id',width:'20%'">用户ID</th>
					<th data-options="field:'taobao_user_nick',width:'20%'">用户名</th>
					<th data-options="field:'registerTime',width:'20%'">接入时间</th>
					<th data-options="field:'status',width:'20%'"
						formatter="formatStatusShow">当前状态</th>
				</tr>
			</thead>
		</table>
	</div>
	<div id="toolbar" style="display: none;"></div>
</body>
</html>