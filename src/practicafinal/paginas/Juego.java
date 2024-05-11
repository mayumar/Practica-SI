package practicafinal.paginas;

import javax.swing.*;
import java.awt.*;

public class Juego {
    public static JPanel createJuego(String gameName){
        JPanel juego = new JPanel(new BorderLayout());
        juego.add(new Titulo(gameName, false), BorderLayout.NORTH);

        return juego;
    }
}
