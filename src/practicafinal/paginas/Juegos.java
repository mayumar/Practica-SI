package practicafinal.paginas;

import javax.swing.*;

import org.json.simple.JSONObject;

import practicafinal.DataManager;
import practicafinal.componentes.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * La clase Juegos extiende JPanel y representa un panel que muestra una lista de juegos.
 * Los juegos pueden ser filtrados por una categoría específica o mostrar todos los juegos disponibles.
*/
public class Juegos extends JPanel{
    /**
     * Crea un panel de juegos con el nombre de la lista especificada y configura sus propiedades y contenido.
     *
     * @param nlista El nombre de la lista o categoría de juegos.
     * @param parentPanel El panel padre que contiene el panel de juegos.
     * @param views Un HashMap que contiene las vistas de las diferentes categorías de la aplicación.
     * @param allGames Un booleano que indica si se deben mostrar todos los juegos o solo los de una categoría específica.
    */
    public Juegos(String nlista, JPanel parentPanel, HashMap<String,JPanel> views, Boolean allGames){
        
        setLayout(new BorderLayout());

        add(new Titulo(nlista, false), BorderLayout.NORTH);

        JPanel contenido = new JPanel(new BorderLayout());

        JPanel topMargin = new JPanel();
        topMargin.setPreferredSize(new Dimension(1, 40));
        contenido.add(topMargin, BorderLayout.NORTH);

        JPanel lista = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(20, 10, 20, 10); // Espaciamiento entre elementos

        DataManager dataManager = null;

        try {
            dataManager = new DataManager("src/data.json");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        @SuppressWarnings("unchecked")
        ArrayList<JSONObject> juegos = allGames ? dataManager.getAllGames() : dataManager.getGamesFromCategory(nlista);
        
        int row = 0, col = 0;
        int columns = 5; // Número de columnas en la cuadrícula

        for (JSONObject juego : juegos) {
            c.gridx = col;
            c.gridy = row;
            lista.add(new Juego((String) juego.get("nombre"), parentPanel, this, BorderLayout.CENTER, views), c);
            col++;
            if (col == columns) {
                col = 0;
                row++;
            }
        }

        contenido.add(lista, BorderLayout.CENTER);

        add(contenido, BorderLayout.CENTER);
    }

}
