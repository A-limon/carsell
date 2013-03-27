package com.bmw.sell.mail;

import java.io.IOException;
import java.sql.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bmw.sell.value.ClientValue;

/**
 * Servlet implementation class SendMail
 */
@WebServlet("/index/mail.do")
public class SendMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClientValue civ = (ClientValue) request.getAttribute("civ");
		String host="smtp.163.com";
		String username= "nicejava@163.com";
		String password="javaee";
		try{
			Properties p = System.getProperties();
			p.put("mail.smtp.host",host);
			p.put("mail.transport.protocol", "smtp");
			p.put("mail.smtp.auth", "true");
			
			MailAuth auth = new MailAuth(username,password);
			
			Session session = Session.getDefaultInstance(p,auth);
			MimeMessage message= new MimeMessage(session);
			
			message.setFrom(new InternetAddress(username));
			message.setRecipient(Message.RecipientType.TO,new InternetAddress(civ.getClientmail()));
			String sex=civ.getClientsex();
			String showsex=null;
			if(sex.endsWith("男")){
				showsex="先生";
			}else
				showsex="女士";
			message.setSubject("感谢您购买BMW汽车");
			String content = "尊敬的"+civ.getClientname()+showsex+"您好!<br/>感谢您在BMW宝马4S店购买了发动机编号为"+civ.getEngineid()+"的BMW汽车<br/>您的相关购车手续将会在一周内完成并邮寄到您的住所。";
			message.setContent(content,"text/html;charset=utf-8");
			message.setSentDate(new Date(0));
			Transport.send(message);
			System.out.println("SendMail--OK222222222OK---" );
		}catch(Exception e){
			System.out.println("SendMail--Error---"+e.getMessage());
		}
		response.sendRedirect("main.do");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
