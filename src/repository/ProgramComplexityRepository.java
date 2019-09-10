package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbconnection.DBConnection;
import entity.ProgramComplexity;
import queries.ProgramComplexityMeasurementQueries;
import queries.ProgramComplexityQueries;

public class ProgramComplexityRepository {
	
	private Connection getDBConnection() {
		DBConnection dbConnection = DBConnection.getInstance();
		Connection connection = dbConnection.getCon();
		
		return connection;
	}

	public boolean insertProgramComplexity(ProgramComplexity programComplexity) {
		Connection con = getDBConnection();
		int result = 0;
		int result1 = 0;
		
		try {
			PreparedStatement pst = con.prepareStatement(ProgramComplexityQueries.INSERT_PROGRAM_COMPLEXITY);
			pst.setString(1, programComplexity.getProgramName());
			pst.setInt(2, programComplexity.getTotalComplexity());
			pst.setInt(3, programComplexity.getNoOfLines());
			
			result = pst.executeUpdate();
			
			if (result > 0) {
				
			}
			
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
		return (result > 0);
	}
	
	public int getLastRecordId() {
		Connection con = getDBConnection();
		int result = 0;
		int result1 = 0;
		int last_Id = 0;
		ResultSet lastRecord = null;
		
		try {
			Statement st = con.createStatement();
			lastRecord = st.executeQuery(ProgramComplexityQueries.GET_LAST_RECORD);
			
			while (lastRecord.next()) {
				last_Id = lastRecord.getInt(1);
			}
			
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return last_Id;
	}
	
	public List<ProgramComplexity> getAllProgramComplexities() {
		Connection con = getDBConnection();
		ResultSet result = null;
        List<ProgramComplexity> programComplexitiesList = new ArrayList<>();
		
		try {
			Statement st = con.createStatement();
			
			result = st.executeQuery(ProgramComplexityQueries.GET_ALL_RECORDS);
			
			while (result.next()) {
				ProgramComplexity programComplexity = new ProgramComplexity();
				
				programComplexity.setProgramId(result.getInt(1));
				programComplexity.setProgramName(result.getString(2));
				programComplexity.setTotalComplexity(result.getInt(3));
				programComplexity.setNoOfLines(result.getInt(4));
				
				programComplexitiesList.add(programComplexity);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return programComplexitiesList;
		
		
	}

	public boolean deleteProgramComplexity(int progId) {
		Connection con = getDBConnection();
		int result = 0;
		
		try {
			PreparedStatement pst = con.prepareStatement(ProgramComplexityQueries.DELETE_PROGRAM_COMPLEXITY);
			pst.setInt(1, progId);
			
			result = pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (result > 0);
	}

}
