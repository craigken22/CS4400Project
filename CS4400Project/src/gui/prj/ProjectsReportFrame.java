/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.prj;

import conn.Connector;
import dat.UserProfile;
import gui.adm.ChooseFunctFrame;
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
import javax.swing.JRadioButton;
import javax.swing.JTable;

/**
 *
 * @author Kenneth Craig
 */
public class ProjectsReportFrame extends JFrame {
    private JLabel          projectsLabel;
    private JButton         backButton;
    private JTable          table;
    private Connector       con;
    private UserProfile     profile;
    
    public ProjectsReportFrame(Connector con, UserProfile profile) {
        this.con = con;
        this.profile = profile;
        setTitle("Popular Project");
        buildPane();
        pack();
        setVisible(true);
    }
    
    private void buildPane() {
        createFields();
        addToPane();
    }
    
    private void createFields() {
        projectsLabel = new JLabel("<html><span style='font-size:20px'><font color='gold'>Popular Project</font></span></html>");
        
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
        panels[2].setLayout(new FlowLayout(FlowLayout.LEFT));
        
        //Panel 0
        panels[0].add(projectsLabel);
        
        //Panel 1
        panels[1].add(table);
        
        //Panel 2
        panels[2].add(backButton);
        
        //Add to main panel
        mainPanel.add(panels[0]);
        mainPanel.add(panels[1]);
        mainPanel.add(panels[2]);
        this.add(mainPanel);
    }
    
    private class BackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new ChooseFunctFrame(con, profile);
            dispose();
        }
    }
}
