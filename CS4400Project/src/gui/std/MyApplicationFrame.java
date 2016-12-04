/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.std;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author Kenneth Craig
 */
public class MyApplicationFrame extends JFrame {
    private JLabel          applicationLabel;
    private JButton         backButton;
    private JTable          table;
    
    
    public MyApplicationFrame() {
        setTitle("My Application");
        buildPane();
        pack();
        setVisible(true);
    }
    
    private void buildPane() {
        createFields();
        addToPane();
    }
    
    private void createFields() {
        applicationLabel = new JLabel("<html><span style='font-size:20px'><font color='gold'>My Application</font></span></html>");
        
        table = new JTable();
        
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
        panels[2].setLayout(new FlowLayout(FlowLayout.CENTER));
        
        //Panel 0
        panels[0].add(applicationLabel);
        
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
//            new RegisterFrame();
            dispose();
        }
    }
}
