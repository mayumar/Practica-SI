package practicafinal.paginas;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import practicafinal.componentes.*;

public class Inicio extends JPanel{

    public Inicio(){

        setLayout(new BorderLayout());

        add(new Titulo("EXPLORA, JUEGA, DECIDE: LA GUÍA DEFINITVA PARA GAMERS", true), BorderLayout.NORTH);

        // Crear los elementos del carrousel
        ArrayList<JButton> elements = new ArrayList<JButton>();

        elements.add(new Juego("cs2"));
        elements.add(new Juego("battlefield"));
        elements.add(new Juego("borderlands"));
        elements.add(new Juego("cod"));
        elements.add(new Juego("doom"));
        elements.add(new Juego("halo"));
        elements.add(new Juego("helldivers"));


        // Crear el carrousel
        Carrousel carrousel = new Carrousel(elements, 5);

        JPanel contenido = new JPanel(new BorderLayout());
        
        // Añadir el carrousel al panel
        contenido.add(carrousel, BorderLayout.NORTH);
        
        //Titulo de destacados
        contenido.add(new Titulo("DESTACADOS", false), BorderLayout.CENTER);

        FlowLayout fl = new FlowLayout();
        JPanel destacados = new JPanel(fl);


        destacados.add(new Juego("cs2"));
        destacados.add(new Juego("doom"));
        destacados.add(new Juego("halo"));

        contenido.add(destacados, BorderLayout.SOUTH);

        add(contenido, BorderLayout.CENTER);
    }
}
