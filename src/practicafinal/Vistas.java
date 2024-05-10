package practicafinal;

import java.util.ArrayList;

import javax.swing.*;

import practicafinal.paginas.*;

public class Vistas {
    
    public static ArrayList<JPanel> create_vistas(){

        ArrayList<JPanel> views = new ArrayList<JPanel>();

        views.add(Inicio.createInicio());
        views.add(Juegos.createJuegos("Juegos"));
        views.add(Categorias.createCategorias());
        views.add(Juegos.createJuegos("FPS"));
        views.add(Juego.createJuego("Call Of Duty"));
        views.add(Review.createReview());

        return views;
    }

}
