package practicafinal.paginas;

import javax.swing.*;
import java.awt.*;

public class Juegos {
    public static JPanel createJuegos(String nlista){
        JPanel juegos = new JPanel(new BorderLayout());
        juegos.add(Titulo.createTitulo(nlista, false), BorderLayout.NORTH);

        return juegos;
    }
}
