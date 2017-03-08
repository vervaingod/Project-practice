<%@page import="com.meeting.bean.EmployeeBean"%>
<%@page import="java.util.List"%>
<%@page import="com.meeting.bean.MeetinginfoBean"%>
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
	<%
		EmployeeBean employeeBean = (EmployeeBean) request.getSession()
				.getAttribute("employeeBean");
	%>
	<div class="page-header">
		<div class="header-banner">
			<img src="images/header.png" alt="CoolMeeting" />
		</div>
		<div class="header-title">欢迎访问Cool-Meeting会议管理系统</div>
		<div class="header-quicklink">
			欢迎您，<strong><%=employeeBean.getAccountname()%></strong> <a
				href="changepassword.jsp">[修改密码]</a>
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
			<div class="content-nav">个人中心 > 我的预定</div>
			<%=request.getAttribute("message") != null ? request
					.getAttribute("message") : ""%>
			<table class="listtable">
				<caption>我预定的会议：</caption>
				<tr class="listheader">
					<th>会议名称</th>
					<th>会议室名称</th>
					<th>会议开始时间</th>
					<th>会议结束时间</th>
					<th>会议预定时间</th>
					<th>操作</th>
				</tr>
				<%
					List<MeetinginfoBean> meetinginfoBeanList = (List<MeetinginfoBean>) request
							.getAttribute("meetinginfoBeanList");
					if (meetinginfoBeanList != null && !meetinginfoBeanList.isEmpty()) {
				%>


				<%
					for (MeetinginfoBean meetinginfoBean : meetinginfoBeanList) {
				%>
				<tr>
					<td><%=meetinginfoBean.getMeetingname()%></td>
					<td><%=meetinginfoBean.getCapacity()%></td>
					<td><%=meetinginfoBean.getStartdate()%></td>
					<td><%=meetinginfoBean.getEnddate()%></td>
					<td><%=meetinginfoBean.getAdddate()!=null?meetinginfoBean.getAdddate():""%></td>
					<td><a class="clickbutton"
						href="./CancelMeetingServlet?meetingid=<%=meetinginfoBean.getMeetingid()%>">查看/撤销</a>
					</td>
				</tr>
				<%
					}
					} else {
						out.print("<tr><td colspan='6'>无会议！</td></tr>");
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