package practicafinal.componentes;

import javax.swing.*;

import java.awt.*;

public class Juego extends JButton {
    private String nombre;

    public Juego(String nombre) {
        this.nombre = nombre;
        ImageIcon imagen = new ImageIcon("src/images/juegos/fps/p_" + this.nombre + ".png");
        setIcon(imagen);
        setPreferredSize(new Dimension(207, 224));
        setBorder(Bordes.Black_border);
        setBackground(Colores.CadetGray);
    }
}
