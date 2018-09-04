package com.metacube.userLogin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metacube.userLogin.enums.Status;
import com.metacube.userLogin.facade.UserFacade;
import com.metacube.userLogin.view.ProfileView;

/**
 * Servlet implementation class UpdateUserProfileDataController
 */
@WebServlet("/UpdateUserProfileDataController")
public class UpdateUserProfileDataController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserFacade userFacade = UserFacade.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserProfileDataController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String name = (String) request.getParameter("update_name");
		String age = (String) request.getParameter("update_age");
		String contact = (String) request.getParameter("update_contact");
		String org = (String) request.getParameter("update_org");
		String email = request.getSession().getAttribute("email").toString();

		Status status = userFacade.updateUserProfleData(name,age,contact,org,email);
		
		String message = "";
		
		switch(status){
		case CREATED:
			break;
		case DELETED:
			break;
		case DUPLICATE_USER:
			break;
		case ERROR:
			message = "got some error ";
			break;
		case NOT_FOUND:
			break;
		case OK:
			break;
		case UPDATED:
			message = "data has been updated ";
			break;
		default:
			break;
		
		}
		
		ProfileView profileView = userFacade.getUserProfileData(request.getSession().getAttribute("email").toString());	
		request.setAttribute("update_message", message);
		request.setAttribute("profile_data", profileView );
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("profile.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
