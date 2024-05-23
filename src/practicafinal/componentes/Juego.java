package practicafinal.componentes;

import javax.swing.*;
import java.awt.*;

import org.json.simple.JSONObject;

import practicafinal.paginas.PortadaJuego;
import practicafinal.DataManager;
import practicafinal.config.Bordes;
import practicafinal.config.Colores;

import java.util.HashMap;
import java.util.ResourceBundle;

/**
 * La clase Juego extiende JPanel y representa un componente personalizado para un juego específico.
 * Al crear una instancia de esta clase, se configura un botón con una imagen del juego,
 * y se establece un ActionListener que cambia el panel de enfoque al panel del juego seleccionado.
 * Además, muestra un recuadro con la calificación del juego sobre el botón.
 */
public class Juego extends JPanel {
    private String nombre;
    private JPanel parentPanel;
    private JPanel oldPanel;
    private String position;
    private HashMap<String,JPanel> views;
    private JSONObject game;

    /**
     * Crea un componente de juego con el nombre especificado y configura sus propiedades y comportamiento.
     *
     * @param nombre      El nombre del juego que este componente representará.
     * @param parentPanel El panel padre que contiene el componente.
     * @param oldPanel    El panel anterior que se reemplazará cuando se haga clic en el botón del juego.
     * @param position    La posición del panel dentro del contenedor.
     * @param views       Un HashMap que contiene las vistas de los diferentes juegos.
     * @param bundleText  El ResourceBundle que contiene los textos traducidos.
     */
    public Juego(String nombre, JPanel parentPanel, JPanel oldPanel, String position, HashMap<String,JPanel> views, ResourceBundle bundleText) {
        this.nombre = nombre;
        this.parentPanel = parentPanel;
        this.oldPanel = oldPanel;
        this.position = position;
        this.views = views;
        
        JSONObject game = null;

        try {
            DataManager dataManager = new DataManager("src/data.json");
            game = dataManager.getGameFromName(nombre);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.game = game;

        // Crear el botón del juego
        JButton juegoButton = createJuego(bundleText);

        // Crear un JLayeredPane para contener el botón y el recuadro
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(207, 224)); // Tamaño del contenedor

        // Añadir el botón al JLayeredPane en la capa base (DEFAULT_LAYER)
        juegoButton.setBounds(0, 0, 207, 224); // Ajustar el tamaño y posición del botón
        layeredPane.add(juegoButton, JLayeredPane.DEFAULT_LAYER);
        
        // Añadir el recuadro al JLayeredPane en la capa superior (PALETTE_LAYER)
        Double calificacionDouble = (Double) game.get("calificacion");
        Recuadro recuadro = new Recuadro(calificacionDouble);
        recuadro.setCursor(new Cursor(Cursor.HAND_CURSOR));
        layeredPane.add(recuadro, JLayeredPane.PALETTE_LAYER);

        // Añade el JLayeredPane al JPanel
        setLayout(new BorderLayout());
        add(layeredPane, BorderLayout.CENTER);
    }

    /**
     * Crea un botón del juego con su imagen y configura su comportamiento.
     * 
     * @param bundleText El ResourceBundle que contiene los textos traducidos.
     * @return Un JButton que representa el juego.
     */
    private JButton createJuego(ResourceBundle bundleText){
        JButton juego = new JButton();

        ImageIcon imagen = new ImageIcon((String) game.get("imagen"));
        juego.setIcon(imagen);

        juego.setBorder(Bordes.black_border);
        juego.setBackground(Colores.cadet_gray);
        juego.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JPanel portada = new PortadaJuego(nombre, parentPanel, this.views, bundleText);
        if(views.get(nombre) == null){
            views.put(nombre, portada);
        }
        juego.addActionListener(new FocusPanelGameListener(parentPanel, oldPanel, views.get(nombre), position));

        return juego;
    }
}
