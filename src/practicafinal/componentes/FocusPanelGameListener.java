/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
*/
package practicafinal.componentes;

/**
 *
 * @author mayumar
 */

import java.awt.event.*;
import javax.swing.*;

public class FocusPanelGameListener implements ActionListener{
    JPanel parent_panel;
    JPanel old_panel;
    JPanel new_panel;
    String position;
    
    public FocusPanelGameListener(JPanel parent_panel, JPanel old_panel,
            JPanel new_panel, String position){
        this.parent_panel = parent_panel;
        this.old_panel = old_panel;
        this.new_panel = new_panel;
        this.position = position;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        old_panel.setVisible(false);
        parent_panel.remove(old_panel);
        
        new_panel.setVisible(true);
        parent_panel.add(new_panel, position);
        
        parent_panel.revalidate();
    }
}
