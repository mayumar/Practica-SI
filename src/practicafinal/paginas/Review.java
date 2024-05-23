package practicafinal.paginas;

import javax.swing.*;

import practicafinal.componentes.Titulo;

import java.awt.*;
import java.util.ResourceBundle;

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
        add(createForm(bundleText));

    }

    private JPanel createForm(ResourceBundle bundleText) {
        JPanel form = new JPanel(new GridBagLayout());
        
        JTextField nameInput = new JTextField(50);
        


        form.add(nameInput);

        return form;
    }

}
