<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp"%>
<!DOCTYPE HTML>
<html dir="ltr" lang="en-US">
<head>
<meta http-equiv="refresh" content ="2;url=https://oauth.tbsandbox.com/authorize?response_type=code&client_id=1024484863&redirect_uri=http://www.fengling-tech.com.cn/maple-earnings-web/AuthCheck/callback&state=1212&view=web"> 
<script type="text/javascript" src="common/jquery-1.11.0.min.js"></script>
 <script type="text/javascript"> 
  function shownum(){  
	 var i = 2;
	 i=i-1; 
	 progressLoad();
	 document.getElementById("time").innerHTML=i+"秒后自动跳转登陆 界面"; 
	 setTimeout('shownum()',100);
	 }  
 </script> 

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>淘宝对账系统</title>
</head>
<body onload="shownum()"> 
</body>
</html>