/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class Barra_superior {

    public static JPanel createBarra(JPanel parent_panel, ArrayList<JPanel> views, JFrame jf){
        //Colores
        Color Silver = new Color(202, 204, 207); //Gris muy claro
        Color CadetGray = new Color(159, 163, 168); //Gris claro
        Color DimGray = new Color(93, 96, 101); //Gris medio
        Color RisingBlack = new Color(27, 28, 34); //Negro
        
        //Bordes
        Border Gray_border = BorderFactory.createLineBorder(DimGray, 2);
        Border button_empty_border = BorderFactory.createEmptyBorder(10, 30, 10, 30);
        
        
        JPanel barra_superior = new JPanel(new BorderLayout());
        barra_superior.setBackground(CadetGray);
        barra_superior.setBorder(Gray_border);  
        
        
        //Panel de botones
        FlowLayout fl = new FlowLayout();
        fl.setAlignment(FlowLayout.LEFT);
        JPanel botones = new JPanel(fl);
        botones.setBackground(CadetGray);
        
        JButton b_inicio = new JButton("Inicio");
        b_inicio.setBackground(CadetGray);
        b_inicio.setBorder(button_empty_border);
        b_inicio.setForeground(RisingBlack);
        b_inicio.addActionListener(new FocusPanelButtonListener(parent_panel, views, views.get(0), BorderLayout.CENTER, jf));
        botones.add(b_inicio);
        
        JButton b_juegos = new JButton("Juegos");
        b_juegos.setBackground(CadetGray);
        b_juegos.setBorder(button_empty_border);
        b_juegos.setForeground(RisingBlack);
        b_juegos.addActionListener(new FocusPanelButtonListener(parent_panel, views, views.get(1), BorderLayout.CENTER, jf));
        botones.add(b_juegos);
        
        JButton b_categorias = new JButton("Categorias");
        b_categorias.setBackground(CadetGray);
        b_categorias.setBorder(button_empty_border);
        b_categorias.setForeground(RisingBlack);
        b_categorias.addActionListener(new FocusPanelButtonListener(parent_panel, views, views.get(2), BorderLayout.CENTER, jf));
        botones.add(b_categorias);
        
        barra_superior.add(botones, BorderLayout.WEST);
        
        
        //Panel de barra de busqueda
        fl.setAlignment(FlowLayout.RIGHT);
        JPanel busqueda = new JPanel(new GridBagLayout());
        busqueda.setBackground(CadetGray);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(2,4,2,7);
        
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 1;
        JTextField buscar = new JTextField(15);
        buscar.setBorder(Gray_border);
        busqueda.add(buscar, c);
        
        ImageIcon icon = new ImageIcon("src/images/buscar.png");
        c.gridx = 1;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 1;
        JButton b_busqueda = new JButton(icon);
        b_busqueda.setBackground(Silver);
        b_busqueda.setBorder(Gray_border);
        b_busqueda.setForeground(RisingBlack);
        busqueda.add(b_busqueda, c);
        
        barra_superior.add(busqueda, BorderLayout.EAST);
        
        return barra_superior;
    }
}
