/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

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
public class ApplicationFrame extends JFrame {
    private JLabel          applicationLabel;
    private JButton         backButton,
                            acceptButton,
                            rejectButton;
    private JRadioButton[]  radioButtons;
    private JPanel[]        radioPanels;
    private JTable          table;
    
    
    public ApplicationFrame() {
        setTitle("Application");
        buildPane();
        pack();
        setVisible(true);
    }
    
    private void buildPane() {
        createFields();
        addToPane();
    }
    
    private void createFields() {
        applicationLabel = new JLabel("<html><span style='font-size:20px'><font color='gold'>Application</font></span></html>");
        
        backButton = new JButton("Back");
        backButton.addActionListener(new BackListener());
        acceptButton = new JButton("Accept");
        acceptButton.addActionListener(new AcceptListener());
        rejectButton = new JButton("Reject");
        rejectButton.addActionListener(new RejectListener());
    }
    
    private void addToPane() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        JPanel[] panels = new JPanel[3];
        panels[0] = new JPanel();
        panels[1] = new JPanel();
        panels[2] = new JPanel();
        
        panels[0].setLayout(new FlowLayout(FlowLayout.CENTER));
        panels[1].setLayout(new BoxLayout(panels[1], BoxLayout.X_AXIS));
        panels[2].setLayout(new BoxLayout(panels[2], BoxLayout.X_AXIS));
        
        JPanel[] subPanels = new JPanel[4];
        subPanels[0] = new JPanel();
        subPanels[1] = new JPanel();
        subPanels[2] = new JPanel();
        subPanels[3] = new JPanel();
        
        subPanels[0].setLayout(new BoxLayout(subPanels[0], BoxLayout.Y_AXIS));
        subPanels[1].setLayout(new FlowLayout(FlowLayout.RIGHT));
        subPanels[2].setLayout(new FlowLayout(FlowLayout.LEFT));
        subPanels[3].setLayout(new FlowLayout(FlowLayout.RIGHT));
        
        //Panel 0
        panels[0].add(applicationLabel);
        
        //Panel 1
        radioPanels = new JPanel[radioButtons.length];
        for (int i = 0; i < radioButtons.length; i++) {
            radioPanels[i] = new JPanel();
            radioPanels[i].setLayout(new FlowLayout(FlowLayout.CENTER));
            radioPanels[i].add(radioButtons[i]);
            subPanels[0].add(radioPanels[i]);
        }
        subPanels[1].add(table);
        panels[1].add(subPanels[0]);
        panels[1].add(subPanels[1]);
        
        //Panel 2
        subPanels[2].add(backButton);
        subPanels[3].add(acceptButton);
        subPanels[3].add(rejectButton);
        panels[2].add(subPanels[2]);
        panels[2].add(subPanels[3]);
        
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
    
    private class AcceptListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    }
    
    private class RejectListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    }
}
