package practicafinal.paginas;

import javax.swing.*;
import java.awt.*;

public class Review {
    public static JPanel createReview(){
        FlowLayout fl = new FlowLayout();
        fl.setAlignment(FlowLayout.CENTER);

        JPanel review = new JPanel(fl);
        review.add(new JLabel("REVIEW"));

        return review;
    }
}
