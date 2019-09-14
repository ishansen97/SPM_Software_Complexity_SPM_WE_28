package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.MetricMeasurement;
import repository.MetricMeasurementRepository;

/**
 * Servlet implementation class InsertMetrics
 */
@WebServlet("/InsertMetrics")
public class InsertMetrics extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertMetrics() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int size_complexity = Integer.parseInt(request.getParameter("size_complexity"));
		int control_complexity = Integer.parseInt(request.getParameter("control_complexity"));
		int nested_complexity = Integer.parseInt(request.getParameter("nested_complexity"));
		int inheritance_complexity = Integer.parseInt(request.getParameter("inheritance_complexity"));
		int recursion_complexity = Integer.parseInt(request.getParameter("recursion_complexity"));
		
		PrintWriter out = response.getWriter();
		
		MetricMeasurement metrices = new MetricMeasurement(size_complexity,control_complexity,nested_complexity,inheritance_complexity,recursion_complexity);
		MetricMeasurementRepository repository = new MetricMeasurementRepository();
		
		if (repository.insertMetricMeasurements(metrices)) {
			response.sendRedirect(request.getContextPath() + "/MetricManagement.jsp");
		}
		else {
			out.println("Error");
		}
//		out.println("size: " + size_complexity);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
