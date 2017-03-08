package com.meeting.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meeting.bean.DepartmentBean;
import com.meeting.bean.EmployeeBean;
import com.meeting.biz.DepartmentBiz;
import com.meeting.biz.DepartmentBizImpl;

/**
 * @see 添加部门的Servlet，用于底层的判断
 * @author 刘均前
 * @since 2015-08-29
 * @version V1.0
 */
@WebServlet("/AddDepartmentServlet")
public class AddDepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String departmentname = request.getParameter("departmentname");
		EmployeeBean employeeBean = new EmployeeBean();
		employeeBean = (EmployeeBean) request.getSession().getAttribute(
				"employeeBean");
		try {
			int role = employeeBean.getRole();
			if (role == 1) {
				if (departmentname == null || departmentname.trim().equals("")) {
					request.setAttribute("message", "添加的部门名称不能为空!");
					request.getRequestDispatcher("./FetchDepartmentServlet")
							.forward(request, response);
				} else {
					DepartmentBean departmentBean = new DepartmentBean();
					departmentBean.setDepartmentname(departmentname);

					DepartmentBiz departmentBiz = new DepartmentBizImpl();
					int id = departmentBiz
							.fetchIdByDepartmentName(departmentname);
					if (id == 0) {
						int result = departmentBiz
								.addDepartment(departmentBean);
						if (result == 1) {
							request.setAttribute("message", "部门添加成功！");
							request.getRequestDispatcher(
									"./FetchDepartmentServlet").forward(
									request, response);
						} else {
							request.setAttribute("message", "部门添加失败，请重新添加！");
							request.getRequestDispatcher(
									"./FetchDepartmentServlet").forward(
									request, response);
						}
					} else {
						request.setAttribute("message", "该部门已存在！");
						request.getRequestDispatcher("./FetchDepartmentServlet")
								.forward(request, response);
					}

					/*
					 * List<DepartmentBean> departmentBeanList = departmentBiz
					 * .fetchAllDepartments(); if (departmentBeanList != null &&
					 * !departmentBeanList.isEmpty()) {
					 * request.setAttribute("departmentBeanList",
					 * departmentBeanList);
					 * request.getRequestDispatcher("./FetchDepartmentServlet"
					 * ).forward( request, response); } else {
					 * request.setAttribute("messagelist", "没有任何部门，请添加部门！");
					 * request
					 * .getRequestDispatcher("./FetchDepartmentServlet").forward
					 * ( request, response); }
					 */
				}
			} else {
				request.setAttribute("message", "添加部门失败!非管理员不能进行该操作！");
				request.getRequestDispatcher("./FetchDepartmentServlet")
						.forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("message", "非管理员不能进行该操作！");
			request.getRequestDispatcher("./FetchDepartmentServlet").forward(
					request, response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
