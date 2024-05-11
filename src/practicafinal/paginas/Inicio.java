package practicafinal.paginas;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import practicafinal.componentes.Titulo;

public class Inicio extends JPanel{

    public Inicio(){

        setLayout(new BorderLayout());

        add(new Titulo("EXPLORA, JUEGA, DECIDE: LA GUÍA DEFINITVA PARA GAMERS", true), BorderLayout.NORTH);

        // Crear los elementos del carrousel
        ArrayList<JPanel> elements = new ArrayList<JPanel>();
        for (int i = 0; i < 5; i++) {
            elements.add(new JPanel());
            elements.get(i).add(new JLabel("Elemento " + (i+1)));
        }

        // Crear el carrousel
        Carrousel carrousel = new Carrousel(elements, 3);

        JPanel contenido = new JPanel(new BorderLayout());
        
        // Añadir el carrousel al panel
        contenido.add(carrousel, BorderLayout.NORTH);
        
        //Titulo de destacados
        contenido.add(new Titulo("DESTACADOS", false), BorderLayout.CENTER);

        contenido.add(new JLabel("JUEGO 1"), BorderLayout.SOUTH);

        add(contenido, BorderLayout.CENTER);
    }
}
