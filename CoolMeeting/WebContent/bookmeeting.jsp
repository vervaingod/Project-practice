<!DOCTYPE html>
<%@page import="com.meeting.bean.Department_EmployeeBean"%>
<%@page import="java.util.List"%>
<%@page import="com.meeting.bean.DepartmentBean"%>

<%@page import="com.meeting.bean.EmployeeBean"%>
<html>
<head>
<meta http-equiv="content-type" content="text/html" ;charset="utf-8">
<title>CoolMeeting会议管理系统</title>
<link rel="stylesheet" href="styles/common.css" />
<style type="text/css">
#divfrom {
	float: left;
	width: 150px;
}

#divto {
	float: left;
	width: 150px;
}

#divoperator {
	float: left;
	width: 50px;
	padding: 60px 5px;
}

#divoperator input[type="button"] {
	margin: 10px 0;
}

#selDepartments {
	display: block;
	width: 100%;
}

#selEmployees {
	display: block;
	width: 100%;
	height: 200px;
}

#selSelectedEmployees {
	display: block;
	width: 100%;
	height: 225px;
}
</style>
<script type="application/javascript">
	

            function employee(employeeid, employeename){
                this.employeeid = employeeid;
                this.employeename = employeename;
            }
            function department(departmentid, departmentname, employees){
                this.departmentid = departmentid;
                this.departmentname = departmentname;
                this.employees = employees;
            }
            
<%List<Department_EmployeeBean> department_EmployeeBeanList=(List<Department_EmployeeBean>)request.getAttribute("department_UserBeanList");
            List<Department_EmployeeBean> department_EmployeeBeanList2=(List<Department_EmployeeBean>)request.getAttribute("department_UserBeanList2");%>
	
            	


            
<%out.print(" var data = new Array(");
                if(department_EmployeeBeanList2!=null&&!department_EmployeeBeanList2.isEmpty()){
                  int i=0;
                  
                    for(i=0;i<department_EmployeeBeanList2.size();i++){
                    	Department_EmployeeBean department_EmployeeBean2=new Department_EmployeeBean();
                    	department_EmployeeBean2=department_EmployeeBeanList2.get(i);
                    	if(i<(department_EmployeeBeanList2.size()-1)){
                    		out.print(" new department("+department_EmployeeBean2.getDepartmentid()+"," +"\""+department_EmployeeBean2.getDepartmentname()+"\""+",new Array(" );
                    		if(department_EmployeeBeanList!=null&&!department_EmployeeBeanList.isEmpty()){
                    			int a=0;
                    			int b=0;
                    			int f=0;
                    			for(a=0;a<department_EmployeeBeanList.size();a++){
                    				Department_EmployeeBean department_EmployeeBean3=new Department_EmployeeBean();
                    				department_EmployeeBean3=department_EmployeeBeanList.get(a);
                                     if(department_EmployeeBean2.getDepartmentid()==department_EmployeeBean3.getDepartmentid()){
                                    	 f++;
                                     }
                                     
                    			}
                    			 for(int j=0;j<department_EmployeeBeanList.size();j++){
                    				 Department_EmployeeBean department_EmployeeBean=new Department_EmployeeBean();
                                     department_EmployeeBean=department_EmployeeBeanList.get(j);
                                     if(department_EmployeeBean2.getDepartmentid()==department_EmployeeBean.getDepartmentid()){
                                    	 if(b<(f-1)){
                                    		 out.print("new employee("+department_EmployeeBean.getEmployeeid()+"," +"\""+department_EmployeeBean.getEmployeename() +"\""+"),");
                                    		 b++;
                                    	 }else{
                                    		 out.print("new employee("+department_EmployeeBean.getEmployeeid()+"," +"\""+department_EmployeeBean.getEmployeename() +"\""+")");
                                    	 }
                                     }
                              }
                    		}
                    		out.print(")),");
                    	}else{
                    		out.print(" new department("+department_EmployeeBean2.getDepartmentid()+"," +"\""+department_EmployeeBean2.getDepartmentname()+"\""+",new Array(" );
                    		if(department_EmployeeBeanList!=null&&!department_EmployeeBeanList.isEmpty()){
                    	     int c=0;
                    	     int d=0;
                    	     int p=0;
                    	     for(p=0;p<department_EmployeeBeanList.size();p++){
                    	    	 Department_EmployeeBean department_EmployeeBean4=new Department_EmployeeBean();
                    	    	 department_EmployeeBean4=department_EmployeeBeanList.get(p);
                                 if(department_EmployeeBean2.getDepartmentid()==department_EmployeeBean4.getDepartmentid()){
                                	 c++;
                                 }
                    	     }
                    	     
                   			 for(int k=0;k<department_EmployeeBeanList.size();k++){
                                    Department_EmployeeBean department_EmployeeBean=new Department_EmployeeBean();
                                    department_EmployeeBean=department_EmployeeBeanList.get(k);
                                    if(department_EmployeeBean2.getDepartmentid()==department_EmployeeBean.getDepartmentid()){
                                    	
                                    	 if(d<(c-1)){
                                    		 out.print("new employee("+department_EmployeeBean.getEmployeeid()+"," +"\""+department_EmployeeBean.getEmployeename() +"\""+"),");
                                    		 d++;
                                    	 }else{
                                    		 out.print("new employee("+department_EmployeeBean.getEmployeeid()+"," +"\""+department_EmployeeBean.getEmployeename() +"\""+")");
                                    	 }
                                    }
                   			 }
                    		}
                    		out.print("))");
                    	}
                    }
                }

            out.print(");");%>
	
            
            var selDepartments;
            var selEmployees;
            var selSelectedEmployees;

            function body_load(){
                selDepartments = document.getElementById("selDepartments");
                selEmployees = document.getElementById("selEmployees");
                selSelectedEmployees = document.getElementById("selSelectedEmployees");
                
                for(var i=0;i<data.length;i++){
                    var dep = document.createElement("option");
                    dep.value = data[i].departmentid;
                    dep.text = data[i].departmentname;
                    selDepartments.appendChild(dep);
                }
                
                fillEmployees();
            }
            //new date = new Array(new department(),new Array(new employee()));
            function fillEmployees(){
                clearList(selEmployees);
                var departmentid = selDepartments.options[selDepartments.selectedIndex].value;
                var employees1;
                for(var i=0;i<data.length;i++){
                    if (departmentid == data[i].departmentid){
                        employees1= data[i].employees;
                        break;
                   }
                }
                
                 for(i=0;i<employees1.length;i++){ 
                    var emp = document.createElement("option");
                    emp.value = employees1[i].employeeid;
                    emp.text = employees1[i].employeename;
                    selEmployees.appendChild(emp);
                 }   
            }
            
            function clearList(list){
                while(list.childElementCount > 0){
                    list.removeChild(list.lastChild);
                }
            }
            
            function selectEmployees(){
                for(var i=0;i<selEmployees.options.length;i++){
                    if (selEmployees.options[i].selected){
                        addEmployee(selEmployees.options[i]);
                        selEmployees.options[i].selected = false;
                    }
                }
            }
            
            function deSelectEmployees(){
                var elementsToRemoved = new Array();
                var options = selSelectedEmployees.options;
                for(var i=0;i<options.length;i++){
                    if (options[i].selected){
                        elementsToRemoved.push(options[i]);
                    }
                }
                for(i=0;i<elementsToRemoved.length;i++){
                    selSelectedEmployees.removeChild(elementsToRemoved[i]);
                }
            }
            
            function addEmployee(optEmployee){
                var options = selSelectedEmployees.options;
                var i = 0;
                var insertIndex = -1;
                while(i < options.length){
                    if (optEmployee.value == options[i].value){
                        return;
                    } else if (optEmployee.value < options[i].value) {
                        insertIndex = i;
                        break;
                    }
                    i++;
                }
                var opt = document.createElement("option");
                opt.value = optEmployee.value;
                opt.text = optEmployee.text;
                
                if (insertIndex == -1){
                    selSelectedEmployees.appendChild(opt);
                } else {
                    selSelectedEmployees.insertBefore(opt, options[insertIndex]);
                }
            }            


