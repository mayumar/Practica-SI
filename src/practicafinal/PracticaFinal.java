package practicafinal;

import javax.swing.*;

import practicafinal.componentes.BarraSuperior;

import java.awt.*;
import java.util.HashMap;

/** 
 * La clase PracticaFinal es la clase principal del programa
 * Se encarga de inicializar la interfaz gráfica de usuario y de configurar los elementos principales de la aplicación.
*/
public class PracticaFinal {

    /**
     * Función principal del programa
     * Inicializa la ventana principal, configura el panel de desplazamiento y los márgenes, 
     * crea las vistas necesarias, y establece la vista inicial y la barra superior.
     * 
     * @param args Los argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        JFrame jf = new JFrame("LevelUp");
        
        JScrollPane scrollPane = new JScrollPane();
        jf.add(scrollPane);

        // Ajustar la sensibilidad del scroll
        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        JScrollBar horizontalScrollBar = scrollPane.getHorizontalScrollBar();

        int unitIncrement = 16; // Incremento de unidad en píxeles
        verticalScrollBar.setUnitIncrement(unitIncrement);
        horizontalScrollBar.setUnitIncrement(unitIncrement);

        int blockIncrement = 64; // Incremento de bloque en píxeles
        verticalScrollBar.setBlockIncrement(blockIncrement);
        horizontalScrollBar.setBlockIncrement(blockIncrement);

        JPanel mainPanel = new JPanel(new BorderLayout());
        scrollPane.setViewportView(mainPanel); // Establecer el JScrollPane como vista del mainPanel

        //Panel con margenes
        JPanel panel = new JPanel(new BorderLayout());
        mainPanel.add(panel, BorderLayout.CENTER);

        //Margenes
        JPanel leftMargin = new JPanel();
        leftMargin.setPreferredSize(new Dimension(80, 1));
        panel.add(leftMargin, BorderLayout.WEST);

        JPanel rightMargin = new JPanel();
        rightMargin.setPreferredSize(new Dimension(80, 1));
        panel.add(rightMargin, BorderLayout.EAST);

        JPanel topMargin = new JPanel();
        topMargin.setPreferredSize(new Dimension(1, 60));
        panel.add(topMargin, BorderLayout.NORTH);

        //Vistas
        HashMap<String, JPanel> views = Vistas.create_vistas(panel, Inter.getInstance().getBundle());
        
        //Inicio como vista por defecto
        views.get("inicio").setVisible(true);
        panel.add(views.get("inicio"));

        //Barra superior
        BarraSuperior barra_superior = new BarraSuperior(panel, views, jf, Inter.getInstance());
        mainPanel.add(barra_superior, BorderLayout.NORTH);
        
        jf.setSize(1452, 779);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }
}
