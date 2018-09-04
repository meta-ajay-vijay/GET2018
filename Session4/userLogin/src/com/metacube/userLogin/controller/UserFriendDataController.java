package com.metacube.userLogin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metacube.userLogin.facade.UserFacade;
import com.metacube.userLogin.models.User;
import com.metacube.userLogin.view.UserFriendView;

/**
 * Servlet implementation class UserFriendDataController
 */
public class UserFriendDataController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserFacade userFacade = UserFacade.getInstance();
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserFriendDataController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getSession().getAttribute("email").toString();
		
		List<UserFriendView> listOfUsers = userFacade.getUserFriendsData(email);

       request.setAttribute("friend_list", listOfUsers);
       
//       response.sendRedirect("user_friends.jsp");
       
		RequestDispatcher requestDispatcher =  request.getRequestDispatcher("user_friends.jsp");
		requestDispatcher.include(request, response);
		
//		System.out.println(listOfUsers);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
