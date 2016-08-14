package com.ge.tps.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ge.tps.service.EditProfileService;
import com.ge.tps.service.RetrieveProfileService;

/**
 * Servlet implementation class EditAboutMe
 */
@WebServlet("/EditAboutMe")
public class EditProfileServlet extends HttpServlet {
	EditProfileService editProfileService=null;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("IN EDIT ABOUT ME");
		long userId=Long.parseLong(request.getParameter("user_id"));
		String aboutMe=(String)request.getParameter("aboutMe");
		editProfileService=new EditProfileService();
		boolean editAbout=editProfileService.setAboutMe(userId, aboutMe);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print(editAbout);
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
