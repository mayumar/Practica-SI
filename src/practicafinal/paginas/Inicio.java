package practicafinal.paginas;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;

import org.json.simple.JSONObject;

import practicafinal.DataManager;
import practicafinal.componentes.*;

/**
 * La clase Inicio extiende JPanel y representa la vista inicial de la aplicación.
 * Esta vista incluye un título principal, un carrusel de juegos y una sección de juegos destacados.
*/
public class Inicio extends JPanel{
    /**
     * Crea un panel de inicio con un título, un carrusel de juegos y una sección de juegos destacados.
     *
     * @param parentPanel El panel padre que contiene el panel de inicio.
     * @param views Un HashMap que contiene las vistas de las diferentes secciones de la aplicación.
    */
    public Inicio(JPanel parentPanel, HashMap<String,JPanel> views){

        setLayout(new BorderLayout());

        add(new Titulo("EXPLORA, JUEGA, DECIDE: LA GUÍA DEFINITVA PARA GAMERS", true), BorderLayout.NORTH);

        // Crear los elementos del carrousel
        ArrayList<JButton> elements = new ArrayList<JButton>();
        
        // Lista de todos los juegos disponibles
        DataManager dataManager = null;

        try {
            dataManager = new DataManager("src/data.json");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        ArrayList<JSONObject> games = dataManager.getAllGames();
        
        for(int i = 0; i < 7; i ++) {
            elements.add(new Juego((String) games.get(i).get("nombre"), parentPanel, this, BorderLayout.CENTER, views));
        }

        // Crear el carrousel
        Carrousel carrousel = new Carrousel(elements, 5);

        JPanel contenido = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(30, 10, 30, 10);
        
        // Añadir el carrousel al panel
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 1;
        contenido.add(carrousel, c);
        
        //Titulo de destacados
        c.gridx = 0;
        c.gridy = 1;
        c.gridheight = 1;
        c.gridwidth = 1;
        contenido.add(new Titulo("DESTACADOS", false), c);

        FlowLayout fl = new FlowLayout();
        JPanel destacados = new JPanel(fl);

        for(int i = 0; i < 3; i++) {
            destacados.add(new Juego((String) games.get(i).get("nombre"), parentPanel, this, BorderLayout.CENTER, views));
        }

        c.gridx = 0;
        c.gridy = 2;
        c.gridheight = 1;
        c.gridwidth = 1;
        contenido.add(destacados, c);

        add(contenido, BorderLayout.CENTER);
    }
}
