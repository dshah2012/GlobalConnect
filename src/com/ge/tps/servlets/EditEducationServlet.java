package com.ge.tps.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ge.tps.service.EditProfileService;

/**
 * Servlet implementation class EditEducation
 */
@WebServlet("/EditEducation")
public class EditEducationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     EditProfileService editProfileService=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditEducationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("IN EDIT Education Info");
		long userId=Long.parseLong(request.getParameter("user_id"));
		String educationInfoJson=(String)request.getParameter("educationJson");
		editProfileService=new EditProfileService();
		editProfileService.editEducationInfo(userId,educationInfoJson);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
