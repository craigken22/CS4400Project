/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dat;

import conn.Connector;
import java.util.ArrayList;

/**
 *
 * @author Kenneth Craig
 */
public class Lookups {
    public static String[] getDesignations(Connector con, boolean forFilter) {
        ArrayList<String> designations = new ArrayList();
        String sql = "";
        
        if (forFilter) {
            designations.add("Please Select");
        }
        
        
        
        return (String[])(designations.toArray());
    }
    public static String[] getCategories(Connector con) {
        ArrayList<String> designations = new ArrayList();
        String sql = "";
        
        
        
        
        
        return (String[])(designations.toArray());
    }
    public static String[] getMajors(Connector con) {
        ArrayList<String> designations = new ArrayList();
        String sql = "";
        
        
        
        return (String[])(designations.toArray());
    }
    public static String[] getYears(Connector con) {
        ArrayList<String> designations = new ArrayList();
        String sql = "";
        
        
        
        return (String[])(designations.toArray());
    }
}
