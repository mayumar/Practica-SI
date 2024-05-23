package practicafinal.componentes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import practicafinal.config.Colores;

/**
 * Un JTextField que muestra un texto de sugerencia (placeholder) cuando está vacío y no enfocado.
*/
public class HintTextField extends JTextField {
    private boolean showingHint;

    /**
     * Crea un nuevo HintTextField con el texto de sugerencia especificado.
     * 
     * @param hint El texto de sugerencia a mostrar cuando el área de texto está vacía y no enfocada.
    */
    public HintTextField(final String hint) {
        super(hint);
        this.showingHint = true;
        super.setForeground(Colores.dim_gray);
        super.setMargin(new Insets(10, 10, 10, 10));
        
        this.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (getText().isEmpty()) {
                    setText("");
                    setForeground(Colores.rising_black);
                    showingHint = false;
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getText().isEmpty()) {
                    setText(hint);
                    setForeground(Colores.dim_gray);
                    showingHint = true;
                }
            }
        });
    }

    /**
     * Obtiene el texto del área de texto. Si el texto actual es el texto de sugerencia,
     * devuelve una cadena vacía en su lugar.
     * 
     * @return El texto actual del área de texto.
    */
    @Override
    public String getText() {
        return showingHint ? "" : super.getText();
    }
}