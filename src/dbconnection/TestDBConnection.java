package dbconnection;

import java.sql.Connection;

public class TestDBConnection {

	public static void main(String[] args) {
		DBConnection dbcon = DBConnection.getInstance();
		Connection con = null;
		con = dbcon.getCon();
		
		if (con != null) {
			System.out.println("Successfully connected");
		}
		else {
			System.out.println("Not connected");
		}
	}
}
