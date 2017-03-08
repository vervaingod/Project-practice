<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cool-Meeting会议管理系统</title>
<link rel="stylesheet" href="styles/common.css"/>
</head>
<body>
	<div class="page-header">
		<div class="header-banner">
			<img src="images/header.png" alt="CoolMeeting" />
		</div>
		<div class="header-title">欢迎访问Cool-Meeting会议管理系统</div>
		<div class="header-quicklink">
			<strong><a href="login.jsp">[请登录]</strong> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</div>
	</div>
	<div class="page-body">
		<div class="page-sidebar">
			<div class="sidebar-menugroup">
				<div class="sidebar-grouptitle">个人中心</div>
				<ul class="sidebar-menu">
					<li class="sidebar-menuitem"><a href="login.jsp">最新通知</a></li>
					<li class="sidebar-menuitem active"><a href="login.jsp">我的预定</a></li>
					<li class="sidebar-menuitem"><a href="login.jsp">我的会议</a></li>
				</ul>
			</div>
			<div class="sidebar-menugroup">
				<div class="sidebar-grouptitle">人员管理</div>
				<ul class="sidebar-menu">
					<li class="sidebar-menuitem"><a href="login.jsp">部门管理</></li>
					<li class="sidebar-menuitem"><a href="register.jsp">员工注册</a></li>
					<li class="sidebar-menuitem"><a href="login.jsp">注册审批</a></li>
					<li class="sidebar-menuitem"><a href="login.jsp">搜索员工</a></li>
				</ul>
			</div>
			<div class="sidebar-menugroup">
				<div class="sidebar-grouptitle">会议预定</div>
				<ul class="sidebar-menu">
					<li class="sidebar-menuitem"><a href="login.jsp">添加会议室</a></li>
					<li class="sidebar-menuitem"><a href="login.jsp">查看会议室</a></li>
					<li class="sidebar-menuitem"><a href="login.jsp">预定会议</a></li>
					<li class="sidebar-menuitem"><a href="login.jsp">搜索会议</a></li>
				</ul>
			</div>
		</div>
		<div class="page-content">
			<div class="content-nav">
				登录 <br />
				<%=request.getAttribute("message") != null ? request
					.getAttribute("message") : ""%>
			</div>
			<form action="LoginServlet" method="post">
				<fieldset>
					<legend>登录信息</legend>
					<table class="formtable" style="width: 50%">
						<tr>
							<td>账号名:</td>
							<td><input id="accountname" type="text" name="accountname"
								value="<%=request.getAttribute("temp_accountname") != null ? request
					.getAttribute("temp_accountname") : ""%>" /></td>
						</tr>
						<tr>
							<td>密码:</td>
							<td><input id="new" type="password" name="password" /></td>
						</tr>
						<tr>
							<td colspan="2" class="command"><input type="submit"
								value="登录" class="clickbutton"
								onclick="window.location.href='notifiactions.html';" /> <input
								type="button" value="返回" class="clickbutton"
								onclick="window.history.back();" /></td>
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