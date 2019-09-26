package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.DeleteProgramComplexityRequest;
import models.DeleteProgramComplexityResponse;
import service.ProgramComplexityService;

/**
 * Servlet implementation class DeleteProrgramComplexityServlet
 */
@WebServlet("/DeleteProrgramComplexityServlet")
public class DeleteProrgramComplexityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProrgramComplexityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int id = Integer.parseInt(request.getParameter("programId"));
		
		PrintWriter out = response.getWriter();
		
		out.write("hello there" + id);
		
		DeleteProgramComplexityRequest deleteRequest = new DeleteProgramComplexityRequest();
		deleteRequest.setProgId(id);
		
		ProgramComplexityService service = new ProgramComplexityService();
		
		DeleteProgramComplexityResponse deleteResponse = service.deleteProgramComplexity(deleteRequest);
		
		if (deleteResponse.isDeleted()) {
			out.println("great");
		}
		else {
			out.println("not great");
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
