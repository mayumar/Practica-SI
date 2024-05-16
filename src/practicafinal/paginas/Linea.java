package practicafinal.paginas;

import javax.swing.*;

import practicafinal.componentes.Colores;

import java.awt.*;

/**
 * La clase Linea extiende JPanel y representa una línea dibujada en el panel.
 * Se puede utilizar para dibujar líneas horizontales o verticales en la interfaz de usuario.
*/
public class Linea extends JPanel {
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    /**
     * Crea una línea con las coordenadas especificadas.
     *
     * @param x1 La coordenada x del punto de inicio de la línea.
     * @param y1 La coordenada y del punto de inicio de la línea.
     * @param x2 La coordenada x del punto de final de la línea.
     * @param y2 La coordenada y del punto de final de la línea.
    */
    public Linea(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    
    /**
     * Sobrescribe el método paint para dibujar la línea en el panel.
     *
     * @param g El contexto gráfico en el cual se debe dibujar la línea.
    */
    @Override
    public void paint(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));

        //draw in black
        g2.setColor(Colores.RisingBlack);

        //draw a centered horizontal line
        g2.drawLine(this.x1, this.y1, this.x2, this.y2);
    }
}
