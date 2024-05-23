/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/

package practicafinal.componentes;

import javax.swing.*;

import practicafinal.*;
import practicafinal.paginas.Categorias;
import practicafinal.paginas.Inicio;
import practicafinal.paginas.Juegos;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * La clase Barra_superior extiende JPanel y representa la barra de navegación superior de la aplicación.
 * Contiene botones para cambiar entre las diferentes vistas y una barra de búsqueda.
*/
public class BarraSuperior extends JPanel {
    private JPanel parentPanel;
    private HashMap<String, JPanel> views;
    private JFrame jf;
    private JButton b_inicio;
    private JButton b_juegos;
    private JButton b_categorias;
    private JPopupMenu menuIdiomas;
    private JMenuItem itemEspanol;
    private JMenuItem itemIngles;

    /**
     * Crea una barra de navegación superior con los paneles y el marco especificados.
     *
     * @param parentPanel El panel padre que contiene la barra de navegación.
     * @param views       Un HashMap que contiene las vistas de las diferentes secciones de la aplicación.
     * @param jf          El JFrame principal de la aplicación.
     * @param inter       Instancia de la clase Inter para gestionar el idioma.
    */
    public BarraSuperior(JPanel parentPanel, HashMap<String, JPanel> views, JFrame jf, Inter inter) {
        this.parentPanel = parentPanel;
        this.views = views;
        this.jf = jf;
        
        setLayout(new BorderLayout());
        setBackground(Colores.cadet_gray);
        setBorder(Bordes.gray_border);  
        
        // Panel de botones
        JPanel botones = createBotones(inter.getBundle());
        add(botones, BorderLayout.WEST);
        
        // Panel de barra de búsqueda
        JPanel busqueda = createBusqueda(inter);
        add(busqueda, BorderLayout.EAST);
    }

    /**
     * Crea el panel de botones de la barra de navegación.
     *
     * @param bundleText Bundle con los diferentes textos traducidos dependiendo del idioma seleccionado.
     * 
     * @return El JPanel que contiene los botones de la barra de navegación.
    */
    private JPanel createBotones(ResourceBundle bundleText) {
        FlowLayout fl = new FlowLayout();
        fl.setAlignment(FlowLayout.LEFT);
        JPanel botones = new JPanel(fl);
        botones.setBackground(Colores.cadet_gray);
        
        b_inicio = new JButton(bundleText.getString("Texto_inicio"));
        b_inicio.setBackground(Colores.cadet_gray);
        b_inicio.setBorder(Bordes.button_empty_border);
        b_inicio.setForeground(Colores.rising_black);
        b_inicio.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b_inicio.addActionListener(new FocusPanelButtonListener(parentPanel, views, views.get("inicio"), BorderLayout.CENTER, jf));
        botones.add(b_inicio);
        
        b_juegos = new JButton(bundleText.getString("Texto_juegos"));
        b_juegos.setBackground(Colores.cadet_gray);
        b_juegos.setBorder(Bordes.button_empty_border);
        b_juegos.setForeground(Colores.rising_black);
        b_juegos.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b_juegos.addActionListener(new FocusPanelButtonListener(parentPanel, views, views.get("juegos"), BorderLayout.CENTER, jf));
        botones.add(b_juegos);
        
        b_categorias = new JButton(bundleText.getString("Texto_categorias"));
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
     * @param inter Instancia de la clase Inter para gestionar el idioma.
     * 
     * @return El JPanel que contiene la barra de búsqueda.
    */
    private JPanel createBusqueda(Inter inter) {
        FlowLayout fl = new FlowLayout();
        fl.setAlignment(FlowLayout.RIGHT);
        JPanel busqueda = new JPanel(new GridBagLayout());
        busqueda.setBackground(Colores.cadet_gray);
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(2, 4, 2, 7);

        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 1;
        ImageIcon idioma = new ImageIcon("src/images/idioma.png");
        JButton b_idioma = new JButton(idioma);
        b_idioma.setBackground(Colores.cadet_gray);
        b_idioma.setBorder(Bordes.button_empty_border);
        b_idioma.setPreferredSize(new Dimension(idioma.getIconWidth() + 5, idioma.getIconHeight()));
        b_idioma.setCursor(new Cursor(Cursor.HAND_CURSOR));

        menuIdiomas = new JPopupMenu();
        itemEspanol = new JMenuItem(inter.getBundle().getString("Texto_espanol"));
        menuIdiomas.add(itemEspanol);
        itemIngles = new JMenuItem(inter.getBundle().getString("Texto_ingles"));
        menuIdiomas.add(itemIngles);

        // Añadir un ActionListener al botón para mostrar el menú
        b_idioma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuIdiomas.show(b_idioma, b_idioma.getWidth(), b_idioma.getHeight());
            }
        });

        // Puedes añadir ActionListener a los ítems del menú para manejar sus acciones
        itemEspanol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción para cambiar a Español
                System.out.println("Español seleccionado");
                inter.setCurrentLocale(new Locale("es", "ES"));

                Inicio inicio = (Inicio) views.get("inicio");
                Juegos juegos = (Juegos) views.get("juegos");
                Categorias categorias = (Categorias) views.get("categorias");

                updateTexts(inter.getBundle());
                inicio.updateTexts(inter.getBundle());
                juegos.updateTexts(inter.getBundle());
                categorias.updateTexts(inter.getBundle());
                
                revalidate();
                repaint();
            }
        });
        
        itemIngles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción para cambiar a Inglés
                System.out.println("Inglés seleccionado");
                inter.setCurrentLocale(new Locale("en", "GB"));

                Inicio inicio = (Inicio) views.get("inicio");
                Juegos juegos = (Juegos) views.get("juegos");
                Categorias categorias = (Categorias) views.get("categorias");

                updateTexts(inter.getBundle());                
                inicio.updateTexts(inter.getBundle());
                juegos.updateTexts(inter.getBundle());
                categorias.updateTexts(inter.getBundle());
                revalidate();
                repaint();
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

    /**
     * Actualiza los textos de los componentes basándose en el ResourceBundle proporcionado.
     *
     * @param bundleText Bundle con los diferentes textos traducidos dependiendo del idioma seleccionado.
    */
    private void updateTexts(ResourceBundle bundleText) {
        b_inicio.setText(bundleText.getString("Texto_inicio"));
        b_juegos.setText(bundleText.getString("Texto_juegos"));
        b_categorias.setText(bundleText.getString("Texto_categorias"));
        itemEspanol.setText(bundleText.getString("Texto_espanol"));
        itemIngles.setText(bundleText.getString("Texto_ingles"));
        revalidate();
        repaint();
    }
}

