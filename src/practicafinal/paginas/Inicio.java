package practicafinal.paginas;

import java.awt.*;
import javax.swing.*;

public class Inicio {

    public static JPanel createInicio(){
        JPanel inicio = new JPanel(new BorderLayout());

        inicio.add(new JLabel("INICIO"), BorderLayout.NORTH);

        inicio.add(new Linea(50, 10, 250, 10), BorderLayout.CENTER);

        // JPanel inicio = new JPanel(new GridLayout(0,1));
        // inicio.add(new JLabel("INICIO"));
        // inicio.add(new Linea(50, 100, 250, 100));
        // inicio.add(new JLabel("HOLAAAA"));

        return inicio;
    }
}
