package practicafinal.paginas;

import java.awt.*;
import javax.swing.*;

public class Inicio {

    public static JPanel createInicio(){
        //Colores
        Color RisingBlack = new Color(27, 28, 34); //Negro

        JPanel inicio = new JPanel(new BorderLayout());

        JPanel logoSlogan = new JPanel(new BorderLayout());

        ImageIcon icon = new ImageIcon("src/images/logo.png");
        JLabel logo = new JLabel(icon);
        logo.setHorizontalAlignment(JLabel.LEFT);
        logoSlogan.add(logo, BorderLayout.NORTH);

        JLabel slogan = new JLabel("EXPLORA, JUEGA, DECIDE: LA GUÍA DEFINITVA PARA GAMERS");
        slogan.setForeground(RisingBlack);
        slogan.setBackground(RisingBlack);
        logoSlogan.add(slogan, BorderLayout.CENTER);

        inicio.add(logoSlogan, BorderLayout.NORTH);

        inicio.add(new Linea(0, 10, 2000, 10), BorderLayout.CENTER);

        return inicio;
    }
}
