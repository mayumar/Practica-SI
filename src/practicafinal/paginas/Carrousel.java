package practicafinal.paginas;

import javax.swing.*;

import practicafinal.componentes.Colores;

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

        JButton prevButton = new JButton("<");
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPrevious();
            }
        });

        prevButton.setOpaque(false);
        prevButton.setContentAreaFilled(false);
        prevButton.setBorderPainted(false);
        prevButton.setForeground(Colores.RisingBlack);
        prevButton.setFont(new Font(prevButton.getFont().getFontName(), Font.PLAIN, 30));

        JButton nextButton = new JButton(">");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showNext();
            }
        });

        nextButton.setOpaque(false);
        nextButton.setContentAreaFilled(false);
        nextButton.setBorderPainted(false);
        nextButton.setForeground(Colores.RisingBlack);
        nextButton.setFont(new Font(nextButton.getFont().getFontName(), Font.PLAIN, 30));

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
