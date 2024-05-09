package practicafinal.paginas;

import javax.swing.*;
import java.awt.*;

public class Categorias {
    public static JPanel createCategorias(){
        FlowLayout fl = new FlowLayout();
        fl.setAlignment(FlowLayout.CENTER);

        JPanel categorias = new JPanel(fl);
        categorias.add(new JLabel("CATEGORIAS"));

        return categorias;
    }
}
