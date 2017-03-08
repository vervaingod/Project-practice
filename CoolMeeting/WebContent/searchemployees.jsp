<!DOCTYPE html>
<%@page import="com.meeting.bean.PageBean"%>
<%@page import="com.meeting.bean.EmployeeBean"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta http-equiv="content-type" content="text/html" charset="utf-8">
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
			欢迎您，<strong><%=employeeBean2.getAccountname()%></strong> <a href="changepassword.jsp">[修改密码]</a>
			<a href="login.jsp">[退出]</a>
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
                        <li class="sidebar-menuitem"><a href="./FetchDepartmentServlet">部门管理</></li>
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
                        <li class="sidebar-menuitem"><a href="./SearchMeetingsServlet">搜索会议</a></li>
                    </ul>
                </div>
            </div>
		<div class="page-content">
			<div class="content-nav">会议预定 > 搜索员工</div>
			<form action="SearchEmployeeServlet" method="post">
				<fieldset>
					<legend>搜索会议</legend>
					<table class="formtable">

						<tr>
							<td>姓名：</td>
							<td><input type="text" id="employeename" maxlength="20"
								name="employeename" /></td>
							<td>账号名：</td>
							<td><input type="text" id="accountname" maxlength="20"
								name="accountname" /></td>
							<td>状态：</td>
							<td><input type="radio" id="status" name="status" value="1"
								checked="checked" /><label>已批准</label> <input type="radio"
								id="status" name="status" value="0" /><label>待审批</label> <input
								type="radio" id="status" name="status" value="2" /><label>已关闭</label>
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
			<div>
				<h3 style="text-align: center; color: black">查询结果</h3>
				<div class="pager-header">
				<br/>
					<%=request.getAttribute("message") != null ? request
					.getAttribute("message") : ""%>
					<table class="listtable">
						<tr class="listheader">
							<th>姓名</th>
							<th>账号名</th>
							<th>联系电话</th>
							<th>电子邮件</th>
							<th>操作</th>
						</tr>
						<%
							List<EmployeeBean> employeeBeanList = (List<EmployeeBean>) request
									.getAttribute("employeeBeanList");
						
							if (employeeBeanList != null && !employeeBeanList.isEmpty()) {
								for (EmployeeBean employeeBean : employeeBeanList) {
						%>
						<tr>
							<td><%=employeeBean.getEmployeename()%></td>
							<td><%=employeeBean.getAccountname()%></td>
							<td><%=employeeBean.getPhone()%></td>
							<td><%=employeeBean.getEmail()%></td>
							
							<td><a class="clickbutton"
								href="./CloseEmployeeServlet?employeeid=<%=employeeBean.getEmployeeid()%>">关闭账号</a></td>
						</tr>
						<%
							}
								PageBean pageBean = (PageBean) request.getAttribute("pageBean");
								if (pageBean != null) {
						%>
						<div class="header-nav">
							<a href="PagingServlet?pageno=1"><input type="submit"
								class="clickbutton" value="首页" /></a> <a
								href="./PagingServlet?pageno=<%=pageBean.getPageno() - 1%>"><input
								type="submit" class="clickbutton" value="上页" /> </a> <a
								href="./PagingServlet?pageno=<%=pageBean.getPageno() + 1%>"><input
								type="submit" class="clickbutton" value="下页" /> </a> <a
								href="./PagingServlet?pageno=<%=pageBean.getMaxpage()%>"><input
								type="submit" class="clickbutton" value="末页" /></a>
						</div>
						</div>
						</div>
						<%
							}
								}
							 else {
								request.setAttribute("message", "无员工信息");
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