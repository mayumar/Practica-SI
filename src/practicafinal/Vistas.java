package practicafinal;

import java.awt.*;
import java.util.ArrayList;

import javax.sound.sampled.Line;
import javax.swing.*;

import practicafinal.Linea;

public class Vistas {
    
    public static ArrayList<JPanel> create_vistas(){
        //Colores
        Color RisingBlack = new Color(27, 28, 34); //Negro

        ArrayList<JPanel> views = new ArrayList<JPanel>();

        FlowLayout fl = new FlowLayout();
        fl.setAlignment(FlowLayout.CENTER);


        JPanel inicio = new JPanel(new GridLayout(0,1));
        inicio.add(new JLabel("INICIO"));
        // JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        // separator.setForeground(RisingBlack);
        // separator.setBackground(RisingBlack);
        // inicio.add(separator);
        inicio.add(new Linea(50, 100, 250, 100));
        inicio.add(new JLabel("HOLAAAA"));
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
