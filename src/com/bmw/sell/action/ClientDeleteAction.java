package com.bmw.sell.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bmw.sell.business.IClient;
import com.bmw.sell.factory.BusinessFactory;

/**
 * Servlet implementation class ClientDeleteAction
 */
@WebServlet("/client/delete.do")
public class ClientDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientDeleteAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			IClient ic=BusinessFactory.getClient();
			ic.delete(Integer.parseInt(request.getParameter("clientid")));
			response.setCharacterEncoding("utf-8");
			javax.servlet.RequestDispatcher rd=request.getRequestDispatcher("main.do");
			rd.forward(request, response);
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
		doGet(request,response);
	}

}
