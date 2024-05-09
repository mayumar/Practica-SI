package practicafinal.paginas;

import javax.swing.*;

import componentes.Juego;

import java.awt.*;

public class Juegos {
    public static JPanel createJuegos(String nlista){
        Color RisingBlack = new Color(27, 28, 34); //Negro

        JPanel juegos = new JPanel(new BorderLayout());
        juegos.add(new Juego("cs2").crear());

        JLabel titulo = new JLabel(nlista);
        titulo.setForeground(RisingBlack);
        titulo.setBackground(RisingBlack);

        juegos.add(titulo, BorderLayout.NORTH);

        juegos.add(new Linea(0, 10, 2000, 10), BorderLayout.CENTER);
        juegos.add(new Juego("CS2").crear(), BorderLayout.SOUTH);

        return juegos;
    }
}
