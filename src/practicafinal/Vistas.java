package practicafinal;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import practicafinal.paginas.*;

public class Vistas {
    
    public static ArrayList<JPanel> create_vistas(){

        ArrayList<JPanel> views = new ArrayList<JPanel>();

        views.add(Inicio.createInicio());
        views.add(Juegos.createJuegos("JUEGOS"));
        views.add(Categorias.createCategorias());
        views.add(Juegos.createJuegos("FPS"));
        views.add(Juego.createJuego());
        views.add(Review.createReview());

        return views;
    }

    public static JPanel createInicio(){
        //Colores
        Color RisingBlack = new Color(27, 28, 34); //Negro

        JPanel inicio = new JPanel(new GridLayout(10,1));
=========
        JPanel inicio = new JPanel(new GridLayout(0,1));
>>>>>>>>> Temporary merge branch 2
        inicio.add(new JLabel("INICIO"));
        // JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        // separator.setForeground(RisingBlack);
        // separator.setBackground(RisingBlack);
        // inicio.add(separator);
        inicio.add(new Linea(50, 100, 250, 100));
        inicio.add(new JLabel("HOLAAAA"));

        return inicio;
    }

    public static JPanel createJuegos(){
        FlowLayout fl = new FlowLayout();
        fl.setAlignment(FlowLayout.CENTER);

        JPanel juegos = new JPanel(fl);
        juegos.add(new JLabel("JUEGOS"));

        return juegos;
    }

    public static JPanel createCategorias(){
        FlowLayout fl = new FlowLayout();
        fl.setAlignment(FlowLayout.CENTER);

        JPanel categorias = new JPanel(fl);
        categorias.add(new JLabel("CATEGORIAS"));

        return categorias;
    }

    public static JPanel createListaCategoria(){
        FlowLayout fl = new FlowLayout();
        fl.setAlignment(FlowLayout.CENTER);

        JPanel categoria = new JPanel(fl);
        categoria.add(new JLabel("FPS"));

        return categoria;
    }

    public static JPanel createJuego(){
        FlowLayout fl = new FlowLayout();
        fl.setAlignment(FlowLayout.CENTER);

        JPanel juego = new JPanel(fl);
        juego.add(new JLabel("JUEGO"));

        return juego;
    }

    public static JPanel createReview(){
        FlowLayout fl = new FlowLayout();
        fl.setAlignment(FlowLayout.CENTER);

        JPanel review = new JPanel(fl);
        review.add(new JLabel("REVIEW"));

        return review;
    }

}
