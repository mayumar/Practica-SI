package componentes;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;


public class Juego {
    private String nombre;

    public Juego(String nombre) {
        this.nombre = nombre; 
    }

    public JPanel crear() {
        Color RisingBlack = new Color(27, 28, 34); //Negro
        Color White = new Color(255, 255, 255); //Negro

        //Bordes
        Border black_border = BorderFactory.createLineBorder(RisingBlack, 2);
        
        ImageIcon imagen = new ImageIcon("src/images/juegos/fps/p_cs2.png");
        
        JPanel panel_juego = new JPanel(new BorderLayout());
        panel_juego.setBackground(White);
        panel_juego.setBorder(black_border);
        panel_juego.add(new JLabel(imagen));

        return panel_juego;
    }
}
