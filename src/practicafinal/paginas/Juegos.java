package practicafinal.paginas;

import javax.swing.*;
import practicafinal.componentes.Titulo;

import java.awt.*;

public class Juegos extends JPanel{

    public Juegos(String nlista){
        setLayout(new BorderLayout());
        FlowLayout fl = new FlowLayout();
        JPanel contenido = new JPanel(fl);
        //contenido.add(new Juego("CS2"));

        add(new Titulo(nlista, false), BorderLayout.NORTH);
        add(contenido, BorderLayout.CENTER);
    }

}
