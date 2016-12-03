/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.adm;

import conn.Connector;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Kenneth Craig
 */
public class ChooseFunctFrame extends JFrame {
    private JLabel          chooseLabel,
                            viewAppsLabel,
                            viewProjReportLabel,
                            viewAppReportLabel,
                            addProjectLabel,
                            addCourseLabel;
    private JButton         backButton;
    private Connector       con;
    
    public ChooseFunctFrame(Connector con) {
        this.con = con;
        setTitle("My Profile");
        buildPane();
        pack();
        setVisible(true);
    }
    
    private void buildPane() {
        createFields();
        addToPane();
    }
    
    private void createFields() {
        chooseLabel = new JLabel("<html><span style='font-size:20px'><font color='gold'>Choose Functionality</font></span></html>");
        viewAppsLabel = new JLabel("<html><font color='blue'><u>Edit Profile</u></font></html>");
        viewAppsLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        viewProjReportLabel = new JLabel("<html><font color='blue'><u>My Application</u></font></html>");
        viewProjReportLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        backButton = new JButton("Back");
        backButton.addActionListener(new BackListener());
    }
    
    private void addToPane() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        JPanel[] panels = new JPanel[5];
        panels[0] = new JPanel();
        panels[1] = new JPanel();
        panels[2] = new JPanel();
        panels[3] = new JPanel();
        
        panels[0].setLayout(new FlowLayout(FlowLayout.CENTER));
        panels[1].setLayout(new FlowLayout(FlowLayout.CENTER));
        panels[2].setLayout(new FlowLayout(FlowLayout.CENTER));
        panels[3].setLayout(new FlowLayout(FlowLayout.CENTER));
        
        //Panel 0
        panels[0].add(chooseLabel);
        
        //Panel 1
        panels[1].add(viewAppsLabel);
        
        //Panel 2
        panels[2].add(viewProjReportLabel);
        
        //Panel 3
        panels[3].add(backButton);
        
        //Add to main panel
        mainPanel.add(panels[0]);
        mainPanel.add(panels[1]);
        mainPanel.add(panels[2]);
        mainPanel.add(panels[3]);
        this.add(mainPanel);
    }
    
    private class BackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
//            new RegisterFrame();
            dispose();
        }
    }
    
    private class EditProfileListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            //Open Register Frame.
//            new RegisterFrame();
            dispose();
        }
    }
    
    private class AddCourseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            //Open Register Frame.
//            new RegisterFrame();
            dispose();
        }
    }
}
