package com.ge.tps.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ge.tps.dto.RealTimeExperienceDto;
import com.ge.tps.entities.WorkExperience;
import com.ge.tps.service.AddProfileInfoService;
import com.google.gson.Gson;

/**
 * Servlet implementation class AddRealTimeExperience
 */
@WebServlet("/AddRealTimeExperience")
public class AddRealTimeExperience extends HttpServlet {
	AddProfileInfoService addProfileInfoService=null;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRealTimeExperience() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		addProfileInfoService=new AddProfileInfoService();
		String trainingExpJson=request.getParameter("realTimeExperience");
		long trainerId=Long.parseLong(request.getParameter("trainerId"));
		Set<WorkExperience> RealTimeExperienceList=addProfileInfoService.addRealTimeExperience(trainingExpJson,trainerId);
		PrintWriter out=response.getWriter();
		Gson gson=new Gson();
		String RealTimeExperienceJsonInfo=gson.toJson(RealTimeExperienceList);
		out.write(RealTimeExperienceJsonInfo);
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
