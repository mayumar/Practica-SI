package practicafinal.config;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 * La clase Bordes proporciona una colección de bordes personalizados utilizados en la aplicación.
 * Cada borde está representado como un objeto estático de la clase {@link Border}.
*/
public class Bordes {
    /**
     * Borde de color gris medio con un grosor de 2 píxeles.
    */
    public static final Border gray_border = BorderFactory.createLineBorder(Colores.dim_gray, 2);

    /**
     * Borde vacío con 10 píxeles de espacio en la parte superior e inferior y 30 píxeles de espacio
     * en los lados izquierdo y derecho.
    */
    public static final Border button_empty_border = BorderFactory.createEmptyBorder(10, 30, 10, 30);

    /**
     * Borde de color negro naciente con un grosor de 2 píxeles.
    */
    public static final Border black_border = BorderFactory.createLineBorder(Colores.rising_black, 2);
}
