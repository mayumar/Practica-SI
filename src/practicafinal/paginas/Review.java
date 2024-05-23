package practicafinal.paginas;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

import practicafinal.componentes.FormReview;
import practicafinal.componentes.Titulo;

// TODO: ARREGLAR PROBLEMA DE CAMBIAR DE VISTA

/**
 * La clase Review representa un panel en el que los usuarios pueden dejar sus reseñas.
*/
public class Review extends JPanel{
    /**
     * Crea una instancia de Review. Este panel utiliza un BorderLayout y contiene un título en la parte superior.
    */
    public Review(ResourceBundle bundleText){
        setLayout(new BorderLayout());
        add(new Titulo(bundleText.getString("Texto_review"), false), BorderLayout.NORTH);
        add(new FormReview());
    }
}
