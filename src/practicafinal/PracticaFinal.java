/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practicafinal;

import javax.swing.*;
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
        
        JPanel panel = new JPanel(new BorderLayout());
        jf.setContentPane(panel);

        //Vistas
        ArrayList<JPanel> views = Vistas.create_vistas();
        
        //Inicio como vista por defecto
        views.get(0).setVisible(true);
        panel.add(views.get(0));

        //Barra superior
        JPanel barra_superior = Barra_superior.createBarra(panel, views, jf);
        panel.add(barra_superior, BorderLayout.NORTH);

        
        jf.setSize(1452, 779);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }
    
}
