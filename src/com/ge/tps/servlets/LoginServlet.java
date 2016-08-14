package com.ge.tps.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("login");
		String password = request.getParameter("password");

		// Create a configuration object and configure the app
		Configuration cfg = new AnnotationConfiguration().configure("hibernate.cfg.xml");
		//cfg.addResource("hibernate.cfg.xml");

		// Get the Session factory
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		// Get the session
		Session session_hibernate = sessionFactory.openSession();
		org.hibernate.Transaction tx = session_hibernate.beginTransaction();
		
		/*User user1 = new User();
		user1.setUserName("chandra");
		user1.setPassword("pratian");
		user1.setPrimaryMailId("chandra@pratian.com");
		session_hibernate.save(user1);
		*/
		tx.commit();
		tx = session_hibernate.beginTransaction();
		
		//String hql = "select userId from User where username = " + name + " and password = " + password;
		Query query = session_hibernate.createQuery("FROM User user WHERE user.userName = :name and user.password = :password")
				.setParameter("name", name).setParameter("password",password);
		List<?> results = query.list();
		System.out.println(results);
		System.out.println(name + "             " + password);
		if(!results.isEmpty())
		{
			//out.print("true");
			HttpSession session_http = request.getSession();
			
			session_http.setAttribute("name",name);
			session_http.setAttribute("id", results.get(0));
			response.sendRedirect("Pages/Account.jsp");
		}
		else
		{
			response.sendRedirect("index.html");
		}

		tx.commit();
		out.close();
		
		// Close the session
		session_hibernate.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
