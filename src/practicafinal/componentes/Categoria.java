package practicafinal.componentes;

import java.awt.Font;
import java.awt.Cursor;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import practicafinal.paginas.Juegos;

/**
 * La clase Categoria extiende JButton y representa un botón personalizado para una categoría específica.
 * Al crear una instancia de esta clase, se configura un botón con una imagen de la categoría,
 * y se establece un ActionListener que cambia el panel de enfoque al panel de la categoría seleccionada.
*/
public class Categoria extends JButton {
    /**
     * Crea un botón de categoría con el nombre especificado y configura sus propiedades y comportamiento.
     *
     * @param nombre El nombre de la categoría que este botón representará.
     * @param parentPanel El panel padre que contiene el botón.
     * @param oldPanel El panel anterior que se reemplazará cuando se haga clic en el botón.
     * @param position La posición del panel dentro del contenedor.
     * @param views Un HashMap que contiene las vistas de las diferentes categorías.
    */
    public Categoria(String nombre, JPanel parentPanel, JPanel oldPanel, String position, HashMap<String,JPanel> views) {

        ImageIcon imagen = new ImageIcon("src/images/categorias/c_" + nombre.toLowerCase() + ".png");
        setIcon(imagen);

        setBorder(Bordes.black_border);

        setText(nombre);
        setHorizontalTextPosition(SwingConstants.CENTER);
        setVerticalTextPosition(SwingConstants.CENTER);
        setBackground(Colores.CadetGray);
        setForeground(Colores.WhiteSmoke);
        setFont(new Font(getFont().getFontName(), Font.PLAIN, 25));

        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setText(nombre);

        JPanel portada = new Juegos(nombre, parentPanel, views, false);
        if(views.get(nombre) == null){
            views.put(nombre, portada);
        }
        
        addActionListener(new FocusPanelGameListener(parentPanel, oldPanel, views.get(nombre), position));
    }
}
