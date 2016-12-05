/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dat;

import conn.Connector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kenneth Craig
 */
public class Lookups {
    public static Object[] getDesignations(Connector con, boolean forFilter) {
        ArrayList<String> designations = new ArrayList();
        String sql = "SELECT designation\n" +
"     FROM LKP_DESIGNATIONS;";
        
        if (forFilter) {
            designations.add("Please Select");
        }
        
        ResultSet rs = con.getResults(sql);
        
        try {
            while (rs.next()) {
                designations.add(rs.getString(1));
                System.out.println(rs.getString(1));
            }
        } catch (SQLException ex) {
            
        }
        
        return (designations.toArray());
    }
    public static Object[] getCategories(Connector con) {
        ArrayList<String> designations = new ArrayList();
        String sql = "SELECT category\n" +
"     FROM LKP_CATEGORIES;";
        
        
        
        ResultSet rs = con.getResults(sql);
        
        try {
            while (rs.next()) {
                designations.add(rs.getString(1));
                System.out.println(rs.getString(1));
            }
        } catch (SQLException ex) {
            
        }
        return (designations.toArray());
    }
    public static Object[] getMajors(Connector con, String dept) {
        ArrayList<String> designations = new ArrayList();
        String sql = "SELECT major\n" +
"     FROM LKP_MAJORS\n" +
"     WHERE department = '" + dept + "'";
        
        
        
        ResultSet rs = con.getResults(sql);
        
        try {
            while (rs.next()) {
                designations.add(rs.getString(1));
                System.out.println(rs.getString(1));
            }
        } catch (SQLException ex) {
            
        }
        return (designations.toArray());
    }
    public static Object[] getMajors(Connector con) {
        ArrayList<String> designations = new ArrayList();
        String sql = "SELECT major\n" +
"     FROM LKP_MAJORS";
        
        
        
        ResultSet rs = con.getResults(sql);
        
        try {
            while (rs.next()) {
                designations.add(rs.getString(1));
                System.out.println(rs.getString(1));
            }
        } catch (SQLException ex) {
            
        }
        return (designations.toArray());
    }
    public static Object[] getYears(Connector con) {
        ArrayList<String> designations = new ArrayList();
        String sql = "SELECT year FROM LKP_YEARS";
        
        
        
        ResultSet rs = con.getResults(sql);
        
        try {
            while (rs.next()) {
                designations.add(rs.getString(1));
                System.out.println(rs.getString(1));
            }
        } catch (SQLException ex) {
            
        }
        return (designations.toArray());
    }
}
