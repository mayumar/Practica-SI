package practicafinal;

import java.util.ArrayList;

import javax.swing.*;

import practicafinal.paginas.*;

public class Vistas{
    
    public static ArrayList<JPanel> create_vistas(JPanel parentPanel){

        ArrayList<JPanel> views = new ArrayList<JPanel>();

        views.add(new Juegos("Juegos"));
        views.add(new Categorias());
        views.add(new Juegos("FPS"));
        views.add(new Review());
        views.add(new Inicio(parentPanel, views));

        return views;
    }

}
