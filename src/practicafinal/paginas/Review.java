package practicafinal.paginas;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

import practicafinal.componentes.*;
import practicafinal.config.*;

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
        add(createFormReview());
    }

    private JPanel createFormReview(){
        JPanel formReview = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;

        HintTextField nameInput = new HintTextField("Nombre");
        nameInput.setPreferredSize(new Dimension(701, 53));
        nameInput.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridy = 0;
        formReview.add(nameInput, gbc);

        HintTextField apellidosInput = new HintTextField("Apellidos");
        apellidosInput.setPreferredSize(new Dimension(701, 53));
        apellidosInput.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridy = 1;
        formReview.add(apellidosInput, gbc);

        HintTextArea reviewArea = new HintTextArea("Deja tu reseña", 5, 50);
        reviewArea.setFont(new Font("Arial", Font.BOLD, 16));
        reviewArea.setLineWrap(true);
        reviewArea.setWrapStyleWord(true);
        JScrollPane reviewScrollPane = new JScrollPane(reviewArea);
        reviewScrollPane.setPreferredSize(new Dimension(701, 150));
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.BOTH;
        formReview.add(reviewScrollPane, gbc);

        // Ratings buttons
        JPanel ratingPanel = new JPanel(new GridLayout());
        
        for (int i = 0; i <= 10; i++)
            ratingPanel.add(new RatingButton(i));
        
        gbc.gridy = 3;
        formReview.add(ratingPanel, gbc);

        gbc.gridy = 4;
        JButton sendButton = new JButton("Enviar");
        sendButton.setPreferredSize(new Dimension(570, 54));
        sendButton.setBackground(Colores.cadet_gray);
        sendButton.setBorder(Bordes.black_border);
        sendButton.setForeground(Colores.rising_black);
        sendButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        formReview.add(sendButton, gbc);

        return formReview;
    }
}
