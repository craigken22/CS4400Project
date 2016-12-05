/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import conn.Connector;
import dat.Lookups;
import dat.UserProfile;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Kenneth Craig
 */
public class MainPageFrame extends JFrame {
    private JLabel                  meLabel,
                                    mainPageLabel,
                                    titleLabel,
                                    categoryLabel,
                                    addCategoryLabel,
                                    designationLabel,
                                    majorLabel,
                                    yearLabel;
    private JTextField              titleField;
    private ArrayList<JComboBox>    categoryBoxes;
    private JComboBox               designationBox,
                                    majorBox,
                                    yearBox;
    private JRadioButton            projectButton,
                                    courseButton,
                                    bothButton;
    private JButton                 applyButton,
                                    resetButton;
    private JTable                  courseAndProjectTable;
    private Object[]                designations,
                                    majors,
                                    years,
                                    categories;
    private Connector               con;
    private UserProfile             profile;
    private Object[][]              data;
    private JPanel[]                panels;
    
    public MainPageFrame(Connector con, UserProfile profile) {
        this.profile = profile;
        this.con = con;
        setTitle("Application");
        buildPane();
        pack();
        setVisible(true);
    }
    
    private void buildPane() {
        createFields();
        addToPane();
    }
    
    private void createFields() {
        meLabel = new JLabel("Me");
        mainPageLabel = new JLabel("<html></html>");
        titleLabel = new JLabel("Title");
        categoryLabel = new JLabel("Category");
        addCategoryLabel = new JLabel("<html></html>");
        designationLabel = new JLabel("Designation");
        majorLabel = new JLabel("Major");
        yearLabel = new JLabel("Year");
        
        titleField = new JTextField();
        
        categoryBoxes = new ArrayList();
        
        categories = Lookups.getCategories(con);
        designations = Lookups.getDesignations(con, true);
        majors = Lookups.getMajors(con, profile.getDepartment());
        years = Lookups.getYears(con);
        
        designationBox = new JComboBox(designations);
        majorBox = new JComboBox(majors);
        yearBox = new JComboBox(years);
        
        String sql = "SELECT COUNT(project_name) FROM STD_PROJECTS "
                + "UNION "
                + "SELECT COUNT(course_name) FROM STD_COURSES";
        ResultSet rs = con.getResults(sql);
        int count = 0;
        try {
            rs.next();
            count = rs.getInt(1);
            rs.next();
            count = count + rs.getInt(1);
        } catch (SQLException ex) {
            
        }
        data = new Object[count][2];
        
        sql = "SELECT project_name, 'Project' FROM STD_PROJECTS "
                + "UNION "
                + "SELECT course_name, 'Course' FROM STD_COURSES";
        rs = con.getResults(sql);
        
        try {
            while (rs.next()) {
                for (int i = 0; i < count; i++) {
                    data[i][0] = rs.getString(1);
                    data[i][1] = rs.getString(2);
                }
            }
        } catch (SQLException ex) {
            
        }
        
        courseAndProjectTable = new JTable(new MyTableModel());
        
        applyButton = new JButton("Apply Filter");
        resetButton = new JButton("Reset Filter");
        
        applyButton.addActionListener(new ApplyListener());
        resetButton.addActionListener(new ResetListener());
    }
    
    
    
    class MyTableModel extends AbstractTableModel {
        String[] cols = {"Name", "Type"};
        Object[][] dat = data;
        
        @Override
        public int getColumnCount() {
            return cols.length;
        }
        @Override
        public int getRowCount() {
            return dat.length;
        }
        @Override
        public String getColumnName(int col) {
            return cols[col];
        }
        @Override
        public Object getValueAt(int row, int col) {
            return dat[row][col];
        }
        
        @Override
        public Class getColumnClass(int c) {
            return getValueAt(0,c).getClass();
        }
    }
    
    private void addToPane() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        JPanel[] panels = new JPanel[7];
        panels[0] = new JPanel();
        panels[1] = new JPanel();
        panels[2] = new JPanel();
        panels[3] = new JPanel();
        panels[4] = new JPanel();
        panels[5] = new JPanel();
        panels[6] = new JPanel();
        
