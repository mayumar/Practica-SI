package practicafinal.componentes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * La clase RatingButton extiendo de JButton y representa un botón que usará el usuario para establecer una calificacion.
*/
public class RatingButton extends JButton {
    public static RatingButton selectedButton = null; // Referencia al botón seleccionado actualmente
    
    /**
     * Crea un nuevo RatingButton con la calificación especificada.
     * 
     * @param calification La calificación que representa este botón.
    */
    public RatingButton(int calification) {
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setText(String.valueOf(calification));
        setPreferredSize(new Dimension(41, 50));

        if (calification < 5) {
            setBackground(Color.RED);
        } else if (calification < 7) {
            setBackground(Color.YELLOW);
        } else {
            setBackground(Color.GREEN);
        }
        
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Deseleccionar el botón anterior, si existe
                if (selectedButton != null)
                    selectedButton.setBackground(getOriginalColor(selectedButton));
                
                // Seleccionar este botón
                setBackground(Color.CYAN);
                selectedButton = RatingButton.this;
            }
        });
    }
    
    // Método para obtener el color original del botón
    private Color getOriginalColor(RatingButton button) {
        int calification = Integer.parseInt(button.getText());

        if (calification < 5) {
            return Color.RED;
        } else if (calification < 7) {
            return Color.YELLOW;
        } else {
            return Color.GREEN;
        }
    }
}
