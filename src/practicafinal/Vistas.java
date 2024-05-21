package practicafinal;

import java.util.HashMap;
import java.util.ResourceBundle;

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
    public static HashMap<String,JPanel> create_vistas(JPanel parentPanel, ResourceBundle bundleText){
        

        HashMap<String,JPanel> views = new HashMap<String,JPanel>();

        views.put("inicio", new Inicio(parentPanel, views, bundleText));
        views.put("juegos", new Juegos(bundleText.getString("Texto_juegos"), parentPanel, views, true, bundleText));
        views.put("categorias", new Categorias(bundleText.getString("Texto_categorias"), parentPanel, views, bundleText));
        views.put("review", new Review());

        return views;
    }

}
