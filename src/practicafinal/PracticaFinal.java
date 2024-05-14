/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practicafinal;

import javax.swing.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import practicafinal.componentes.Barra_superior;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author mayumar
 */
public class PracticaFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame jf = new JFrame("LevelUp");
        
        JScrollPane scrollPane = new JScrollPane();
        jf.add(scrollPane);

        JPanel mainPanel = new JPanel(new BorderLayout());
        scrollPane.setViewportView(mainPanel); // Establecer el JScrollPane como vista del mainPanel

        //Panel con margenes
        JPanel panel = new JPanel(new BorderLayout());
        mainPanel.add(panel, BorderLayout.CENTER);

        //Margenes
        JPanel leftMargin = new JPanel();
        leftMargin.setPreferredSize(new Dimension(100, 1));
        panel.add(leftMargin, BorderLayout.WEST);

        JPanel rightMargin = new JPanel();
        rightMargin.setPreferredSize(new Dimension(100, 1));
        panel.add(rightMargin, BorderLayout.EAST);

        JPanel topMargin = new JPanel();
        topMargin.setPreferredSize(new Dimension(1, 60));
        panel.add(topMargin, BorderLayout.NORTH);

        //Vistas
        ArrayList<JPanel> views = Vistas.create_vistas(panel);
        
        //Inicio como vista por defecto
        views.get(views.size()-1).setVisible(true);
        panel.add(views.get(views.size()-1));

        //Barra superior
        Barra_superior barra_superior = new Barra_superior(panel, views, jf);
        mainPanel.add(barra_superior, BorderLayout.NORTH);
        
        jf.setSize(1452, 779);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);

        try {
            DataManager dataManager = new DataManager("src/data.json");
            ArrayList<JSONArray> games = dataManager.getAllGames();

            for(JSONArray gameList : games) {
                for (Object game : gameList) {
                    JSONObject jsonGame = (JSONObject) game;
                    System.out.println(jsonGame.get("nombre"));
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    
}
