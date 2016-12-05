/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.std;

import conn.Connector;
import dat.Lookups;
import dat.UserProfile;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Kenneth Craig
 */
public class EditProfileFrame extends JFrame {
    private JLabel          editLabel,
                            majorLabel,
                            yearLabel,
                            deptLabel,
                            deptOutLabel;
    private JButton         backButton;
    private JComboBox       majorBox,
                            yearBox;
    private Object[]        majors,
                            years;
    private Connector       con;
    private UserProfile     profile;
    
    public EditProfileFrame(Connector con, UserProfile profile) {
        this.con = con;
        this.profile = profile;
        setTitle("Edit Your Profile");
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
        editLabel = new JLabel("<html><span style='font-size:20px'><font color='gold'>Edit Your Profile</font></span></html>");
        majorLabel = new JLabel("Major");
        yearLabel = new JLabel("Year");
        deptLabel = new JLabel("Department");
        deptOutLabel = new JLabel();
        
        majors = Lookups.getMajors(con);
        years = Lookups.getYears(con);
        
        majorBox = new JComboBox(majors);
        yearBox = new JComboBox(years);
        
        backButton = new JButton("Back");
        backButton.addActionListener(new BackListener());
    }
    
    private void fillInFields() {
        majorBox.setSelectedItem(profile.getMajor());
        deptOutLabel.setText(profile.getDepartment());
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
        panels[1].setLayout(new GridLayout(2, 1));
        panels[2].setLayout(new GridLayout(2, 1));
        panels[3].setLayout(new GridLayout(2, 1));
        panels[4].setLayout(new FlowLayout(FlowLayout.CENTER));
        
        JPanel[] subPanels = new JPanel[6];
        subPanels[0] = new JPanel();
        subPanels[1] = new JPanel();
        subPanels[2] = new JPanel();
        subPanels[3] = new JPanel();
        subPanels[4] = new JPanel();
        subPanels[5] = new JPanel();
        
        subPanels[0].setLayout(new FlowLayout(FlowLayout.LEFT));
        subPanels[1].setLayout(new FlowLayout(FlowLayout.LEFT));
        subPanels[2].setLayout(new FlowLayout(FlowLayout.LEFT));
        subPanels[3].setLayout(new FlowLayout(FlowLayout.LEFT));
        subPanels[4].setLayout(new FlowLayout(FlowLayout.LEFT));
        subPanels[5].setLayout(new FlowLayout(FlowLayout.LEFT));
        
        //Panel 0
        panels[0].add(editLabel);
        
        //Panel 1
        subPanels[0].add(majorLabel);
        subPanels[1].add(majorBox);
        panels[1].add(subPanels[0]);
        panels[1].add(subPanels[1]);
        
        //Panel 2
        subPanels[2].add(yearLabel);
        subPanels[3].add(yearBox);
        panels[2].add(subPanels[2]);
        panels[2].add(subPanels[3]);
        
        //Panel 3
        subPanels[4].add(deptLabel);
        subPanels[5].add(deptOutLabel);
        panels[3].add(subPanels[4]);
        panels[3].add(subPanels[5]);
        
        //Panel 4
        panels[3].add(backButton);
        
        //Add to main panel
        mainPanel.add(panels[0]);
        mainPanel.add(panels[1]);
        mainPanel.add(panels[2]);
        mainPanel.add(panels[3]);
        mainPanel.add(panels[4]);
        this.add(mainPanel);
    }
    
    private class BackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = (String)(majorBox.getSelectedItem());
            String password;
            
            if (username != null) {
                if (!username.isEmpty()) {
                    
                    new MeFrame(con, profile);
                    dispose();
                } else {
                    //Password empty
                }
            } else {
                //Error
            }
            //Open Register Frame.
            
        }
    }
}
