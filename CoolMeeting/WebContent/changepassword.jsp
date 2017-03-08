<%@page import="com.meeting.bean.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CoolMeeting会议管理系统</title>
<link rel="stylesheet" href="styles/common.css" />
</head>
<body>
	<div class="page-header">
		<div class="header-banner">
			<img src="images/header.png" alt="CoolMeeting" />
		</div>
		<div class="header-title">欢迎访问Cool-Meeting会议管理系统</div>
		<div class="header-quicklink">
			<%
				EmployeeBean employeeBean = (EmployeeBean) request.getSession()
						.getAttribute("employeeBean");
			%>
			欢迎您，<strong><%=employeeBean.getAccountname()%></strong> <a
				href="changepassword.jsp">[修改密码]</a><a href="login.jsp">[退出]</a>
		</div>
	</div>
	<div class="page-body">
		<div class="page-sidebar">
			<div class="sidebar-menugroup">
				<div class="sidebar-grouptitle">个人中心</div>
				<ul class="sidebar-menu">
					<li class="sidebar-menuitem"><a href="notifications.jsp">最新通知</a></li>
					<li class="sidebar-menuitem active"><a href="mybookings.jsp">我的预定</a></li>
					<li class="sidebar-menuitem"><a href="mymeetings.jsp">我的会议</a></li>
				</ul>
			</div>
			<div class="sidebar-menugroup">
				<div class="sidebar-grouptitle">人员管理</div>
				<ul class="sidebar-menu">
					<li class="sidebar-menuitem"><a href="departments.jsp">部门管理</></li>
					<li class="sidebar-menuitem"><a href="register.jsp">员工注册</a></li>
					<li class="sidebar-menuitem"><a href="approveaccount.jsp">注册审批</a></li>
					<li class="sidebar-menuitem"><a href="searchemployees.jsp">搜索员工</a></li>
				</ul>
			</div>
			<div class="sidebar-menugroup">
				<div class="sidebar-grouptitle">会议预定</div>
				<ul class="sidebar-menu">
					<li class="sidebar-menuitem"><a href="addmeetingroom.jsp">添加会议室</a></li>
					<li class="sidebar-menuitem"><a href="meetingrooms.jsp">查看会议室</a></li>
					<li class="sidebar-menuitem"><a href="bookmeeting.jsp">预定会议</a></li>
					<li class="sidebar-menuitem"><a href="searchmeetings.jsp">搜索会议</a></li>
				</ul>
			</div>
		</div>

		<form action="ChangePasswordServlet" method="post">
			<div class="page-content">
				<div class="content-nav">修改密码</div>

				<fieldset>
					<legend>修改密码信息</legend>
					<%=request.getAttribute("message") != null ? request
					.getAttribute("message") : ""%>
					<table class="formtable" style="width: 50%">
						<tr>
							<td>原密码:</td>
							<td><input id="origin" type="password" name="originpwd" /></td>
						</tr>
						<tr>
							<td>新密码:</td>
							<td><input id="new" type="password" name="password" /></td>
						</tr>
						<tr>
							<td>确认新密码：</td>
							<td><input id="confirm" type="password" name="newpwd" /></td>
						</tr>
						<tr>
							<td colspan="2" class="command"><input type="submit"
								value="确认修改" class="clickbutton" /> <input type="submit"
								value="返回" class="clickbutton" onclick="window.history.back();" />
							</td>
						</tr>
					</table>
				</fieldset>
		</form>
		<a href="login.jsp">返回</a>

	</div>
	</div>
	<div class="page-footer">
		<hr />
		更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a> <img
			src="images/footer.png" alt="CoolMeeting" />
	</div>
</body>
</html>