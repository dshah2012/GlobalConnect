package com.ge.tps.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ge.tps.entities.WorkExperience;
import com.ge.tps.service.AddProfileInfoService;
import com.ge.tps.service.EditProfileService;
import com.google.gson.Gson;

/**
 * Servlet implementation class EditRealTimeExperience
 */
@WebServlet("/EditRealTimeExperience")
public class EditRealTimeExperience extends HttpServlet {
	EditProfileService editProfileService=null;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditRealTimeExperience() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("In Edit RealExperience Exp");
		editProfileService=new EditProfileService();
		String realTimeExpJson=request.getParameter("realTimeExperience");
		System.out.println(realTimeExpJson);
		long trainerId=Long.parseLong(request.getParameter("trainerId"));
		List<WorkExperience> workExperiences=editProfileService.editRealTimeExperience(realTimeExpJson,trainerId);
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
