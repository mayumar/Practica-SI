/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practicafinal;

import java.util.HashMap;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 * La clase FocusPanelButtonListener maneja los eventos de acción de los botones para cambiar el panel visible en un JFrame.
*/
public class FocusPanelButtonListener implements ActionListener{
    JPanel parent_panel;
    HashMap<String,JPanel> old_panels;
    JPanel new_panel;
    String position;
    JFrame frame;
    
    /**
     * Crea una instancia de FocusPanelButtonListener.
     *
     * @param parent_panel El panel padre que contiene los paneles antiguos y el nuevo panel.
     * @param old_panels Un HashMap que contiene los paneles antiguos que deben ocultarse.
     * @param new_panel El nuevo panel que debe mostrarse.
     * @param position La posición en el layout donde se debe añadir el nuevo panel.
     * @param frame El JFrame que contiene el parent_panel y necesita ser actualizado.
    */
    public FocusPanelButtonListener(JPanel parent_panel, HashMap<String,JPanel> old_panels,
            JPanel new_panel, String position, JFrame frame){
        this.parent_panel = parent_panel;
        this.old_panels = old_panels;
        this.new_panel = new_panel;
        this.position = position;
        this.frame = frame;
    }
    
    /**
     * Método llamado cuando se realiza una acción. Este método oculta todos los paneles antiguos, muestra el nuevo panel
     * y actualiza el JFrame.
     *
     * @param e El evento de acción que dispara este método.
    */
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
