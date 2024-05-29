package practicafinal.paginas;

import javax.swing.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import practicafinal.DataManager;
import practicafinal.componentes.*;
import practicafinal.config.Bordes;
import practicafinal.config.Colores;
import practicafinal.eventos.FocusPanelGameListener;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

/**
 * La clase PortadaJuego representa un panel que muestra la portada de un juego específico.
*/
public class PortadaJuego extends JPanel{
    private String gameName;
    private JSONObject game;
    private JPanel parentPanel;
    private HashMap<String,JPanel> views;
    private JLabel descripcionLabel;
    private JLabel infoLabel;
    private JLabel linea;
    private Double calification;
    private JButton buttonReviews;
    private JSONArray reviewlist;
    private JPanel reviews;

    /**
     * Crea una instancia de PortadaJuego que muestra la portada de un juego específico.
     * 
     * @param gameName    El nombre del juego que se mostrará en la portada.
     * @param parentPanel El panel principal al que se añadirá esta portada.
     * @param views       Un mapa de vistas para gestionar la navegación entre ellas.
     * @param bundleText  ResourceBundle que contiene los textos para internacionalización.
     */
    public PortadaJuego(String gameName, JPanel parentPanel, HashMap<String,JPanel> views, ResourceBundle bundleText){
        this.gameName = gameName;
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
        JSONArray images = (JSONArray) this.game.get("capturas");

        for (Object image : images) {
            JSONObject imageJSON = (JSONObject) image;

            JPanel imagePanel = new JPanel(new GridLayout(1, 1));
            ImageIcon imageIcon = new ImageIcon((String) imageJSON.get("ruta"));
    
            Image reescaled = imageIcon.getImage().getScaledInstance(443, 280, Image.SCALE_SMOOTH);
            imageIcon.setImage(reescaled);
            
            JLabel imageLabel = new JLabel(imageIcon);
            imagePanel.add(imageLabel);
            imagePanel.setPreferredSize(new Dimension(443, 275));
            imagePanel.setBorder(Bordes.black_border);
            imagePanel.setBackground(Colores.platinum);
            
            elements.add(imagePanel);
        }

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

        this.reviews = createReviews(bundleText);

        c.gridx = 0;
        c.gridy = 1;
        c.gridheight = 1;
        c.gridwidth = 2;
        contenido.add(reviews, c);
        
        add(contenido, BorderLayout.CENTER);
    }

    /**
     * Crea y devuelve un panel que contiene información detallada sobre el juego, incluida su descripción, fecha de lanzamiento, desarrollador y enlaces a tiendas.
     * 
     * @param bundleText El ResourceBundle que contiene los textos necesarios para internacionalización.
     * @return Un JPanel que contiene la información detallada sobre el juego.
     */
    private JPanel createInformacion(ResourceBundle bundleText){
        JPanel informacion = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);

        /********************************************/
        /* Descripcion del juego                    */
        /********************************************/

        JPanel descripcion = new JPanel(new GridLayout(1,1));
        this.descripcionLabel = new JLabel("<html><div style='text-align: center; margin: 15px;'>" + bundleText.getString((String) this.game.get("descripcion")) + "</div></html>");
        this.descripcionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.descripcionLabel.setForeground(Colores.rising_black);
        descripcion.add(this.descripcionLabel);

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
        this.infoLabel = new JLabel("<html><div style='margin: 10px'>" + bundleText.getString("Texto_fecha_lanzamiento") +": " + this.game.get("fecha_lanzamiento") + "<br/>" + bundleText.getString("Texto_desarrollador") + ": " + this.game.get("desarrollador") + "<div/></html>");
        this.infoLabel.setForeground(Colores.rising_black);
        info.add(this.infoLabel);
        
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

