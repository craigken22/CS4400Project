/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.std;

import gui.std.EditProfileFrame;
import conn.Connector;
import dat.UserProfile;
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
public class MeFrame extends JFrame {
    private JLabel          meLabel,
                            editProfileLabel,
                            myApplicationLabel;
    private JButton         backButton;
    private Connector       con;
    private UserProfile     profile;
    
    public MeFrame(Connector con, UserProfile profile) {
        this.con = con;
        this.profile = profile;
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
        meLabel = new JLabel("<html><span style='font-size:20px'><font color='gold'>Me</font></span></html>");
        editProfileLabel = new JLabel("<html>Edit Profile</html>");
        myApplicationLabel = new JLabel("<html>My Application</html>");
        
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
        panels[0].add(meLabel);
        
        //Panel 1
        panels[1].add(editProfileLabel);
        
        //Panel 2
        panels[2].add(myApplicationLabel);
        
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
            new EditProfileFrame(con, profile);
            dispose();
        }
    }
    
    private class MyApplicationListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            //Open Register Frame.
//            new RegisterFrame();
            dispose();
        }
    }
}
