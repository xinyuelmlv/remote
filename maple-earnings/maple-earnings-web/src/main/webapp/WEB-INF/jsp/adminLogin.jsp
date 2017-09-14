<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>枫灵对账管理后台</title>
<style>
* {
	padding: 0px;
	margin: 0px;
	list-style: none;
}

body {
	width: 100%;
	margin: 0px;
	padding: 0px;
	background: url(${staticPath }/static/style/images/bg03.jpg);
	width: 100%;
	height: 100%
}

.top {
	width: 960px;
	height: 336px;
	margin: 0 auto;
	background: url(${staticPath }/static/style/images/bg01s.jpg) no-repeat;
	position: relative
}

.bottom {
	width: 960px;
	height: 305px;
	margin: 0 auto;
	background: url(${staticPath }/static/style/images/bg02.jpg) no-repeat;
	position: relative
}

#username, #p_t, #userpwd, #validatecode {
	position: absolute;
	top: 206px;
	left: 187px;
	width: 193px;
	height: 34px;
	border: 0px;
	font-size: 14px;
	line-height: 30px;
	color: #666
}

#p_t, #userpwd {
	left: 402px;
	z-index: 2
}

#validatecode {
	left: 618px;
	z-index: 2;
	width: 113px
}

#vcodesrc {
	position: absolute;
	top: 165px;
	left: 616px;
	font-family: Arial
}

#userpwd {
	z-index: 1;
	color: #333
}

#code {
	position: absolute;
	top: 207px;
	left: 740px;
	width: 80px;
	height: 34px;
	z-index: 3;
	border: 0px;
	cursor: pointer font-family: Arial;
	font-style: italic;
	font-weight: bold;
	border: 0;
	color: red;
}

#radioa {
	position: absolute;
	top: 300px;
	left: 390px;
	z-index: 3;
	border: 0px;
	cursor: pointe;
	font-weight: bold;
}

#radiob {
	position: absolute;
	top: 300px;
	left: 500px;
	z-index: 3;
	border: 0px;
	cursor: pointe;
	font-weight: bold;
}

#login_bt {
	position: absolute;
	top: 207px;
	left: 830px;
	width: 102px;
	height: 33px;
	background: transparent;
	z-index: 3;
	border: 0px;
	cursor: pointer
}

.forget {
	color: #94adc3;
	position: absolute;
	top: 247px;
	left: 805px;
	font-size: 12px;
	text-decoration: none
}

.forget1 {
	color: #ff6600;
	position: absolute;
	top: 247px;
	left: 745px;
	font-size: 12px;
	text-decoration: none
}

.item_list {
	position: absolute;
	top: 70px;
	left: 505px;
	width: 300px;
	padding-top: 20px;
}

ul, li {
	padding: 0;
	margin: 0;
	font-size: 12px;
	list-style: none;
	border: 0;
	font-weight: normal;
}

.item_list ul {
	width: 100%
}

.item_list li {
	width: 100%;
	line-height: 24px;
	color: #fff;
}
</style>
</head>
<body>
	<div align=center>
		<div style="width: 960px;" margin:0auto; height:90px>
			<script>
				var code; //在全局定义验证码   
				//产生验证码  
				function createCode() {
					code = "";
					var codeLength = 4;//验证码的长度  
					var checkCode = document.getElementById("code");
					var random = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'A',
							'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
							'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
							'V', 'W', 'X', 'Y', 'Z');//随机数  
					for (var i = 0; i < codeLength; i++) {//循环操作  
						var index = Math.floor(Math.random() * 36);//取得随机数的索引（0~35）  
						code += random[index];//根据索引取得随机数加到code上  
					}
					checkCode.value = code;//把code值赋给验证码  
				}
				//校验验证码  
				function validate() {
					var inputCode = document.getElementById("validatecode").value
							.toUpperCase(); //取得输入的验证码并转化为大写        
					if (inputCode.length <= 0) { //若输入的验证码长度为0  
						alert("请输入验证码！"); //则弹出请输入验证码  
					} else if (inputCode != code) { //若输入的验证码与产生的验证码不一致时  
						alert("验证码输入错误!"); //则弹出验证码输入错误  
						createCode();//刷新验证码  
						document.getElementById("validatecode").value = "";//清空文本框  
					} else { //输入正确时  
						var userName=document.getElementById("username").value;
				    	var password=document.getElementById("p_t").value;
				    	var role;
				    	 var radio = document.getElementsByName("role");  
				    	    for (i=0; i<radio.length; i++) {  
				    	        if (radio[i].checked) {  
				    	        	role=radio[i].value;  
				    	        }  
				    	    } 
				    	$.ajax({
				    		url : '${path}/AuthCheck/checkUser',
							type : "GET",
							dataType : 'json',
							data : {//请求携带参数
								userName : userName,
								password : password,
								role:role
							},
							success : function(data) {
								if(data==1){
									window.location.href="http://www.fengling-tech.com.cn/AuthCheck/superAdmin";	
								    return;
								}
							    if(data==2){
									alert("您被禁止登录！请联系超级管理员");
									return;
								}
							    if(data==3){
									window.location.href="http://www.fengling-tech.com.cn/maple-earnings-web/AuthCheck/userManager";	
								    return;
								}
								else{
									alert("请核对用户名和密码！")
								}
							}
				    	});    
					}
				}
			
			</script>
		</div>
	</div>
	<div class="top">
		<form name="userLoginActionForm" id="userLoginActionForm"
			target="_parent">
			<input type="text" autofocus="true" id="username" name="username"
				maxlength="20" placeholder="账户..." onblur="" /> <input
				type="password" id="p_t" name="p_t" placeholder="密码..." /> <input
				type="text" id="validatecode" name="validatecode"
				placeholder="输入右侧验证码" maxlength="20" onblur="" /> <input
				type="button" id="code" onclick="createCode()" value="获取验证码" /> <input
				type="button" value="" id="login_bt" name="login_bt"
				onclick="validate()" /> <label id="radioa">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;超级管理员</label><input
				type="radio" value="2" id="radioa" name="role" /> <label id="radiob">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;普通管理员</label><input
				type="radio" value="1" id="radiob" name="role" checked="checked" />
		</form>
	</div>
	</div>
</body>
</html>