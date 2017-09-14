<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/global.jsp"%>
<!DOCTYPE HTML>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<style type="text/css">
.contact_form {
	border: 1px solid #DDDDDD;
	padding: 10px;
	width: 760px;
	margin: 40px auto 0 auto;
}
/* === Remove input autofocus webkit === */
*:focus {
	outline: none;
}

/* === Form Typography === */
body {
	font: 14px/21px "Lucida Sans", "Lucida Grande", "Lucida Sans Unicode",
		sans-serif;
}

.contact_form h2, .contact_form label {
	font-family: Georgia, Times, "Times New Roman", serif;
}

.form_hint, .required_notification {
	font-size: 11px;
}

/* === List Styles === */
.contact_form ul {
	list-style-type: none;
	list-style-position: outside;
	margin: 0px;
	padding: 0px;
}

.contact_form li {
	padding: 12px;
	border-bottom: 1px solid #eee;
	position: relative;
}

.contact_form li:first-child, .contact_form li:last-child {
	border-bottom: 1px solid #777;
}

/* === Form Header === */
.contact_form h2 {
	margin: 0;
	display: inline;
}

.required_notification {
	color: #d45252;
	margin: 5px 0 0 0;
	display: inline;
	float: right;
}

/* === Form Elements === */
.contact_form label {
	width: 150px;
	margin-top: 3px;
	display: inline-block;
	float: left;
	padding: 3px;
}

.contact_form input {
	height: 20px;
	width: 220px;
	padding: 5px 8px;
}

.contact_form textarea {
	padding: 8px;
	width: 300px;
}

.contact_form button {
	margin-left: 156px;
}

/* form element visual styles */
.contact_form input, .contact_form textarea {
	border: 1px solid #aaa;
	box-shadow: 0px 0px 3px #ccc, 0 10px 15px #eee inset;
	border-radius: 2px;
	padding-right: 30px;
	-moz-transition: padding .25s;
	-webkit-transition: padding .25s;
	-o-transition: padding .25s;
	transition: padding .25s;
}

.contact_form input:focus, .contact_form textarea:focus {
	background: #fff;
	border: 1px solid #555;
	box-shadow: 0 0 3px #aaa;
	padding-right: 70px;
}

/* === HTML5 validation styles === */
.contact_form input:required, .contact_form textarea:required {
	background: #fff
		url(${staticPath }/static/style/images/red_asterisk.png) no-repeat 98%
		center;
}

.contact_form input:required:valid, .contact_form textarea:required:valid
	{
	background: #fff url(${staticPath }/static/style/images/valid.png)
		no-repeat 98% center;
	box-shadow: 0 0 5px #5cd053;
	border-color: #28921f;
}

.contact_form input:focus:invalid, .contact_form textarea:focus:invalid
	{
	background: #fff url(${staticPath }/static/style/images/invalid.png)
		no-repeat 98% center;
	box-shadow: 0 0 5px #d45252;
	border-color: #b03535
}

/* === Form hints === */
.form_hint {
	background: #d45252;
	border-radius: 3px 3px 3px 3px;
	color: white;
	margin-left: 8px;
	padding: 1px 6px;
	z-index: 999; /* hints stay above all other elements */
	position: absolute; /* allows proper formatting if hint is two lines */
	display: none;
}

.form_hint::before {
	content: "\25C0";
	color: #d45252;
	position: absolute;
	top: 1px;
	left: -6px;
}

.contact_form input:focus+.form_hint {
	display: inline;
}

.contact_form input:required:valid+.form_hint {
	background: #28921f;
}

.contact_form input:required:valid+.form_hint::before {
	color: #28921f;
}

