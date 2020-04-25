<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'top.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
			<style>
			ul {
			    list-style-type: none;
			    margin: 0;
			    padding: 0;
			    overflow: hidden;
			    background:rgba(0, 0, 0, 0.1);
			}
			
			li {
			    float: left;
			}
			
			li a {
			    display: block;
			    color: black;
			    text-align: center;
			    padding: 14px 16px;
			    text-decoration: none;
			}
			
			li a:hover {
			    background-color: #33FF99;
			    color:#0000ff;
			}
			li a:link {color:#000000;font-size:16px}
			</style>

	</head>

	<body>
		<table width="100%" height=20% border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td height="20" width="100%" >
				<div class="imgcenter">
				<font size="7" face="SimSun" color="#4682B4" style="font-size:10 px;border:10px;background:rgba(0, 0, 0, 0); "><b>Welcome to human resource management system 
				</b>
				</font>
				</div>
				</td>
			</tr>
			<tr>
				<td><ul>
				  <li><a class="active" href="default.jsp">首页</a></li>
				  <li><a href="QueryDeptServlet">部门查询</a></li>
				  <li><a href="QueryJobsServlet">职务查询</a></li>
				  <li><a href="QueryEmpServlet">任职查询</a></li>
				  <li><a href="logout.jsp">退出登录</a></li>
				</ul>
			</tr>
			<tr>
				<td height="24" align="right" >
					当前用户:${user.username } &nbsp;&nbsp;身份:
					<c:choose>
						<c:when test="${user.level == 1 }">
							管理员
						</c:when>
						<c:otherwise>
							员工
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</table>
	</body>
</html>
