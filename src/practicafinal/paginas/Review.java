package practicafinal.paginas;

import javax.swing.*;
import java.awt.*;

public class Review extends JPanel{

    public Review(){
        setLayout(new BorderLayout());
        add(new Titulo("Deja tu reseña", false), BorderLayout.NORTH);
    }

}
