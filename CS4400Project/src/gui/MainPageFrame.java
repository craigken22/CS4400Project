/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import conn.Connector;
import dat.Lookups;
import dat.UserProfile;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Kenneth Craig
 */
public class MainPageFrame extends JPanel {
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
    private String[]                designations,
                                    majors,
                                    years,
                                    categories;
    private Connector               con;
    private UserProfile             profile;
    
    public MainPageFrame(Connector con, UserProfile profile) {
        this.profile = profile;
        this.con = con;
        
        createLabels();
        createFields();
        setupPanel();
    }
    
    private void createLabels() {
        meLabel = new JLabel("Me");
        mainPageLabel = new JLabel("<html></html>");
        titleLabel = new JLabel("Title");
        categoryLabel = new JLabel("Category");
        addCategoryLabel = new JLabel("<html></html>");
        designationLabel = new JLabel("Designation");
        majorLabel = new JLabel("Major");
        yearLabel = new JLabel("Year");
    }
    
    private void createFields() {
        titleField = new JTextField();
        
        categoryBoxes = new ArrayList();
        
        categories = Lookups.getCategories(con);
        designations = Lookups.getDesignations(con, true);
        majors = Lookups.getMajors(con);
        years = Lookups.getYears(con);
        
        designationBox = new JComboBox(designations);
        majorBox = new JComboBox(majors);
        yearBox = new JComboBox(years);
        
        applyButton = new JButton("Apply Filter");
        resetButton = new JButton("Reset Filter");
        
        applyButton.addActionListener(new ApplyListener());
        resetButton.addActionListener(new ResetListener());
    }
    
    private void setupPanel() {
        
    }
    
    private class ApplyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    }
    
    private class ResetListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    }
}
