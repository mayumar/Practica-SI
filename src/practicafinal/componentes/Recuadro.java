package practicafinal.componentes;

import javax.swing.*;

import practicafinal.config.Bordes;
import practicafinal.config.Colores;

import java.awt.*;

/**
 * La clase Recuadro extiende JPanel y se utiliza para representar una calificación en forma de recuadro con un número.
 * El color del recuadro y el número varían dependiendo de la calificación proporcionada.
 */
public class Recuadro extends JPanel{

    /**
     * Crea un recuadro con la calificación proporcionada en forma de número decimal.
     * 
     * @param calificacionDouble La calificación del recuadro representada como un número decimal.
     */
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

    /**
     * Crea un recuadro con la calificación proporcionada en forma de número entero.
     * 
     * @param calificacionLong La calificación del recuadro representada como un número entero.
     */
    public Recuadro(Long calificacionLong){
        setLayout(new BorderLayout());

        JLabel calificacion = new JLabel(Long.toString(calificacionLong));
        calificacion.setHorizontalAlignment(SwingConstants.CENTER);
        calificacion.setForeground(Colores.rising_black);
        add(calificacion, BorderLayout.CENTER);

        setBorder(Bordes.black_border); // Crear un borde negro

        setCursor(new Cursor(Cursor.HAND_CURSOR));

        if(calificacionLong < 5){
            setBackground(Colores.bittersweet);
        }else if(calificacionLong < 8){
            setBackground(Colores.jonquil);
        }else{
            setBackground(Colores.spring_green);
        }

        setPreferredSize(new Dimension(60, 47));
        setBounds(127, 158, 60, 47); // Ajustar el tamaño y posición del recuadro
    }
}
