<%@page import="com.meeting.bean.EmployeeBean"%>
<%@page import="com.meeting.bean.PageBean"%>
<%@page import="com.meeting.bean.MeetingRoomBean"%>
<%@page import="java.util.List"%>
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
			<div class="content-nav">会议预定 > 查看会议室</div>


			<%
				List<MeetingRoomBean> meetingroomBeanList = (List<MeetingRoomBean>) request
							.getAttribute("meetingroomBeanList");

					if (meetingroomBeanList != null
							&& !meetingroomBeanList.isEmpty()) {
			%>
			<table class="listtable">
				<caption>
					所有会议室:
					<%=request.getAttribute("message") != null ? request
							.getAttribute("message") : ""%></caption>
				<tr class="listheader">
					<th>门牌编号</th>
					<th>会议室名称</th>
					<th>容纳人数</th>
					<th>当前状态</th>
					<th>操作</th>
				</tr>
				<%
					for (MeetingRoomBean meetingRoomBean : meetingroomBeanList) {
				%>
				<tr>
					<td><%=meetingRoomBean.getRoomnumber()%></td>
					<td><%=meetingRoomBean.getCapacity()%></td>
					<td><%=meetingRoomBean.getRoomcapacity()%></td>
					<td>
						<%
							int status = meetingRoomBean.getStatus();
										String showstatus = "";
										if (status == 1) {
											showstatus = "启用";
										} else {
											showstatus = "停用";
										}
						%> <%=showstatus%></td>
					<td><a class="clickbutton"
						href="./FetchMeetingRoomByRoomnumberServlet?id=<%=meetingRoomBean.getRoomnumber()%>">查看详情</a></td>
				</tr>
				<%
					}
							PageBean pageBean = (PageBean) request
									.getAttribute("pageBean");
							if (pageBean != null) {
				%>
				<tr>
					<td colspan="5"><a
						href="./FetchAllMeetingRoomServlet?pageno=1">首页</a> <a
						href="./FetchAllMeetingRoomServlet?pageno=<%=pageBean.getPageno() - 1%>">上一页</a>
						<a
						href="./FetchAllMeetingRoomServlet?pageno=<%=pageBean.getPageno() + 1%>">下一页</a>
						<a
						href="./FetchAllMeetingRoomServlet?pageno=<%=pageBean.getMaxpage()%>">尾页</a>
					</td>

				</tr>
				<%
					}
						} else {
							out.print("无会议室信息，请添加！");
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