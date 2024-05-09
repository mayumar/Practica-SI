package practicafinal.paginas;

import javax.swing.*;
import java.awt.*;

public class Juegos {
    public static JPanel createJuegos(String nlista){
        FlowLayout fl = new FlowLayout();
        fl.setAlignment(FlowLayout.CENTER);

        JPanel juegos = new JPanel(fl);
        juegos.add(new JLabel(nlista));

        return juegos;
    }
}