</script>
</head>
<body onload="body_load()">
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
				href="changepassword.jsp">[修改密码]</a>
				<a href="login.jsp">[退出]</a>
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
			<div class="content-nav">会议预定 > 预定会议</div>
			<form action="BookMeetingServlet" method="post">

				<fieldset>
					<legend>会议信息</legend>
					<%=request.getAttribute("message") != null ? request
					.getAttribute("message") : ""%>
					<table class="formtable">
						<tr>
							<td>会议名称：</td>
							<td><input type="text" id="meetingname" maxlength="20"
								name="meetingname" /></td>
						</tr>
						<tr>
							<td>预计参加人数：</td>
							<td><input type="text" id="numofattendents"
								name="numofattendents" /></td>
						</tr>
						<tr>
							<td>预计开始时间：</td>
							<td><input type="text" id="startdate" name="startdate" /></td>
						</tr>
						<tr>
							<td>预计结束时间：</td>
							<td><input type="text" id="enddate" name="enddate" /></td>
						</tr>
						<tr>
							<td>会议室名称</td>
							<td><input type="text" id="capacity" name="capacity" /></td>
						</tr>
						<tr>
							<td>预订人</td>
							<td><input type="text" id="accountname" name="accountname" /></td>
						</tr>

						<tr>
							<td>会议说明：</td>
							<td><textarea id="description" rows="5" name="description"></textarea></td>
						</tr>
						<tr>
							<td>选择参会人员：</td>
							<td>
								<div id="divfrom">
									<select id="selDepartments" onchange="fillEmployees()"></select>

									<select id="selEmployees" multiple="true">
									</select>
								</div>
								<div id="divoperator">
									<input type="button" class="clickbutton" value="&gt;"
										onclick="selectEmployees()" /> <input type="button"
										class="clickbutton" value="&lt;" onclick="deSelectEmployees()" />
								</div>
								<div id="divto">
									<select id="selSelectedEmployees" multiple="true"
										name="selectEmployee">
									</select>
								</div>
							</td>
						</tr>
						<tr>
							<td class="command" colspan="2"><input type="submit"
								class="clickbutton" value="预定会议" /> <input type="reset"
								class="clickbutton" value="重置" /></td>
						</tr>
					</table>
<%} %>
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