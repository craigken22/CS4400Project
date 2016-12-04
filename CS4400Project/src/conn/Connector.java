/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Kenneth Craig
 */
public class Connector {
    private Connection con;
    private Statement  stmt;
    private ResultSet  rs;
    
    public Connector() {
        con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://academic-mysql.cc.gatech.edu",
                    " cs4400_Team_31", "1vakj0D9");
            if(!con.isClosed())
                System.out.println("Successfully connected to " +
                                        "MySQL server using TCP/IP...");
        } catch(Exception e) {
            System.err.println("Exception: " + e.getMessage());
        } finally {
            try {
                if(con != null) {
                    con.close();
                }
            } catch(SQLException e) {}
        }
    }
    
    public ResultSet getResults(String sql) {
        try {
            rs = stmt.executeQuery(sql);
        } catch(Exception conExcept) {
            
        }
        return rs;
    }
}
