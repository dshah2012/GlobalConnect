package com.ge.tps.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ge.tps.entities.JobEmployment;
import com.ge.tps.service.AddProfileInfoService;
import com.google.gson.Gson;

/**
 * Servlet implementation class AddEducation
 */
@WebServlet("/AddEmployment")
public class AddEmployment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AddProfileInfoService addProfileInfoService=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployment() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In Servlet Add");
		addProfileInfoService=new AddProfileInfoService();
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date sDate=null;
		Date eDate=null;
		try {
			 sDate=  sdf.parse(request.getParameter("startDate"));
			 eDate=sdf.parse(request.getParameter("endDate"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JobEmployment job=new JobEmployment();
		job.setDesignation(request.getParameter("designation"));
		job.setOrganizationName(request.getParameter("organizationName"));
		if(!request.getParameter("salaryPackage").equals(""))
		job.setSalaryPackage(Integer.parseInt(request.getParameter("salaryPackage")));
		job.setStartDate(sDate);
		job.setEndDate(eDate);
		job.setCurrent(Boolean.parseBoolean(request.getParameter("current")));
		long trainerId = Long.parseLong(request.getParameter("trainerInfoId"));
		List<JobEmployment> educationList=addProfileInfoService.addEmployment(job,trainerId);
		PrintWriter out=response.getWriter();
		Gson gson=new Gson();
		String EducationJsonInfo=gson.toJson(educationList);
		out.print(EducationJsonInfo);
		out.flush();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
