package practicafinal.componentes;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextArea;

/**
 * Un JTextArea que muestra un texto de sugerencia (placeholder) cuando está vacío y no enfocado.
*/
public class HintTextArea extends JTextArea {
    private boolean showingHint;

    /**
     * Crea un nuevo HintTextArea con el texto de sugerencia especificado.
     * 
     * @param hint El texto de sugerencia a mostrar cuando el área de texto está vacía y no enfocada.
     * @param rows El número de filas inicial del área de texto.
     * @param cols El número de columnas inicial del área de texto.
    */
    public HintTextArea(final String hint, int rows, int cols) {
        super(hint, rows, cols);
        this.showingHint = true;
        super.setForeground(Color.GRAY);
        
        this.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (getText().isEmpty()) {
                    setText("");
                    setForeground(Color.BLACK);
                    showingHint = false;
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (getText().isEmpty()) {
                    setText(hint);
                    setForeground(Color.GRAY);
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
