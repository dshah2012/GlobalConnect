package com.ge.tps.servlets;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ge.tps.dto.LiveSessionDTO;
import com.ge.tps.entities.LiveSession;
import com.ge.tps.service.LiveSessionService;
import com.ge.tps.service.impl.LiveSessionServiceImpl;
import com.ge.tps.util.CustomSortUtil;
import com.ge.tps.util.LiveSessionTransformer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/GetComments")
public class AddLiveSessionServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private LiveSessionService liveSessionService = new LiveSessionServiceImpl();
       
    public AddLiveSessionServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In Get Comments");
		String url = request.getParameter("url");
		System.out.println("URL :  " + url);
		LiveSession liveSession = liveSessionService.getLiveSession(url);
		CustomSortUtil.sortLiveSessionCommentsByDateTime(liveSession);
		String liveSessionJson = transformLiveSessionToDTO(liveSession);
		PrintWriter out = response.getWriter();
		System.out.println("\n\n\n\n\n\n\n\n\n\n");
		System.out.println(liveSessionJson);
		out.print("[" + liveSessionJson + "]");
		out.flush();
	}

	private String transformLiveSessionToDTO(LiveSession liveSession) {
		LiveSessionTransformer liveSessionTransformer = new LiveSessionTransformer();
		LiveSessionDTO liveSessionDTO = liveSessionTransformer.transform(liveSession);
		Gson gson = new GsonBuilder().create();
		String liveSessionJson = gson.toJson(liveSessionDTO);
		return liveSessionJson;
	}
}
