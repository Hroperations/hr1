package com.virtusa.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;

import com.virtusa.factory.FactoryApplicantService;
import com.virtusa.model.ApplicantModel;
import com.virtusa.service.ApplicantService;

/**
 * Servlet implementation class ApplicantServlet
 */
@WebServlet("/applicant")
public class ApplicantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger log=Logger.getLogger(ApplicantServlet.class);
	private ApplicantService applicantService = null;
	private final String UPLOAD_DIRECTORY = "C:/uploads";


	// private ApplicantModel applicantModel=null;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ApplicantServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.applicantService = FactoryApplicantService.createApplicantService();
		// this.applicantModel=new ApplicantModel();
	}

	/**
	 * @throws IOException
	 * @throws ServletException
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if (action.contentEquals("viewJob")) {
		List<ApplicantModel> applicantModelList;
		try {
				applicantModelList = applicantService.retrieveJobService();
				request.setAttribute("applicantModelList", applicantModelList);

				if (!applicantModelList.isEmpty()) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("searchJob.jsp");
					dispatcher.forward(request, response);
				} else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("noJobFound.jsp");
					dispatcher.forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(action.contentEquals("applicationStatus")){
			try {
				List<ApplicantModel> applicantModelList=applicantService.retrieveApplicationStatus();
				request.setAttribute("applicantModelList", applicantModelList);
				if (!applicantModelList.isEmpty()) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("applicantStatus.jsp");
					dispatcher.forward(request, response);
				} else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("noJobFound.jsp");
					dispatcher.forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(action.contentEquals("resultUpdate")){
			try {
				List<ApplicantModel> applicantModelList=applicantService.retreiveResultUpdate();
				request.setAttribute("applicantModelList", applicantModelList);
				if (!applicantModelList.isEmpty()) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("ResultUpdate.jsp");
					dispatcher.forward(request, response);
				} else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("noJobFound.jsp");
					dispatcher.forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(action.contentEquals("approveOfferLetter")){
			try {
				List<ApplicantModel> applicantModelList=applicantService.retreiveOfferLetter();
				request.setAttribute("applicantModelList", applicantModelList);
				if (!applicantModelList.isEmpty()) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("ApproveOrRejectOfferLetter.jsp");
					dispatcher.forward(request, response);
				} else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("noJobFound.jsp");
					dispatcher.forward(request, response);
				}
			
			
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<FileItem> multiparts;
		String resumepath = null;
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmssSSS");
		String currentDate=formatter.format(new Date());
		try {
			multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
			//resumepath = UPLOAD_DIRECTORY + '/' + multiparts.get(0).getName();
			for (FileItem item : multiparts) {
				if (item.isFormField()) {} 
				else {
					resumepath=UPLOAD_DIRECTORY+"/"+currentDate+item.getName();
					String name = new File(currentDate+item.getName()).getName();
					item.write(new File(UPLOAD_DIRECTORY + File.separator + name));
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			 ApplicantModel applicantModel = new ApplicantModel();
			 applicantModel.setResume(resumepath);
			 String result = applicantService.postResume(applicantModel);
			 request.setAttribute("result", result);
			 if (result != null) {
			 RequestDispatcher dispatcher =
			 request.getRequestDispatcher("s.html");
			 dispatcher.forward(request, response);
			 } else {
			
			 RequestDispatcher dispatcher =
			 request.getRequestDispatcher("unsuccess.html");
			 dispatcher.forward(request, response);
			 }
		}

	}


