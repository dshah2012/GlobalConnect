package com.ge.tps.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ge.tps.entities.Education;
import com.ge.tps.entities.Patent;
import com.ge.tps.service.AddProfileInfoService;
import com.google.gson.Gson;

/**
 * Servlet implementation class AddPatent
 */
@WebServlet("/AddPatent")
public class AddPatent extends HttpServlet {
	AddProfileInfoService addProfileInfoService=null;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPatent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In Servlet AddPatent");
		addProfileInfoService=new AddProfileInfoService();
		Patent patent=new Patent();
		System.out.println(request.getParameter("dateOfIssue"));
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			patent.setDateOfIssue(sdf.parse(request.getParameter("dateOfIssue")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		patent.setDescription(request.getParameter("description"));
		
		if(!request.getParameter("patentApplicationNumber").equals(""))
		patent.setPatentApplicationNo(Long.parseLong(request.getParameter("patentApplicationNumber")));
		
		patent.setPatentOffice(request.getParameter("patentOffice"));
		patent.setPatentStatusIssued(Boolean.parseBoolean(request.getParameter("patentStatus_IsIssued")));
		patent.setPatentUrl(request.getParameter("patentUrl"));
		patent.setTitle(request.getParameter("title"));
		
		long trainerId = Long.parseLong(request.getParameter("trainerInfoId"));
		List<Patent> listPatents=addProfileInfoService.addPatent(patent, trainerId);
		PrintWriter out=response.getWriter();
		Gson gson=new Gson();
		String listPatentsJson=gson.toJson(listPatents);
		out.print(listPatentsJson);
		out.flush();
		System.out.println(patent);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
