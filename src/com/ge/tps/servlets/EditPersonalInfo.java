package com.ge.tps.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ge.tps.service.EditProfileService;

/**
 * Servlet implementation class EditPersonalInfo
 */
@WebServlet("/EditPersonalInfo")
public class EditPersonalInfo extends HttpServlet {
	EditProfileService editProfileService=null;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPersonalInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("IN EDIT Personal Info");
		long userId=Long.parseLong(request.getParameter("user_id"));
		String personalInfo=(String)request.getParameter("personalInfo");
		editProfileService=new EditProfileService();
		boolean editPersonalInfoStatus=editProfileService.setPersonalInfo(userId, personalInfo);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
