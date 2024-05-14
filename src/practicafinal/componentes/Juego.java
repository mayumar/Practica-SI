package practicafinal.componentes;

import javax.swing.*;

import practicafinal.paginas.PortadaJuego;

import java.util.HashMap;

public class Juego extends JButton {
    private String nombre;

    public Juego(String nombre, JPanel parentPanel, JPanel oldPanel, String position, HashMap<String,JPanel> views) {
        this.nombre = nombre;
        ImageIcon imagen = new ImageIcon("src/images/juegos/fps/p_" + this.nombre + ".png");
        setIcon(imagen);
        setBorder(Bordes.Black_border);
        setBackground(Colores.CadetGray);
        JPanel portada = new PortadaJuego(nombre);
        if(views.get(nombre) == null){
            views.put(nombre, portada);
        }
        addActionListener(new FocusPanelGameListener(parentPanel, oldPanel, views.get(nombre), position));
    }
}
