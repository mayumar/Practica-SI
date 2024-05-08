package practicafinal;

import javax.swing.*;
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
        //Get the current size of this component
        Dimension d = this.getSize();

        //draw in black
        g.setColor(Color.BLACK);
        //draw a centered horizontal line
        g.drawLine(this.x1, this.y1, this.x2, this.y2);
    }
}
