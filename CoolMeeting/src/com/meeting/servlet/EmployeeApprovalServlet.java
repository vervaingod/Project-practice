package com.meeting.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meeting.bean.EmployeeBean;
import com.meeting.biz.EmployeeBiz;
import com.meeting.biz.EmployeeBizImpl;

/**
 * @see 审批员工注册时用于通过审批的Servlet，用于底层的判断
 * @author 刘均前
 * @since 2015-08-29
 * @version V1.0
 */
@WebServlet("/EmployeeApprovalServlet")
public class EmployeeApprovalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String idString=request.getParameter("id");
		String message="";
		
		EmployeeBean employeeBean = new EmployeeBean();
		employeeBean = (EmployeeBean) request.getSession().getAttribute(
				"employeeBean");
		int role=employeeBean.getRole();
		if(role==1){
			try {
				int id=Integer.parseInt(idString);
				EmployeeBiz employeeBiz=new EmployeeBizImpl();
				int rows=employeeBiz.employeeApproval(id);
				if(rows==1){
					message="员工信息审批通过！";
				}else{
					message="员工信息删除成功！";
				}
			} catch (Exception e) {
				message = "该员工ID不合法，请确认后重新删除！";
			}
		}else {
			message="审批通过失败！非管理员不能进行该操作！";
		}
		request.setAttribute("message", message);
		request.getRequestDispatcher("./FetchEmployeeServlet").forward(
				request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
