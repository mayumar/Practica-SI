/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
*/
package practicafinal.eventos;

import java.awt.event.*;
import javax.swing.*;

/**
 * La clase FocusPanelGameListener implementa ActionListener y se utiliza para cambiar el panel visible dentro de un contenedor.
 * Al activar el evento, oculta el panel antiguo y muestra el nuevo panel en la posición especificada.
*/
public class FocusPanelGameListener implements ActionListener{
    private JPanel parent_panel;
    private JPanel old_panel;
    private JPanel new_panel;
    private String position;
    
    /**
     * Crea un listener para cambiar el panel visible dentro de un contenedor.
     *
     * @param parent_panel El panel padre que contiene los paneles a cambiar.
     * @param old_panel    El panel antiguo que se ocultará.
     * @param new_panel    El nuevo panel que se mostrará.
     * @param position     La posición del nuevo panel dentro del contenedor.
    */
    public FocusPanelGameListener(JPanel parent_panel, JPanel old_panel, JPanel new_panel, String position){
        this.parent_panel = parent_panel;
        this.old_panel = old_panel;
        this.new_panel = new_panel;
        this.position = position;
    }
    
    /**
     * Maneja el evento de acción para cambiar los paneles.
     *
     * @param e El evento de acción que desencadena el cambio de panel.
    */
    @Override
    public void actionPerformed(ActionEvent e){
        old_panel.setVisible(false);
        parent_panel.remove(old_panel);
        
        new_panel.setVisible(true);
        parent_panel.add(new_panel, position);
        
        parent_panel.revalidate();
    }
}
