/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practicafinal;

import javax.swing.*;
import javax.swing.border.Border;
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
        
        //Colores
        Color CadetGray = new Color(159, 163, 168); //Gris claro
        Color DimGray = new Color(93, 96, 101); //Gris medio
        Color RisingBlack = new Color(27, 28, 34); //Negro
        
        //Bordes
        Border Gray_border = BorderFactory.createLineBorder(DimGray, 2);
        Border empty_border = BorderFactory.createEmptyBorder();
        
        //Barra superior
        FlowLayout fl = new FlowLayout();
        fl.setAlignment(FlowLayout.LEFT);
        
        JPanel barra_superior = new JPanel(fl);
        barra_superior.setBackground(CadetGray);
        barra_superior.setBorder(Gray_border);
        panel.add(barra_superior, BorderLayout.NORTH);
        
        JButton b_inicio = new JButton("Inicio");
        b_inicio.setBackground(CadetGray);
        b_inicio.setBorder(empty_border);
        b_inicio.setForeground(RisingBlack);
        barra_superior.add(b_inicio);
        
        JButton b_juegos = new JButton("Juegos");
        b_juegos.setBackground(CadetGray);
        b_juegos.setBorder(empty_border);
        b_juegos.setForeground(RisingBlack);
        barra_superior.add(b_juegos);
        
        JButton b_categorias = new JButton("Categorias");
        b_categorias.setBackground(CadetGray);
        b_categorias.setBorder(empty_border);
        b_categorias.setForeground(RisingBlack);
        barra_superior.add(b_categorias);
        
        jf.setSize(1452, 779);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }
    
}
