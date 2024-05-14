package practicafinal.paginas;

import javax.swing.*;

import practicafinal.componentes.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Juegos extends JPanel{

    public Juegos(String nlista, JPanel parentPanel, HashMap<String,JPanel> views){
        
        setLayout(new BorderLayout());

        add(new Titulo(nlista, false), BorderLayout.NORTH);

        JPanel contenido = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10, 10, 10, 10); // Espaciamiento entre elementos

        ArrayList<String> juegos = new ArrayList<String>();
        juegos.add("cs2");
        juegos.add("battlefield");
        juegos.add("borderlands");
        juegos.add("cod");
        juegos.add("doom");
        juegos.add("halo");
        juegos.add("helldivers");
        int row = 0, col = 0;
        int columns = 5; // Número de columnas en la cuadrícula

        for (String juego : juegos) {
            c.gridx = col;
            c.gridy = row;
            contenido.add(new Juego(juego, parentPanel, this, BorderLayout.CENTER, views), c);
            col++;
            if (col == columns) {
                col = 0;
                row++;
            }
        }

        add(contenido, BorderLayout.CENTER);
    }

}
