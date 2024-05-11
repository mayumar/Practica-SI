package practicafinal.paginas;

import javax.swing.*;

import practicafinal.componentes.Titulo;

import java.awt.*;

public class Review extends JPanel{

    public Review(){
        setLayout(new BorderLayout());
        add(new Titulo("Deja tu reseña", false), BorderLayout.NORTH);
    }

}