        ImageIcon steam = new ImageIcon("src/images/steam.png");
        JButton b_tienda1 = new JButton(steam);
        b_tienda1.setBorder(Bordes.button_empty_border);
        b_tienda1.setOpaque(false);
        b_tienda1.setContentAreaFilled(false);
        b_tienda1.setBorderPainted(false);
        b_tienda1.setPreferredSize(new Dimension(steam.getIconWidth() + 5, info.getHeight()));
        b_tienda1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        c.gridx = 7;
        c.gridy = 1;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weightx = 0.1;
        informacion.add(b_tienda1, c);
        
        ImageIcon epic = new ImageIcon("src/images/epic.png");
        JButton b_tienda2 = new JButton(epic);
        b_tienda2.setBorder(Bordes.button_empty_border);
        b_tienda2.setOpaque(false);
        b_tienda2.setContentAreaFilled(false);
        b_tienda2.setBorderPainted(false);
        b_tienda2.setPreferredSize(new Dimension(epic.getIconWidth() + 5, info.getHeight()));
        b_tienda2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        c.gridx = 8;
        c.gridy = 1;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weightx = 0.1;
        informacion.add(b_tienda2, c);
        
        ImageIcon ps = new ImageIcon("src/images/ps.png");
        JButton b_tienda3 = new JButton(ps);
        b_tienda3.setBorder(Bordes.button_empty_border);
        b_tienda3.setOpaque(false);
        b_tienda3.setContentAreaFilled(false);
        b_tienda3.setBorderPainted(false);
        b_tienda3.setPreferredSize(new Dimension(ps.getIconWidth() + 5, info.getHeight()));
        b_tienda3.setCursor(new Cursor(Cursor.HAND_CURSOR));
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
        this.calification = DataManager.getRateMean(game);
        Recuadro recuadro = new Recuadro(this.calification);
        informacion.add(recuadro, c);

        JPanel resume_reviews = getResumeReviews(this.calification, bundleText);

        c.gridx = 1;
        c.gridy = 2;
        c.gridheight = 1;
        c.gridwidth = 6;
        c.weightx = 0.5;
        informacion.add(resume_reviews, c);


        /********************************************/
        /* Boton para hacer review                  */
        /********************************************/
        this.buttonReviews = new JButton(bundleText.getString("Texto_escribir_review"));
        this.buttonReviews.setBackground(Colores.cadet_gray);
        this.buttonReviews.setBorder(Bordes.black_border);
        this.buttonReviews.setForeground(Colores.rising_black);
        this.buttonReviews.setCursor(new Cursor(Cursor.HAND_CURSOR));
        c.gridx = 7;
        c.gridy = 2;
        c.gridheight = 1;
        c.gridwidth = 3;
        c.weightx = 0.5;
        informacion.add(this.buttonReviews, c);

        if(this.views.get("review" + this.gameName) == null)
            this.views.put("review" + this.gameName, new Review(bundleText, this.gameName, this.parentPanel, this.views));

        this.buttonReviews.addActionListener(new FocusPanelGameListener(parentPanel, this, this.views.get("review" + this.gameName), BorderLayout.CENTER));
        
