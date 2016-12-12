<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<title>错误页面</title>
<script type="text/javascript">
	window.onload = function(){
		alert("密码输入错误，请重新输入");
	}
</script>

</head>
<body>
	
</body>

</html>