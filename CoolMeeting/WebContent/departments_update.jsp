<%@page import="com.meeting.bean.EmployeeBean"%>
<%@page import="com.meeting.bean.DepartmentBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html ;charset=UTF-8">
<title>CoolMeeting会议管理系统</title>
<link rel="stylesheet" href="styles/common.css" />
</head>
<body>
<% 
	EmployeeBean employeeBean = (EmployeeBean)request.getSession().getAttribute("employeeBean");
%>
	<div class="page-header">
		<div class="header-banner">
			<img src="images/header.png" alt="CoolMeeting" />
		</div>
		<div class="header-title">欢迎访问Cool-Meeting会议管理系统</div>
		<div class="header-quicklink">
			欢迎您，<strong><%=employeeBean.getAccountname()%></strong> <a href="changepassword.jsp">[修改密码]</a><a href="login.jsp">[退出]</a>
		</div>
	</div>
	<div class="page-body">
		<div class="page-sidebar">
			<div class="sidebar-menugroup">
				<div class="sidebar-grouptitle">个人中心</div>
				<ul class="sidebar-menu">
					<li class="sidebar-menuitem"><a href="#">最新通知</a></li>
					<li class="sidebar-menuitem active"><a href="#">我的预定</a></li>
					<li class="sidebar-menuitem"><a href="#">我的会议</a></li>
				</ul>
			</div>
			<div class="sidebar-menugroup">
				<div class="sidebar-grouptitle">人员管理</div>
				<ul class="sidebar-menu">
					<li class="sidebar-menuitem"><a
						href="./FetchDepartmentServlet">部门管理</></li>
					<li class="sidebar-menuitem"><a href="#">员工注册</a></li>
					<li class="sidebar-menuitem"><a href="#">注册审批</a></li>
					<li class="sidebar-menuitem"><a href="#">搜索员工</a></li>
				</ul>
			</div>
			<div class="sidebar-menugroup">
				<div class="sidebar-grouptitle">会议预定</div>
				<ul class="sidebar-menu">
					<li class="sidebar-menuitem"><a href="#">添加会议室</a></li>
					<li class="sidebar-menuitem"><a href="#">查看会议室</a></li>
					<li class="sidebar-menuitem"><a href="#">预定会议</a></li>
					<li class="sidebar-menuitem"><a href="#">搜索会议</a></li>
				</ul>
			</div>
		</div>
		<div class="page-content">
			<div class="content-nav">人员管理 > 部门管理</div>
			<%
				DepartmentBean departmentBean = (DepartmentBean) session
						.getAttribute("departmentBean");
				if (departmentBean != null) {
			%>
			<form action="./UpdateDepartmentServlet" method="post">
				<fieldset>
					<legend>编辑部门</legend>
					部门编号:<input type="text" id="departmentname" name="departmentid"
						value="<%=departmentBean.getDepartmentid()%>" readonly="readonly" /><br />
					<br /> 部门名称: <input type="text" id="departmentname"
						name="departmentname"
						value="<%=departmentBean.getDepartmentname()%>" maxlength="20" />&nbsp;&nbsp;&nbsp;
					<input type="submit" class="clickbutton" value="修改" />&nbsp;&nbsp;&nbsp; <font
						color="red"><%=request.getAttribute("message") != null ? request
						.getAttribute("message") : ""%></font>
				</fieldset>
			</form>
			<br /> <a class="clickbutton" href="./FetchDepartmentServlet">返回部门列表</a>
			<%
				} else {
					request.setAttribute("message", "该部门信息不存在，请确认后重新查看");
					request.getRequestDispatcher("./FetchDepartmentServlet")
							.forward(request, response);
				}
			%>

		</div>
	</div>
	<div class="page-footer">
		<hr />
		更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a> <img
			src="images/footer.png" alt="CoolMeeting" />
	</div>
</body>
</html>