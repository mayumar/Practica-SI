package practicafinal.paginas;

import javax.swing.*;

import org.json.simple.JSONObject;

import practicafinal.DataManager;
import practicafinal.componentes.Bordes;
import practicafinal.componentes.Carrousel;
import practicafinal.componentes.Colores;
import practicafinal.componentes.Recuadro;
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
        GridBagConstraints c_contenido = new GridBagConstraints();
        c_contenido.fill = GridBagConstraints.BOTH;
        c_contenido.insets = new Insets(10, 10, 10, 10);

        ArrayList<JPanel> elements = new ArrayList<JPanel>();

        JSONObject game = null;

        try {
            DataManager dataManager = new DataManager("src/data.json");
            game = dataManager.getGameFromName(gameName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Panel para la imagen
        JPanel imagePanel = new JPanel();
        ImageIcon imageIcon = new ImageIcon((String) game.get("imagen"));
        JLabel imageLabel = new JLabel(imageIcon);
        imagePanel.add(imageLabel);
        imagePanel.setPreferredSize(new Dimension(443, 275));
        imagePanel.setBorder(Bordes.black_border);
        imagePanel.setBackground(Colores.platinum);

        elements.add(imagePanel);

        Carrousel carrousel = new Carrousel(elements, 1);

        c_contenido.gridx = 0;
        c_contenido.gridy = 0;
        c_contenido.gridheight = 1;
        c_contenido.gridwidth = 1;
        contenido.add(carrousel, c_contenido);

        JPanel informacion = new JPanel(new GridBagLayout());
        GridBagConstraints c_informacion = new GridBagConstraints();
        c_informacion.fill = GridBagConstraints.BOTH;
        c_informacion.insets = new Insets(10, 5, 10, 5);

        JPanel descripcion = new JPanel(new GridLayout(1,1));
        JLabel descripcionLabel = new JLabel("<html><div style='text-align: center;'>" + (String) game.get("descripcion") + "</div></html>");
        descripcionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        descripcionLabel.setForeground(Colores.rising_black);
        descripcion.add(descripcionLabel);

        descripcion.setBorder(Bordes.black_border);
        descripcion.setBackground(Colores.platinum);
        descripcion.setPreferredSize(new Dimension(638, 165));

        c_informacion.gridx = 0;
        c_informacion.gridy = 0;
        c_informacion.gridheight = 2;
        c_informacion.gridwidth = 5;
        informacion.add(descripcion, c_informacion);

        
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
        
        c_informacion.gridx = 0;
        c_informacion.gridy = 2;
        c_informacion.gridheight = 1;
        c_informacion.gridwidth = 2;
        informacion.add(info, c_informacion);
        
        JButton b_tienda1 = new JButton("Tienda 1");
        c_informacion.gridx = 2;
        c_informacion.gridy = 2;
        c_informacion.gridheight = 1;
        c_informacion.gridwidth = 1;
        informacion.add(b_tienda1, c_informacion);
        
        JButton b_tienda2 = new JButton("Tienda 2");
        c_informacion.gridx = 3;
        c_informacion.gridy = 2;
        c_informacion.gridheight = 1;
        c_informacion.gridwidth = 1;
        informacion.add(b_tienda2, c_informacion);
        
        JButton b_tienda3 = new JButton("Tienda 3");
        c_informacion.gridx = 4;
        c_informacion.gridy = 2;
        c_informacion.gridheight = 1;
        c_informacion.gridwidth = 1;
        informacion.add(b_tienda3, c_informacion);

        c_informacion.gridx = 0;
        c_informacion.gridy = 3;
        c_informacion.gridheight = 1;
        c_informacion.gridwidth = 1;
        informacion.add(new Recuadro(game), c_informacion);

        JPanel resume_reviews = new JPanel(new GridLayout(0,1));

        resume_reviews.setPreferredSize(new Dimension(300, 48));
        resume_reviews.setBorder(Bordes.black_border);

        Double calificacionDouble = (Double) game.get("calificacion");
        if(calificacionDouble < 5.0){
            resume_reviews.setBackground(Colores.bittersweet);
            resume_reviews.add(new JLabel("Las reseñas de usuarios son mayoritariamente negativas."));
            resume_reviews.add(new JLabel("Los jugadores han expresado insatisfacción con la experiencia ofrecida."));
        }else if(calificacionDouble < 8.0){
            resume_reviews.setBackground(Colores.jonquil);
            resume_reviews.add(new JLabel("Las reseñas de usuarios son mixtas."));
            resume_reviews.add(new JLabel("Los jugadores han expresado no se que con la experiencia ofrecida."));
        }else{
            resume_reviews.setBackground(Colores.spring_green);
            resume_reviews.add(new JLabel("Las reseñas de usuarios son mayormente positivas."));
            resume_reviews.add(new JLabel("Los jugadores han expresado satisfacción con la experiencia ofrecida."));
        }

        c_informacion.gridx = 1;
        c_informacion.gridy = 3;
        c_informacion.gridheight = 1;
        c_informacion.gridwidth = 2;
        informacion.add(resume_reviews, c_informacion);

        JButton reviews = new JButton("Realizar reseña");
        reviews.setBackground(Colores.cadet_gray);
        reviews.setBorder(Bordes.black_border);
        c_informacion.gridx = 3;
        c_informacion.gridy = 3;
        c_informacion.gridheight = 1;
        c_informacion.gridwidth = 2;
        informacion.add(reviews, c_informacion);
        
        c_contenido.gridx = 1;
        c_contenido.gridy = 0;
        c_contenido.gridheight = 1;
        c_contenido.gridwidth = 1;
        contenido.add(informacion, c_contenido);

        
        add(contenido, BorderLayout.CENTER);
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
