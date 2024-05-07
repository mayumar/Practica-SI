/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practicafinal;

/**
 *
 * @author mayumar
 */

import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class FocusPanelButtonListener implements ActionListener{
    JPanel parent_panel;
    ArrayList<JPanel> old_panels;
    JPanel new_panel;
    String position;
    JFrame frame;
    
    public FocusPanelButtonListener(JPanel parent_panel, ArrayList<JPanel> old_panels,
            JPanel new_panel, String position, JFrame frame){
        this.parent_panel = parent_panel;
        this.old_panels = old_panels;
        this.new_panel = new_panel;
        this.position = position;
        this.frame = frame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        for(JPanel jp: old_panels){
            jp.setVisible(false);
            parent_panel.remove(jp);
        }
        
        new_panel.setVisible(true);
        parent_panel.add(new_panel, position);
        
        frame.revalidate();
    }
}
