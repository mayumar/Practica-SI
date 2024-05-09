package practicafinal.paginas;

import javax.swing.*;
import java.awt.*;

public class Juego {
    public static JPanel createJuego(){
        FlowLayout fl = new FlowLayout();
        fl.setAlignment(FlowLayout.CENTER);

        JPanel juego = new JPanel(fl);
        juego.add(new JLabel("JUEGO"));

        return juego;
    }
}
