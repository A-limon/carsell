package com.bmw.sell.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bmw.sell.business.IEmployee;
import com.bmw.sell.factory.BusinessFactory;
import com.bmw.sell.value.EmployeeValue;

/**
 * Servlet implementation class EmployeeEditAction
 */
@WebServlet("/employee/edit.do")
public class EmployeeEditAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeEditAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			EmployeeValue emv=new EmployeeValue();
			IEmployee emp=BusinessFactory.getEmployee();
			emv=emp.getEmployee(Integer.parseInt(request.getParameter("id")));
			
			request.setAttribute("emv", emv);
			//保存给JSP显示员工列表
			response.setCharacterEncoding("utf-8");
			javax.servlet.RequestDispatcher rd=request.getRequestDispatcher("edit.jsp");
			rd.forward(request, response);
			//转发到员工主页
			} catch (Exception e) {
				String mess=e.getMessage();
				response.sendRedirect("../index/error.jsp?mess="+mess);
				e.printStackTrace();
			}
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
