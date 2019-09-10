package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbconnection.DBConnection;
import entity.ProgramComplexityMeasurement;
import queries.ProgramComplexityMeasurementQueries;

public class ProgramComplexityMeasurementRepository {

	private Connection getDBConnection() {
		DBConnection dbConnection = DBConnection.getInstance();
		Connection connection = dbConnection.getCon();
		
		return connection;
	}

	public boolean insertProgramComplexityMeasurement(ProgramComplexityMeasurement programComplexityMeasurement) {
		Connection con = getDBConnection();
		int result = 0;
		
		try {
			PreparedStatement pst = con.prepareStatement(ProgramComplexityMeasurementQueries.INSERT_PROGRAM_STATEMENT_COMPLEXITY);
			pst.setInt(1, programComplexityMeasurement.getProgId());
			pst.setInt(2, programComplexityMeasurement.getLineNo());
			pst.setString(3, programComplexityMeasurement.getStatement());
			pst.setInt(4, programComplexityMeasurement.getSizeCount());
			pst.setInt(5, programComplexityMeasurement.getControlCount());
			pst.setInt(6, programComplexityMeasurement.getNestedCount());
			pst.setInt(7, programComplexityMeasurement.getInheritanceCount());
			pst.setInt(8, programComplexityMeasurement.getTotalWeight());
			pst.setInt(9, programComplexityMeasurement.getStatementComplexity());
			pst.setInt(10, programComplexityMeasurement.getRecusrionComplxity());			
			
			result = pst.executeUpdate();
			
			
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
		return (result > 0);
	}
	
	public List<ProgramComplexityMeasurement> getProgramComplexityMeasurement(int programId) {
		List<ProgramComplexityMeasurement> measurementList = new ArrayList<>();
		Connection con = getDBConnection();
		ResultSet result = null;
		
		try {
			PreparedStatement pst = con.prepareStatement(ProgramComplexityMeasurementQueries.GET_PROGRAM_STATEMENT_COMPLEXITY);
			pst.setInt(1, programId);			
			
			result = pst.executeQuery();
			
			while (result.next()) {
				ProgramComplexityMeasurement programComplexityMeasurement = new ProgramComplexityMeasurement();
				
				programComplexityMeasurement.setProgId(programId);
				programComplexityMeasurement.setLineNo(result.getInt(2));
				programComplexityMeasurement.setStatement(result.getString(3));
				programComplexityMeasurement.setSizeCount(result.getInt(4));
				programComplexityMeasurement.setControlCount(result.getInt(5));
				programComplexityMeasurement.setNestedCount(result.getInt(6));
				programComplexityMeasurement.setInheritanceCount(result.getInt(7));
				programComplexityMeasurement.setTotalWeight(result.getInt(8));
				programComplexityMeasurement.setStatementComplexity(result.getInt(9));
				programComplexityMeasurement.setRecusrionComplxity(result.getInt(10));
				
				measurementList.add(programComplexityMeasurement);
				
			}
			
			
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return measurementList;
		
		
	}

	public boolean deleteProgramComplexityMeasurements(int progId) {
		Connection con = getDBConnection();
		int result = 0;
		
		try {
			PreparedStatement pst = con.prepareStatement(ProgramComplexityMeasurementQueries.DELETE_PROGRAM_STATEMENT_COMPLEXITIES);
			pst.setInt(1, progId);
			
			result = pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (result > 0);
	}
}
