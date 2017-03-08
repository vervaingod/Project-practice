<%@page import="com.meeting.bean.PageBean"%>
<%@page import="com.meeting.bean.EmployeeBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html ;charset=UTF-8">
<title>CoolMeeting会议管理系统</title>
<link rel="stylesheet" href="styles/common.css" />
<style type="text/css">
</style>
</head>
<body>
<% 
	EmployeeBean employeeBean2 = (EmployeeBean)request.getSession().getAttribute("employeeBean");
%>
	<div class="page-header">
		<div class="header-banner">
			<img src="images/header.png" alt="CoolMeeting" />
		</div>
		<div class="header-title">欢迎访问Cool-Meeting会议管理系统</div>
		<div class="header-quicklink">
			欢迎您，<strong><%=employeeBean2.getAccountname()%></strong> <a href="changepassword.jsp">[修改密码]</a><a href="login.jsp">[退出]</a>
		</div>
	</div>
	<div class="page-body">
		<div class="page-sidebar">
			<div class="sidebar-menugroup">
				<div class="sidebar-grouptitle">个人中心</div>
				<ul class="sidebar-menu">
					<li class="sidebar-menuitem"><a href="./NotificationsServlet">最新通知</a></li>
					<li class="sidebar-menuitem active"><a href="./MyBookingsServlet">我的预定</a></li>
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
					<li class="sidebar-menuitem"><a href="./FetchAllMeetingRoomServlet">查看会议室</a></li>
					<li class="sidebar-menuitem"><a href="./PreAddMeetingServlet">预定会议</a></li>
					<li class="sidebar-menuitem"><a href="searchmeetings.jsp">搜索会议</a></li>
				</ul>
			</div>
		</div>
		<div class="page-content">
			<div class="content-nav">
				人员管理 > <a href="./FetchEmployeeServlet">注册审批</a>
			</div>
			<%
				List<EmployeeBean> employeeBeanList = (List<EmployeeBean>) request
						.getAttribute("employeeBeanList");
				if (employeeBeanList != null && !employeeBeanList.isEmpty()) {
			%>
			<table class="listtable">
				<caption>
					所有待审批注册信息：<font color="red"><%=request.getAttribute("message") != null ? request
						.getAttribute("message") : ""%></font>
				</caption>
				<tr class="listheader">
					<th>姓名</th>
					<th>账号名</th>
					<th>联系电话</th>
					<th>电子邮件</th>
					<th>操作</th>
				</tr>
				<%
					for (EmployeeBean employeeBean : employeeBeanList) {
				%>
				<tr>
					<td><%=employeeBean.getEmployeename()%></td>
					<td><%=employeeBean.getAccountname()%></td>
					<td><%=employeeBean.getPhone()%></td>
					<td><%=employeeBean.getEmail()%></td>
					<td><a class="clickbutton"
						href="./EmployeeApprovalServlet?id=<%=employeeBean.getEmployeeid()%>">通过</a>
						<a class="clickbutton"
						href="./DeleteEmployeeServlet?id=<%=employeeBean.getEmployeeid()%>">删除</a></td>
				</tr>
				<%
					}
						PageBean pageBean = (PageBean) request.getAttribute("pageBean");
						if (pageBean != null) {
				%>
				<tr>
					<td colspan="5"><a href="./FetchEmployeeServlet?pageno=1">首页</a>
						<a
						href="./FetchEmployeeServlet?pageno=<%=pageBean.getPageno() - 1%>">上一页</a>
						<a
						href="./FetchEmployeeServlet?pageno=<%=pageBean.getPageno() + 1%>">下一页</a>
						<a href="./FetchEmployeeServlet?pageno=<%=pageBean.getMaxpage()%>">尾页</a>
					</td>
				</tr>
				<%
					}
					} else {
						out.print("无员工注册信息！");
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