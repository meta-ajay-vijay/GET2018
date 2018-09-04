package com.metacube.userLogin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metacube.userLogin.enums.Status;
import com.metacube.userLogin.facade.UserFacade;
import com.metacube.userLogin.models.User;
import com.metacube.userLogin.view.ProfileView;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class UserImageController
 */
public class UserImageController extends HttpServlet {
    UserFacade userFacade = UserFacade.getInstance();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserImageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {

		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
System.out.println("got it");
try{
    MultipartRequest multipartRequest = new MultipartRequest(request,
            "E://eclipse workspace//userLogin//WebContent//images");

    Enumeration files = multipartRequest.getFileNames();
    String fileName = "";

    while(files.hasMoreElements() )
      {
        String upload = (String)files.nextElement();
        fileName = multipartRequest.getFilesystemName(upload);

    }
    
    Status status = userFacade.addImageUrl("./images/"+fileName,request.getSession().getAttribute("email").toString());
    String message = "";
    switch(status){
	case CREATED:
		break;
	case DELETED:
		break;
	case DUPLICATE_USER:
		break;
	case ERROR:
		message = "error in uploading";
		break;
	case NOT_FOUND:
		break;
	case OK:
		message = "image has been added";
		break;
	case UPDATED:
		break;
	default:
		break;
    
    }
    
    request.setAttribute("image_message", message);
	
	ProfileView profileView = userFacade.getUserProfileData(request.getSession().getAttribute("email").toString());
	
	request.setAttribute("profile_data", profileView);
	request.setAttribute("visibility", "block");
	
	RequestDispatcher requestDispatcher = request.getRequestDispatcher("/profile.jsp");
	requestDispatcher.forward(request, response);

	}catch(Exception e){
		System.out.println(e.getMessage());
	}
/*	       
	       Enumeration files = multipartRequest.getFileNames();
	       String path = null;
	       while (files.hasMoreElements()) {
	           String name = (String) files.nextElement();
	           path = multipartRequest.getFilesystemName(name);
	       }
	       
	       System.out.println(path);*/
	      
	       
/*	       userDetails.setEmail((String) request.getSession().getAttribute("email"));
	       userDetails.setImage(fileName);
	       Status status = userFacade.uploadImage(userDetails);
	       if (Status.UPDATED.equals(status)) {
	           userDetails = userFacade.selectUserDetailsByEmail((String) request.getSession().getAttribute("email"));
	           request.setAttribute("userDetails", userDetails);
	           RequestDispatcher view = request
	                   .getRequestDispatcher("/profile.jsp");
	           view.forward(request, response);
	       } else {
	           out.println(status);
	       }
*/	}

}
