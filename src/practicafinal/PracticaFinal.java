/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practicafinal;

import javax.swing.*;

import componentes.Barra_superior;

import java.awt.*;
import java.util.ArrayList;

/**
 *
 * @author mayumar
 */
public class PracticaFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame jf = new JFrame("LevelUp");
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        jf.setContentPane(mainPanel);

        //Panel con margenes
        JPanel panel = new JPanel(new BorderLayout());
        mainPanel.add(panel, BorderLayout.CENTER);

        //Margenes
        JPanel leftMargin = new JPanel();
        leftMargin.setPreferredSize(new Dimension(100, 1));
        panel.add(leftMargin, BorderLayout.WEST);

        JPanel rightMargin = new JPanel();
        rightMargin.setPreferredSize(new Dimension(100, 1));
        panel.add(rightMargin, BorderLayout.EAST);

        JPanel topMargin = new JPanel();
        topMargin.setPreferredSize(new Dimension(1, 60));
        panel.add(topMargin, BorderLayout.NORTH);

        //Vistas
        ArrayList<JPanel> views = Vistas.create_vistas();
        
        //Inicio como vista por defecto
        views.get(0).setVisible(true);
        panel.add(views.get(0));

        //Barra superior
        JPanel barra_superior = Barra_superior.createBarra(panel, views, jf);
        mainPanel.add(barra_superior, BorderLayout.NORTH);

        
        jf.setSize(1452, 779);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }
    
}
