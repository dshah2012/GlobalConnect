package com.ge.tps.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ge.tps.entities.JobEmployment;
import com.ge.tps.entities.LanguageKnown;
import com.ge.tps.entities.PersonalInfo;
import com.ge.tps.entities.SpokenLanguage;
import com.ge.tps.service.AddProfileInfoService;
import com.google.gson.Gson;

/**
 * Servlet implementation class AddLanguage
 */
@WebServlet("/AddLanguage")
public class AddLanguage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AddProfileInfoService addProfileInfoService=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddLanguage() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In Servlet Add Language");
		addProfileInfoService=new AddProfileInfoService();
		
		long trainerId = Long.parseLong(request.getParameter("trainerInfoId"));
		
		SpokenLanguage spokenLanguage=new SpokenLanguage();
		spokenLanguage.setLanguageName(request.getParameter("spokenLanguageName"));
		
		LanguageKnown languageKnown = new LanguageKnown();
		languageKnown.setCanRead(Boolean.parseBoolean(request.getParameter("canRead")));
		languageKnown.setCanWrite(Boolean.parseBoolean((request.getParameter("canWrite"))));
		languageKnown.setCanSpeak(Boolean.parseBoolean(request.getParameter("canSpeak")));
		languageKnown.setSpokenLanguage(spokenLanguage);
		long personalInfoId=Long.parseLong(request.getParameter("personalInfoId"));
		List<LanguageKnown> languageKnownList=addProfileInfoService.addLanguage(languageKnown,trainerId,personalInfoId);
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
		doGet(request, response);
	}

}
