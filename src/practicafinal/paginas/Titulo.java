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

            JLabel slogan = new JLabel(label);
            slogan.setForeground(RisingBlack);
            slogan.setBackground(RisingBlack);
            Font fuente = slogan.getFont();
            slogan.setFont(new Font(fuente.getFontName(), Font.PLAIN, fuente.getSize()));
            panel.add(slogan, BorderLayout.CENTER);
        }else{
            JLabel title = new JLabel(label);
            title.setForeground(RisingBlack);
            title.setBackground(RisingBlack);
            Font fuente = title.getFont();
            title.setFont(new Font(fuente.getFontName(), Font.PLAIN, 25));
            panel.add(title);
        }

        panel.add(new Linea(0, 5, 2000,5), BorderLayout.SOUTH);

        return panel;
    }
}
