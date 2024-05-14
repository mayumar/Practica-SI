/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practicafinal;

/**
 *
 * @author mayumar
 */

import java.util.HashMap;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class FocusPanelButtonListener implements ActionListener{
    JPanel parent_panel;
    HashMap<String,JPanel> old_panels;
    JPanel new_panel;
    String position;
    JFrame frame;
    
    public FocusPanelButtonListener(JPanel parent_panel, HashMap<String,JPanel> old_panels,
            JPanel new_panel, String position, JFrame frame){
        this.parent_panel = parent_panel;
        this.old_panels = old_panels;
        this.new_panel = new_panel;
        this.position = position;
        this.frame = frame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        for(String key: old_panels.keySet()){
            old_panels.get(key).setVisible(false);
            parent_panel.remove(old_panels.get(key));
        }
        
        new_panel.setVisible(true);
        parent_panel.add(new_panel, position);
        
        frame.revalidate();
    }
}
