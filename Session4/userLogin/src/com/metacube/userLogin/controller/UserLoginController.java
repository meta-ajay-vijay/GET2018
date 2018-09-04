package com.metacube.userLogin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metacube.userLogin.facade.UserFacade;
import com.metacube.userLogin.view.ProfileView;

/**
 * Servlet implementation class UserLoginController
 */

public class UserLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserFacade userFacade = UserFacade.getInstance();
	    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String friendEmail  = request.getParameter("friend_email");
		
		if(friendEmail==null){
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if(userFacade.checkUserEmailPassword(email,password)){
			HttpSession session = request.getSession();
			

			session.setAttribute("email", email);


			ProfileView profileView = userFacade.getUserProfileData(request.getSession().getAttribute("email").toString());
			
			request.setAttribute("profile_data", profileView);
			request.setAttribute("visibility", "block");

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/profile.jsp");
			requestDispatcher.forward(request, response);
		}else{
			request.setAttribute("login_message", "invalid email or password");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
			requestDispatcher.forward(request, response);
		}
		
	}else{

		ProfileView profileView = userFacade.getUserProfileData(friendEmail);
		
		request.setAttribute("profile_data", profileView);
		request.setAttribute("visibility", "none");
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/profile.jsp");
		requestDispatcher.forward(request, response);
	}
	}

}
