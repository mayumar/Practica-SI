/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practicafinal;

import javax.swing.*;
import java.awt.*;

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
        
        //Barra superior
        JPanel barra_superior = Barra_superior.createBarra();
        panel.add(barra_superior, BorderLayout.NORTH);
        
        jf.setSize(1452, 779);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }
    
}
