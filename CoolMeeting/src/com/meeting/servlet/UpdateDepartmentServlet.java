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
 * @see 修改部门信息时的Servlet，用于底层的判断及跳转
 * @author 刘均前
 * @since 2015-08-29
 * @version V1.0
 */
@WebServlet("/UpdateDepartmentServlet")
public class UpdateDepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String idString = request.getParameter("departmentid");
		EmployeeBean employeeBean = new EmployeeBean();
		employeeBean = (EmployeeBean) request.getSession().getAttribute(
				"employeeBean");
		int role = employeeBean.getRole();
		try {
			int id = Integer.parseInt(idString);
			String departmentname = request.getParameter("departmentname");
			if (role == 1) {
				if (departmentname == null || departmentname.trim().equals("")) { // 判断修改后的用户名是否为空
					request.setAttribute("message", "部门名称不能为空！");
					request.getRequestDispatcher("departments_update.jsp")
							.forward(request, response);
				} else {
					DepartmentBean departmentBean = new DepartmentBean();
					departmentBean.setDepartmentid(id);
					departmentBean.setDepartmentname(departmentname);

					DepartmentBiz departmentBiz = new DepartmentBizImpl();
					int temp_id = departmentBiz
							.fetchIdByDepartmentName(departmentname);
					if (temp_id == 0 || temp_id == id) {
						int result = departmentBiz
								.updateDepartment(departmentBean);
						if (result == 1) {
							request.getSession().removeAttribute(
									"departmentBean");
							request.setAttribute("messagedelete", "修改成功！");
							request.getRequestDispatcher(
									"./FetchDepartmentServlet").forward(
									request, response);
						} else {
							request.setAttribute("messagedelete", "修改失败！");
							request.getRequestDispatcher(
									"./FetchDepartmentServlet").forward(
									request, response);
						}
					} else {
						request.setAttribute("message", "编辑失败！该部门名称已存在！");
						request.getRequestDispatcher("departments_update.jsp")
								.forward(request, response);
					}
				}
			} else {
				request.setAttribute("messagedelete", "编辑失败！非管理员不能进行该操作！");
				request.getRequestDispatcher("./FetchDepartmentServlet")
						.forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("messagedelete", "用户ID不合法，请确认后重新修改！");
			request.getRequestDispatcher("./FetchDepartmentServlet").forward(
					request, response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
