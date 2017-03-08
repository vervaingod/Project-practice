<%@page import="com.meeting.bean.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html" ;charset="UTF-8">
<title>CoolMeeting会议管理系统</title>
<link rel="stylesheet" href="styles/common.css" />
</head>
<body>
	<%
		EmployeeBean employeeBean = (EmployeeBean) request.getSession()
				.getAttribute("employeeBean");
		if (employeeBean == null) {
			request.setAttribute("message", "您还未登录，请先登录");
			request.getRequestDispatcher("login.jsp").forward(request,
					response);
		} else {
	%>

	<div class="page-header">
		<div class="header-banner">
			<img src="images/header.png" alt="CoolMeeting" />
		</div>
		<div class="header-title">欢迎访问Cool-Meeting会议管理系统</div>
		<div class="header-quicklink">
			欢迎您，<strong><%=employeeBean.getAccountname()%></strong> <a
				href="changepassword.jsp">[修改密码]</a><a href="login.jsp">[退出]</a>
		</div>
	</div>
	<div class="page-body">
		<div class="page-sidebar">
			<div class="sidebar-menugroup">
				<div class="sidebar-grouptitle">个人中心</div>
				<ul class="sidebar-menu">
					<li class="sidebar-menuitem"><a href="./NotificationsServlet">最新通知</a></li>
					<li class="sidebar-menuitem active"><a
						href="./MyBookingsServlet">我的预定</a></li>
					<li class="sidebar-menuitem"><a href="./MyMeetingsServlet">我的会议</a></li>
				</ul>
			</div>
			<div class="sidebar-menugroup">
				<div class="sidebar-grouptitle">人员管理</div>
				<ul class="sidebar-menu">
					<li class="sidebar-menuitem"><a
						href="./FetchDepartmentServlet">部门管理</></li>
					<li class="sidebar-menuitem"><a href="register.jsp">员工注册</a></li>
					<li class="sidebar-menuitem"><a href="./FetchEmployeeServlet">注册审批</a></li>
					<li class="sidebar-menuitem"><a href="./SearchEmployeeServlet">搜索员工</a></li>
				</ul>
			</div>
			<div class="sidebar-menugroup">
				<div class="sidebar-grouptitle">会议预定</div>
				<ul class="sidebar-menu">
					<li class="sidebar-menuitem"><a href="addmeetingroom.jsp">添加会议室</a></li>
					<li class="sidebar-menuitem"><a
						href="./FetchAllMeetingRoomServlet">查看会议室</a></li>
					<li class="sidebar-menuitem"><a href="./PreAddMeetingServlet">预定会议</a></li>
					<li class="sidebar-menuitem"><a href="./SearchMeetingsServlet">搜索会议</a></li>
				</ul>
			</div>
		</div>
		<div class="page-content">
			<div class="content-nav">会议预定 > 添加会议室</div>
			<form action="./AddMeetingRoomServlet">
				<fieldset>
					<legend>
						会议室信息
						<%=request.getAttribute("message") != null ? request
						.getAttribute("message") : ""%></legend>
					<table class="formtable">
						<tr>
							<td>门牌号:</td>
							<td><input id="roomnumber" name="roomnumber" type="text"
								placeholder="例如：201" maxlength="10" /></td>
						</tr>
						<tr>
							<td>会议室名称:</td>
							<td><input id="capacity" name="capacity" type="text"
								placeholder="例如：第一会议室" maxlength="20" /></td>
						</tr>
						<tr>
							<td>最多容纳人数：</td>
							<td><input id="roomcapacity" type="text" name="roomcapacity"
								placeholder="填写一个正整数" /></td>
						</tr>
						<tr>
							<td>当前状态：</td>
							<td><input type="radio" id="status" name="status"
								checked="checked" value="1" /> <label for="status">启用</label> <input
								type="radio" id="status" name="status" value="0" /><label
								for="status">停用</label> <input type="radio" id="status"
								name="status" value="-1" /><label for="status">删除</label></td>
						</tr>
						<tr>
							<td>备注：</td>
							<td><textarea id="note" maxlength="200" rows="5" name="note"
									cols="60" placeholder="200字以内的文字描述"></textarea></td>
						</tr>
						<tr>
							<td colspan="2" class="command"><input type="submit"
								value="添加" class="clickbutton" /> <input type="reset"
								value="重置" class="clickbutton" /></td>
						</tr>
						<tr>
							<strong> <%
 	}
 %>
							</strong>

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