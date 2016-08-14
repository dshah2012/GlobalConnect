package com.ge.tps.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ge.tps.dao.impl.RegistrationServiceHibernate;
import com.ge.tps.entities.Contact;
import com.ge.tps.entities.PersonalInfo;
import com.ge.tps.entities.TrainerProfile;
import com.ge.tps.entities.User;
import com.ge.tps.enums.Gender;
import com.ge.tps.enums.Salutation;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/addRegDetails.htm")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String firstName= request.getParameter("firstname");
		String lastName= request.getParameter("lastname");
		String userName= request.getParameter("username");
		String primaryMailId= request.getParameter("primaryMailId");
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		Date dob=null;
		try {
			dob = format.parse(request.getParameter("dateOfBirth"));
		} catch (ParseException e1) {
		
			e1.printStackTrace();
		}
		long primaryMobileNo=Long.parseLong(request.getParameter("primaryMobileNo"));
		Salutation salutation=Salutation.valueOf(request.getParameter("salutation"));
		Gender gender=Gender.valueOf(request.getParameter("gender"));
		
		RegistrationServiceHibernate registrationService = new RegistrationServiceHibernate();
		
		User user = new User(primaryMailId, userName, "");
		PersonalInfo personalInfo = new PersonalInfo(firstName, "", lastName, "", dob, gender, null);
		Contact contact = new Contact();
		contact.setPrimaryMobileNo(primaryMobileNo);
		user.setContact(contact);
    //    user.getRole().setRoleName("TRAINER");
    //    user.setUserStatus(UserStatus.ACTIVE);
		TrainerProfile trainerProfile = new TrainerProfile();
		trainerProfile.setSalutation(salutation);
		trainerProfile.setProfileCreationDate(new Date());
		trainerProfile.setUser(user);
		trainerProfile.setPersonalInfo(personalInfo);
		
		if(registrationService.isEmailAvailable(primaryMailId)){
			if(registrationService.isUserNameAvailable(userName)){
				response.getWriter().append(registrationService.registerTrainerProfile(trainerProfile));
			}else{
				response.getWriter().append( "userName Not available");
			}
		}else{
			response.getWriter().append( "email id not available");
		}       		
	}
	

		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
