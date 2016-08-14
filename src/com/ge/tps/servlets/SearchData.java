package com.ge.tps.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ge.tps.dto.TrainerProfileDTOMain;
import com.ge.tps.service.SearchService;
import com.ge.tps.service.impl.SearchServiceImpl;
import com.google.gson.Gson;

/**
 * Servlet implementation class SearchData
 */
@WebServlet("/getSearchData")
public class SearchData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SearchService searchServiceImpl = new SearchServiceImpl();
		Map<String, List<TrainerProfileDTOMain>> listOfTrainers = new HashMap<>();
		listOfTrainers = searchServiceImpl.getSearchResults();
		Gson json = new Gson(); 
		String serialization = json.toJson(listOfTrainers);
		serialization = serialization.substring(4, serialization.length()-1);	
		response.getWriter().append(serialization);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
