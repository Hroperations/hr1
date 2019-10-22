package com.virtusa.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.virtusa.dao.ApplicantDAO;
import com.virtusa.factory.FactoryApplicantDAO;


/**
 * Servlet implementation class ArroveOrRejectServlet
 */
@WebServlet("/approve")
public class ArroveOrRejectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ApplicantDAO applicantDAO=null;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArroveOrRejectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init(ServletConfig config) throws ServletException {
    super.init(config);
    this.applicantDAO=FactoryApplicantDAO.createApplicantDAO();
   
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			boolean result=applicantDAO.approveOfferLetterStatus();
			System.out.println(result);
			if(result) {
				RequestDispatcher dispatcher=
				request.getRequestDispatcher("success.html");
				dispatcher.forward(request, response);
				}
				else
				{
				
				}
				
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
