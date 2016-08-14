package com.ge.tps.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ge.tps.entities.LanguageKnown;
import com.ge.tps.service.EditProfileService;
import com.google.gson.Gson;

/**
 * Servlet implementation class EditLanguages
 */
@WebServlet("/EditLanguages")
public class EditLanguages extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EditProfileService editProfileService=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditLanguages() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("IN EDIT Language Info");
		long personalInfoId=Long.parseLong(request.getParameter("personalInfoId"));
		String LanInfoJson=(String)request.getParameter("languageInformation");
		System.out.println(LanInfoJson);
		editProfileService=new EditProfileService();
		List<LanguageKnown> languageKnownList=editProfileService.editLanguage(personalInfoId,LanInfoJson);
		PrintWriter out=response.getWriter();
		Gson gson=new Gson();
		String languageKnownListJson=gson.toJson(languageKnownList);
		out.print(languageKnownListJson);
		out.flush();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
