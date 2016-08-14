package com.ge.tps.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ge.tps.util.SendEmailUsingGMailSMTP;

/**
 * Servlet implementation class MailController
 */
@WebServlet("/sendMail")
public class MailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MailController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String body = request.getParameter("emailBody");
		String subject = request.getParameter("emailSubject");
		String attachment = request.getParameter("emailAttachment");
		String to = request.getParameter("emailTo");
		String redirectPage = request.getParameter("redirectPage");
		boolean isMailSent = SendEmailUsingGMailSMTP.sendMail(to, subject, body, attachment);
		
		if(!redirectPage.equalsIgnoreCase("false")){
			response.sendRedirect(redirectPage);
		}else{
			response.getWriter().append("true");
		}
	}

}
