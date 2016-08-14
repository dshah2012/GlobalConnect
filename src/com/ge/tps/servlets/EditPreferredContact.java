package com.ge.tps.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ge.tps.service.EditProfileService;

/**
 * Servlet implementation class EditPreferredContact
 */
@WebServlet("/EditPreferredContact")
public class EditPreferredContact extends HttpServlet {
	EditProfileService editProfileService=null;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPreferredContact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("IN EDIT Preferred Contact");
		long userId=Long.parseLong(request.getParameter("user_id"));
		String preferredInfoJson=(String)request.getParameter("preferredInfoJson");
		editProfileService=new EditProfileService();
		editProfileService.editPreferredContact(userId,preferredInfoJson);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
