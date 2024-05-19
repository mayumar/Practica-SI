/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicafinal.componentes;

import javax.swing.*;

import practicafinal.*;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.ResourceBundle;

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
     * @param bundleText Bundle con los diferentes textos traducidos dependiendo del idioma seleccionado.
    */
    public Barra_superior(JPanel parentPanel, HashMap<String,JPanel> views, JFrame jf, ResourceBundle bundleText){
        this.parentPanel = parentPanel;
        this.views = views;
        this.jf = jf;
        
        setLayout(new BorderLayout());
        setBackground(Colores.cadet_gray);
        setBorder(Bordes.gray_border);  
        
        
        //Panel de botones
        JPanel botones = createBotones(bundleText);
        
        add(botones, BorderLayout.WEST);
        
        
        //Panel de barra de busqueda
        JPanel busqueda = createBusqueda(bundleText);
        
        add(busqueda, BorderLayout.EAST);
    }

    /**
     * Crea el panel de botones de la barra de navegación.
     *
     * @param bundleText Bundle con los diferentes textos traducidos dependiendo del idioma seleccionado.
     * 
     * @return El JPanel que contiene los botones de la barra de navegación.
    */
    private JPanel createBotones(ResourceBundle bundleText){
        FlowLayout fl = new FlowLayout();
        fl.setAlignment(FlowLayout.LEFT);
        JPanel botones = new JPanel(fl);
        botones.setBackground(Colores.cadet_gray);
        
        JButton b_inicio = new JButton(bundleText.getString("Texto_inicio"));
        b_inicio.setBackground(Colores.cadet_gray);
        b_inicio.setBorder(Bordes.button_empty_border);
        b_inicio.setForeground(Colores.rising_black);
        b_inicio.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b_inicio.addActionListener(new FocusPanelButtonListener(parentPanel, views, views.get("inicio"), BorderLayout.CENTER, jf));
        botones.add(b_inicio);
        
        JButton b_juegos = new JButton(bundleText.getString("Texto_juegos"));
        b_juegos.setBackground(Colores.cadet_gray);
        b_juegos.setBorder(Bordes.button_empty_border);
        b_juegos.setForeground(Colores.rising_black);
        b_juegos.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b_juegos.addActionListener(new FocusPanelButtonListener(parentPanel, views, views.get("juegos"), BorderLayout.CENTER, jf));
        botones.add(b_juegos);
        
        JButton b_categorias = new JButton(bundleText.getString("Texto_categorias"));
        b_categorias.setBackground(Colores.cadet_gray);
        b_categorias.setBorder(Bordes.button_empty_border);
        b_categorias.setForeground(Colores.rising_black);
        b_categorias.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b_categorias.addActionListener(new FocusPanelButtonListener(parentPanel, views, views.get("categorias"), BorderLayout.CENTER, jf));
        botones.add(b_categorias);

        return botones;
    }

    /**
     * Crea el panel de barra de búsqueda de la barra de navegación.
     *
     * @param bundleText Bundle con los diferentes textos traducidos dependiendo del idioma seleccionado.
     * 
     * @return El JPanel que contiene la barra de búsqueda.
    */
    private JPanel createBusqueda(ResourceBundle bundleText){
        FlowLayout fl = new FlowLayout();
        fl.setAlignment(FlowLayout.RIGHT);
        JPanel busqueda = new JPanel(new GridBagLayout());
        busqueda.setBackground(Colores.cadet_gray);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(2,4,2,7);

        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 1;
        ImageIcon idioma = new ImageIcon("src/images/idioma.png");
        JButton b_idioma = new JButton(idioma);
        b_idioma.setBackground(Colores.cadet_gray);
        b_idioma.setBorder(Bordes.button_empty_border);
        b_idioma.setPreferredSize(new Dimension(idioma.getIconWidth()+5, idioma.getIconHeight()));
        b_idioma.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JPopupMenu menuIdioma = new JPopupMenu();
        menuIdioma.add(new JMenuItem(bundleText.getString("Texto_espanol")));
        menuIdioma.add(new JMenuItem(bundleText.getString("Texto_ingles")));

        b_idioma.addMouseListener(new MouseAdapter() {
        @Override
            public void mousePressed(MouseEvent e) {
                menuIdioma.show(b_idioma, e.getX(), e.getY());
            }
        });


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
        b_busqueda.setBackground(Colores.silver);
        b_busqueda.setBorder(Bordes.gray_border);
        b_busqueda.setForeground(Colores.rising_black);
        b_busqueda.setCursor(new Cursor(Cursor.HAND_CURSOR));
        busqueda.add(b_busqueda, c);

        return busqueda;
    }
}
