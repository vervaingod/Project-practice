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
 * @see ɾ�����ŵ�Servlet�����ڵײ���ж�
 * @author ����ǰ
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
					message="ɾ���ɹ���";
				}else{
					message="ɾ��ʧ�ܣ�";
				}
			} catch (Exception e) {
				message = "�ò���ID���Ϸ�����ȷ�Ϻ�����ɾ����";
			}
		}else{
			message="ɾ��ʧ�ܣ��ǹ���Ա���ܽ��иò�����";
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
