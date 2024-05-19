package practicafinal.paginas;

import javax.swing.*;

import practicafinal.componentes.Titulo;

import java.awt.*;

/**
 * La clase Review representa un panel en el que los usuarios pueden dejar sus reseñas.
*/
public class Review extends JPanel{
    /**
     * Crea una instancia de Review. Este panel utiliza un BorderLayout y contiene un título en la parte superior.
    */
    public Review(){
        setLayout(new BorderLayout());
        add(new Titulo("Deja tu reseña", false), BorderLayout.NORTH);
    }

}
