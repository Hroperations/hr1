package com.virtusa.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.virtusa.factory.UserFactory;
import com.virtusa.model.UserModel;
import com.virtusa.service.UserService;
/**
 * Servlet implementation class UserServlet
 */
@WebServlet(urlPatterns="/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService=null;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init(ServletConfig config) throws ServletException{
    	super.init(config);
    	this.userService=UserFactory.createUserService();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserModel userModel=new UserModel();
		//UserModelValidator userModelValidator =new UserModelValidator();
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		userModel.setUserName(userName);
		userModel.setPassword(password);
		//if(userModelValidator.validate(userModel)){
		String userType=
				userService.userAuthenticationService(userModel);
		if(userType.contentEquals("APPLICANT")) {
			RequestDispatcher dispatcher=
					request.getRequestDispatcher("ApplicantView.html");
					dispatcher.forward(request,response);
		}else if(userType.contentEquals("ADMIN")) {
			RequestDispatcher dispatcher=
				request.getRequestDispatcher("AdminView.html");
				dispatcher.forward(request,response);
		}else if(userType.contentEquals("HR")) {
			RequestDispatcher dispatcher=
					request.getRequestDispatcher("HrView.html");
					dispatcher.forward(request,response);
		}else if(userType.contentEquals("INTERVIEWER")) {
			RequestDispatcher dispatcher=
					request.getRequestDispatcher("InterviewerView.html");
					dispatcher.forward(request,response);
		}
		else if(userType.contentEquals("INTERVIEWER")) {
			RequestDispatcher dispatcher=
					request.getRequestDispatcher("InterviewerView.html");
					dispatcher.forward(request,response);
		}else {	
			RequestDispatcher dispatcher=
					request.getRequestDispatcher("unsuccessful.html");
					dispatcher.forward(request,response);
		}
	}
}

