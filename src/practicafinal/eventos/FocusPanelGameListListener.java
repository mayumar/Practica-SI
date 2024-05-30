/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
*/
package practicafinal.eventos;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import javax.swing.*;

import practicafinal.paginas.Juegos;

/**
 * La clase FocusPanelGameListener implementa ActionListener y se utiliza para cambiar el panel visible dentro de un contenedor.
 * Al activar el evento, oculta el panel antiguo y muestra el nuevo panel en la posición especificada.
*/
public class FocusPanelGameListListener implements ActionListener{
    private JPanel parentPanel;
    private JPanel oldPanel;
    private String name;
    private HashMap<String,JPanel> views;
    private ResourceBundle bundleText;
    private ArrayList<Juegos> juegos;
    
    /**
     * Crea un listener para cambiar el panel visible dentro de un contenedor.
     *
     * @param parentPanel El panel padre que contiene los paneles a cambiar.
     * @param oldPanel    El panel antiguo que se ocultará.
     * @param name    El nuevo panel que se mostrará.
     * @param views     La posición del nuevo panel dentro del contenedor.
    */
    public FocusPanelGameListListener(JPanel parentPanel, JPanel oldPanel, String name, HashMap<String,JPanel> views, ResourceBundle bundleText, ArrayList<Juegos> juegos){
        this.parentPanel = parentPanel;
        this.oldPanel = oldPanel;
        this.name = name;
        this.views = views;
        this.bundleText = bundleText;
        this.juegos = juegos;
    }
    
    /**
     * Maneja el evento de acción para cambiar los paneles.
     *
     * @param e El evento de acción que desencadena el cambio de panel.
    */
    @Override
    public void actionPerformed(ActionEvent e){
        this.oldPanel.setVisible(false);
        this.parentPanel.remove(oldPanel);
        

        Juegos newPanel = new Juegos(this.name, this.parentPanel, this.views, false, this.bundleText);

        if(this.views.get(this.name) == null){
            juegos.add(newPanel);
            this.views.put(this.name, newPanel);
        }
        
        this.views.get(this.name).setVisible(true);
        this.parentPanel.add(this.views.get(this.name), BorderLayout.CENTER);
        
        this.parentPanel.revalidate();
    }
}
