package practicafinal;

import java.util.ArrayList;

import javax.swing.*;

import practicafinal.paginas.*;

public class Vistas{
    
    public static ArrayList<JPanel> create_vistas(){

        ArrayList<JPanel> views = new ArrayList<JPanel>();

        views.add(new Inicio());
        views.add(new Juegos("Juegos"));
        views.add(new Categorias());
        views.add(new Juegos("FPS"));
        views.add(new Juego("Call Of Duty"));
        views.add(new Review());

        return views;
    }

}
