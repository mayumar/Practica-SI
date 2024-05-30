package practicafinal.paginas;

import javax.swing.*;

import org.json.simple.JSONObject;

import practicafinal.DataManager;
import practicafinal.componentes.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

/**
 * La clase Juegos extiende JPanel y representa un panel que muestra una lista de juegos.
 * Los juegos pueden ser filtrados por una categoría específica o mostrar todos los juegos disponibles.
*/
public class Juegos extends JPanel{
    private Titulo title;
    private String titleText;
    private JPanel lista;
    
    /**
     * Crea un panel de juegos con el nombre de la lista especificada y configura sus propiedades y contenido.
     *
     * @param viewTitle   El nombre de la lista o categoría de juegos.
     * @param parentPanel El panel padre que contiene el panel de juegos.
     * @param views       Un HashMap que contiene las vistas de las diferentes secciones de la aplicación.
     * @param allGames    Un booleano que indica si se deben mostrar todos los juegos o solo los de una categoría específica.
     * @param bundleText  El ResourceBundle que contiene los textos necesarios para internacionalización.
    */
    public Juegos(String viewTitle, JPanel parentPanel, HashMap<String,JPanel> views, Boolean allGames, ResourceBundle bundleText){
        setLayout(new BorderLayout());
        
        this.titleText = viewTitle;
        this.title = new Titulo(bundleText.getString("Texto_" + this.titleText.toLowerCase()), false);

        add(this.title, BorderLayout.NORTH);

        if (viewTitle.contains("_"))
            viewTitle = viewTitle.replace("_", " ");

        JPanel contenido = new JPanel(new BorderLayout());

        JPanel topMargin = new JPanel();
        topMargin.setPreferredSize(new Dimension(1, 40));
        contenido.add(topMargin, BorderLayout.NORTH);

        this.lista = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(20, 10, 20, 10); // Espaciamiento entre elementos

        DataManager dataManager = null;

        try {
            dataManager = new DataManager("src/data.json");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        ArrayList<JSONObject> juegos = allGames ? dataManager.getAllGames() : dataManager.getGamesFromCategory(viewTitle);
        
        int row = 0, col = 0;
        int columns = 5; // Número de columnas en la cuadrícula

        for (JSONObject juego : juegos) {
            c.gridx = col;
            c.gridy = row;
            this.lista.add(new Juego((String) juego.get("nombre"), parentPanel, this, views, bundleText), c);
            col++;
            if (col == columns) {
                col = 0;
                row++;
            }
        }

        contenido.add(this.lista, BorderLayout.CENTER);

        add(contenido, BorderLayout.CENTER);
    }

    /**
     * Actualiza los textos de la clase con los nuevos textos del ResourceBundle.
     * 
     * @param bundleText El ResourceBundle que contiene los textos actualizados.
     */
    public void updateTexts(ResourceBundle bundleText) {
        this.title.setLabel(bundleText.getString("Texto_" + this.titleText.toLowerCase()));
        
        for (Component juego : this.lista.getComponents()) {
            if (juego instanceof Juego)
                ((Juego) juego).updateTexts(bundleText);
        }

        revalidate();
        repaint();
    }
}
