/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.prj;

import dat.obj.Project;
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
public class ViewProjectFrame extends JFrame {
    private JLabel          titleLabel;
    private JTextArea       descriptionArea;
    private JButton         backButton,
                            applyButton;
    private Project         project;
    
    public ViewProjectFrame() {
        setTitle("Login");
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
        titleLabel = new JLabel("Login");
        descriptionArea = new JTextArea();
        descriptionArea.setWrapStyleWord(true);
        
        backButton = new JButton("Back");
        backButton.addActionListener(new BackListener());
        applyButton = new JButton("Apply");
        applyButton.addActionListener(new ApplyListener());
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
        
        JPanel[] subPanels = new JPanel[2];
        subPanels[0] = new JPanel();
        subPanels[1] = new JPanel();
        
        //Panel 0
        panels[0].add(titleLabel);
        
        //Panel 1
        panels[1].add(descriptionArea);
        
        //Panel 2
        subPanels[0].add(backButton);
        subPanels[1].add(applyButton);
        panels[2].add(subPanels[0]);
        panels[2].add(subPanels[1]);
        
        //Add to main panel
        mainPanel.add(panels[0]);
        mainPanel.add(panels[1]);
        mainPanel.add(panels[2]);
        this.add(mainPanel);
    }
    
    private void fillInFields() {
        titleLabel.setText(project.getProjectName());
        
        String desc = "Advisor: " + project.getAdvisor()
                + " (" + project.getAdvisorEmail() + ")"
                + "\n\nDescription: " + project.getDescription()
                + "\n\nDesignation: " + project.getDesignation()
                + "\n\nCategory: " + project.getCategories()
                + "\n\nRequirements: " + project.getRequirements()
                + "\n\nEstimated number of students: " + project.getEstNumStudents();
        
        descriptionArea.setText(desc);
    }
    
    private class BackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //Open Register Frame.
            new RegisterFrame();
            dispose();
        }
    }
    
    private class ApplyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
//            String username = usernameField.getText();
//            String password;
//            
//            if (username != null) {
//                if (!username.isEmpty()) {
//                    
//                    dispose();
//                } else {
//                    //Password empty
//                }
//            } else {
//                //Error
//            }
            
        }
    }
}
