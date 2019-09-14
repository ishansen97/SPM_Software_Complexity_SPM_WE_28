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
 * Servlet implementation class UpdateMetricManagementServlet
 */
@WebServlet("/UpdateMetricManagementServlet")
public class UpdateMetricManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMetricManagementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out = response.getWriter();
		
		int Id = Integer.parseInt(request.getParameter("Id"));
		int size = Integer.parseInt(request.getParameter("size"));
		int control = Integer.parseInt(request.getParameter("control"));
		int nested = Integer.parseInt(request.getParameter("nested"));
		int inheritance = Integer.parseInt(request.getParameter("inheritance"));
		int recursion = Integer.parseInt(request.getParameter("recursion"));
		
		MetricMeasurement metrices = new MetricMeasurement(Id, size, control, nested, inheritance, recursion);
		MetricMeasurementRepository repository = new MetricMeasurementRepository();
		
		if (repository.updateMetricMeasurements(metrices)) {
			out.println("successfully updated");
		}
		else {
			out.println("could not be updated");
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