/* === Button Style === */
button.submit {
	background-color: #68b12f;
	background: -webkit-gradient(linear, left top, left bottom, from(#68b12f),
		to(#50911e));
	background: -webkit-linear-gradient(top, #68b12f, #50911e);
	background: -moz-linear-gradient(top, #68b12f, #50911e);
	background: -ms-linear-gradient(top, #68b12f, #50911e);
	background: -o-linear-gradient(top, #68b12f, #50911e);
	background: linear-gradient(top, #68b12f, #50911e);
	border: 1px solid #509111;
	border-bottom: 1px solid #5b992b;
	border-radius: 3px;
	-webkit-border-radius: 3px;
	-moz-border-radius: 3px;
	-ms-border-radius: 3px;
	-o-border-radius: 3px;
	box-shadow: inset 0 1px 0 0 #9fd574;
	-webkit-box-shadow: 0 1px 0 0 #9fd574 inset;
	-moz-box-shadow: 0 1px 0 0 #9fd574 inset;
	-ms-box-shadow: 0 1px 0 0 #9fd574 inset;
	-o-box-shadow: 0 1px 0 0 #9fd574 inset;
	color: white;
	font-weight: bold;
	padding: 6px 20px;
	text-align: center;
	text-shadow: 0 -1px 0 #396715;
}

button.submit:hover {
	opacity: .85;
	cursor: pointer;
}

button.submit:active {
	border: 1px solid #20911e;
	box-shadow: 0 0 10px 5px #356b0b inset;
	-webkit-box-shadow: 0 0 10px 5px #356b0b inset;
	-moz-box-shadow: 0 0 10px 5px #356b0b inset;
	-ms-box-shadow: 0 0 10px 5px #356b0b inset;
	-o-box-shadow: 0 0 10px 5px #356b0b inset;
}
</style>
<script type="text/javascript" src="common/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
	var useid = $
	{
		sessionScope.userId
	};
	$(document)
			.ready(
					function() {
						$
								.ajax({
									url : '${path}/AuthCheck/pickUserInfo',
									type : "POST",
									dataType : 'json',
									data : {//请求携带参数
										userId : useid
									},
									success : function(data) {
										document.getElementById("name").value = data["name"];
										document.getElementById("email").value = data["email"];
										document.getElementById("tel").value = data["tel"];
										document.getElementById("companyName").value = data["companyName"];
										document.getElementById("nashui").value = data["nashui"];
										document.getElementById("addr").value = data["addr"];
										document.getElementById("kaihu").value = data["kaihu"];

									}
								});
						$('.too-plain').focus(function() {

							if ($(this).val() == "Enter your email here")
								$(this).val('');

						}).blur(function() {

							if ($(this).val() == "")
								$(this).val('Enter your email here');

						});

						$('.username-label, .password-label').animate({
							opacity : "0.4"
						}).click(function() {
							var thisFor = $(this).attr('for');
							$('.' + thisFor).focus();
						});

						$('.username').focus(function() {

							$('.username-label').animate({
								opacity : "0"
							}, "fast");

							if ($(this).val() == "username")
								$(this).val() == "";

						}).blur(function() {

							if ($(this).val() == "") {
								$(this).val() == "username";
								$('.username-label').animate({
									opacity : "0.4"
								}, "fast");
							}
						});

						$('.password').focus(function() {

							$('.password-label').animate({
								opacity : "0"
							}, "fast");

							if ($(this).val() == "password") {
								$(this).val() == "";
							}
						}).blur(function() {

							if ($(this).val() == "") {
								$(this).val() == "password";
								$('.password-label').animate({
									opacity : "0.4"
								}, "fast");
							}
						});

						$('.username-label-sliding, .password-label-sliding')
								.animate({
									opacity : "0.4"
								}).click(function() {
									var thisFor = $(this).attr('for');
									$('.' + thisFor).focus();
								});

						$('.username-sliding').focus(function() {

							$('.username-label-sliding').animate({
								marginLeft : "7em"
							}, "fast");

							if ($(this).val() == "username")
								$(this).val() == "";

						}).blur(function() {

							if ($(this).val() == "") {
								$(this).val() == "username";
								$('.username-label-sliding').animate({
									marginLeft : "12px"
								}, "fast");
							}
						});

						$('.password-sliding').focus(function() {

							$('.password-label-sliding').animate({
								marginLeft : "7em"
							}, "fast");

							if ($(this).val() == "password") {
								$(this).val() == "";
							}
						}).blur(function() {

							if ($(this).val() == "") {
								$(this).val() == "password";
								$('.password-label-sliding').animate({
									marginLeft : "12px"
								}, "fast");
							}
						});

					});
</script>
<script type="text/javascript">
	function jianquan() {
		window.location.href = "https://oauth.tbsandbox.com/authorize?response_type=code&client_id=1024484863&redirect_uri=http://www.fengling-tech.com.cn/maple-earnings-web/AuthCheck/callback&state=1212&view=web";
		;
		//	window.location.href="https://oauth.tbsandbox.com/authorize?response_type=code&client_id=1024484863&redirect_uri=http://www.fengling-tech.com.cn:8080/AuthCheck/callback&state=1212&view=web";;

	}
	function jianquanzs() {
		if (document.getElementById("name").value == "") {
			alert("用户名不能为空.");
			return;
		}
		if (document.getElementById("email").value == "") {
			alert("邮箱不能为空.");
			return;
		}
		if (document.getElementById("tel").value == "") {
			alert("联系方式不能为空.");
			return;
		}
		if (document.getElementById("companyName").value == "") {
			alert("公司名不能为空.");
			return;
		}
		if (document.getElementById("nashui").value == "") {
			alert("纳税人识别号不能为空.");
			return;
		}
		if (document.getElementById("addr").value == "") {
			alert("公司地址不能为空.");
			return;
		} else {
			var name = document.getElementById("name").value;
			var email = document.getElementById("email").value;
			var tel = document.getElementById("tel").value;
			var companyName = document.getElementById("companyName").value;
			var nashui = document.getElementById("nashui").value;
			var addr = document.getElementById("addr").value;
			var kaihu = document.getElementById("kaihu").value;
			$.ajax({
				url : '${path}/AuthCheck/saveUser',
				type : "POST",
				dataType : 'json',
				data : {//请求携带参数
					name : name,
					email : email,
					tel : tel,
					companyName : companyName,
					nashui : nashui,
					addr : addr,
					kaihu : kaihu
				},
				success : function(data) {
					if (data == 1) {
						window.location.href="http://www.fengling-tech.com.cn/AuthCheck/returnlogin";	

					}
				}
			});
		}
	}
	function houtaiguanli() {
		window.location.href = "http://www.fengling-tech.com.cn/AuthCheck/adminLogin";

	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>淘宝对账系统</title>
</head>
<body>
	<form class="contact_form" action="#" method="post" name="contact_form">
		<ul>
			<li>
				<h2>联系信息</h2> <span class="required_notification">* 表示必填项</span>
			</li>
			<li><label for="name">姓名:</label> <input type="text" id="name"
				placeholder="联系人姓名" required /></li>
			<li><label for="email">电子邮件:</label> <input type="email"
				id="email" name="email" placeholder="****@**.com" required /> <span
				class="form_hint">正确格式为：***@**.com</span></li>
			<li><label for="name">联系人电话:</label> <input type="text" id="tel"
				name="tel" placeholder="联系人电话" required /> <span class="form_hint">正确格式为：11位有效的手机号码</span></li>
			<li><h2>发票信息</h2></li>
			<li><label for="name">公司名称:</label> <input type="text"
				id="companyName" name="companyName" placeholder="公司名称" required />
				<span class="form_hint">正确格式为：有效英文或者汉字</span></li>
			<li><label for="name">纳税人识别号:</label> <input type="text"
				id="nashui" name="companyName" placeholder="纳税人识别号" required /> <span
				class="form_hint">请输入纳税人识别号</span></li>
			<li><label for="name">开户行账号:</label> <input type="text"
				id="kaihu" name="companyName" placeholder="开户行账号" /> <span
				class="form_hint"></span></li>
			<li><label for="message">公司地址:</label> <textarea name="message"
					id="addr" cols="40" rows="4" placeholder="公司地址" required></textarea></li>
			<li>
				<button class="submit" type="button" onclick="jianquanzs();">提交</button>

			</li>
		</ul>
	</form>
</body>
</html>