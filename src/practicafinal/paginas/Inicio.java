package practicafinal.paginas;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;

import practicafinal.componentes.*;

public class Inicio extends JPanel{

    public Inicio(JPanel parentPanel, HashMap<String,JPanel> views){

        setLayout(new BorderLayout());

        add(new Titulo("EXPLORA, JUEGA, DECIDE: LA GUÍA DEFINITVA PARA GAMERS", true), BorderLayout.NORTH);

        // Crear los elementos del carrousel
        ArrayList<JButton> elements = new ArrayList<JButton>();

        elements.add(new Juego("cs2", parentPanel, this, BorderLayout.CENTER, views));
        elements.add(new Juego("battlefield", parentPanel, this, BorderLayout.CENTER, views));
        elements.add(new Juego("borderlands", parentPanel, this, BorderLayout.CENTER, views));
        elements.add(new Juego("cod", parentPanel, this, BorderLayout.CENTER, views));
        elements.add(new Juego("doom", parentPanel, this, BorderLayout.CENTER, views));
        elements.add(new Juego("halo", parentPanel, this, BorderLayout.CENTER, views));
        elements.add(new Juego("helldivers", parentPanel, this, BorderLayout.CENTER, views));

        // Crear el carrousel
        Carrousel carrousel = new Carrousel(elements, 5);

        JPanel contenido = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(30, 10, 30, 10);
        
        // Añadir el carrousel al panel
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 1;
        contenido.add(carrousel, c);
        
        //Titulo de destacados
        c.gridx = 0;
        c.gridy = 1;
        c.gridheight = 1;
        c.gridwidth = 1;
        contenido.add(new Titulo("DESTACADOS", false), c);

        FlowLayout fl = new FlowLayout();
        JPanel destacados = new JPanel(fl);


        destacados.add(new Juego("cs2", parentPanel, this, BorderLayout.CENTER, views));
        destacados.add(new Juego("doom", parentPanel, this, BorderLayout.CENTER, views));
        destacados.add(new Juego("halo", parentPanel, this, BorderLayout.CENTER, views));

        c.gridx = 0;
        c.gridy = 2;
        c.gridheight = 1;
        c.gridwidth = 1;
        contenido.add(destacados, c);

        add(contenido, BorderLayout.CENTER);
    }
}
