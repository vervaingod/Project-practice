<%@page import="com.meeting.bean.EmployeeBean"%>
<%@page import="com.meeting.bean.MeetinginfoBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="styles/common.css" />
<title>CoolMeeting会议管理系统</title>
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
						href="./FetchDepartmentServlet">部门管理</a></li>
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
			<div class="content-nav">个人中心 > 我的会议</div>
			<table class="listtable">
				<caption>我将参加的会议：</caption>
				<%
					List<MeetinginfoBean> meetinginfoBeanList = (List<MeetinginfoBean>) request
								.getAttribute("meetinginfoBeanList");
						if (meetinginfoBeanList != null
								&& !meetinginfoBeanList.isEmpty()) {
				%>
				<tr class="listheader">
					<th>会议名称</th>
					<th>会议室名称</th>
					<th>会议开始时间</th>
					<th>会议结束时间</th>
					<th>会议预定时间</th>
					<th>预定者</th>
					<th>操作</th>
				</tr>
				<%
					for (MeetinginfoBean meetinginfoBean : meetinginfoBeanList) {
				%>

				<tr>
					<td><%=meetinginfoBean.getMeetingname()%></td>
					<td><%=meetinginfoBean.getCapacity()%></td>
					<td><%=meetinginfoBean.getStartdate()%></td>
					<td><%=meetinginfoBean.getEnddate()%></td>
					<td><%=meetinginfoBean.getAdddate() != null ? meetinginfoBean
								.getAdddate() : ""%></td>
					<td><%=meetinginfoBean.getAccountname()%></td>
					<td><a class="clickbutton"
						href="./MyMeetingDetailsServlet?meetingid=<%=meetinginfoBean.getMeetingid()%>">查看详情</a>
					</td>
				</tr>
				<%
					}
						} else {
							out.print("<tr><td>无会议信息</td></tr>");
						}
					}
				%>
			</table>
		</div>
	</div>
	<div class="page-footer">
		<hr />
		更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a> <img
			src="images/footer.png" alt="CoolMeeting" />
	</div>
</body>
</html>