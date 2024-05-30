package practicafinal.componentes;

import javax.swing.*;

import practicafinal.config.Colores;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * La clase Carrousel extiende JPanel y proporciona una interfaz para mostrar un conjunto de elementos JButton
 * en un estilo de carrusel, permitiendo al usuario navegar hacia adelante y hacia atrás.
*/
public class Carrousel extends JPanel {
    private JPanel elementsPanel;
    private int currentIndex;
    private ArrayList<JPanel> elements;
    private int elementsToShow;

    /**
     * Crea un carrusel con los elementos especificados y la cantidad de elementos a mostrar.
     *
     * @param elements       Una lista de JPanels que se mostrarán en el carrusel.
     * @param elementsToShow La cantidad de elementos que se mostrarán simultáneamente en el carrusel.
    */
    public Carrousel(ArrayList<JPanel> elements, int elementsToShow) {
        this.elements = elements;
        this.elementsToShow = elementsToShow;
        this.currentIndex = 0;

        this.elementsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));

        for (int i = 0; i < this.elementsToShow && i < elements.size(); i++) {
            this.elementsPanel.add(elements.get(i));
        }

        setLayout(new BorderLayout());
        add(this.elementsPanel, BorderLayout.CENTER);

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
        prevButton.setForeground(Colores.rising_black);
        prevButton.setFont(new Font(prevButton.getFont().getFontName(), Font.PLAIN, 30));
        prevButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

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
        nextButton.setForeground(Colores.rising_black);
        nextButton.setFont(new Font(nextButton.getFont().getFontName(), Font.PLAIN, 30));
        nextButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        add(prevButton, BorderLayout.WEST);
        add(nextButton, BorderLayout.EAST);
    }

    /**
     * Muestra el siguiente conjunto de elementos en el carrusel, si los hay.
    */
    public void showNext() {
        if (this.currentIndex + this.elementsToShow < this.elements.size()) {
            this.currentIndex++;
            updateElements();
        }
    }

    /**
     * Muestra el conjunto anterior de elementos en el carrusel, si los hay.
    */
    public void showPrevious() {
        if (this.currentIndex - 1 >= 0) {
            this.currentIndex--;
            updateElements();
        }
    }

    /**
     * Actualiza los elementos visibles en el carrusel según el índice actual.
    */
    private void updateElements() {
        this.elementsPanel.removeAll();
        for (int i = this.currentIndex; i < this.currentIndex + this.elementsToShow && i < elements.size(); i++) {
            this.elementsPanel.add(elements.get(i));
        }
        this.elementsPanel.revalidate();
        this.elementsPanel.repaint();
    }
}
