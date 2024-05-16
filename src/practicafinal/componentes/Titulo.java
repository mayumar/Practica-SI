package practicafinal.componentes;

import javax.swing.*;

import practicafinal.paginas.Linea;

import java.awt.*;

/**
 * La clase Titulo extiende JPanel y se utiliza para mostrar un título o un logo con un eslogan.
 * Dependiendo del valor de isInicio, se configura con un logo y un eslogan, o solo un título.
*/
public class Titulo extends JPanel{
    /**
     * Crea un panel de título con el texto y la configuración especificados.
     *
     * @param label El texto del título o eslogan que se mostrará en el panel.
     * @param isInicio Si es true, muestra un logo y un eslogan, de lo contrario, solo muestra un título.
    */
    public Titulo(String label, Boolean isInicio){
        setLayout(new BorderLayout());

        if(isInicio){

            ImageIcon icon = new ImageIcon("src/images/logo.png");
            JLabel logo = new JLabel(icon);
            logo.setHorizontalAlignment(JLabel.LEFT);
            add(logo, BorderLayout.NORTH);

            JLabel slogan = new JLabel(label);
            slogan.setForeground(Colores.RisingBlack);
            slogan.setBackground(Colores.RisingBlack);
            Font fuente = slogan.getFont();
            slogan.setFont(new Font(fuente.getFontName(), Font.PLAIN, fuente.getSize()));
            add(slogan, BorderLayout.CENTER);

        }else{

            JLabel title = new JLabel(label);
            title.setForeground(Colores.RisingBlack);
            title.setBackground(Colores.RisingBlack);
            Font fuente = title.getFont();
            title.setFont(new Font(fuente.getFontName(), Font.PLAIN, 25));
            add(title, BorderLayout.CENTER);
            
        }

        add(new Linea(0, 5, 2000,5), BorderLayout.SOUTH);
    }
}
