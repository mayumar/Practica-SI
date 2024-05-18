package practicafinal.componentes;

import javax.swing.*;
import java.awt.*;

import org.json.simple.JSONObject;

import practicafinal.paginas.PortadaJuego;
import practicafinal.DataManager;

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
        setBackground(Colores.cadet_gray);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        JPanel portada = new PortadaJuego(nombre);
        if(views.get(nombre) == null){
            views.put(nombre, portada);
        }
        addActionListener(new FocusPanelGameListener(parentPanel, oldPanel, views.get(nombre), position));
    }

    public static JPanel createJuegoConRecuadro(String nombre, JPanel parentPanel, JPanel oldPanel, String position, HashMap<String,JPanel> views) {
        // Crear el botón del juego
        Juego juegoButton = new Juego(nombre, parentPanel, oldPanel, position, views);

        // Crear un JLayeredPane para contener el botón y el recuadro
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(207, 224)); // Tamaño del contenedor

        // Añadir el botón al JLayeredPane en la capa base (DEFAULT_LAYER)
        juegoButton.setBounds(0, 0, 207, 224); // Ajustar el tamaño y posición del botón
        layeredPane.add(juegoButton, JLayeredPane.DEFAULT_LAYER);

        // Crear el recuadro superpuesto
        JPanel recuadro = new JPanel(new BorderLayout());

        JSONObject game = null;

        try {
            DataManager dataManager = new DataManager("src/data.json");
            game = dataManager.getGameFromName(nombre);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        Double calificacionDouble = (Double) game.get("calificacion");
        JLabel calificacion = new JLabel(Double.toString(calificacionDouble));
        calificacion.setHorizontalAlignment(SwingConstants.CENTER);
        calificacion.setForeground(Colores.rising_black);
        recuadro.add(calificacion, BorderLayout.CENTER);

        recuadro.setBorder(Bordes.black_border); // Crear un borde negro

        recuadro.setCursor(new Cursor(Cursor.HAND_CURSOR));

        if(calificacionDouble < 5.0){
            recuadro.setBackground(Colores.bittersweet);
        }else if(calificacionDouble < 8.0){
            recuadro.setBackground(Colores.jonquil);
        }else{
            recuadro.setBackground(Colores.spring_green);
        }

        recuadro.setBounds(127, 158, 60, 47); // Ajustar el tamaño y posición del recuadro

        // Añadir el recuadro al JLayeredPane en la capa superior (PALETTE_LAYER)
        layeredPane.add(recuadro, JLayeredPane.PALETTE_LAYER);

        // Crear un JPanel para contener el JLayeredPane
        JPanel container = new JPanel(new BorderLayout());
        container.add(layeredPane, BorderLayout.CENTER);

        return container;
    }
}
