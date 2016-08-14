package com.ge.tps.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ge.tps.dao.ConnectDao;

/**
 * Servlet implementation class ConnectMeController
 */
@WebServlet("/connectMe")
public class ConnectMeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnectMeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String userName=request.getParameter("userName");
	String connectName=request.getParameter("connectName");
	String reason=request.getParameter("reason");
	String check=request.getParameter("check");
	System.out.println(check);
	boolean bool= false;
	if(check.equalsIgnoreCase("yes")){
		bool=true;
	}
	
	SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
	Date start=null;
	
	try {
		if(request.getParameter("date").isEmpty()){
			start = new Date();
		}
		else{
			start=format.parse(request.getParameter("date"));
		}
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	String description= request.getParameter("description");
	
	ConnectDao connectService= new ConnectDao();
	
	connectService.connectMe(userName,connectName,reason,bool,start,description);
	
	
	
	
	
	}

}
