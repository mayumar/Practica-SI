package practicafinal.componentes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private HashMap<String,JPanel> views;
    private JSONObject game;
    private ResourceBundle bundleText;
    private PortadaJuego portada;

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
    public Juego(String nombre, JPanel parentPanel, JPanel oldPanel, HashMap<String,JPanel> views, ResourceBundle bundleText) {
        this.nombre = nombre;
        this.parentPanel = parentPanel;
        this.oldPanel = oldPanel;
        this.views = views;
        this.bundleText = bundleText;
        this.portada = null;
        
        JSONObject game = null;

        try {
            DataManager dataManager = new DataManager("src/data.json");
            game = dataManager.getGameFromName(nombre);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.game = game;

        // Crear el botón del juego
        JButton juegoButton = createJuego();

        // Crear un JLayeredPane para contener el botón y el recuadro
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(207, 224)); // Tamaño del contenedor

        // Añadir el botón al JLayeredPane en la capa base (DEFAULT_LAYER)
        juegoButton.setBounds(0, 0, 207, 224); // Ajustar el tamaño y posición del botón
        layeredPane.add(juegoButton, JLayeredPane.DEFAULT_LAYER);
        
        // Añadir el recuadro al JLayeredPane en la capa superior (PALETTE_LAYER)
        double calificacionDouble = DataManager.getRateMean(game);
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
     * @return Un JButton que representa el juego.
     */
    private JButton createJuego(){
        JButton juego = new JButton();

        ImageIcon imagen = new ImageIcon((String) game.get("imagen"));

        Image reescaled = imagen.getImage().getScaledInstance(207, 224, Image.SCALE_SMOOTH);
        imagen.setImage(reescaled);

        juego.setIcon(imagen);

        juego.setBorder(Bordes.black_border);
        juego.setBackground(Colores.cadet_gray);
        juego.setCursor(new Cursor(Cursor.HAND_CURSOR));

        juego.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                oldPanel.setVisible(false);
                parentPanel.remove(oldPanel);

                addPortada();
                views.get(nombre).setVisible(true);
                parentPanel.add(views.get(nombre), BorderLayout.CENTER);
                
                parentPanel.revalidate();
            }
        });

        return juego;
    }

    public void addPortada(){
        this.portada = new PortadaJuego(this.nombre, parentPanel, this.views, this.bundleText);
        if(views.get(this.nombre) == null){
            views.put(this.nombre, this.portada);
        }
    }

    public void updateTexts(ResourceBundle bundleText) {
        this.bundleText = bundleText;
        
        if(this.portada != null)
            this.portada.updateTexts(bundleText);
    }
}
