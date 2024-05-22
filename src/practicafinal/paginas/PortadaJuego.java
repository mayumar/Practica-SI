package practicafinal.paginas;

import javax.swing.*;

import org.json.simple.JSONObject;

import practicafinal.DataManager;
import practicafinal.componentes.*;

import java.awt.*;
import java.util.ArrayList;

/**
 * La clase PortadaJuego representa un panel que muestra la portada de un juego específico.
*/
public class PortadaJuego extends JPanel{
    JSONObject game;

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

        JSONObject game = null;

        try {
            DataManager dataManager = new DataManager("src/data.json");
            game = dataManager.getGameFromName(gameName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.game = game;

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

        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 1;
        contenido.add(carrousel, c);

        JPanel informacion = createInformacion();

        c.gridx = 1;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 1;
        contenido.add(informacion, c);

        JPanel reviews = createReviews();

        c.gridx = 0;
        c.gridy = 1;
        c.gridheight = 1;
        c.gridwidth = 2;
        contenido.add(reviews, c);
        
        add(contenido, BorderLayout.CENTER);
    }

    private JPanel createInformacion(){
        JPanel informacion = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);


        /********************************************/
        /* Descripcion del juego                    */
        /********************************************/

        JPanel descripcion = new JPanel(new GridLayout(1,1));
        JLabel descripcionLabel = new JLabel("<html><div style='text-align: center; margin: 15px;'>" + (String) game.get("descripcion") + "</div></html>");
        descripcionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        descripcionLabel.setForeground(Colores.rising_black);
        descripcion.add(descripcionLabel);

        descripcion.setBorder(Bordes.black_border);
        descripcion.setBackground(Colores.platinum);
        descripcion.setPreferredSize(new Dimension(650, 165));

        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 10;
        informacion.add(descripcion, c);


        /********************************************/
        /* Fecha y desarrollador                    */
        /********************************************/

        JPanel info = new JPanel(new GridLayout(0,1));
        JLabel infoLabel = new JLabel("<html><div style='margin: 10px'>Fecha de lanzamiento: ()<br/>Desarrollador: ()<div/></html>");
        infoLabel.setForeground(Colores.rising_black);
        info.add(infoLabel);
        
        info.setBackground(Colores.platinum);
        info.setBorder(Bordes.black_border);
        info.setPreferredSize(new Dimension(300, 50));
        
        c.gridx = 0;
        c.gridy = 1;
        c.gridheight = 1;
        c.gridwidth = 7;
        c.weightx = 0.5;
        informacion.add(info, c);
        

        /********************************************/
        /* Tiendas                                  */
        /********************************************/

        ImageIcon idioma = new ImageIcon("src/images/idioma.png");

        JButton b_tienda1 = new JButton(idioma);
        b_tienda1.setBorder(Bordes.button_empty_border);
        b_tienda1.setOpaque(false);
        b_tienda1.setContentAreaFilled(false);
        b_tienda1.setBorderPainted(false);
        b_tienda1.setPreferredSize(new Dimension(idioma.getIconWidth() + 5, info.getHeight()));
        c.gridx = 7;
        c.gridy = 1;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weightx = 0.1;
        informacion.add(b_tienda1, c);
        
        JButton b_tienda2 = new JButton(idioma);
        b_tienda2.setBorder(Bordes.button_empty_border);
        b_tienda2.setOpaque(false);
        b_tienda2.setContentAreaFilled(false);
        b_tienda2.setBorderPainted(false);
        b_tienda2.setPreferredSize(new Dimension(idioma.getIconWidth() + 5, info.getHeight()));
        c.gridx = 8;
        c.gridy = 1;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weightx = 0.1;
        informacion.add(b_tienda2, c);
        
        JButton b_tienda3 = new JButton(idioma);
        b_tienda3.setBorder(Bordes.button_empty_border);
        b_tienda3.setOpaque(false);
        b_tienda3.setContentAreaFilled(false);
        b_tienda3.setBorderPainted(false);
        b_tienda3.setPreferredSize(new Dimension(idioma.getIconWidth() + 5, info.getHeight()));
        c.gridx = 9;
        c.gridy = 1;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weightx = 0.1;
        informacion.add(b_tienda3, c);


        /********************************************/
        /* Resumen de calificaciones                */
        /********************************************/

        c.gridx = 0;
        c.gridy = 2;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weightx = 0.2;
        Double calificacionDouble = (Double) game.get("calificacion");
        Recuadro recuadro = new Recuadro(calificacionDouble);
        informacion.add(recuadro, c);

        JPanel resume_reviews = getResumeReviews(calificacionDouble);

        c.gridx = 1;
        c.gridy = 2;
        c.gridheight = 1;
        c.gridwidth = 6;
        c.weightx = 0.5;
        informacion.add(resume_reviews, c);


        /********************************************/
        /* Boton para hacer review                  */
        /********************************************/
        JButton reviews = new JButton("Realizar reseña");
        reviews.setBackground(Colores.cadet_gray);
        reviews.setBorder(Bordes.black_border);
        reviews.setForeground(Colores.rising_black);
        c.gridx = 7;
        c.gridy = 2;
        c.gridheight = 1;
        c.gridwidth = 3;
        c.weightx = 0.5;
        informacion.add(reviews, c);
        
        return informacion;
    }

    private JPanel getResumeReviews(Double calification){
        JPanel resume_reviews = new JPanel(new GridLayout(1,1));

        //resume_reviews.setPreferredSize(new Dimension(350, 48));
        resume_reviews.setBorder(Bordes.black_border);


        if(calification < 5.0){
            resume_reviews.setBackground(Colores.bittersweet);
            JLabel linea = new JLabel("<html><div style='text-align: center;'>Las reseñas de usuarios son mayoritariamente negativas.<br/>Los jugadores han expresado insatisfacción con la experiencia ofrecida.</div></html>");
            linea.setFont(new Font(linea.getFont().getFontName(), Font.BOLD, 9));
            linea.setHorizontalAlignment(SwingConstants.CENTER);
            resume_reviews.add(linea);
        }else if(calification < 8.0){
            resume_reviews.setBackground(Colores.jonquil);
            JLabel linea = new JLabel("<html><div style='text-align: center;'>Las reseñas de usuarios son mixtas.<br/>Los jugadores han expresado no se que con la experiencia ofrecida.</div></html>");
            linea.setFont(new Font(linea.getFont().getFontName(), Font.BOLD, 9));
            linea.setHorizontalAlignment(SwingConstants.CENTER);
            resume_reviews.add(linea);
        }else{
            resume_reviews.setBackground(Colores.spring_green);
            JLabel linea = new JLabel("<html><div style='text-align: center;'>Las reseñas de usuarios son mayormente positivas.<br/>Los jugadores han expresado satisfacción con la experiencia ofrecida.</div></html>");
            linea.setFont(new Font(linea.getFont().getFontName(), Font.BOLD, 9));
            linea.setHorizontalAlignment(SwingConstants.CENTER);
            resume_reviews.add(linea);
        }

        return resume_reviews;
    }

    private JPanel createReviews(){
        JPanel reviews = new JPanel();

        return reviews;
    }
    
}
