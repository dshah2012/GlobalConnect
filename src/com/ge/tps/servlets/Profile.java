package com.ge.tps.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ge.tps.service.RetrieveProfileService;


@WebServlet("/GetProfile")
public class Profile extends HttpServlet {
	RetrieveProfileService ps=null;
	private static final long serialVersionUID = 1L;
    
    public Profile() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("IN GET PROFILE");
		long userId=Long.parseLong(request.getParameter("user_id"));
		ps=new RetrieveProfileService();
		String trainerProfile=ps.getUserProfileAsJson(userId);
		System.out.println(trainerProfile);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print(trainerProfile);
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
