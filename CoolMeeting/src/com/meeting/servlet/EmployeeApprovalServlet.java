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
 * @see ����Ա��ע��ʱ����ͨ��������Servlet�����ڵײ���ж�
 * @author ����ǰ
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
					message="Ա����Ϣ����ͨ����";
				}else{
					message="Ա����Ϣɾ���ɹ���";
				}
			} catch (Exception e) {
				message = "��Ա��ID���Ϸ�����ȷ�Ϻ�����ɾ����";
			}
		}else {
			message="����ͨ��ʧ�ܣ��ǹ���Ա���ܽ��иò�����";
		}
		request.setAttribute("message", message);
		request.getRequestDispatcher("./FetchEmployeeServlet").forward(
				request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
