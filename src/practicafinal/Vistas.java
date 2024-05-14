package practicafinal;

import java.util.HashMap;

import javax.swing.*;

import practicafinal.paginas.*;

public class Vistas{
    
    public static HashMap<String,JPanel> create_vistas(JPanel parentPanel){

        HashMap<String,JPanel> views = new HashMap<String,JPanel>();

        views.put("inicio", new Inicio(parentPanel, views));
        views.put("juegos", new Juegos("Juegos"));
        views.put("categorias", new Categorias());
        views.put("fps", new Juegos("FPS"));
        views.put("review", new Review());

        return views;
    }

}
