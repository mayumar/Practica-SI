package practicafinal.paginas;

import javax.swing.*;

import practicafinal.Colores;

import java.awt.*;

public class Titulo extends JPanel{

    public Titulo(String label, Boolean isInicio){
        setLayout(new BorderLayout());

        if(isInicio){

            ImageIcon icon = new ImageIcon("src/images/logo.png");
            JLabel logo = new JLabel(icon);
            logo.setHorizontalAlignment(JLabel.LEFT);
            add(logo, BorderLayout.NORTH);

            JLabel slogan = new JLabel(label);
            slogan.setForeground(Colores.RisingBlack);
            slogan.setBackground(Colores.RisingBlack);
            Font fuente = slogan.getFont();
            slogan.setFont(new Font(fuente.getFontName(), Font.PLAIN, fuente.getSize()));
            add(slogan, BorderLayout.CENTER);

        }else{

            JLabel title = new JLabel(label);
            title.setForeground(Colores.RisingBlack);
            title.setBackground(Colores.RisingBlack);
            Font fuente = title.getFont();
            title.setFont(new Font(fuente.getFontName(), Font.PLAIN, 25));
            add(title);
            
        }

        add(new Linea(0, 5, 2000,5), BorderLayout.SOUTH);
    }
}
