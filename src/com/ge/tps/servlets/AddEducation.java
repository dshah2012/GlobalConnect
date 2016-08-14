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
import com.ge.tps.entities.TrainerProfile;
import com.ge.tps.service.AddProfileInfoService;
import com.google.gson.Gson;

/**
 * Servlet implementation class AddEducation
 */
@WebServlet("/AddEducation")
public class AddEducation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AddProfileInfoService addProfileInfoService=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEducation() {
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
		Education edu=new Education();
		edu.setInstituteName(request.getParameter("instituteName"));
		edu.setCourseName(request.getParameter("courseName"));
		edu.setCourseDuration(Integer.parseInt(request.getParameter("courseDuration")));
		edu.setBoardName(request.getParameter("boardName"));
		edu.setFieldOfStudy(request.getParameter("fieldOfStudy"));
		edu.setPercentage(Float.parseFloat(request.getParameter("percentage")));
		edu.setStartYear(Integer.parseInt(request.getParameter("startYear")));
		edu.setYearOfPassing(Integer.parseInt(request.getParameter("yearOfPassing")));
		
		Location location=new Location();
		location.setCity(request.getParameter("city"));
		location.setState(request.getParameter("state"));
		location.setCountry(request.getParameter("country"));
		long trainerId = Long.parseLong(request.getParameter("trainerInfoId"));
		edu.setLocation(location);
		List<Education> educationList=addProfileInfoService.addEducation(edu,trainerId);
		PrintWriter out=response.getWriter();
		Gson gson=new Gson();
		String EducationJsonInfo=gson.toJson(educationList);
		out.print(EducationJsonInfo);
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
