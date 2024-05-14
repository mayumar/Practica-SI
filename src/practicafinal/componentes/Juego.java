package practicafinal.componentes;

import javax.swing.*;

import practicafinal.paginas.PortadaJuego;

import java.awt.*;
import java.util.ArrayList;

public class Juego extends JButton {
    private String nombre;

    public Juego(String nombre, JPanel parentPanel, JPanel oldPanel, String position, ArrayList<JPanel> views) {
        this.nombre = nombre;
        ImageIcon imagen = new ImageIcon("src/images/juegos/fps/p_" + this.nombre + ".png");
        setIcon(imagen);
        setPreferredSize(new Dimension(207, 224));
        setBorder(Bordes.Black_border);
        setBackground(Colores.CadetGray);
        JPanel portada = new PortadaJuego(nombre);
        views.add(portada);
        addActionListener(new FocusPanelGameListener(parentPanel, oldPanel, portada, position));
    }
}
