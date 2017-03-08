<%@page import="com.meeting.bean.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CoolMeeting会议管理系统</title>
<link rel="stylesheet" href="styles/common.css" />
<style type="text/css">
</style>
</head>
<body>
	<div class="page-header">
		<div class="header-banner">
			<img src="images/header.png" alt="CoolMeeting" />
		</div>
		<div class="header-title">欢迎访问Cool-Meeting会议管理系统</div>
		<div class="header-quicklink">
			<a href="login.jsp">[返回登录]</a>
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
		<%=request.getAttribute("message") != null ? request
					.getAttribute("message") : ""%>
		<div class="page-content">
			<div class="content-nav">人员管理 > 员工注册</div>
			<form action="RegisterServlet" method="post">
				<fieldset>
					<legend>员工信息</legend>
					<table class="formtable" style="width: 50%">
						<tr>
							<td>姓名：</td>
							<td><input type="text" id="employeename" maxlength="20"
								name="employeename"
								value="<%=request.getAttribute("temp_employeename") != null ? request
					.getAttribute("temp_employeename") : ""%>" />
							</td>
						</tr>
						<tr>
							<td>账户名：</td>
							<td><input type="text" id="accountname" maxlength="20"
								name="accountname"
								value="<%=request.getAttribute("temp_accountname") != null ? request
					.getAttribute("temp_accountname") : ""%>" /></td>
						</tr>
						<tr>
							<td>密码：</td>
							<td><input type="password" id="password" maxlength="20"
								placeholder="请输入6位以上的密码" name="password" /></td>
						</tr>
						<tr>
							<td>确认密码：</td>
							<td><input type="password" id="confirm" maxlength="20"
								name="pwdconfirm" /></td>
						</tr>
						<tr>
							<td>联系电话：</td>
							<td><input type="text" id="phone" maxlength="20"
								name="phone"
								value="<%=request.getAttribute("temp_phone") != null ? request
					.getAttribute("temp_phone") : ""%>" /></td>
						</tr>
						<tr>
							<td>电子邮件：</td>
							<td><input type="text" id="email" maxlength="20"
								name="email"
								value="<%=request.getAttribute("temp_email") != null ? request
					.getAttribute("temp_email") : ""%>" /></td>
						</tr>
						<tr>
							<td>所属部门号：</td>
							<td><input type="text" id="departmentid" maxlength="20"
								name="departmentid"
								value="<%=request.getAttribute("temp_departmentid") != null ? request
					.getAttribute("departmentid") : ""%>" /></td>
						</tr>
						<tr>
							<td colspan="6" class="command"><input type="submit"
								class="clickbutton" value="注册" /> <input type="submit"
								class="clickbutton" value="重置" /></td>
						</tr>
					</table>
				</fieldset>
			</form>
		</div>
	</div>
	<div class="page-footer">
		<hr />
		更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a> <img
			src="images/footer.png" alt="CoolMeeting" />
	</div>
</body>
</html>