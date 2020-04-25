<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">


<html>
	<head>
		<title>职务信息</title>
		<link rel="stylesheet" type="text/css" href="../css/style.css">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

		<script type="text/javascript">
			//****************-删除确认***************
			function del(job_id) {
				//弹出确认框
				var flag = window.confirm("你确定要删除" + job_id + "号职务吗?");
								
				//如果单击确定，则执行DelJobsServlet，并且传入职务编号
				if (flag) {
					alert("删除成功");
					location.href = "DelJobServlet?jid="+job_id;
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
							<th width="16%" height="24" align="center" bgcolor="#7FFFD4">
								职务编号
							</th>
							<th width="21%" height="24" align="center" bgcolor="#7FFFD4">
								职务名称
							</th>
							<th width="23%" height="24" align="center" bgcolor="#7FFFD4">
								最低工资
							</th>
							<th width="24%" height="24" align="center" bgcolor="#7FFFD4">
								最高工资
							</th>
							<th width="16%" height="24" align="center" bgcolor="#7FFFD4">
								操作
							</th>
						</tr>
						<!-- 显示职务数据 -->
						<c:forEach items="${jlist }" var="job">
							<tr>
								<td bgcolor="#FFFFFF">
									${job.jid}
								</td>
								<td bgcolor="#FFFFFF">
									${job.jname}
								</td>
								<td bgcolor="#FFFFFF">
									${job.lowsalary}
								</td>
								<td bgcolor="#FFFFFF">
									${job.highsalary}
								</td>
								<td bgcolor="#FFFFFF">
									<c:choose>
										<c:when test="${user.level == 1 }">
											<a href="QueryByIdJobServlet?jid=${job.jid }">修改</a>
											<a href="javascript:del(${job.jid })">删除</a>
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
						<a href="AddJobs.jsp">增加新职务</a>
					</c:if>
											</p>
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