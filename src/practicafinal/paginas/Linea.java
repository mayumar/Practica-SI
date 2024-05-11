package practicafinal.paginas;

import javax.swing.*;

import practicafinal.Colores;

import java.awt.*;

public class Linea extends JPanel {
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    public Linea(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    
    @Override public void paint(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));

        //draw in black
        g2.setColor(Colores.RisingBlack);

        //draw a centered horizontal line
        g2.drawLine(this.x1, this.y1, this.x2, this.y2);
    }
}
