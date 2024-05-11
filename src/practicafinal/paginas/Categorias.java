package practicafinal.paginas;

import javax.swing.*;
import java.awt.*;

public class Categorias {
    public static JPanel createCategorias(){
        JPanel categorias = new JPanel(new BorderLayout());
        
        categorias.add(new Titulo("Categorias", false), BorderLayout.NORTH);

        return categorias;
    }
}
