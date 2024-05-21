package practicafinal.componentes;

import javax.swing.*;


import java.awt.*;

public class Recuadro extends JPanel{
    public Recuadro(Double calificacionDouble){
        setLayout(new BorderLayout());

        JLabel calificacion = new JLabel(Double.toString(calificacionDouble));
        calificacion.setHorizontalAlignment(SwingConstants.CENTER);
        calificacion.setForeground(Colores.rising_black);
        add(calificacion, BorderLayout.CENTER);

        setBorder(Bordes.black_border); // Crear un borde negro

        setCursor(new Cursor(Cursor.HAND_CURSOR));

        if(calificacionDouble < 5.0){
            setBackground(Colores.bittersweet);
        }else if(calificacionDouble < 8.0){
            setBackground(Colores.jonquil);
        }else{
            setBackground(Colores.spring_green);
        }

        setPreferredSize(new Dimension(60, 47));
        setBounds(127, 158, 60, 47); // Ajustar el tamaño y posición del recuadro
    }

    public Recuadro(int calificacionInt){
        setLayout(new BorderLayout());

        JLabel calificacion = new JLabel(Integer.toString(calificacionInt));
        calificacion.setHorizontalAlignment(SwingConstants.CENTER);
        calificacion.setForeground(Colores.rising_black);
        add(calificacion, BorderLayout.CENTER);

        setBorder(Bordes.black_border); // Crear un borde negro

        setCursor(new Cursor(Cursor.HAND_CURSOR));

        if(calificacionInt < 5){
            setBackground(Colores.bittersweet);
        }else if(calificacionInt < 8){
            setBackground(Colores.jonquil);
        }else{
            setBackground(Colores.spring_green);
        }

        setPreferredSize(new Dimension(60, 47));
        setBounds(127, 158, 60, 47); // Ajustar el tamaño y posición del recuadro
    }
}
