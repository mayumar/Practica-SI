package practicafinal.paginas;

import javax.swing.*;
import java.awt.*;

public class Titulo {

    public static JPanel createTitulo(String label, Boolean isInicio){
        Color RisingBlack = new Color(27, 28, 34); //Negro

        JPanel panel = new JPanel(new BorderLayout());

        if(isInicio){
            ImageIcon icon = new ImageIcon("src/images/logo.png");
            JLabel logo = new JLabel(icon);
            logo.setHorizontalAlignment(JLabel.LEFT);
            panel.add(logo, BorderLayout.NORTH);
        }

        JLabel slogan = new JLabel(label);
        slogan.setForeground(RisingBlack);
        slogan.setBackground(RisingBlack);
        panel.add(slogan, BorderLayout.CENTER);

        panel.add(new Linea(0, 5, 2000,5), BorderLayout.SOUTH);

        return panel;
    }
}
