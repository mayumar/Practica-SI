package practicafinal;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class Vistas {
    
    public static ArrayList<JPanel> create_vistas(){
        ArrayList<JPanel> views = new ArrayList<JPanel>();

        FlowLayout fl = new FlowLayout();
        fl.setAlignment(FlowLayout.CENTER);
        JPanel inicio = new JPanel(fl);
        inicio.add(new JLabel("INICIO"));
        views.add(inicio);

        JPanel juegos = new JPanel(fl);
        juegos.add(new JLabel("JUEGOS"));
        views.add(juegos);

        JPanel categorias = new JPanel(fl);
        categorias.add(new JLabel("CATEGORIAS"));
        views.add(categorias);

        JPanel categoria1 = new JPanel(fl);
        categoria1.add(new JLabel("FPS"));
        views.add(categoria1);

        JPanel juego = new JPanel(fl);
        juego.add(new JLabel("JUEGO"));
        views.add(juego);

        JPanel review = new JPanel(fl);
        review.add(new JLabel("REVIEW"));
        views.add(review);

        return views;
    }

}
