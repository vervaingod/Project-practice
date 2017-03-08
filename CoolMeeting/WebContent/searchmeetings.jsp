<%@page import="com.meeting.bean.EmployeeBean"%>
<%@page import="com.meeting.bean.PageBean"%>
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
<style type="text/css">
</style>
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
			<div class="content-nav">会议预定 > 搜索会议</div>
			<form action="./SearchMeetingsServlet" method="post">
				<fieldset>
					<legend>搜索会议</legend>

					<table class="formtable">
						<tr>
							<td>会议名称：</td>
							<td><input type="text" name="meetingname" maxlength="20" /></td>
							<td>会议室名称：</td>
							<td><input type="text" name="capacity" maxlength="20" /></td>
							<td>预定者姓名：</td>
							<td><input type="text" name="accountname" maxlength="20" /></td>
						</tr>
						<tr>
							<td>预定日期：</td>
							<td colspan="5"><input type="date" name="adddate"
								placeholder="例：2013-10-20 07:00:00" style="width: 175px" /></td>
						</tr>
						<tr>
							<td>会议日期：</td>
							<td colspan="5">从&nbsp;<input type="date" name="startdate"
								placeholder="例：2013-10-20 08:00:00" style="width: 175px" />
								到&nbsp;<input type="date" name="enddate"
								placeholder="例：2013-10-22 12:00:00" style="width: 175px" />
							</td>
						</tr>
						<tr>
							<td colspan="6" class="command"><input type="submit"
								class="clickbutton" value="查询" /> <input type="reset"
								class="clickbutton" value="重置" /></td>
						</tr>
					</table>

				</fieldset>
			</form>
			<br />
			<h3 style="text-align: center; color: black">查询结果</h3>
			<br />

			<table class="listtable">
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
					List<MeetinginfoBean> meetinginfoBeanList = (List<MeetinginfoBean>) session
							.getAttribute("meetinginfoBeanList");

					if (meetinginfoBeanList != null && !meetinginfoBeanList.isEmpty()) {

						for (MeetinginfoBean meetinginfoBean2 : meetinginfoBeanList) {
				%>
				<tr>
					<td><%=meetinginfoBean2.getMeetingname()%></td>
					<td><%=meetinginfoBean2.getCapacity()%></td>
					<td><%=meetinginfoBean2.getStartdate() %></td>
					<td><%=meetinginfoBean2.getEnddate()%></td>
					<td><%=meetinginfoBean2.getAdddate().replace(".0", "") %></td>
					<td><%=meetinginfoBean2.getAccountname()%></td>
					<td><a class="clickbutton"
						href="./MyMeetingDetailsServlet?meetingid=<%=meetinginfoBean2.getMeetingid()%>">查看详情</a>
					</td>
				</tr>
				<%
					}
					} else {
						out.print("<tr><td colspan='7'>无会议！</td></tr>");
					}
				%>
				<div class="pager-header">

					<%
						PageBean pageBean = (PageBean) session.getAttribute("pageBean");
						if (pageBean != null) {
					%>

					<tr>
						<td colspan="7"><a href="./PageServlet?pageno=1">首页</a> <a
							href="./PageServlet?pageno=<%=pageBean.getPageno() - 1%>">上一页</a>
							<a href="./PageServlet?pageno=<%=pageBean.getPageno() + 1%>">下一页</a>
							<a href="./PageServlet?pageno=<%=pageBean.getMaxpage()%>">尾页</a>

						</td>
					</tr>

					<%
						}
					%>
				</div>
			</table>


		</div>
		<div class="page-footer">
			<hr />
			更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a> <img
				src="images/footer.png" alt="CoolMeeting" />
		</div>
</body>
</html>