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

import practicafinal.paginas.PortadaJuego;

/**
 * La clase FocusPanelGameListener implementa ActionListener y se utiliza para cambiar el panel visible dentro de un contenedor.
 * Al activar el evento, oculta el panel antiguo y muestra el nuevo panel en la posición especificada.
*/
public class FocusPanelGameListener implements ActionListener{
    private JPanel parentPanel;
    private JPanel oldPanel;
    private String name;
    private HashMap<String,JPanel> views;
    private ResourceBundle bundleText;
    
    /**
     * Crea un listener para cambiar el panel visible dentro de un contenedor.
     *
     * @param parentPanel El panel padre que contiene los paneles a cambiar.
     * @param oldPanel    El panel antiguo que se ocultará.
     * @param name    El nuevo panel que se mostrará.
     * @param views     La posición del nuevo panel dentro del contenedor.
    */
    public FocusPanelGameListener(JPanel parentPanel, JPanel oldPanel, String name, HashMap<String,JPanel> views, ResourceBundle bundleText){
        this.parentPanel = parentPanel;
        this.oldPanel = oldPanel;
        this.name = name;
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
        oldPanel.setVisible(false);
        parentPanel.remove(oldPanel);
        

        PortadaJuego newPanel = new PortadaJuego(name, parentPanel, this.views, bundleText);
        if(views.get(name) == null){
            views.put(name, newPanel);
        }

        this.views.get(name).setVisible(true);
        parentPanel.add(this.views.get(name), BorderLayout.CENTER);
        
        parentPanel.revalidate();
    }
}