        panels[0].setLayout(new FlowLayout(FlowLayout.LEFT));
        panels[1].setLayout(new BoxLayout(panels[1], BoxLayout.X_AXIS));
        panels[2].setLayout(new BoxLayout(panels[2], BoxLayout.X_AXIS));
        panels[3].setLayout(new BoxLayout(panels[3], BoxLayout.X_AXIS));
        panels[4].setLayout(new BoxLayout(panels[4], BoxLayout.X_AXIS));
        panels[5].setLayout(new FlowLayout(FlowLayout.CENTER));
        panels[6].setLayout(new FlowLayout(FlowLayout.RIGHT));
        
        JPanel[] subPanels = new JPanel[10];
        subPanels[0] = new JPanel();
        subPanels[1] = new JPanel();
        subPanels[2] = new JPanel();
        subPanels[3] = new JPanel();
        subPanels[4] = new JPanel();
        subPanels[5] = new JPanel();
        subPanels[6] = new JPanel();
        subPanels[7] = new JPanel();
        subPanels[8] = new JPanel();
        subPanels[9] = new JPanel();
        
        subPanels[0].setLayout(new FlowLayout(FlowLayout.LEFT));
        subPanels[1].setLayout(new FlowLayout(FlowLayout.RIGHT));
        subPanels[2].setLayout(new FlowLayout(FlowLayout.LEFT));
        subPanels[3].setLayout(new FlowLayout(FlowLayout.RIGHT));
        
        //Panel 0
        subPanels[0].add(meLabel);
        subPanels[1].add(mainPageLabel);
        panels[0].add(subPanels[0]);
        panels[0].add(subPanels[1]);
        //Panel 1
        subPanels[0].add(meLabel);
        subPanels[0].add(mainPageLabel);
        panels[1].add(subPanels[0]);
        //Panel 2
        panels[2].add(courseAndProjectTable);
        //Panel 3
        panels[3].add(courseAndProjectTable);
        //Panel 4
        panels[4].add(courseAndProjectTable);
        //Panel 5
        panels[6].add(applyButton);
        panels[6].add(resetButton);
        //Panel 6
        panels[6].add(courseAndProjectTable);
        
        mainPanel.add(applyButton);
        mainPanel.add(courseAndProjectTable);
        this.add(mainPanel);
    }
    
    private class ApplyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String sql = "SELECT COUNT(project_name) FROM STD_PROJECTS "
                + "UNION "
                + "SELECT COUNT(course_name) FROM STD_COURSES";
            ResultSet rs = con.getResults(sql);
            int count = 0;
            try {
                rs.next();
                count = rs.getInt(1);
                rs.next();
                count = count + rs.getInt(1);
            } catch (SQLException ex) {

            }
            data = new Object[count][2];

            sql = "SELECT project_name, 'Project' FROM STD_PROJECTS "
                    + "UNION "
                    + "SELECT course_name, 'Course' FROM STD_COURSES ";
            rs = con.getResults(sql);

            try {
                while (rs.next()) {
                    for (int i = 0; i < count; i++) {
                        data[i][0] = rs.getString(1);
                        data[i][1] = rs.getString(2);
                    }
                }
            } catch (SQLException ex) {

            }

            courseAndProjectTable = new JTable(new MyTableModel());
            panels[6].removeAll();
            panels[6].add(courseAndProjectTable);
        }
    }
    
    private class ResetListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String sql = "SELECT COUNT(project_name) FROM STD_PROJECTS "
                + "UNION "
                + "SELECT COUNT(course_name) FROM STD_COURSES";
            ResultSet rs = con.getResults(sql);
            int count = 0;
            try {
                rs.next();
                count = rs.getInt(1);
                rs.next();
                count = count + rs.getInt(1);
            } catch (SQLException ex) {

            }
            data = new Object[count][2];

            sql = "SELECT project_name, 'Project' FROM STD_PROJECTS "
                    + "UNION "
                    + "SELECT course_name, 'Course' FROM STD_COURSES";
            rs = con.getResults(sql);

            try {
                while (rs.next()) {
                    for (int i = 0; i < count; i++) {
                        data[i][0] = rs.getString(1);
                        data[i][1] = rs.getString(2);
                    }
                }
            } catch (SQLException ex) {

            }

            courseAndProjectTable = new JTable(new MyTableModel());
            panels[6].removeAll();
            panels[6].add(courseAndProjectTable);
        }
    }
}
