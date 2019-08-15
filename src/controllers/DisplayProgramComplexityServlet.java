package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic.CalculateProgramComplexities;
import models.ProgramStatementComplexity;

/**
 * Servlet implementation class DisplayProgramComplexityServlet
 */
@WebServlet("/DisplayProgramComplexityServlet")
public class DisplayProgramComplexityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayProgramComplexityServlet() {
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
		
		String fileName = "D:\\SLIIT\\Year 3\\Assignments\\Semester 2\\SPM\\SPM_Project_Workspace\\Software_Complexity_Measurement\\src\\test\\FibonacciMain.java";
		List<ProgramStatementComplexity> programComplexity = null;
		HttpSession session = null;
		
		programComplexity = CalculateProgramComplexities.getProgramComplexity(fileName);
		
		if (programComplexity != null) {
			session = request.getSession();
			session.setAttribute("ProgramComplexity", programComplexity);
			session.setAttribute("FileName", fileName);
		}
		
		response.sendRedirect(request.getContextPath() + "/DisplayComplexity.jsp");
	}

}
