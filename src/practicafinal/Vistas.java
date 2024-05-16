package practicafinal;

import java.util.HashMap;

import javax.swing.*;

import practicafinal.paginas.*;

/**
 * La clase Vistas se encarga de crear y gestionar un conjunto de vistas (JPanels) para una aplicación.
*/
public class Vistas{
    /**
     * Crea un conjunto de vistas y las asocia con sus nombres clave en un HashMap.
     *
     * @param parentPanel El panel padre al que se añadirán las vistas.
     * @return Un HashMap que contiene las vistas asociadas a sus nombres clave.
    */
    public static HashMap<String,JPanel> create_vistas(JPanel parentPanel){

        HashMap<String,JPanel> views = new HashMap<String,JPanel>();

        views.put("inicio", new Inicio(parentPanel, views));
        views.put("juegos", new Juegos("Juegos", parentPanel, views, true));
        views.put("categorias", new Categorias("Categorias", parentPanel, views));
        views.put("review", new Review());

        return views;
    }

}
