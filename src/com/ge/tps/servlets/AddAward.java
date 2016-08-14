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

import com.ge.tps.entities.HonorAndAward;
import com.ge.tps.service.AddProfileInfoService;
import com.google.gson.Gson;

/**
 * Servlet implementation class AddAward
 */
@WebServlet("/AddAward")
public class AddAward extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AddProfileInfoService addProfileInfoService=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAward() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("In Servlet HonorAdd");
		addProfileInfoService=new AddProfileInfoService();
		SimpleDateFormat date=new SimpleDateFormat("yyyy-MM-dd");
		
		Date d=null;
		try {
			d = date.parse(request.getParameter("dateOfIssue"));
			System.out.println(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HonorAndAward honorAndAwards=new HonorAndAward(request.getParameter("awardTitle"),request.getParameter("issuer") , request.getParameter("occupation"), d);
		
		long trainerId = Long.parseLong(request.getParameter("trainerId"));
		List<HonorAndAward> honorlist=addProfileInfoService.addHonorAndAwards(honorAndAwards,trainerId);
		PrintWriter out=response.getWriter();
		Gson gson=new Gson();
		String honorJsonInfo=gson.toJson(honorlist);
		out.print(honorJsonInfo);
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
