package com.ge.tps.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ge.tps.entities.Education;
import com.ge.tps.entities.SkillSet;
import com.ge.tps.service.AddProfileInfoService;
import com.google.gson.Gson;

/**
 * Servlet implementation class AddSkillSet
 */
@WebServlet("/AddSkillSet")
public class AddSkillSet extends HttpServlet {
	AddProfileInfoService addProfileInfoService=null;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSkillSet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In Servlet Add Skill Set");
		
		addProfileInfoService=new AddProfileInfoService();
		String skillName=request.getParameter("skillSetName");
		String categoryName=request.getParameter("categoryName");
		long trainerId=Long.parseLong(request.getParameter("trainerId"));
		System.out.println(trainerId);
		System.out.println(categoryName+"  "+skillName);
		List<SkillSet> skillSetList=addProfileInfoService.addSkillSet(skillName,categoryName,trainerId);
		
		PrintWriter out=response.getWriter();
		Gson gson=new Gson();
		String skillSetListJson=gson.toJson(skillSetList);
		out.print(skillSetListJson);
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
