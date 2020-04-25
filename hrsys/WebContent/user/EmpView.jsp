<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<html>
	<head>
		<title>任职信息</title>
		<link rel="stylesheet" type="text/css" href="../css/style.css">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		<script type="text/javascript">
			//****************-删除确认***************
			function del(employee_id) {
				//弹出确认框
				var flag = window.confirm("你确定要删除" + employee_id + "号员工的任职吗?");
				//如果单击确定，则执行DelEmpServlet，并且传入员工编号
				if (flag) {
					alert("删除成功");
					location.href = "DelEmpServlet?eid="+employee_id;
				}
			}
		</script>
	</head>

	<body>
		<!-- 页面头部 -->
		<jsp:include page="top.jsp"></jsp:include>
		<!-- 页面内容 -->
<table border="0" width="950" height="350"
			align="center">
			<tr>
				<td align="center" valign="top">
					<table width="90%" border="0" cellpadding="5" cellspacing="1"
						bgcolor="#CCCCCC">
						<tr>
							<td width="10%" height="24" bgcolor="#7FFFD4">
								员工编号
							</td>
							<td width="10%" height="24" bgcolor="#7FFFD4">
								员工姓名
							</td>
							<td width="7%" height="24" bgcolor="#7FFFD4">
								电话
							</td>
							<td width="10%" height="24" bgcolor="#7FFFD4">
								邮箱
							</td>
							<td width="13%" height="24" bgcolor="#7FFFD4">
								入职时间
							</td>
							<td width="7%" height="24" bgcolor="#7FFFD4">
								工资
							</td>
							<td width="7%" height="24" bgcolor="#7FFFD4">
								职务
							</td>
							<td width="7%" height="24" bgcolor="#7FFFD4">
								职务编号
							</td>
							<td width="7%" height="24" bgcolor="#7FFFD4">
								部门
							</td>
							<td width="7%" height="24" bgcolor="#7FFFD4">
								部门编号
							</td>
							<td width="15%" height="24" bgcolor="#7FFFD4">
								操作
							</td>
						</tr>
						<!-- 显示职务数据 -->
						<c:forEach items="${elist }" var="emp">
							<tr>
								<td bgcolor="#FFFFFF">
									${emp.eid }
								</td>
								<td bgcolor="#FFFFFF">
									${emp.ename }
								</td>
								<td bgcolor="#FFFFFF">
									${emp.etel}
								</td>
								<td bgcolor="#FFFFFF">
									${emp.eemail }
								</td>
								<td bgcolor="#FFFFFF">
									${emp.eworkdate }
								</td>
								<td bgcolor="#FFFFFF">
									${emp.esalary}
								</td>
								<td bgcolor="#FFFFFF">
									${emp.jname}
								</td>
								<td bgcolor="#FFFFFF">
									${emp.jid}
								</td>
								<td bgcolor="#FFFFFF">
									${emp.dname}
								</td>
								<td bgcolor="#FFFFFF">
									${emp.did}
								</td>
								<td bgcolor="#FFFFFF">
									<c:choose>
										<c:when test="${user.level == 1 }">
											<a href="QueryByIdEmpServlet?eid=${emp.eid}">修改</a>
											<a href="javascript:del(${emp.eid})">删除</a>
										</c:when>
										<c:otherwise>
											权限不足
										</c:otherwise>
									</c:choose>
								</td>
							</tr>
						</c:forEach>
						</table>
					<p>
					<c:if test="${user.level == 1 }">
						<a href="AddEmpServlet1">增加任职关系</a>
					</c:if>
											</p>
				</td>
			</tr>
	</table>
	<!-- 分页显示用界面 -->
	<table width="950" border="0" align="center" cellpadding="0" cellspacing="0" >
						<tr>
							<td height="24" align="center">
								共4条数据，每页显示9条，
								共1页，当前是第1页
							</td>
						</tr>
						<tr>
							<td height="24" align="center">
								<a href="?pagenum=1">首页</a>
								<a href="?pagenum=0">上页</a>
								<a href="?pagenum=2">下页</a>
								<a href="?pagenum=1">末页</a>
							</td>
						</tr>
						<tr>
							<td height="24" align="center">
								
									
									
										<font color="red"><b>1</b>
										</font>
									
								
							</td>
						</tr>
					</table>
		<!-- 页面底部 -->
		
<table width="100%" height=15% border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td><hr></td>
  </tr>
  <tr>
    <td align="center">©版权所有</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
  </tr>
</table>
	</body>
</html>