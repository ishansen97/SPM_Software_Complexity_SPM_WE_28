package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
	private static DBConnection dbConnection = null;
    private Connection con = null;

    private DBConnection() {
        setConnection();
    }

    public static DBConnection getInstance() {
        if (dbConnection == null) {
            synchronized(DBConnection.class) {
                if (dbConnection == null) {
                    dbConnection =  new DBConnection();
                }
            }
        } 
        return dbConnection;
    }
    
    public void setConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            String url = "jdbc:mysql://localhost:3306/spm_software_complexity";
            String username = "root";
            String password = "";
            
            con = DriverManager.getConnection(url, username, password);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public Connection getCon() {
        return con;
    }
}
