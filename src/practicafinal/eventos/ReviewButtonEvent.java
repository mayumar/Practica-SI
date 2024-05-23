package practicafinal.eventos;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.im.InputContext;

import javax.swing.JOptionPane;

public class ReviewButtonEvent implements ActionListener {
    private Container cp;
    private String name;
    private String surnames;
    private String review;

    public ReviewButtonEvent(Container cp, String name, String surnames, String review) {
        this.cp = cp;
        this.name = name;
        this.surnames = surnames;
        this.review = review;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.name.equals("") || this.surnames.equals("") || this.review.equals(""))
            JOptionPane.showMessageDialog(this.cp, "Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
