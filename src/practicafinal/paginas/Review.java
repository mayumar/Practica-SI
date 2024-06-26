package practicafinal.paginas;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.ResourceBundle;

import practicafinal.componentes.*;
import practicafinal.config.*;

/**
 * La clase Review representa un panel en el que los usuarios pueden dejar sus reseñas.
*/
public class Review extends JPanel{
    private JPanel parentPanel;
    private String gameName;
    private HashMap<String,JPanel> views;
    private HintTextField nameInput;
    private HintTextField surnamesInput;
    private HintTextArea reviewArea;
    private JButton sendButton;
    private Titulo title;
    private String textoMsgError;
    private String textoMsgReviewCorrecta;
    private String textoEnviado;

    /**
     * Crea una instancia de Review. Este panel utiliza un BorderLayout y contiene un título en la parte superior.
     * 
     * @param bundleText  ResourceBundle que contiene los textos para internacionalización.
     * @param gameName    El nombre del juego asociado a esta reseña.
     * @param parentPanel El panel principal al que se añadirá este panel de reseña.
     * @param views       Un mapa de vistas para gestionar la navegación entre ellas.
     */
    public Review(ResourceBundle bundleText, String gameName, JPanel parentPanel, HashMap<String,JPanel> views){
        this.textoMsgError = bundleText.getString("Texto_msg_error");
        this.textoMsgReviewCorrecta = bundleText.getString("Texto_msg_review_correcta");
        this.textoEnviado = bundleText.getString("Texto_enviado");

        this.gameName = gameName;
        this.parentPanel = parentPanel;
        this.views = views;

        setLayout(new BorderLayout());
        this.title = new Titulo(bundleText.getString("Texto_escribir_review"), false);
        add(this.title, BorderLayout.NORTH);
        add(createFormReview(bundleText));
    }

    /**
     * Crea y devuelve un panel que contiene el formulario para que los usuarios escriban su reseña.
     * 
     * @param bundleText ResourceBundle que contiene los textos para internacionalización.
     * @return Un JPanel que contiene el formulario de reseña.
     */
    private JPanel createFormReview(ResourceBundle bundleText){
        JPanel formReview = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;

        this.nameInput = new HintTextField(bundleText.getString("Texto_nombre"));
        this.nameInput.setPreferredSize(new Dimension(701, 53));
        this.nameInput.setFont(new Font("Arial", Font.BOLD, 16));
        this.nameInput.setBorder(Bordes.gray_border);
        gbc.gridy = 0;
        formReview.add(this.nameInput, gbc);

        this.surnamesInput = new HintTextField(bundleText.getString("Texto_apellidos"));
        this.surnamesInput.setPreferredSize(new Dimension(701, 53));
        this.surnamesInput.setFont(new Font("Arial", Font.BOLD, 16));
        this.surnamesInput.setBorder(Bordes.gray_border);
        gbc.gridy = 1;
        formReview.add(this.surnamesInput, gbc);

        this.reviewArea = new HintTextArea(bundleText.getString("Texto_escribir_review"), 5, 50);
        this.reviewArea.setFont(new Font("Arial", Font.BOLD, 16));
        this.reviewArea.setLineWrap(true);
        this.reviewArea.setWrapStyleWord(true);
        this.reviewArea.setBorder(Bordes.thin_gray_border);
        JScrollPane reviewScrollPane = new JScrollPane(this.reviewArea);
        reviewScrollPane.setPreferredSize(new Dimension(701, 150));
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.BOTH;
        formReview.add(reviewScrollPane, gbc);

        // Ratings buttons
        GridLayout gl = new GridLayout();
        gl.setHgap(10);
        JPanel ratingPanel = new JPanel(gl);
        
        for (int i = 0; i <= 10; i++)
            ratingPanel.add(new RatingButton(i));
        
        gbc.gridy = 3;
        formReview.add(ratingPanel, gbc);

        gbc.gridy = 4;
        this.sendButton = new JButton(bundleText.getString("Texto_enviar"));
        this.sendButton.setPreferredSize(new Dimension(570, 54));
        this.sendButton.setBackground(Colores.cadet_gray);
        this.sendButton.setBorder(Bordes.black_border);
        this.sendButton.setForeground(Colores.rising_black);
        this.sendButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        this.sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nameInput.getText().equals("") ||
                    surnamesInput.getText().equals("") ||
                    reviewArea.getText().equals("") ||
                    RatingButton.selectedButton == null) {
                    JOptionPane.showMessageDialog(formReview, textoMsgError, "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                JOptionPane.showMessageDialog(formReview, textoMsgReviewCorrecta, textoEnviado, JOptionPane.INFORMATION_MESSAGE);

                handleOkButtonClick();
            }
        });

        formReview.add(this.sendButton, gbc);

        return formReview;
    }

    /**
     * Maneja el evento de clic en el botón OK del mensaje que aparece cuando se ha realizado la reseña con éxito.
     */
    private void handleOkButtonClick() {
        this.setVisible(false);
        this.parentPanel.remove(this);

        JPanel gamePanel = this.views.get(this.gameName);
        if (gamePanel != null) {
            gamePanel.setVisible(true);
            this.parentPanel.add(gamePanel, BorderLayout.CENTER);
        } else {
            System.err.println("Panel for game " + this.gameName + " not found.");
        }

        this.parentPanel.revalidate();
        this.parentPanel.repaint();
    }

    /**
     * Actualiza los textos de la interfaz de usuario con los valores proporcionados en el nuevo ResourceBundle.
     * 
     * @param bundleText El nuevo ResourceBundle con los textos actualizados.
     */
    public void updateTexts(ResourceBundle bundleText) {
        this.title.setLabel(bundleText.getString("Texto_escribir_review"));
        this.nameInput.setText(bundleText.getString("Texto_nombre"));
        this.surnamesInput.setText(bundleText.getString("Texto_apellidos"));
        this.reviewArea.setText(bundleText.getString("Texto_escribir_review"));
        this.sendButton.setText(bundleText.getString("Texto_enviar"));
        this.textoMsgError = bundleText.getString("Texto_msg_error");
        this.textoMsgReviewCorrecta = bundleText.getString("Texto_msg_review_correcta");
        this.textoEnviado = bundleText.getString("Texto_enviado");
    }
}
