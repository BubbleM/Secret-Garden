<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<title>登录</title>
	<link rel="stylesheet" type="text/css" href="dist/css/bootstrap.min.css">
	<style type="text/css">
		#center1{
			height: 400px;
			width: 700px;
			border: 1px solid #000000;
			margin-left: 20%;
			margin-top: 4%;
		}
	</style>
</head>
<body>	
	<div class="container">
		<header class="row" style="height:60px;border:1px solid #000000;background-color:#3D4958;"></header>
		<div style="height:500px;border:1px solid #000000;" class="row text-center">
			<div id="center1" class="row">
				<div class="col-md-5" style="height:400px;border:1px solid #000000;"></div>
				<div class="col-md-7" style="height:400px;border:1px solid #000000;">
<!-- 登录 -->
					<form id="login" enctype="" action="LoginCLServlet" method="post" style="margin-top:25%;margin-left:12%;display:block;">
					    <table>
					    	<thead>
					    		<tr>
					    			<th>用户登录</th>
					    		</tr>
							</thead>
					        <tr>
					            <td><br><label for="txtname">I &nbsp;D：</label></td>
					            <td><br><input type="text" id="id" name="id" /></td>
					        </tr>
					        <tr>
					            <td><br><label for="txtpswd">密  码：</label></td>
					            <td><br><input type="password" id="txtpswd" name="pwd" /></td>
					        </tr>
					        <tr>
					            <td colspan=2 class="text-right"><br>
					                <input type="submit" id="yes" class="btn btn-default" value="确认" />
					                <input type="button" class="btn btn-default" value="注册" id="register" />
					            </td>
					        </tr>
					    </table>
					</form>
<!-- 注册 -->
					<form id="regist" enctype="" action="RegisterCLServlet"  method="post" style="margin-top:10%;margin-left:12%;display:none;">
					    <table>
							<thead>
								<tr>
									<th>用户注册</th>
								</tr>
							</thead>
							<tr>
					            <td><br><label for="txtname">I &nbsp; D：</label></td>
					            <td><br><input type="text" id="txtname" name="id" /></td>
					        </tr>
					        <tr>
					            <td><br><label for="txtname">用  &nbsp;户 &nbsp;名：</label></td>
					            <td><br><input type="text" id="txtname" name="name" /></td>
					        </tr>
					        <tr>
					            <td><br><label for="txtpswd">密 &nbsp;&nbsp;码：</label></td>
					            <td><br><input type="password" id="txtpswd" name="pwd" /></td>
					        </tr>
					         <tr>
					            <td><br><label for="txtname">公 &nbsp; 开 &nbsp; 密  &nbsp;钥：</label></td>
					            <td><br><input type="text" id="txtname" name="pbk" /></td>
					        </tr>
					        <tr>
					            <td><br><label for="txtpswd">数字摘要算法：</label></td>
					            <td><br>
					            	<input type="text" id="txtpswd" name="digest" list="list1">
					            	<datalist id="list1">
					            		<option value="MD5">
					           			<option value="SHA">
					           		</datalist>	
					            </td>
					        </tr>
					         <tr>
					            <td><br><label for="txtname">非对称密码算法：</label></td>
					            <td><br>
					            	<input type="text" id="txtname" name="encrypt" list="list2" >
					           		<datalist id="list2">
					           			<option value="RSA">
					           		</datalist>	
					            </td>
					        </tr>
					        <tr>
					            <td colspan=2 class="text-right"><br>
					                <input type="submit" id="yes" class="btn btn-default" value="确认" />
					                <input type="button" class="btn btn-default" value="取消" />
					            </td>
					        </tr>
					    </table>
					</form>
				</div>
			</div>
		</div>
		<footer class="row text-center" style="height:60px;border:1px solid #000000;background-color:#3D4958;"></footer>
	</div>
</body>
<script type="text/javascript" src="dist/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
	$(function(){
		$('#register').click(function(){
			$('#login').hide();
			$('#regist').show();
		});
		/*$('#yes').click(function(){
			window.open('index.jsp');
		});*/
	});
	
</script>
</html>