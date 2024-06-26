package practicafinal.paginas;

import javax.swing.*;
import practicafinal.DataManager;
import practicafinal.componentes.Categoria;
import practicafinal.componentes.Titulo;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.Set;

/**
 * La clase Categorias extiende JPanel y representa un panel que muestra una lista de categorías de juegos.
 */
public class Categorias extends JPanel {
    private Titulo title;
    private JPanel parentPanel;
    private HashMap<String, JPanel> views;
    private DataManager dataManager;
    private ResourceBundle bundleText;
    private JPanel contenido;
    private ArrayList<Juegos> juegos;

    /**
     * Crea un panel de categorías con el nombre de la lista especificada y configura sus propiedades y contenido.
     *
     * @param nlista      El nombre de la lista o sección de categorías.
     * @param parentPanel El panel padre que contiene el panel de categorías.
     * @param views       Un HashMap que contiene las vistas de las diferentes secciones de la aplicación.
     * @param bundleText  Bundle con los diferentes textos traducidos dependiendo del idioma seleccionado.
     */
    public Categorias(String nlista, JPanel parentPanel, HashMap<String, JPanel> views, ResourceBundle bundleText) {
        setLayout(new BorderLayout());
        
        this.parentPanel = parentPanel;
        this.views = views;
        this.bundleText = bundleText;
        this.juegos = new ArrayList<>();
        
        this.title = new Titulo(nlista, false);
        add(this.title, BorderLayout.NORTH);

        this.contenido = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(40, 40, 40, 40); // Espaciamiento entre elementos

        try {
            this.dataManager = new DataManager("src/data.json");
        } catch (Exception e) {
            e.printStackTrace();
        }

        updateCategoryList();

        add(this.contenido, BorderLayout.CENTER);
    }

    /**
     * Actualiza la lista de categorías en el panel de categorías. Elimina todos los elementos anteriores del contenido y
     * genera nuevos componentes de categoría basados en las categorías obtenidas del DataManager. Cada categoría se
     * representa como un componente de categoría en el panel de contenido.
     */
    private void updateCategoryList() {
        this.contenido.removeAll();
        
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(40, 40, 40, 40); // Espaciamiento entre elementos
        Set<String> categorias = this.dataManager.getAllCategories();

        int row = 0, col = 0;
        int columns = 3; // Número de columnas en la cuadrícula

        for (String cat : categorias) {
            c.gridx = col;
            c.gridy = row;
            
            if (cat.contains(" ")) cat = cat.replace(" ", "_");

            this.contenido.add(new Categoria(cat, this.parentPanel, this, this.views, this.bundleText, this.juegos), c);
            col++;
            if (col == columns) {
                col = 0;
                row++;
            }
        }

        revalidate();
        repaint();
    }

    /**
     * Actualiza los títulos de las categorías existentes en la lista de juegos. Llama al método `updateTexts` en cada
     * objeto de juegos en la lista de juegos, pasando el nuevo ResourceBundle como parámetro. Esto garantiza que los
     * textos de las categorías se actualicen correctamente al realizarse un cambio de idioma.
     */
    private void updateCategoryTitles(){
        for(Juegos j: this.juegos){
            j.updateTexts(this.bundleText);
        }
    }

    /**
     * Actualiza los textos del panel de categorías con el nuevo ResourceBundle.
     *
     * @param bundleText El nuevo ResourceBundle que contiene los textos traducidos.
     */
    public void updateTexts(ResourceBundle bundleText) {
        this.bundleText = bundleText;
        this.title.setLabel(this.bundleText.getString("Texto_categorias"));
        updateCategoryList();
        updateCategoryTitles();
    }
}
