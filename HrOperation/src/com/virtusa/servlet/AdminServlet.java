	package com.virtusa.servlet;
	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletConfig;
	import java.io.IOException;
	import java.sql.SQLException;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import org.apache.log4j.Logger;

import com.virtusa.factory.FactoryAdminService;
	import com.virtusa.model.AdminModel;
	import com.virtusa.service.AdminService;
	
	/**
	 * Servlet implementation class AdminServlet
	 */
	@WebServlet(urlPatterns="/admin")
	public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger log=Logger.getLogger(AdminServlet.class);
	private AdminService adminService=null;
	private AdminModel adminModel=null;
	    public AdminServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
	   
	    @Override
	    public void init(ServletConfig config) throws ServletException {
	    super.init(config);
	    this.adminService=FactoryAdminService.createAdminService();
	    this.adminModel=new AdminModel();
	   
	    }
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	
	String action=request.getParameter("action");
	int jobId=Integer.parseInt(request.getParameter("jobId"));
	String jobTitle=request.getParameter("jobTitle");
	String eligibilityCriteria=request.getParameter("eligibilityCriteria");
	int opportunityId=Integer.parseInt(request.getParameter("opportunityId"));
	adminModel.setJobId(jobId);
	adminModel.setJobTitle(jobTitle);
	adminModel.setEligibilityCriteria(eligibilityCriteria);
	adminModel.setOpportunityId(opportunityId);
	if(action.contentEquals("viewJob")) {
	try {
	boolean result=adminService.storeJobService(adminModel);
	if(result) {
	RequestDispatcher dispatcher=
	request.getRequestDispatcher("success.html");
	dispatcher.forward(request, response);
	}
	else
	{
	
	}
	} catch (ClassNotFoundException | SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	}
	}
	}