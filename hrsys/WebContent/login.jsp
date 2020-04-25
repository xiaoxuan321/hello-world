<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>用户登陆</title>
		<link href="css/style.css" rel="stylesheet" type="text/css">
	</head>
	<body>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
	<br/>
		<form name="form1" method="post" action="LoginServlet">

			<table width="400" height="200" border="0" align="center" cellpadding="4"
				cellspacing="1" bgcolor="#7FFFD4">
				<tr>
					<td height="24" colspan="2" align="center" bgcolor="#7FFFD4">
						用户登陆
					</td>
				</tr>
				<tr>
					<td width="77" height="24" align="center" bgcolor="#E0FFFF">
						用户姓名
					</td>
					<td width="204" height="24" bgcolor="#E0FFFF">
						<input name="username" type="text" id="username" class="input1">
					</td>
				</tr>
				<tr>
					<td height="24" align="center" bgcolor="#E0FFFF">
						用户密码
					</td>
					<td height="24" bgcolor="#E0FFFF">
						<input name="userpwd" type="password" id="userpwd"
							class="input1">
					</td>
				</tr>
				<tr>
					<td height="24" align="center" bgcolor="#E0FFFF">
						管理级别
					</td>
					<td height="24" bgcolor="#E0FFFF">
						<input name="level" type="radio" value="1" >
						管理员
						<input name="level" type="radio" value="0">
						员工
					</td>
				</tr>
				<tr>
					<td height="24" colspan="2" align="center" bgcolor="#E0FFFF">
						<input type="submit" name="Submit" value="进入系统">
						&nbsp;&nbsp;
						<input type="hidden" name="targetURL" value="">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>