        return informacion;
    }

    /**
     * Crea y devuelve un panel que resume las calificaciones y comentarios de los usuarios sobre el juego.
     * 
     * @param calification La calificación promedio del juego.
     * @return Un JPanel que resume las calificaciones y comentarios de los usuarios.
     */
    private JPanel getResumeReviews(Double calification, ResourceBundle bundleText){
        JPanel resume_reviews = new JPanel(new GridLayout(1,1));

        //resume_reviews.setPreferredSize(new Dimension(350, 48));
        resume_reviews.setBorder(Bordes.black_border);

        if(calification < 5.0){
            resume_reviews.setBackground(Colores.light_red);
            this.linea = new JLabel("<html><div style='text-align: center;'>" + bundleText.getString("Texto_mayormente_negativas") + "</div></html>");
            this.linea.setFont(new Font(this.linea.getFont().getFontName(), Font.BOLD, 9));
            this.linea.setHorizontalAlignment(SwingConstants.CENTER);
            resume_reviews.add(this.linea);
        }else if(calification < 7.0){
            resume_reviews.setBackground(Colores.naples_yellow);
            this.linea = new JLabel("<html><div style='text-align: center;'>" + bundleText.getString("Texto_mixtas") + "</div></html>");
            this.linea.setFont(new Font(this.linea.getFont().getFontName(), Font.BOLD, 9));
            this.linea.setHorizontalAlignment(SwingConstants.CENTER);
            resume_reviews.add(this.linea);
        }else{
            resume_reviews.setBackground(Colores.aquamarine);
            this.linea = new JLabel("<html><div style='text-align: center;'>" + bundleText.getString("Texto_mayormente_positivas") + "</div></html>");
            this.linea.setFont(new Font(this.linea.getFont().getFontName(), Font.BOLD, 9));
            this.linea.setHorizontalAlignment(SwingConstants.CENTER);
            resume_reviews.add(this.linea);
        }

        return resume_reviews;
    }

    /**
     * Crea y devuelve un panel que contiene las reseñas de los usuarios sobre el juego.
     * 
     * @return Un JPanel que contiene las reseñas de los usuarios sobre el juego.
     */
    private JPanel createReviews(ResourceBundle bundleText){
        GridLayout gl = new GridLayout(0, 1);
        gl.setVgap(10);
        JPanel reviews = new JPanel(gl);

        this.reviewlist = (JSONArray) game.get("reviews");

        for(Object reviewObject : this.reviewlist){
            JSONObject reviewJsonObject = (JSONObject) reviewObject;

            JPanel linea = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));

            Long calificacion = (Long) reviewJsonObject.get("calificacion");
            Recuadro recuadro = new Recuadro(calificacion);
            linea.add(recuadro);

            JPanel review = new JPanel(new GridLayout(1, 1));
            JLabel comentario = new JLabel("<html><div style='text-align: center; margin: 10px;'>" + bundleText.getString((String) reviewJsonObject.get("comentario")) + "</div></html>");
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

    public void updateTexts(ResourceBundle bundleText) {
        this.descripcionLabel.setText("<html><div style='text-align: center; margin: 15px;'>" + bundleText.getString((String) this.game.get("descripcion")) + "</div></html>");
        this.infoLabel.setText("<html><div style='margin: 10px'>" + bundleText.getString("Texto_fecha_lanzamiento") +": " + this.game.get("fecha_lanzamiento") + "<br/>" + bundleText.getString("Texto_desarrollador") + ": " + this.game.get("desarrollador") + "<div/></html>");
        
        if (this.calification < 5.0)
            this.linea.setText("<html><div style='text-align: center;'>" + bundleText.getString("Texto_mayormente_negativas") + "</div></html>");
        else if (this.calification < 7.0)
            this.linea.setText("<html><div style='text-align: center;'>" + bundleText.getString("Texto_mixtas") + "</div></html>");
        else
            this.linea.setText("<html><div style='text-align: center;'>" + bundleText.getString("Texto_mayormente_positivas") + "</div></html>");

        this.buttonReviews.setText(bundleText.getString("Texto_escribir_review"));

        this.reviews.removeAll();

        for(Object reviewObject : this.reviewlist){
            JSONObject reviewJsonObject = (JSONObject) reviewObject;

            JPanel linea = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));

            Long calificacion = (Long) reviewJsonObject.get("calificacion");
            Recuadro recuadro = new Recuadro(calificacion);
            linea.add(recuadro);

            JPanel review = new JPanel(new GridLayout(1, 1));
            JLabel comentario = new JLabel("<html><div style='text-align: center; margin: 10px;'>" + bundleText.getString((String) reviewJsonObject.get("comentario")) + "</div></html>");
            comentario.setHorizontalAlignment(SwingConstants.CENTER);
            comentario.setForeground(Colores.rising_black);
            review.add(comentario);
            review.setBackground(Colores.platinum);
            review.setForeground(Colores.rising_black);
            review.setBorder(Bordes.black_border);
            review.setPreferredSize(new Dimension(1150, 47));
            linea.add(review);

            this.reviews.add(linea);
        }

        revalidate();
        repaint();
    }
}
