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

@WebServlet("/CloseEmployeeServlet")
public class CloseEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String employeeidString = request.getParameter("employeeid");
		//System.out.println(employeeidString);
		String message = "";
		EmployeeBean employeeBean = new EmployeeBean();
		employeeBean = (EmployeeBean) request.getSession().getAttribute(
				"employeeBean");
		try {
			int role = employeeBean.getRole();
			if (role == 1) {
				int employeeid = Integer.parseInt(employeeidString);
				EmployeeBiz employeeBiz = new EmployeeBizImpl();
				int rows = employeeBiz.CloseEmployeeById(employeeid);
				if (rows == 1) {
					message = "关闭成功";
				} else {
					message = "关闭失败";
				}
			} else {
				message="非管理员不能进行该操作！";
			}
			request.setAttribute("message", message);
			request.getRequestDispatcher("searchemployees.jsp").forward(request,
					response);
		} catch (Exception e) {
			request.setAttribute("message", "非管理员不能进行该操作！");
			request.getRequestDispatcher("./SearchEmployeeServlet").forward(request,
					response);
		}
		request.setAttribute("message", message);
		request.getRequestDispatcher("searchemployees.jsp").forward(request,
				response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

}
