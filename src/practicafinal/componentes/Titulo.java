package practicafinal.componentes;

import javax.swing.*;

import practicafinal.config.Colores;

import java.awt.*;

/**
 * La clase Titulo extiende JPanel y se utiliza para mostrar un título o un logo con un eslogan.
 * Dependiendo del valor de isInicio, se configura con un logo y un eslogan, o solo un título.
 */
public class Titulo extends JPanel {
    private String label;
    private JLabel textLabel;

    /**
     * Crea un panel de título con el texto y la configuración especificados.
     *
     * @param label    El texto del título o eslogan que se mostrará en el panel.
     * @param isInicio Si es true, muestra un logo y un eslogan, de lo contrario, solo muestra un título.
     */
    public Titulo(String label, Boolean isInicio) {
        setLayout(new BorderLayout());
        this.label = label;
        if (isInicio) {
            ImageIcon icon = new ImageIcon("src/images/logo.png");
            JLabel logo = new JLabel(icon);
            logo.setHorizontalAlignment(JLabel.LEFT);
            add(logo, BorderLayout.NORTH);

            textLabel = new JLabel(this.label);
            textLabel.setForeground(Colores.rising_black);
            textLabel.setBackground(Colores.rising_black);
            Font fuente = textLabel.getFont();
            textLabel.setFont(new Font(fuente.getFontName(), Font.PLAIN, fuente.getSize()));
            add(textLabel, BorderLayout.CENTER);
        } else {
            textLabel = new JLabel(this.label);
            textLabel.setForeground(Colores.rising_black);
            textLabel.setBackground(Colores.rising_black);
            Font fuente = textLabel.getFont();
            textLabel.setFont(new Font(fuente.getFontName(), Font.PLAIN, 25));
            add(textLabel, BorderLayout.CENTER);
        }

        add(new Linea(0, 5, 2000, 5), BorderLayout.SOUTH);
    }

    /**
     * Establece el texto del título.
     * 
     * @param label El texto del título que se establecerá.
     */
    public void setLabel(String label) {
        this.label = label;
        if (textLabel != null) {
            textLabel.setText(label);
        }
    }
}