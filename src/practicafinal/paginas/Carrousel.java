package practicafinal.paginas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Carrousel extends JPanel {
    private JPanel elementsPanel;
    private int currentIndex;
    private ArrayList<JPanel> elements;
    private int elementsToShow;

    public Carrousel(ArrayList<JPanel> elements, int elementsToShow) {
        this.elements = elements;
        this.elementsToShow = elementsToShow;
        currentIndex = 0;

        elementsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        for (int i = 0; i < elementsToShow && i < elements.size(); i++) {
            elementsPanel.add(elements.get(i));
        }

        setLayout(new BorderLayout());
        add(elementsPanel, BorderLayout.CENTER);

        JButton prevButton = new JButton("Prev");
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPrevious();
            }
        });

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showNext();
            }
        });

        add(prevButton, BorderLayout.WEST);
        add(nextButton, BorderLayout.EAST);
    }

    public void showNext() {
        if (currentIndex + elementsToShow < elements.size()) {
            currentIndex++;
            updateElements();
        }
    }

    public void showPrevious() {
        if (currentIndex - 1 >= 0) {
            currentIndex--;
            updateElements();
        }
    }

    private void updateElements() {
        elementsPanel.removeAll();
        for (int i = currentIndex; i < currentIndex + elementsToShow && i < elements.size(); i++) {
            elementsPanel.add(elements.get(i));
        }
        elementsPanel.revalidate();
        elementsPanel.repaint();
    }
}
