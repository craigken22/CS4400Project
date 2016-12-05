/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.lgn;

import conn.Connector;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import util.Utilities;

/**
 *
 * @author Kenneth Craig
 */
public class RegisterFrame extends JFrame {
    
    private JLabel          registerLabel,
                            usernameLabel,
                            emailLabel,
                            passwordLabel,
                            confirmLabel;
    private JButton         createButton;
    private JTextField      usernameField,
                            emailField;
    private JPasswordField  passwordField,
                            confirmField;
    private Connector       con;
    
    public RegisterFrame(Connector con) {
        this.con = con;
        setTitle("New Student Registration");
        buildPane();
        pack();
        setVisible(true);
    }
    
    private void buildPane() {
        createFields();
        addToPane();
    }
    
    private void createFields() {
        registerLabel = new JLabel("<html>New Student Registration</html>");
        usernameLabel = new JLabel("Username");
        emailLabel = new JLabel("GT Email Address");
        passwordLabel = new JLabel("Password");
        confirmLabel = new JLabel("Confirm Password");
        
        usernameField = new JTextField(10);
        emailField = new JTextField(10);
        passwordField = new JPasswordField(10);
        confirmField = new JPasswordField(10);
        
        createButton = new JButton("Create");
        createButton.addActionListener(new CreateListener());
    }
    
    private void addToPane() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        JPanel[] panels = new JPanel[6];
        panels[0] = new JPanel();
        panels[1] = new JPanel();
        panels[2] = new JPanel();
        panels[3] = new JPanel();
        panels[4] = new JPanel();
        panels[5] = new JPanel();
        
        panels[0].setLayout(new FlowLayout(FlowLayout.CENTER));
        panels[1].setLayout(new BoxLayout(panels[1], BoxLayout.X_AXIS));
        panels[2].setLayout(new BoxLayout(panels[2], BoxLayout.X_AXIS));
        panels[3].setLayout(new BoxLayout(panels[3], BoxLayout.X_AXIS));
        panels[4].setLayout(new BoxLayout(panels[4], BoxLayout.X_AXIS));
        panels[5].setLayout(new FlowLayout(FlowLayout.CENTER));
        
        JPanel[] subPanels = new JPanel[8];
        subPanels[0] = new JPanel();
        subPanels[1] = new JPanel();
        subPanels[2] = new JPanel();
        subPanels[3] = new JPanel();
        subPanels[4] = new JPanel();
        subPanels[5] = new JPanel();
        subPanels[6] = new JPanel();
        subPanels[7] = new JPanel();
        
        subPanels[0].setLayout(new FlowLayout(FlowLayout.LEFT));
        subPanels[1].setLayout(new FlowLayout(FlowLayout.RIGHT));
        subPanels[2].setLayout(new FlowLayout(FlowLayout.LEFT));
        subPanels[3].setLayout(new FlowLayout(FlowLayout.RIGHT));
        subPanels[4].setLayout(new FlowLayout(FlowLayout.LEFT));
        subPanels[5].setLayout(new FlowLayout(FlowLayout.RIGHT));
        subPanels[6].setLayout(new FlowLayout(FlowLayout.LEFT));
        subPanels[7].setLayout(new FlowLayout(FlowLayout.RIGHT));
        
        //Panel 0
        panels[0].add(registerLabel);
        
        //Panel 1
        subPanels[0].add(usernameLabel);
        subPanels[1].add(usernameField);
        panels[1].add(subPanels[0]);
        panels[1].add(subPanels[1]);
        
        //Panel 2
        subPanels[2].add(emailLabel);
        subPanels[3].add(emailField);
        panels[2].add(subPanels[2]);
        panels[2].add(subPanels[3]);
        
        //Panel 3
        subPanels[4].add(passwordLabel);
        subPanels[5].add(passwordField);
        panels[3].add(subPanels[4]);
        panels[3].add(subPanels[5]);
        
        //Panel 4
        subPanels[6].add(confirmLabel);
        subPanels[7].add(confirmField);
        panels[4].add(subPanels[6]);
        panels[4].add(subPanels[7]);
        
        //Panel 5
        panels[5].add(createButton);
        
        //Add to main panel
        mainPanel.add(panels[0]);
        mainPanel.add(panels[1]);
        mainPanel.add(panels[2]);
        mainPanel.add(panels[3]);
        mainPanel.add(panels[4]);
        mainPanel.add(panels[5]);
        this.add(mainPanel);
    }
    
    private class CreateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username;
            String email;
            char[] pw;
            char[] pw2;
            String password;
            String password2;
            
            try {
                username = usernameField.getText();
                email = emailField.getText();
                pw = passwordField.getPassword();
                pw2 = confirmField.getPassword();
                password = "";
                password2 = "";
            } catch (NullPointerException ex) {
                username = null;
                email = null;
                pw = null;
                pw2 = null;
                password = null;
                password2 = null;
            }
            
            if (username != null && email != null
                        && pw != null && pw2 != null) {
                
                
                username = username.replaceAll("'", "''");
                email = email.replaceAll("'", "''");
                for (int i = 0; i < pw.length; i++) {
                    password = password + pw[i];
                }
                password = password.replaceAll("'", "''");
                for (int i = 0; i < pw2.length; i++) {
                    password2 = password2 + pw2[i];
                }
                password2 = password2.replaceAll("'", "''");
                
                if (!username.isEmpty() && !email.isEmpty() 
                        && !password.isEmpty() && !password2.isEmpty()) {
                    if (password.equals(password2)) {
                        if (Utilities.validate(email)) {
                            String sql = "INSERT INTO 'STD_USERS'\n" +
"				(username, user_type, password, major, year, email_address)\n" +
"		VALUES\n" +
"				('"+username+"', 'STUDENT', '"+password+"', 'Computer Science', 'Freshman', '"+email+"')";
                            System.out.println(sql);
                            con.execute(sql);
                            new LoginFrame(con);
                            dispose();
                        } else {
                            //Email invalid.
                        }
                    } else {
                        //Passwords don't match.
                    }
                } else {
                    //Fields empty
                    
                }
            } else {
                //Error
            }
            
        }
    }
}
