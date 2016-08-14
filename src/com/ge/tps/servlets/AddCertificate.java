package com.ge.tps.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ge.tps.entities.Certificate;
import com.ge.tps.service.AddProfileInfoService;
import com.google.gson.Gson;

/**
 * Servlet implementation class AddCertificate
 */
@WebServlet("/AddCertificates")
public class AddCertificate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AddProfileInfoService addProfileInfoService=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCertificate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("In Servlet Add Certificate");
		addProfileInfoService=new AddProfileInfoService();
		long trainerId=Long.parseLong(request.getParameter("trainerProfileId"));
		String addCertificateJson=request.getParameter("certificationInfo");
		Set<Certificate> certificateList=addProfileInfoService.addCertificate(trainerId,addCertificateJson);
		Gson gson=new Gson();
		String certificateListJson=gson.toJson(certificateList);
		PrintWriter out=response.getWriter();
		out.print(certificateListJson);
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
