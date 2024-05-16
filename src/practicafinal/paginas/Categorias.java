package practicafinal.paginas;

import javax.swing.*;

import practicafinal.DataManager;
import practicafinal.componentes.Categoria;
import practicafinal.componentes.Titulo;

import java.awt.*;
import java.util.HashMap;
import java.util.Set;

public class Categorias extends JPanel{
    public Categorias(String nlista, JPanel parentPanel, HashMap<String,JPanel> views) {
        setLayout(new BorderLayout());

        add(new Titulo(nlista, false), BorderLayout.NORTH);

        JPanel contenido = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(40, 40, 40, 40); // Espaciamiento entre elementos

        DataManager dataManager = null;

        try {
            dataManager = new DataManager("src/data.json");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Set<String> categorias = dataManager.getAllCategories();

        int row = 0, col = 0;
        int columns = 3; // Número de columnas en la cuadrícula

        for (String cat : categorias) {
            c.gridx = col;
            c.gridy = row;
            contenido.add(new Categoria(cat, parentPanel, this, BorderLayout.CENTER, views), c);
            col++;
            if (col == columns) {
                col = 0;
                row++;
            }
        }

        add(contenido, BorderLayout.CENTER);
    }
}
