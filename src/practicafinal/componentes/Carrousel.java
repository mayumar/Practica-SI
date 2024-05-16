package practicafinal.componentes;

import javax.swing.*;

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
    private ArrayList<JButton> elements;
    private int elementsToShow;

    /**
     * Crea un carrusel con los elementos especificados y la cantidad de elementos a mostrar.
     *
     * @param elements Una lista de JButtons que se mostrarán en el carrusel.
     * @param elementsToShow La cantidad de elementos que se mostrarán simultáneamente en el carrusel.
    */
    public Carrousel(ArrayList<JButton> elements, int elementsToShow) {
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

    /**
     * Muestra el siguiente conjunto de elementos en el carrusel, si los hay.
    */
    public void showNext() {
        if (currentIndex + elementsToShow < elements.size()) {
            currentIndex++;
            updateElements();
        }
    }

    /**
     * Muestra el conjunto anterior de elementos en el carrusel, si los hay.
    */
    public void showPrevious() {
        if (currentIndex - 1 >= 0) {
            currentIndex--;
            updateElements();
        }
    }

    /**
     * Actualiza los elementos visibles en el carrusel según el índice actual.
    */
    private void updateElements() {
        elementsPanel.removeAll();
        for (int i = currentIndex; i < currentIndex + elementsToShow && i < elements.size(); i++) {
            elementsPanel.add(elements.get(i));
        }
        elementsPanel.revalidate();
        elementsPanel.repaint();
    }
}
