package com.ge.tps.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ge.tps.entities.WorkExperience;
import com.ge.tps.service.AddProfileInfoService;
import com.google.gson.Gson;

/**
 * Servlet implementation class AddTrainingExperience
 */
@WebServlet("/AddTrainingExperience")
public class AddTrainingExperience extends HttpServlet {
	AddProfileInfoService addProfileInfoService=null;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTrainingExperience() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In Add training Exp");
		addProfileInfoService=new AddProfileInfoService();
		String trainingExpJson=request.getParameter("trainerExperience");
		System.out.println(trainingExpJson);
		long trainerId=Long.parseLong(request.getParameter("trainerId"));
		Set<WorkExperience> workExperiences=addProfileInfoService.addTrainingExperience(trainingExpJson,trainerId);
		PrintWriter out=response.getWriter();
		Gson gson=new Gson();
		String workExperienceJson=gson.toJson(workExperiences);
		System.out.println(workExperienceJson);
		out.print(workExperienceJson);
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
