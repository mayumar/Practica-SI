/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicafinal.componentes;

import javax.swing.*;

import practicafinal.*;

import java.awt.*;
import java.util.HashMap;

/**
 * La clase Barra_superior extiende JPanel y representa la barra de navegación superior de la aplicación.
 * Contiene botones para cambiar entre las diferentes vistas y una barra de búsqueda.
*/
public class Barra_superior extends JPanel{
    private JPanel parentPanel;
    private HashMap<String,JPanel> views;
    private JFrame jf;

    /**
     * Crea una barra de navegación superior con los paneles y el marco especificados.
     *
     * @param parentPanel El panel padre que contiene la barra de navegación.
     * @param views Un HashMap que contiene las vistas de las diferentes secciones de la aplicación.
     * @param jf El JFrame principal de la aplicación.
    */
    public Barra_superior(JPanel parentPanel, HashMap<String,JPanel> views, JFrame jf){
        this.parentPanel = parentPanel;
        this.views = views;
        this.jf = jf;
        
        setLayout(new BorderLayout());
        setBackground(Colores.CadetGray);
        setBorder(Bordes.gray_border);  
        
        
        //Panel de botones
        JPanel botones = createBotones();
        
        add(botones, BorderLayout.WEST);
        
        
        //Panel de barra de busqueda
        JPanel busqueda = createBusqueda();
        
        add(busqueda, BorderLayout.EAST);
    }

    /**
     * Crea el panel de botones de la barra de navegación.
     *
     * @return El JPanel que contiene los botones de la barra de navegación.
    */
    private JPanel createBotones(){
        FlowLayout fl = new FlowLayout();
        fl.setAlignment(FlowLayout.LEFT);
        JPanel botones = new JPanel(fl);
        botones.setBackground(Colores.CadetGray);
        
        JButton b_inicio = new JButton("Inicio");
        b_inicio.setBackground(Colores.CadetGray);
        b_inicio.setBorder(Bordes.button_empty_border);
        b_inicio.setForeground(Colores.RisingBlack);
        b_inicio.addActionListener(new FocusPanelButtonListener(parentPanel, views, views.get("inicio"), BorderLayout.CENTER, jf));
        botones.add(b_inicio);
        
        JButton b_juegos = new JButton("Juegos");
        b_juegos.setBackground(Colores.CadetGray);
        b_juegos.setBorder(Bordes.button_empty_border);
        b_juegos.setForeground(Colores.RisingBlack);
        b_juegos.addActionListener(new FocusPanelButtonListener(parentPanel, views, views.get("juegos"), BorderLayout.CENTER, jf));
        botones.add(b_juegos);
        
        JButton b_categorias = new JButton("Categorias");
        b_categorias.setBackground(Colores.CadetGray);
        b_categorias.setBorder(Bordes.button_empty_border);
        b_categorias.setForeground(Colores.RisingBlack);
        b_categorias.addActionListener(new FocusPanelButtonListener(parentPanel, views, views.get("categorias"), BorderLayout.CENTER, jf));
        botones.add(b_categorias);

        return botones;
    }

    /**
     * Crea el panel de barra de búsqueda de la barra de navegación.
     *
     * @return El JPanel que contiene la barra de búsqueda.
    */
    private JPanel createBusqueda(){
        FlowLayout fl = new FlowLayout();
        fl.setAlignment(FlowLayout.RIGHT);
        JPanel busqueda = new JPanel(new GridBagLayout());
        busqueda.setBackground(Colores.CadetGray);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(2,4,2,7);

        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 1;
        ImageIcon idioma = new ImageIcon("src/images/idioma.png");
        JButton b_idioma = new JButton(idioma);
        b_idioma.setBackground(Colores.CadetGray);
        b_idioma.setBorder(Bordes.button_empty_border);
        b_idioma.setPreferredSize(new Dimension(idioma.getIconWidth()+5, idioma.getIconHeight()));
        busqueda.add(b_idioma, c);
        
        c.gridx = 1;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 1;
        JTextField buscar = new JTextField(15);
        buscar.setBorder(Bordes.gray_border);
        busqueda.add(buscar, c);
        
        ImageIcon icon = new ImageIcon("src/images/buscar.png");
        c.gridx = 2;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 1;
        JButton b_busqueda = new JButton(icon);
        b_busqueda.setBackground(Colores.Silver);
        b_busqueda.setBorder(Bordes.gray_border);
        b_busqueda.setForeground(Colores.RisingBlack);
        busqueda.add(b_busqueda, c);

        return busqueda;
    }
}
