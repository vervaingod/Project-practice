package com.meeting.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meeting.bean.Department_EmployeeBean;
import com.meeting.biz.DepartmentBiz;
import com.meeting.biz.DepartmentBizImpl;

@WebServlet("/PreAddMeetingServlet")
public class PreAddMeetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public PreAddMeetingServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		List<Department_EmployeeBean> department_EmployeeBeanList=null;
		List<Department_EmployeeBean> department_EmployeeBeanList2=null;
		
		DepartmentBiz departmentBiz=new DepartmentBizImpl();
		try {
			
			department_EmployeeBeanList=departmentBiz.fetchAllDepartment_EmployeeBean();
			department_EmployeeBeanList2=departmentBiz.fetchAllDepartment_EmployeeBean2();
			
			if(department_EmployeeBeanList!=null&&!department_EmployeeBeanList.isEmpty()){
				request.setAttribute("department_UserBeanList", department_EmployeeBeanList);
			}else{
				request.setAttribute("message", "初始化部门职员信息失败！");
			}
			if(department_EmployeeBeanList2!=null&&!department_EmployeeBeanList.isEmpty()){
				request.setAttribute("department_UserBeanList2", department_EmployeeBeanList2);
			}else{
				request.setAttribute("message", "初始化部门信息失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("bookmeeting.jsp").forward(request,
				response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

} 
