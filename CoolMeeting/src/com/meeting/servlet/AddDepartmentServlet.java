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
 * @see ��Ӳ��ŵ�Servlet�����ڵײ���ж�
 * @author ����ǰ
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
					request.setAttribute("message", "��ӵĲ������Ʋ���Ϊ��!");
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
							request.setAttribute("message", "������ӳɹ���");
							request.getRequestDispatcher(
									"./FetchDepartmentServlet").forward(
									request, response);
						} else {
							request.setAttribute("message", "�������ʧ�ܣ���������ӣ�");
							request.getRequestDispatcher(
									"./FetchDepartmentServlet").forward(
									request, response);
						}
					} else {
						request.setAttribute("message", "�ò����Ѵ��ڣ�");
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
					 * request.setAttribute("messagelist", "û���κβ��ţ�����Ӳ��ţ�");
					 * request
					 * .getRequestDispatcher("./FetchDepartmentServlet").forward
					 * ( request, response); }
					 */
				}
			} else {
				request.setAttribute("message", "��Ӳ���ʧ��!�ǹ���Ա���ܽ��иò�����");
				request.getRequestDispatcher("./FetchDepartmentServlet")
						.forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("message", "�ǹ���Ա���ܽ��иò�����");
			request.getRequestDispatcher("./FetchDepartmentServlet").forward(
					request, response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
