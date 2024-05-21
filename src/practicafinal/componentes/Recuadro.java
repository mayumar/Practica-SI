package practicafinal.componentes;

import javax.swing.*;

import org.json.simple.JSONObject;

import java.awt.*;

public class Recuadro extends JPanel{
    public Recuadro(JSONObject game){
        setLayout(new BorderLayout());

        Double calificacionDouble = (Double) game.get("calificacion");
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

        setBounds(127, 158, 60, 47); // Ajustar el tamaño y posición del recuadro
    }
}
