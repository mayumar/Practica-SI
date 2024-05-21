package practicafinal.paginas;

import javax.swing.*;

import practicafinal.componentes.Bordes;
import practicafinal.componentes.Carrousel;
import practicafinal.componentes.Colores;
import practicafinal.componentes.Titulo;

import java.awt.*;
import java.util.ArrayList;

/**
 * La clase PortadaJuego representa un panel que muestra la portada de un juego específico.
*/
public class PortadaJuego extends JPanel{
    /**
     * Crea una instancia de PortadaJuego. Este panel utiliza un BorderLayout y contiene un título en la parte superior
     * que muestra el nombre del juego.
     *
     * @param gameName El nombre del juego que se mostrará en la portada.
    */
    public PortadaJuego(String gameName){
        setLayout(new BorderLayout());

        add(new Titulo(gameName, false), BorderLayout.NORTH);

        JPanel contenido = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(10, 10, 10, 10);

        ArrayList<JPanel> elements = new ArrayList<JPanel>();

        // Panel para la imagen
        JPanel imagePanel = new JPanel();
        ImageIcon imageIcon = new ImageIcon("src/images/juegos/fps/p_cs2.png");
        JLabel imageLabel = new JLabel(imageIcon);
        imagePanel.add(imageLabel);
        imagePanel.setPreferredSize(new Dimension(443, 275));
        imagePanel.setBorder(Bordes.black_border);
        imagePanel.setBackground(Colores.platinum);

        elements.add(imagePanel);

        Carrousel carrousel = new Carrousel(elements, 1);

        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 4;
        c.gridwidth = 1;
        contenido.add(carrousel, c);

        JPanel descripcion = new JPanel(new GridLayout(1,1));
        JLabel descripcionLabel = new JLabel("<html><div style='text-align: center;'> Counter-Strike 2 es una secuela del legendario juego de disparos en primera persona Counter-Strike. Desarrollado por Valve Corporation, sigue la fórmula de su predecesor, con partidas multijugador intensas y estratégicas. </div></html>");
        descripcionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        descripcionLabel.setForeground(Colores.rising_black);
        descripcion.add(descripcionLabel);

        descripcion.setBorder(Bordes.black_border);
        descripcion.setBackground(Colores.platinum);
        descripcion.setPreferredSize(new Dimension(638, 165));

        c.gridx = 1;
        c.gridy = 0;
        c.gridheight = 2;
        c.gridwidth = 5;
        contenido.add(descripcion, c);

        add(contenido, BorderLayout.CENTER);

        JPanel info = new JPanel(new GridLayout(0,1));
        JLabel fecha = new JLabel("Fecha de lanzamiento: ()");
        fecha.setForeground(Colores.rising_black);
        info.add(fecha);
        JLabel desarrollador = new JLabel("Desarrollador: ()");
        desarrollador.setForeground(Colores.rising_black);
        info.add(desarrollador);

        info.setBackground(Colores.platinum);
        info.setBorder(Bordes.black_border);
        info.setPreferredSize(new Dimension(400, 34));

        c.gridx = 1;
        c.gridy = 2;
        c.gridheight = 1;
        c.gridwidth = 2;
        contenido.add(info, c);

/*
        // Panel para los primeros componentes
        JPanel rightTopPanel = new JPanel();
        rightTopPanel.setLayout(new GridLayout(0, 1)); // Un GridLayout de una columna y filas variables
        //topPanel.add(rightTopPanel, BorderLayout.EAST);

        // Caja de texto 1
        JTextField textField1 = new JTextField("Texto predefinido 1");
        textField1.setEditable(false); // Hacer que el campo de texto no sea editable
        rightTopPanel.add(textField1);

        // Panel para el primer número y el segundo texto
        JPanel numberTextPanel = new JPanel();
        numberTextPanel.setLayout(new BorderLayout());

        // Cuadro con número
        JTextField numberTextField = new JTextField("42");
        numberTextField.setEditable(false); // Hacer que el campo de texto no sea editable
        numberTextField.setPreferredSize(new Dimension(50, numberTextField.getPreferredSize().height)); // Ajustar el ancho del campo de texto del número
        numberTextPanel.add(numberTextField, BorderLayout.WEST);

        // Caja de texto 2 debajo del cuadro con número
        JTextField textField2 = new JTextField("Texto predefinido 2");
        textField2.setEditable(false); // Hacer que el campo de texto no sea editable
        numberTextPanel.add(textField2, BorderLayout.CENTER);

        rightTopPanel.add(numberTextPanel);

        // Panel derecho para los demás componentes
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(0, 1)); // Un GridLayout de una columna y filas variables
        rightPanel.setPreferredSize(new Dimension(300, 0)); // Ancho fijo para el panel derecho
        add(rightPanel, BorderLayout.SOUTH);

        // Otras cajas de texto pequeñas
        String[] predefinedTexts = {"Texto 3", "Texto 4", "Texto 5"};
        for (String text : predefinedTexts) {
            // Panel para el campo de número y el campo de texto
            JPanel smallPanel = new JPanel();
            smallPanel.setLayout(new BorderLayout());

            // Campo de número pequeño
            JTextField numberField = new JTextField("0", 3); // Crear un campo de número con ancho fijo
            numberField.setEditable(false); // Hacer que el campo de texto no sea editable
            smallPanel.add(numberField, BorderLayout.WEST);

            // Campo de texto
            JTextField textField = new JTextField(text);
            textField.setEditable(false); // Hacer que el campo de texto no sea editable
            smallPanel.add(textField, BorderLayout.CENTER);

            rightPanel.add(smallPanel);
        }
*/
    }
    
}
