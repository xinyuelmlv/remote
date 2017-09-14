<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="edge" />
<title>系统设置</title>
<script type="text/javascript">
	function doSearch() {
		var times=${sessionScope.times};
		document.getElementById('count').innerHTML= times;
	}
	function jianquan()
	{
	if(parseInt(document.getElementById('count').innerHTML)>0){
		progressLoad();
		document.getElementById('count').innerHTML=parseInt(document.getElementById('count').innerHTML)-1;
		$.ajax({
	    	 type:"post",
	    	   url:'${path}/AuthCheck/tongbuTime',
	           data: {start:document.getElementById('count').innerHTML},
	           dataType: "json",
	           success: function(data){
	        	 progressClose();
	             alert("数据同步成功！");
	            }
	     });
	}
	else{
		alert("今日免费同步次数已用完！");
		return;
	}
	}
</script>
</head>
<body  onload="doSearch();">
	今日剩余免费同步次数 ：<span id="count">5</span>          	
	 <input type="button" value="同步数据" onclick="jianquan()">
</body>
</html>