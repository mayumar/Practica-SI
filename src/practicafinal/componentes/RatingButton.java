package practicafinal.componentes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import practicafinal.config.Bordes;
import practicafinal.config.Colores;

/**
 * La clase RatingButton extiendo de JButton y representa un botón que usará el usuario para establecer una calificacion.
*/
public class RatingButton extends JButton {
    private static RatingButton selectedButton = null; // Referencia al botón seleccionado actualmente
    
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
            setBackground(Colores.bittersweet);
        } else if (calification < 7) {
            setBackground(Colores.jonquil);
        } else {
            setBackground(Colores.spring_green);
        }
        setBorder(Bordes.black_border);
        
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Deseleccionar el botón anterior, si existe
                if (selectedButton != null)
                    selectedButton.setBackground(getOriginalColor(selectedButton));
                
                // Seleccionar este botón
                setBackground(Colores.fluorencent_cyan);
                selectedButton = RatingButton.this;
            }
        });
    }
    
    // Método para obtener el color original del botón
    private Color getOriginalColor(RatingButton button) {
        int calification = Integer.parseInt(button.getText());

        if (calification < 5) {
            return Colores.bittersweet;
        } else if (calification < 7) {
            return Colores.jonquil;
        } else {
            return Colores.spring_green;
        }
    }
}
