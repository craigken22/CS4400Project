/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.crs;

import conn.Connector;
import dat.Lookups;
import dat.UserProfile;
import gui.lgn.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Kenneth Craig
 */
public class AddCourseFrame extends JFrame {
    private JLabel          addLabel,
                            nameLabel,
                            advisorLabel,
                            advisorEmailLabel,
                            descriptionLabel,
                            categoryLabel,
                            designationLabel,
                            estNumStudentsLabel,
                            majorReqLabel,
                            yearReqLabel,
                            deptReqLabel,
                            addCategoryLabel;
    private JButton         backButton,
                            submitButton;
    private JTextField      nameField,
                            advisorField,
                            advisorEmailField,
                            estNumStudentsField;
    private JTextArea       descriptionArea;
    private JComboBox[]     categoryBoxes;
    private JComboBox       designationBox,
                            majorReqBox,
                            yearReqBox,
                            deptReqBox;
    private Object[]        categories,
                            designations,
                            majorReqs,
                            yearReqs,
                            deptReqs;
    private Connector       con;
    private UserProfile     profile;
    
    public AddCourseFrame(Connector con, UserProfile profile) {
        this.con = con;
        this.profile = profile;
        setTitle("Add a Course");
        buildPane();
        pack();
        setVisible(true);
    }
    
    private void buildPane() {
        createFields();
        addToPane();
    }
    
    private void createFields() {
        addLabel = new JLabel("<html><span style='font-size:20px'><font color='gold'>Add a Project</font></span></html>");
        nameLabel = new JLabel("Project Name: ");
        advisorLabel = new JLabel("Advisor: ");
        advisorEmailLabel = new JLabel("Advisor Email: ");
        descriptionLabel = new JLabel("Description: ");
        categoryLabel = new JLabel("Category: ");
        designationLabel = new JLabel("Designation: ");
        estNumStudentsLabel = new JLabel("Estimated # of students: ");
        majorReqLabel = new JLabel("Major Requirement: ");
        yearReqLabel = new JLabel("Year Requirement: ");
        deptReqLabel = new JLabel("Department Requirement: ");
        
        addCategoryLabel = new JLabel("<html>Add a new category</html>");
        addCategoryLabel.addMouseListener(new AddCategoryListener());
        
        nameField = new JTextField(10);
        advisorField = new JTextField(10);
        advisorEmailField = new JTextField(10);
        estNumStudentsField = new JTextField(10);
        
        designations = Lookups.getDesignations(con, false);
        majorReqs = Lookups.getCategories(con);
        yearReqs = Lookups.getCategories(con);
        deptReqs = Lookups.getCategories(con);
        
        designationBox = new JComboBox(designations);
        majorReqBox = new JComboBox(majorReqs);
        yearReqBox = new JComboBox(yearReqs);
        deptReqBox = new JComboBox(deptReqs);
        
        
        categories = Lookups.getCategories(con);
        
        categoryBoxes = new JComboBox[5];
        categoryBoxes[0] = new JComboBox(categories);
        
        backButton = new JButton("Back");
        backButton.addActionListener(new BackListener());
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new SubmitListener());
    }
    
    private void addToPane() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        JPanel[] panels = new JPanel[5];
        panels[0] = new JPanel();
        panels[1] = new JPanel();
        panels[2] = new JPanel();
        panels[3] = new JPanel();
        panels[4] = new JPanel();
        
        panels[0].setLayout(new FlowLayout(FlowLayout.CENTER));
        panels[1].setLayout(new BoxLayout(panels[1], BoxLayout.X_AXIS));
        panels[2].setLayout(new BoxLayout(panels[2], BoxLayout.X_AXIS));
        panels[3].setLayout(new BoxLayout(panels[3], BoxLayout.X_AXIS));
        panels[4].setLayout(new FlowLayout(FlowLayout.RIGHT));
        
        JPanel[] subPanels = new JPanel[6];
        subPanels[0] = new JPanel();
        subPanels[1] = new JPanel();
        subPanels[2] = new JPanel();
        subPanels[3] = new JPanel();
        subPanels[4] = new JPanel();
        subPanels[5] = new JPanel();
        
        subPanels[0].setLayout(new FlowLayout(FlowLayout.LEFT));
        subPanels[1].setLayout(new FlowLayout(FlowLayout.RIGHT));
        subPanels[2].setLayout(new FlowLayout(FlowLayout.LEFT));
        subPanels[3].setLayout(new FlowLayout(FlowLayout.RIGHT));
        subPanels[4].setLayout(new FlowLayout(FlowLayout.LEFT));
        subPanels[5].setLayout(new FlowLayout(FlowLayout.RIGHT));
        
        //Panel 0
        panels[0].add(addLabel);
        
        //Panel 1
        subPanels[0].add(nameLabel);
        subPanels[1].add(nameField);
        panels[1].add(subPanels[0]);
        panels[1].add(subPanels[1]);
        
        //Panel 2
        subPanels[2].add(advisorLabel);
        subPanels[3].add(advisorField);
        panels[2].add(subPanels[2]);
        panels[2].add(subPanels[3]);
        
        //Panel 3
        subPanels[4].add(backButton);
        subPanels[5].add(submitButton);
        panels[3].add(subPanels[4]);
        panels[3].add(subPanels[5]);
        
        //Add to main panel
        mainPanel.add(panels[0]);
        mainPanel.add(panels[1]);
        mainPanel.add(panels[2]);
        mainPanel.add(panels[3]);
        mainPanel.add(panels[4]);
        this.add(mainPanel);
    }
    
    private class AddCategoryListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            //Add another category
        }
    }
    
    private class BackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //Open Register Frame.
            new RegisterFrame(con);
            dispose();
        }
    }
    
    private class SubmitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = nameField.getText();
            String password;
            
            if (username != null) {
                if (!username.isEmpty()) {
                    
                    dispose();
                } else {
                    //Password empty
                }
            } else {
                //Error
            }
            
        }
    }
}
