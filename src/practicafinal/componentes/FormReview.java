package practicafinal.componentes;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * La clase FormReview extiende de JPanel y representa la el formulario que el usuario utlizará para crear una
 * reseña de un juego.
*/
public class FormReview extends JPanel {
    /**
     * Constructor que inicializa el formulario de revisión.
    */
    public FormReview() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;

        HintTextField nameInput = new HintTextField("Nombre");
        nameInput.setPreferredSize(new Dimension(701, 53));
        nameInput.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridy = 0;
        add(nameInput, gbc);

        HintTextField apellidosInput = new HintTextField("Apellidos");
        apellidosInput.setPreferredSize(new Dimension(701, 53));
        apellidosInput.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridy = 1;
        add(apellidosInput, gbc);

        HintTextArea reviewArea = new HintTextArea("Deja tu reseña", 5, 50);
        reviewArea.setFont(new Font("Arial", Font.BOLD, 16));
        reviewArea.setLineWrap(true);
        reviewArea.setWrapStyleWord(true);
        JScrollPane reviewScrollPane = new JScrollPane(reviewArea);
        reviewScrollPane.setPreferredSize(new Dimension(701, 150));
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.BOTH;
        add(reviewScrollPane, gbc);

        // Ratings buttons
        JPanel ratingPanel = new JPanel(new GridLayout());
        
        for (int i = 0; i <= 10; i++)
            ratingPanel.add(new RatingButton(i));
        
        gbc.gridy = 3;
        add(ratingPanel, gbc);

        gbc.gridy = 4;
        JButton sendButton = new JButton("Enviar");
        sendButton.setPreferredSize(new Dimension(570, 54));
        sendButton.setBackground(Colores.cadet_gray);
        sendButton.setBorder(Bordes.black_border);
        sendButton.setForeground(Colores.rising_black);
        sendButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(sendButton, gbc);
    }
}