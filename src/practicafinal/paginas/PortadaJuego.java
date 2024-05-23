package practicafinal.paginas;

import javax.swing.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import practicafinal.DataManager;
import practicafinal.componentes.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

/**
 * La clase PortadaJuego representa un panel que muestra la portada de un juego específico.
*/
public class PortadaJuego extends JPanel{
    private JSONObject game;
    private JPanel parentPanel;
    private HashMap<String,JPanel> views;

    /**
     * Crea una instancia de PortadaJuego. Este panel utiliza un BorderLayout y contiene un título en la parte superior
     * que muestra el nombre del juego.
     *
     * @param gameName El nombre del juego que se mostrará en la portada.
    */
    public PortadaJuego(String gameName, JPanel parentPanel, HashMap<String,JPanel> views, ResourceBundle bundleText){
        this.parentPanel = parentPanel;
        this.views = views;
        setLayout(new BorderLayout());

        add(new Titulo(gameName, false), BorderLayout.NORTH);

        JPanel contenido = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(20, 10, 10, 10);

        ArrayList<JPanel> elements = new ArrayList<JPanel>();

        try {
            DataManager dataManager = new DataManager("src/data.json");
            this.game = dataManager.getGameFromName(gameName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Panel para la imagen
        JPanel imagePanel = new JPanel();
        ImageIcon imageIcon = new ImageIcon((String) this.game.get("imagen"));
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

        JPanel informacion = createInformacion(bundleText);

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

    private JPanel createInformacion(ResourceBundle bundleText){
        JPanel informacion = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);


        /********************************************/
        /* Descripcion del juego                    */
        /********************************************/

        JPanel descripcion = new JPanel(new GridLayout(1,1));
        JLabel descripcionLabel = new JLabel("<html><div style='text-align: center; margin: 15px;'>" + (String) this.game.get("descripcion") + "</div></html>");
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
        Double calificacionDouble = (Double) this.game.get("calificacion");
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
        JButton buttonReviews = new JButton("Realizar reseña");
        buttonReviews.setBackground(Colores.cadet_gray);
        buttonReviews.setBorder(Bordes.black_border);
        buttonReviews.setForeground(Colores.rising_black);
        c.gridx = 7;
        c.gridy = 2;
        c.gridheight = 1;
        c.gridwidth = 3;
        c.weightx = 0.5;
        informacion.add(buttonReviews, c);

        this.views.put("review", new Review(bundleText));

        buttonReviews.addActionListener(new FocusPanelGameListener(parentPanel, this, this.views.get("review"), BorderLayout.CENTER));
        
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
        GridLayout gl = new GridLayout(0, 1);
        gl.setVgap(10);
        JPanel reviews = new JPanel(gl);

        JSONArray reviewlist = (JSONArray) game.get("reviews");

        for(Object reviewObject : reviewlist){
            JSONObject reviewJsonObject = (JSONObject) reviewObject;

            JPanel linea = new JPanel(new FlowLayout(FlowLayout.RIGHT));

            Long calificacion = (Long) reviewJsonObject.get("calificacion");
            Recuadro recuadro = new Recuadro(calificacion);
            linea.add(recuadro);

            JPanel review = new JPanel(new GridLayout(1, 1));
            JLabel comentario = new JLabel("<html><div style='text-align: center; margin: 10px;'>" + (String) reviewJsonObject.get("comentario") + "</div></html>");
            comentario.setHorizontalAlignment(SwingConstants.CENTER);
            comentario.setForeground(Colores.rising_black);
            review.add(comentario);
            review.setBackground(Colores.platinum);
            review.setForeground(Colores.rising_black);
            review.setBorder(Bordes.black_border);
            review.setPreferredSize(new Dimension(1150, 47));
            linea.add(review);

            reviews.add(linea);
        }
        
        return reviews;
    }
    
}
