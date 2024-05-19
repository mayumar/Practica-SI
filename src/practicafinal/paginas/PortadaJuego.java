package practicafinal.paginas;

import javax.swing.*;

import practicafinal.componentes.Titulo;

import java.awt.*;

/**
 * La clase PortadaJuego representa un panel que muestra la portada de un juego específico.
*/
public class PortadaJuego extends JPanel{
    /**
     * Crea una instancia de PortadaJuego. Este panel utiliza un BorderLayout y contiene un título en la parte superior
     * que muestra el nombre del juego.
     *
     * @param gameName El nombre del juego que se mostrará en la portada.
    */
    public PortadaJuego(String gameName){
        setLayout(new BorderLayout());
        add(new Titulo(gameName, false), BorderLayout.NORTH);
    }
    
}
