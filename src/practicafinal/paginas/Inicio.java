package practicafinal.paginas;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class Inicio {

    public static JPanel createInicio(){

        JPanel inicio = new JPanel(new BorderLayout());

        inicio.add(new Titulo("EXPLORA, JUEGA, DECIDE: LA GUÍA DEFINITVA PARA GAMERS", true), BorderLayout.NORTH);

        // Crear los elementos del carrousel
        ArrayList<JPanel> elements = new ArrayList<JPanel>();
        for (int i = 0; i < 5; i++) {
            elements.add(new JPanel());
            elements.get(i).add(new JLabel("Elemento " + (i+1)));
        }

        // Crear el carrousel
        Carrousel carrousel = new Carrousel(elements, 3);

        // Añadir el carrousel al panel
        JPanel contenido = new JPanel();
        contenido.add(carrousel, BorderLayout.CENTER);
        inicio.add(contenido);

        return inicio;
    }
}
