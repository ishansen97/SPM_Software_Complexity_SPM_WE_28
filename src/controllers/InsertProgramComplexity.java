package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;

import models.InsertProgrammingComplexityRequest;
import models.InsertProgrammingComplexityResponse;
import models.ProgramStatementComplexity;
import service.ProgramComplexityService;

/**
 * Servlet implementation class InsertProgramComplexity
 */
@WebServlet("/InsertProgramComplexity")
public class InsertProgramComplexity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertProgramComplexity() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		String programName = request.getParameter("programName");
		int totalComplexity = Integer.parseInt(request.getParameter("total_complexity"));
		int no_of_lines = Integer.parseInt(request.getParameter("no_of_lines"));
		List<ProgramStatementComplexity> programStatementComplexities = (List<ProgramStatementComplexity>) session.getAttribute("ProgramComplexity");
		
		out.println("Program name: " + programName);
		out.println("total complexity: " + totalComplexity);
		out.println("no of lines: " + no_of_lines);
		out.println("list length: " + programStatementComplexities.size());
		
		InsertProgrammingComplexityRequest insertRequest = new InsertProgrammingComplexityRequest();
		
		insertRequest.setProgramName(programName);
		insertRequest.setTotalComplexity(totalComplexity);
		insertRequest.setNoOfLines(no_of_lines);
		insertRequest.setProgramComplexities(programStatementComplexities);
		
		ProgramComplexityService program_service = new ProgramComplexityService();
		
		InsertProgrammingComplexityResponse insertResponse = program_service.insertProgramComplexity(insertRequest);
		
		if (insertResponse.isInserted()) {
			response.sendRedirect(request.getContextPath() + "/DisplayProgramComplexities.jsp");
		}
		else {
			response.sendRedirect(request.getContextPath() + "/DisplayComplexity.jsp");
		}
		
	}

}
