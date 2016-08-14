package com.ge.tps.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ge.tps.entities.Address;
import com.ge.tps.entities.Education;
import com.ge.tps.entities.Location;
import com.ge.tps.service.AddProfileInfoService;
import com.google.gson.Gson;

/**
 * Servlet implementation class AddEducation
 */
@WebServlet("/AddAddress")
public class AddAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AddProfileInfoService addProfileInfoService=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAddress() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("In Servlet Add Adress");
		addProfileInfoService=new AddProfileInfoService();
		long contactId=Long.parseLong(request.getParameter("contactId"));
		Address address=new Address();
		address.setPropertyNo(request.getParameter("propertyNo"));
		address.setStreetName(request.getParameter("streetName"));
		address.setAreaName(request.getParameter("areaName"));
		address.setLandmark(request.getParameter("landmark"));
		address.setPincode(request.getParameter("pincode"));
		
		Location location=new Location();
		location.setCity(request.getParameter("city"));
		location.setState(request.getParameter("state"));
		location.setCountry(request.getParameter("country"));
		long trainerId = Long.parseLong(request.getParameter("trainerInfoId"));
		address.setLocation(location);
		String adressType =  request.getParameter("addressType");
		System.out.println(address);
		String contactJson=addProfileInfoService.addAddress(address,trainerId,adressType,contactId);
		PrintWriter out=response.getWriter();
		out.print(contactJson);
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
