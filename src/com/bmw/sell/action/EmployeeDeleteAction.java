package com.bmw.sell.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bmw.sell.business.IEmployee;
import com.bmw.sell.factory.BusinessFactory;

/**
 * Servlet implementation class UserDeleteAction
 */
@WebServlet("/employee/delete.do")
public class EmployeeDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

       
    public EmployeeDeleteAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			request.setCharacterEncoding("utf-8");
			IEmployee emp=BusinessFactory.getEmployee();
			emp.delete(Integer.parseInt(request.getParameter("id")));
			response.setCharacterEncoding("utf-8");
			javax.servlet.RequestDispatcher rd=request.getRequestDispatcher("main.do");
			rd.forward(request, response);
		}  catch (Exception e) {
			String mess=e.getMessage();
			response.sendRedirect("../index/error.jsp?mess="+mess);
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
		
	

}
