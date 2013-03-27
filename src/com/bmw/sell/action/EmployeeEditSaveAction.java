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
 * Servlet implementation class EmployeeEditSaveAction
 */
@WebServlet("/employee/editsave.do")
public class EmployeeEditSaveAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeEditSaveAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			request.setCharacterEncoding("utf-8");
			IEmployee emp=BusinessFactory.getEmployee();
			int id=Integer.parseInt(request.getParameter("id"));
			String name=request.getParameter("inputusername");
			String loginname=request.getParameter("inputloginname");
			String password=request.getParameter("inputPassword");
			String sex=request.getParameter("optionsRadios");
			int age=Integer.parseInt(request.getParameter("inputage"));
			String department=request.getParameter("inputdep");
			emp.modify(id, name, password, sex, age, loginname, department);
		
			response.setCharacterEncoding("utf-8");
			response.sendRedirect("main.do");
			//转发到员工主页
	} catch (Exception e) {
			String mess=e.getMessage();
			response.sendRedirect("../index/error.jsp?mess="+mess);
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
