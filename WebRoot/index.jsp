<%@page import="com.bubble.classes.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<title>电子商务安全与技术大作业</title>
	<link rel="stylesheet" type="text/css" href="dist/css/bootstrap.min.css">
	<style type="text/css">
		body{
			font-size: 20px;
		}
		h1{
			margin-left: 100px;
		}
		ul{
			list-style-type: none;
			margin-top: 100px;
			margin-left:-35px;
		}
		ul li{
			height: 50px;
			font-size: 25px;
			border: 1px solid #4F5A68;
			text-align: center;
			padding-top: 6px;
			margin-top: 2px;
		}
		ul li a span{
			float: left;
			margin-top: 8px;
		}
		td{
			height: 40px;
		}
	</style>
</head>
<body>
	<div class="container">
		<header class="row" style="height:60px;border:1px solid #000000;background-color:#3D4958;">
			<h1 style="color:#ffffff;">Secret Garden</h1>
		</header>
		<div style="height:500px;border:1px solid #000000;" class="row">
			<div class="col-md-2 text-center" style="height:500px;border:1px solid #000000;background-color:#FFFFFF;">
				<ul>
					<li id="getinfo">
						<span class="glyphicon glyphicon-comment"></span>
						<input type="button" value="查询信息"/>
					</li>
					<li id="getppwd">
						<span class="glyphicon glyphicon-wrench"></span>
						<input type="button" href="" value="获取公钥"/>
					</li>
					<li id="sendmsg">
						<span class="glyphicon glyphicon-share-alt"></span>
						<input type="button" value="密文发送"/>
					</li>
					<li id="out">
						<span class="glyphicon glyphicon-home"></span>
						<input type="button" value=" &nbsp;退  &nbsp;出 &nbsp;"/>
					</li>
					<li id="register">
						<span class="glyphicon glyphicon-pencil"></span>
						<input type="button" value=" &nbsp;注  &nbsp; 册 &nbsp;"/>
					</li>
					<li id="others">
						<span class="glyphicon glyphicon-phone"></span>
						<input type="button" value=" &nbsp;其  &nbsp; 他 &nbsp;"/>
					</li>
				</ul>
			</div>
			<div class="col-md-10" style="height:500px;border:1px solid #000000;">
<!-- 查询信息				 -->
				
				<form  style="margin-left:10%;margin-top:3%;display:none;" id="getinfo1">
					<table border="1">
						<%User myUser = (User)request.getSession().getAttribute("myUser"); %>
				 　　　　<caption style="color:blue;">我的信息列表</caption>
				 			<tr>
				 				<td>ID</td>
				 				<td><%=myUser.getId()%></td>
				 			</tr>
				 			<tr>
				 				<td>用户名</td>
				 				<td>${myUser.name}</td>
				 			</tr>
				 			<tr>
				 				<td>密码</td>
				 				<td>${myUser.pwd}</td>
				 			</tr>
				 			<tr>
				 				<td>公钥</td>
				 				<td>${myUser.pbk}</td>
				 			</tr>
				 			<tr>
				 				<td>密文</td>
				 				<td>${myUser.security}</td>
				 			</tr>
				 			<tr>
				 				<td>摘要算法</td>
				 				<td>${myUser.digest}</td>
				 			</tr>
				 			<tr>
				 				<td>加密算法</td>
				 				<td><%=myUser.getEnctypt()%></td>
				 			</tr>
					</table>
				</form>
<!-- 获取公钥 -->
				<form action="GetPbkServlet" method="post" style="margin-top:6%;margin-left:20%;display:block;" id="getppwd1">
					<table>
						<caption style="color:blue;">获取公钥信息</caption>
						<tr>
					        <td><br><label for="txtname">用户ID：</label></td>
					        <td><br><input type="text" id="" name="id" value='' /></td>
					    </tr>
					    <tr>
					        <td colspan=2 class="text-right"><br>
					            <input type="submit" class="btn btn-default" value="查询" />
					            <input type="reset" class="btn btn-default" value="取消" />
					        </td>
					    </tr>
					    <tr>
					        <td><br><br><label for="txtname">用户ID：</label></td>
					        <td><br><br><input type="text" id="pbk" name="" value="<%=session.getAttribute("id1")%>"/></td>
					    </tr>
					    <tr>
					        <td><br><br><label for="txtname">公共密钥：</label></td>
					        <td><br><br><input type="text" id="pbk" name="" value="<%=session.getAttribute("pbk1")%>"/></td>
					    </tr>
					</table>
				</form>
<%
	session.removeAttribute("pbk1");
	session.removeAttribute("id1");
 %>
<!-- 密文发送 -->
				<form action="SendPassage" method="post" style="margin-top:6%;margin-left:20%;display:none;" id="sendmsg1">
					<table>
						<caption style="color:blue;">密文发送</caption>
						<tr>
					        <td><br><label for="txtname">用户ID：</label></td>
					        <td><br><input type="text" id="" name="id" /></td>
					    </tr>
					    <tr>
					        <td><br><br><label for="txtname">密文：</label></td>
					        <td><br><br><input type="text" id="" name="security" /></td>
					    </tr>
					    <tr>
					        <td colspan=2 class="text-right"><br>
					            <input type="submit" class="btn btn-default" value="发送" />
					            <input type="reset" class="btn btn-default" value="取消" />
					        </td>
					    </tr>
					</table>
				</form>
			</div>
		</div>
		<footer class="row text-center" style="height:60px;border:1px solid #000000;background-color:#3D4958;">
			<h5>作者：电子商务1401 刘敏 02142027</h5>
		</footer>
	</div>
</body>
<script type="text/javascript" src="dist/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	
	$(function(){
		$('#getinfo').click(function(){
			$('#getinfo1').show();
			$('#getppwd1').hide();
			$('#sendmsg1').hide();
		});
		$('#getppwd').click(function(){
			$('#getinfo1').hide();
			$('#getppwd1').show();
			$('#sendmsg1').hide();
		});
		$('#sendmsg').click(function(){
			$('#getinfo1').hide();
			$('#getppwd1').hide();
			$('#sendmsg1').show();
		});
		$('#out').click(function(){
			window.open('login.jsp');
		});
		$('#register').click(function(){
			window.open('login.jsp');
		});
	});
	
	var xhr;
	if(window.XMLHttpRequest){
		xhr = new XMLHttpRequest();
	}else{
		xhr = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	xhr.open('POST','GetPbkServlet',onreadystatechange);
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById("#pbk").value = xhr.responseText;
		}
	}
	
</script>
</html>