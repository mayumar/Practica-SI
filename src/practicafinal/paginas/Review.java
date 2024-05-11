package practicafinal.paginas;

import javax.swing.*;
import java.awt.*;

public class Review {
    public static JPanel createReview(){
        JPanel review = new JPanel(new BorderLayout());
        review.add(new Titulo("Deja tu reseña", false), BorderLayout.NORTH);

        return review;
    }
}
