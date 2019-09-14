package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbconnection.DBConnection;
import entity.MetricMeasurement;
import queries.MetricMeasurementQueries;

public class MetricMeasurementRepository {

	private Connection getDBConnection() {
		DBConnection dbConnection = DBConnection.getInstance();
		Connection connection = dbConnection.getCon();
		
		return connection;
	}
	
	public boolean insertMetricMeasurements(MetricMeasurement metrics) {
		Connection con = getDBConnection();
		int result = 0;
		
		try {
			PreparedStatement pst = con.prepareStatement(MetricMeasurementQueries.INSERT_METRIC_MEASUREMENT);
			pst.setInt(1, metrics.getSize_metric());
			pst.setInt(2, metrics.getControl_metric());
			pst.setInt(3, metrics.getNested_metric());
			pst.setInt(4, metrics.getInheritance_metric());
			pst.setInt(5, metrics.getRecursion_metric());			
			
			result = pst.executeUpdate();
			
			
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
		return (result > 0);
	}
	
	public boolean updateMetricMeasurements(MetricMeasurement metrics) {
		Connection con = getDBConnection();
		int result = 0;
		
		try {
			PreparedStatement pst = con.prepareStatement(MetricMeasurementQueries.UPDATE_METRIC_MEASUREMENT);
			pst.setInt(1, metrics.getSize_metric());
			pst.setInt(2, metrics.getControl_metric());
			pst.setInt(3, metrics.getNested_metric());
			pst.setInt(4, metrics.getInheritance_metric());
			pst.setInt(5, metrics.getRecursion_metric());			
			pst.setInt(6, metrics.getId());
			
			result = pst.executeUpdate();
			
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return (result > 0);
	}
	
	public List<MetricMeasurement> getAllParkings() {
        Connection con = getDBConnection();
        ResultSet result = null;
        List<MetricMeasurement> metricList = new ArrayList<>();
        
        try {
           
            PreparedStatement pst = con.prepareStatement(MetricMeasurementQueries.GET_ALL_METRIC_MEASUREMENTS);
            
            result = pst.executeQuery();
            
            while (result.next()) {
                MetricMeasurement metric = new MetricMeasurement();
            
            	metric.setId(result.getInt(1));
            	metric.setSize_metric(result.getInt(2));
            	metric.setControl_metric(result.getInt(3));
            	metric.setNested_metric(result.getInt(4));
            	metric.setInheritance_metric(result.getInt(5));
            	metric.setRecursion_metric(result.getInt(6));
                
                metricList.add(metric);
                
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
        	ex.printStackTrace();        
        }
        
        return metricList;
	}
}
