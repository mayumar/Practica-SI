package practicafinal.paginas;

import javax.swing.*;

import practicafinal.componentes.Titulo;

import java.awt.*;

public class PortadaJuego extends JPanel{

    public PortadaJuego(String gameName){
        setLayout(new BorderLayout());
        add(new Titulo(gameName, false), BorderLayout.NORTH);
    }
    
}
