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
 * Servlet implementation class ClientAddAction
 */
@WebServlet("/client/add.do")
public class ClientAddAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientAddAction() {
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
			int clientid=0;
			String clientname=request.getParameter("inputclientname");
			String clientsex=request.getParameter("optionsRadios");
			int clientage=Integer.parseInt(request.getParameter("inputage"));
			int engineid=Integer.parseInt(request.getParameter("inputengineid"));
			String clientphone=request.getParameter("inputphone");
			String clientmail=request.getParameter("inputemail");
			ic.add(clientid, clientname, clientsex, clientage, clientphone, clientmail, engineid);
			response.setCharacterEncoding("utf-8");
			response.sendRedirect("main.do");
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
