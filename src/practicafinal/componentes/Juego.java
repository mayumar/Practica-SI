package practicafinal.componentes;

import javax.swing.*;

import org.json.simple.JSONObject;

import practicafinal.paginas.PortadaJuego;
import practicafinal.DataManager;

import java.util.HashMap;

public class Juego extends JButton {

    public Juego(String nombre, JPanel parentPanel, JPanel oldPanel, String position, HashMap<String,JPanel> views) {
        JSONObject game = null;

        try {
            DataManager dataManager = new DataManager("src/data.json");
            game = dataManager.getGameFromName(nombre);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ImageIcon imagen = new ImageIcon((String) game.get("imagen"));
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
