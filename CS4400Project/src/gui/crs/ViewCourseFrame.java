/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.crs;

import conn.Connector;
import dat.UserProfile;
import dat.obj.Course;
import dat.obj.Project;
import gui.adm.ChooseFunctFrame;
import gui.lgn.RegisterFrame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Kenneth Craig
 */
public class ViewCourseFrame extends JFrame {
    private JLabel          titleLabel;
    private JTextArea       descriptionArea;
    private JButton         backButton;
    private Course          course;
    private Connector       con;
    private UserProfile     profile;
    
    public ViewCourseFrame(Connector con, UserProfile profile) {
        this.con = con;
        this.profile = profile;
        setTitle(course.getCourseName());
        buildPane();
        pack();
        setVisible(true);
    }
    
    private void buildPane() {
        createFields();
        addToPane();
        fillInFields();
    }
    
    private void createFields() {
        titleLabel = new JLabel(course.getCourseName());
        descriptionArea = new JTextArea();
        descriptionArea.setWrapStyleWord(true);
        
        backButton = new JButton("Back");
        backButton.addActionListener(new BackListener());
    }
    
    private void addToPane() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        JPanel[] panels = new JPanel[3];
        panels[0] = new JPanel();
        panels[1] = new JPanel();
        panels[2] = new JPanel();
        
        panels[0].setLayout(new FlowLayout(FlowLayout.CENTER));
        panels[1].setLayout(new FlowLayout(FlowLayout.CENTER));
        panels[2].setLayout(new BoxLayout(panels[2], BoxLayout.X_AXIS));
        
        JPanel[] subPanels = new JPanel[1];
        subPanels[0] = new JPanel();
        subPanels[0].setLayout(new FlowLayout(FlowLayout.LEFT));
        
        //Panel 0
        panels[0].add(titleLabel);
        
        //Panel 1
        panels[1].add(descriptionArea);
        
        //Panel 2
        subPanels[0].add(backButton);
        panels[2].add(subPanels[0]);
        
        //Add to main panel
        mainPanel.add(panels[0]);
        mainPanel.add(panels[1]);
        mainPanel.add(panels[2]);
        this.add(mainPanel);
    }
    
    private void fillInFields() {
        titleLabel.setText("<html><span style='font-size:20px'><font color='gold'>" + course.getCourseNum() + "</font></span></html>");
        
        String desc = "Course Name: " + course.getCourseName()
                + "\n\nInstructor: " + course.getInstructor()
                + "\n\nDesignation: " + course.getDesignation()
                + "\n\nCategory: " + course.getCategories()
                + "\n\nEstimated number of students: " + course.getEstNumStudents();
        
        descriptionArea.setText(desc);
    }
    
    private class BackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //Open Register Frame.
            new ChooseFunctFrame(con, profile);
            dispose();
        }
    }
}
