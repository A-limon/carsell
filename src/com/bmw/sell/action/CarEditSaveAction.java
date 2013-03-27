package com.bmw.sell.action;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import com.bmw.sell.business.ICar;
import com.bmw.sell.factory.BusinessFactory;
import com.jspsmart.upload.SmartUpload;

/**
 * Servlet implementation class CarEditSaveAction
 */
@WebServlet("/car/editsave.do")
public class CarEditSaveAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarEditSaveAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			ICar car = BusinessFactory.getCar();
			SmartUpload load = new SmartUpload();
			PageContext pageContext = null;
			JspFactory jspxFactory = null;
			// pagecontext不能直接使用，需要转换一下
			jspxFactory = JspFactory.getDefaultFactory();
			pageContext = jspxFactory.getPageContext(this, request, response,
					"", true, 8192, true);
			load.initialize(pageContext);
			String realPath = "../upload/bmw.jpg";
			// 初始化文件上传组件smartupload

			load.upload();
			String filename = load.getFiles().getFile(0).getFileName();
			String url = "/upload/";//设置上传路径
			String newurl = this.getServletContext().getRealPath(url);
			System.out.print(newurl);
			// 获取文件上传的真实物理地址
			SimpleDateFormat tempDate = new SimpleDateFormat("yyyyMMddHHmm");
			String datetime = tempDate.format(new java.util.Date());
			//用日期进行重命名文件
			load.getFiles().getFile(0).saveAs(url + datetime + filename);
			if (!filename.isEmpty()) {
				realPath = ".." + url + datetime + filename;//如果上传文件保存此路径
			} else {
				realPath = load.getRequest().getParameter("carpic");//如果不上传保存原来的路径
			}

			int id = Integer.parseInt(load.getRequest().getParameter(
					"carid"));
			String carname = load.getRequest().getParameter("inputcarname");
			int stock = Integer.parseInt(load.getRequest().getParameter(
					"inputstock"));
			Float price = Float.parseFloat(load.getRequest().getParameter(
					"inputprice"));
			String color = load.getRequest().getParameter("inputcolor");
			String engine = load.getRequest().getParameter("inputengine");
			String carpic = realPath;
			car.modify(id, carname, price, color, engine, carpic, stock);
			response.setCharacterEncoding("utf-8");
			response.sendRedirect("main.do");
		} catch (Exception e) {
			String mess = e.getMessage();
			response.sendRedirect("../index/error.jsp?mess=" + mess);
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
