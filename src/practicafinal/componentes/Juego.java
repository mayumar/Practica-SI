package practicafinal.componentes;

import javax.swing.*;

import org.json.simple.JSONObject;

import practicafinal.paginas.PortadaJuego;
import practicafinal.DataManager;

import java.awt.Cursor;
import java.util.HashMap;

/**
 * La clase Juego extiende JButton y representa un botón personalizado para un juego específico.
 * Al crear una instancia de esta clase, se configura un botón con una imagen del juego, 
 * y se establece un ActionListener que cambia el panel de enfoque al panel del juego seleccionado.
*/
public class Juego extends JButton {
    /**
     * Crea un botón de juego con el nombre especificado y configura sus propiedades y comportamiento.
     *
     * @param nombre El nombre del juego que este botón representará.
     * @param parentPanel El panel padre que contiene el botón.
     * @param oldPanel El panel anterior que se reemplazará cuando se haga clic en el botón.
     * @param position La posición del panel dentro del contenedor.
     * @param views Un HashMap que contiene las vistas de los diferentes juegos.
    */
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
        setBorder(Bordes.black_border);
        setBackground(Colores.CadetGray);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        JPanel portada = new PortadaJuego(nombre);
        if(views.get(nombre) == null){
            views.put(nombre, portada);
        }
        addActionListener(new FocusPanelGameListener(parentPanel, oldPanel, views.get(nombre), position));
    }
}
