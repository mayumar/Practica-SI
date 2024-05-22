package practicafinal.paginas;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import javax.swing.*;
import org.json.simple.JSONObject;
import practicafinal.DataManager;
import practicafinal.componentes.*;

/**
 * La clase Inicio extiende JPanel y representa la vista inicial de la aplicación.
 * Esta vista incluye un título principal, un carrusel de juegos y una sección de juegos destacados.
*/
public class Inicio extends JPanel {
    private Titulo tituloPrincipal;
    private Titulo tituloDestacados;
    private Carrousel carrousel;
    private JPanel destacados;

    /**
     * Crea un panel de inicio con un título, un carrusel de juegos y una sección de juegos destacados.
     *
     * @param parentPanel El panel padre que contiene el panel de inicio.
     * @param views Un HashMap que contiene las vistas de las diferentes secciones de la aplicación.
     * @param bundleText El ResourceBundle que contiene los textos traducidos.
    */
    public Inicio(JPanel parentPanel, HashMap<String, JPanel> views, ResourceBundle bundleText) {
        setLayout(new BorderLayout());

        // Inicializa los componentes
        this.tituloPrincipal = new Titulo(bundleText.getString("Texto_slogan"), true);
        add(this.tituloPrincipal, BorderLayout.NORTH);

        // Crear los elementos del carrousel
        ArrayList<JPanel> elements = new ArrayList<JPanel>();
        DataManager dataManager = null;

        try {
            dataManager = new DataManager("src/data.json");
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<JSONObject> games = dataManager.getAllGames();
        for (int i = 0; i < 7; i++) {
            elements.add(new Juego((String) games.get(i).get("nombre"), parentPanel, this, BorderLayout.CENTER, views));
        }

        // Crear el carrousel
        this.carrousel = new Carrousel(elements, 5);

        JPanel contenido = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(30, 10, 30, 10);

        // Añadir el carrousel al panel
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 1;
        contenido.add(carrousel, c);

        // Titulo de destacados
        this.tituloDestacados = new Titulo(bundleText.getString("Texto_destacados"), false);
        c.gridx = 0;
        c.gridy = 1;
        c.gridheight = 1;
        c.gridwidth = 1;
        contenido.add(this.tituloDestacados, c);

        FlowLayout fl = new FlowLayout();
        this.destacados = new JPanel(fl);

        for (int i = 0; i < 3; i++) {
            this.destacados.add(new Juego((String) games.get(i).get("nombre"), parentPanel, this, BorderLayout.CENTER, views));
        }

        c.gridx = 0;
        c.gridy = 2;
        c.gridheight = 1;
        c.gridwidth = 1;
        contenido.add(destacados, c);

        add(contenido, BorderLayout.CENTER);
    }

    /**
     * Actualiza los textos del panel de inicio con el nuevo ResourceBundle.
     *
     * @param bundleText El nuevo ResourceBundle que contiene los textos traducidos.
     */
    public void updateTexts(ResourceBundle bundleText) {
        // Actualizar los textos de los títulos
        this.tituloPrincipal.setLabel(bundleText.getString("Texto_slogan"));
        this.tituloDestacados.setLabel(bundleText.getString("Texto_destacados"));
        revalidate();
        repaint();
    }
}
