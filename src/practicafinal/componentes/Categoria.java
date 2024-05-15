package practicafinal.componentes;

import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import practicafinal.paginas.Juegos;

/**
 * @author @Pacatro
 */
public class Categoria extends JButton {
    public Categoria(String nombre, JPanel parentPanel, JPanel oldPanel, String position, HashMap<String,JPanel> views) {
        ImageIcon imagen = new ImageIcon("src/images/categorias/c_" + nombre.toLowerCase() + ".png");
        setIcon(imagen);
        setBorder(Bordes.Black_border);
        setBackground(Colores.CadetGray);
        setText(nombre);
        JPanel portada = new Juegos(nombre, parentPanel, views, false);
        if(views.get(nombre) == null){
            views.put(nombre, portada);
        }
        addActionListener(new FocusPanelGameListener(parentPanel, oldPanel, views.get(nombre), position));
    }
}
