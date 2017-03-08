package com.meeting.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meeting.bean.EmployeeBean;
import com.meeting.biz.DepartmentBiz;
import com.meeting.biz.DepartmentBizImpl;

/**
 * @see 删除部门的Servlet，用于底层的判断
 * @author 刘均前
 * @since 2015-08-29
 * @version V1.0
 */
@WebServlet("/DeleteDepartmentServlet")
public class DeleteDepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String idString = request.getParameter("id");
		String message = "";
		EmployeeBean employeeBean = new EmployeeBean();
		employeeBean = (EmployeeBean) request.getSession().getAttribute(
				"employeeBean");
		int role=employeeBean.getRole();
		if(role==1){
			try {
				int id=Integer.parseInt(idString);
				DepartmentBiz departmentBiz=new DepartmentBizImpl();
				int rows=departmentBiz.deleteDepartmentById(id);
				if(rows==1){
					message="删除成功！";
				}else{
					message="删除失败！";
				}
			} catch (Exception e) {
				message = "该部门ID不合法，请确认后重新删除！";
			}
		}else{
			message="删除失败！非管理员不能进行该操作！";
		}
		request.setAttribute("messagedelete", message);
		request.getRequestDispatcher("./FetchDepartmentServlet").forward(
				request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
