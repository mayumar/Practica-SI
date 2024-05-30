/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
*/
package practicafinal.eventos;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.util.HashMap;
import java.util.ResourceBundle;

import javax.swing.*;

import practicafinal.paginas.Review;

/**
 * La clase FocusPanelReviewListener implementa ActionListener y se utiliza para cambiar el panel visible dentro de un contenedor.
 * Al activar el evento, oculta el panel antiguo y muestra el nuevo panel en la posición especificada.
*/
public class FocusPanelReviewListener implements ActionListener{
    private JPanel parent_panel;
    private JPanel old_panel;
    private String new_panel_name;
    private HashMap<String,JPanel> views;
    private ResourceBundle bundleText;
    
    /**
     * Crea un listener para cambiar el panel visible dentro de un contenedor.
     *
     * @param parent_panel El panel padre que contiene los paneles a cambiar.
     * @param old_panel    El panel antiguo que se ocultará.
     * @param new_panel_name    El nuevo panel que se mostrará.
     * @param views     La posición del nuevo panel dentro del contenedor.
    */
    public FocusPanelReviewListener(JPanel parent_panel, JPanel old_panel, String new_panel_name, HashMap<String,JPanel> views, ResourceBundle bundleText){
        this.parent_panel = parent_panel;
        this.old_panel = old_panel;
        this.new_panel_name = new_panel_name;
        this.views = views;
        this.bundleText = bundleText;
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
        

        JPanel new_panel = new Review(bundleText, new_panel_name, parent_panel, this.views);

        if(this.views.get("review" + new_panel_name) == null)
            this.views.put("review" + new_panel_name, new_panel);
        
        this.views.get(this.new_panel_name).setVisible(true);
        parent_panel.add(this.views.get(this.new_panel_name), BorderLayout.CENTER);
        
        parent_panel.revalidate();
    }
}
