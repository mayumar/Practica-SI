package practicafinal.paginas;

import javax.swing.*;
import practicafinal.componentes.Juego;
import java.awt.*;

public class Juegos extends JPanel{

    public Juegos(String nlista){
        setLayout(new BorderLayout());

        add(new Juego("CS2").crear());

        add(new Titulo(nlista, false), BorderLayout.NORTH);
    }

}
