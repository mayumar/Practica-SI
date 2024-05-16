package practicafinal.paginas;

import javax.swing.*;

import practicafinal.DataManager;
import practicafinal.componentes.Categoria;
import practicafinal.componentes.Titulo;

import java.awt.*;
import java.util.HashMap;
import java.util.Set;

/**
 * La clase Categorias extiende JPanel y representa un panel que muestra una lista de categorías de juegos.
*/
public class Categorias extends JPanel{
    /**
     * Crea un panel de categorías con el nombre de la lista especificada y configura sus propiedades y contenido.
     *
     * @param nlista El nombre de la lista o sección de categorías.
     * @param parentPanel El panel padre que contiene el panel de categorías.
     * @param views Un HashMap que contiene las vistas de las diferentes secciones de la aplicación.
    */
    public Categorias(String nlista, JPanel parentPanel, HashMap<String,JPanel> views) {
        setLayout(new BorderLayout());

        add(new Titulo(nlista, false), BorderLayout.NORTH);

        JPanel contenido = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10, 10, 10, 10); // Espaciamiento entre elementos

        DataManager dataManager = null;

        try {
            dataManager = new DataManager("src/data.json");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Set<String> categorias = dataManager.getAllCategories();

        int row = 0, col = 0;
        int columns = 3; // Número de columnas en la cuadrícula

        for (String cat : categorias) {
            c.gridx = col;
            c.gridy = row;
            contenido.add(new Categoria(cat, parentPanel, this, BorderLayout.CENTER, views), c);
            col++;
            if (col == columns) {
                col = 0;
                row++;
            }
        }

        add(contenido, BorderLayout.CENTER);
    }
}
