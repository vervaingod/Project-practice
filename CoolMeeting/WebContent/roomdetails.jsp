<%@page import="com.meeting.bean.EmployeeBean"%>
<%@page import="com.meeting.bean.MeetingRoomBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html" ;charset="gb2312">
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
				href="changepassword.jsp">[修改密码]</a></a><a href="login.jsp">[退出]</a>
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
					<li class="sidebar-menuitem"><a href="./PreAddMeetingServlet">注册审批</a></li>
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
			<div class="content-nav">会议预定 > 修改会议室信息</div>


			<%
				MeetingRoomBean meetingroomBean = (MeetingRoomBean) request
							.getAttribute("meetingRoomBean");
					if (meetingroomBean != null) {
			%>



			<form action="./UpdateMeetingRoomServlet" method="post">
				<fieldset>
					<legend>
						会议室信息
						<%=request.getAttribute("message") != null ? request
							.getAttribute("message") : ""%></legend>
					<table class="formtable">
						<tr>
							<td>门牌号:</td>
							<td><input id="roomnumber" name="roomnumber" type="text"
								readonly="readonly" value="<%=meetingroomBean.getRoomnumber()%>"
								maxlength="10" /></td>
						</tr>
						<tr>
							<td>会议室名称:</td>
							<td><input id="capacity" name="capacity" type="text"
								value="<%=meetingroomBean.getCapacity()%>" maxlength="20" /></td>
						</tr>
						<tr>
							<td>最多容纳人数：</td>
							<td><input id="roomcapacity" name="roomcapacity" type="text"
								value="<%=meetingroomBean.getRoomcapacity()%>" /></td>
						</tr>
						<tr>
							<td>当前状态：</td>


							<td><input type="radio" id="status" name="status"
								checked="checked" value="1" /><label for="status">启用</label> <input
								type="radio" id="status" name="status" value="0" /><label
								for="status">停用</label> <input type="radio" id="status"
								name="status" value="-1" /><label for="status">删除</label></td>
						</tr>
						<tr>
							<td>备注：</td>
							<td><textarea id="description" maxlength="200" rows="5"
									cols="60" name="note"><%=meetingroomBean.getNote()%></textarea>
							</td>
						</tr>
						<tr>
							<td colspan="2" class="command"><input type="submit"
								value="确认修改" class="clickbutton" /> <input type="button"
								class="clickbutton" value="返回" onclick="window.history.back();" />
							</td>
						</tr>
					</table>
				</fieldset>
			</form>
			<%
				} else {
						out.print("查询失败");

					}
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