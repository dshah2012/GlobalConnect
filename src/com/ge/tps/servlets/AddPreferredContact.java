package com.ge.tps.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ge.tps.entities.Education;
import com.ge.tps.entities.Location;
import com.ge.tps.entities.PreferredContact;
import com.ge.tps.entities.TrainerProfile;
import com.ge.tps.service.AddProfileInfoService;
import com.google.gson.Gson;

/**
 * Servlet implementation class AddEducation
 */
@WebServlet("/AddPreferredContact")
public class AddPreferredContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AddProfileInfoService addProfileInfoService=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPreferredContact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("In Servlet Add");
		addProfileInfoService=new AddProfileInfoService();
		
		String methodOfContact = (String)request.getParameter("preferredContact");
		System.out.println(methodOfContact);
		long userId= Long.parseLong(request.getParameter("userId"));
		addProfileInfoService = new AddProfileInfoService();
		boolean addPreferredContact=addProfileInfoService.setPreferredContact(methodOfContact, userId);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}