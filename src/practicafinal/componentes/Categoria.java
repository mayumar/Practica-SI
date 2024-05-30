package practicafinal.componentes;

import java.awt.Font;
import java.awt.Cursor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import practicafinal.config.Bordes;
import practicafinal.config.Colores;
import practicafinal.eventos.FocusPanelGameListListener;
import practicafinal.paginas.Juegos;

/**
 * La clase Categoria extiende JButton y representa un botón personalizado para una categoría específica.
 * Al crear una instancia de esta clase, se configura un botón con una imagen de la categoría,
 * y se establece un ActionListener que cambia el panel de enfoque al panel de la categoría seleccionada.
*/
public class Categoria extends JButton {
    private String nombre;
    HashMap<String,JPanel> views;
    JPanel parentPanel;

    /**
     * Crea un botón de categoría con el nombre especificado y configura sus propiedades y comportamiento.
     *
     * @param nombre      El nombre de la categoría que este botón representará.
     * @param parentPanel El panel padre que contiene el botón.
     * @param oldPanel    El panel anterior que se reemplazará cuando se haga clic en el botón.
     * @param views       Un HashMap que contiene las vistas de las diferentes secciones de la aplicación.
     * @param bundleText  Bundle con los diferentes textos traducidos dependiendo del idioma seleccionado.
     * @param juegos      ArrayList que contiene la lista de juegos de la categoría.
    */
    public Categoria(String nombre, JPanel parentPanel, JPanel oldPanel, HashMap<String,JPanel> views, ResourceBundle bundleText, ArrayList<Juegos> juegos) {
        this.nombre = nombre;
        this.views = views;
        this.parentPanel = parentPanel;

        ImageIcon imagen = new ImageIcon("src/images/categorias/c_" + this.nombre.toLowerCase() + ".png");
        setIcon(imagen);

        setBorder(Bordes.black_border);

        setText(bundleText.getString("Texto_" + this.nombre.toLowerCase()));
        setHorizontalTextPosition(SwingConstants.CENTER);
        setVerticalTextPosition(SwingConstants.CENTER);
        setBackground(Colores.cadet_gray);
        setForeground(Colores.white_smoke);
        setFont(new Font(getFont().getFontName(), Font.PLAIN, 25));

        setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        addActionListener(new FocusPanelGameListListener(this.parentPanel, oldPanel, this.nombre, this.views, bundleText, juegos));
    }

    /**
     * Actualiza los textos del botón de categoría con el nuevo ResourceBundle.
     * 
     * @param bundleText El nuevo ResourceBundle que contiene los textos traducidos.
     */
    public void updateTexts(ResourceBundle bundleText) {
        JPanel portada = new Juegos(this.nombre, this.parentPanel, this.views, false, bundleText);
        if(this.views.get(this.nombre) == null){
            this.views.put(this.nombre, portada);
        }
    }
}
