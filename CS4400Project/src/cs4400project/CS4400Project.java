/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs4400project;

import gui.lgn.LoginFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Kenneth Craig
 */
public class CS4400Project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException e) {
             //handle exception
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            // handle exception
            System.out.println(e.getMessage());
        } catch (InstantiationException e) {
            // handle exception
            System.out.println(e.getMessage());
        } catch (IllegalAccessException e) {
            // handle exception
            System.out.println(e.getMessage());
        }
        
        LoginFrame frame = new LoginFrame();
    }
    
}
