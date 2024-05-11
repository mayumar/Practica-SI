package practicafinal.paginas;

import javax.swing.*;
import java.awt.*;

public class Juego extends JPanel{

    public Juego(String gameName){
        setLayout(new BorderLayout());
        add(new Titulo(gameName, false), BorderLayout.NORTH);
    }
    
}
