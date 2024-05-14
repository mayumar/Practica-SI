package practicafinal.paginas;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;

import org.json.simple.JSONObject;

import practicafinal.DataManager;
import practicafinal.componentes.*;

public class Inicio extends JPanel{

    public Inicio(JPanel parentPanel, HashMap<String,JPanel> views){

        setLayout(new BorderLayout());

        add(new Titulo("EXPLORA, JUEGA, DECIDE: LA GUÍA DEFINITVA PARA GAMERS", true), BorderLayout.NORTH);

        // Crear los elementos del carrousel
        ArrayList<JButton> elements = new ArrayList<JButton>();
        
        // Lista de todos los juegos disponibles
        ArrayList<JSONObject> games = new ArrayList<JSONObject>();

        try {
            DataManager dataManager = new DataManager("src/data.json");
            games = dataManager.getAllGames();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for(int i = 0; i < 7; i ++) {
            elements.add(new Juego((String) games.get(i).get("nombre"), parentPanel, this, BorderLayout.CENTER, views));
        }

        // Crear el carrousel
        Carrousel carrousel = new Carrousel(elements, 5);

        JPanel contenido = new JPanel(new BorderLayout());
        
        // Añadir el carrousel al panel
        contenido.add(carrousel, BorderLayout.NORTH);
        
        //Titulo de destacados
        contenido.add(new Titulo("DESTACADOS", false), BorderLayout.CENTER);

        FlowLayout fl = new FlowLayout();
        JPanel destacados = new JPanel(fl);

        for(int i = 0; i < 3; i++) {
            destacados.add(new Juego((String) games.get(i).get("nombre"), parentPanel, this, BorderLayout.CENTER, views));
        }

        contenido.add(destacados, BorderLayout.SOUTH);

        add(contenido, BorderLayout.CENTER);
    }
}
