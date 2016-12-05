/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.lgn;

import conn.Connector;
import dat.Lookups;
import dat.UserProfile;
import dat.obj.User;
import gui.MainPageFrame;
import gui.adm.ChooseFunctFrame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Kenneth Craig
 */
public class LoginFrame extends JFrame {
    private JLabel          loginLabel,
                            usernameLabel,
                            passwordLabel,
                            buzzLabel;
    private JButton         loginButton,
                            registerButton;
    private JTextField      usernameField;
    private JPasswordField  passwordField;
    private ImageIcon       buzzImage;
    private Connector       con;
    
    public LoginFrame() {
        setTitle("Login");
        buildPane();
        pack();
        setVisible(true);
        
        
        con = new Connector();
    }
    
    public LoginFrame(Connector con) {
        this.con = con;
        setTitle("Login");
        buildPane();
        pack();
        setVisible(true);
        
        
        
        
    }
    
    private void buildPane() {
        createFields();
        addToPane();
    }
    
    private void createFields() {
        loginLabel = new JLabel("Login");
        usernameLabel = new JLabel("Username");
        passwordLabel = new JLabel("Password");
        buzzImage = new ImageIcon();
        buzzLabel = new JLabel(buzzImage);
        
        usernameField = new JTextField(10);
        passwordField = new JPasswordField(10);
        
        loginButton = new JButton("Login");
        loginButton.addActionListener(new LoginListener());
        registerButton = new JButton("Register");
        registerButton.addActionListener(new RegisterListener());
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
        panels[0].add(loginLabel);
        
        //Panel 1
        subPanels[0].add(usernameLabel);
        subPanels[1].add(usernameField);
        panels[1].add(subPanels[0]);
        panels[1].add(subPanels[1]);
        
        //Panel 2
        subPanels[2].add(passwordLabel);
        subPanels[3].add(passwordField);
        panels[2].add(subPanels[2]);
        panels[2].add(subPanels[3]);
        
        //Panel 3
        subPanels[4].add(loginButton);
        subPanels[5].add(registerButton);
        panels[3].add(subPanels[4]);
        panels[3].add(subPanels[5]);
        
        //Panel 4
        panels[4].add(buzzLabel);
        
        //Add to main panel
        mainPanel.add(panels[0]);
        mainPanel.add(panels[1]);
        mainPanel.add(panels[2]);
        mainPanel.add(panels[3]);
        mainPanel.add(panels[4]);
        this.add(mainPanel);
    }
    
    private class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username;
            char[] pw;
            String password;
            try {
                username = usernameField.getText();
                pw = passwordField.getPassword();
                password = "";
            } catch (NullPointerException ex) {
                username = null;
                pw = null;
                password = null;
            }
            if (username != null && pw != null) {
                username = username.replaceAll("'", "''");
                for (int i = 0; i < pw.length; i++) {
                    password = password + pw[i];
                }
                password = password.replaceAll("'", "''");
                if (!username.isEmpty() && !password.isEmpty()) {
                    String sql = "SELECT	u.username,\n" +
"		u.password,\n" +
"		u.user_type,\n" +
"		u.major,\n" +
"		m.department,\n" +
"		u.year,\n" +
"		u.email_address\n" +
"	FROM STD_USERS u\n" +
"		LEFT OUTER JOIN LKP_MAJORS m ON u.major = m.major\n" +
"	WHERE u.username = '"+username+"' AND u.password = '"+password+"'";
                    System.out.println(sql);
                    ResultSet rs = con.getResults(sql);
                    
                    try {
                        if (rs.next()) {
                            User user = new User(
                                                    rs.getString(1),
                                                    rs.getString(2),
                                                    rs.getString(3),
                                                    rs.getString(4),
                                                    rs.getString(5),
                                                    rs.getString(6),
                                                    rs.getString(7)
                                                );
                    System.out.println(user.getUsername());
                            UserProfile profile = new UserProfile(user);
                            if (profile.getUserType().equals("STUDENT")) {
                                new MainPageFrame(con, profile);
                            } else {
                                new ChooseFunctFrame(con, profile);
                            }
                            dispose();
                        }
                    } catch (Exception ex) {
                        //Connection error.  Login failed.
                        
                    }
                } else {
                    //Username or Password empty
                    JOptionPane.showMessageDialog(null, 
                            "Username and Password cannot be empty.  Please try again.", 
                            "Empty Username or Password",
                            JOptionPane.WARNING_MESSAGE);
                }
            } else {
                //Error
                JOptionPane.showMessageDialog(null, 
                        "Username and Password cannot be empty.  Please try again.", 
                        "Empty Username or Password",
                        JOptionPane.WARNING_MESSAGE);
            }
            
        }
    }
    
    private class RegisterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //Open Register Frame.
            new RegisterFrame(con);
            dispose();
        }
    }
}
