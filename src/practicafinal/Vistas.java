package practicafinal;

import java.util.HashMap;
import java.util.ResourceBundle;

import javax.swing.*;

import practicafinal.paginas.*;

/**
 * La clase Vistas se encarga de crear y gestionar un conjunto de vistas (JPanels) para una aplicación.
 * Proporciona un método estático para inicializar y asociar diferentes vistas con claves específicas en un HashMap.
*/
public class Vistas{
    /**
     * Crea un conjunto de vistas y las asocia con sus nombres clave en un HashMap.
     * Este método inicializa varias vistas (JPanel) específicas de la aplicación, 
     * las configura adecuadamente y las agrega a un HashMap con sus respectivos nombres clave.
     *
     * @param parentPanel El panel padre al que se añadirán las vistas.
     * @param bundleText  El ResourceBundle que contiene los textos necesarios para internacionalización.
     * @return Un HashMap que contiene las vistas asociadas a sus nombres clave.
    */
    public static HashMap<String,JPanel> create_vistas(JPanel parentPanel, ResourceBundle bundleText){
        HashMap<String,JPanel> views = new HashMap<String,JPanel>();

        views.put("inicio", new Inicio(parentPanel, views, bundleText));
        views.put("juegos", new Juegos("Juegos", parentPanel, views, true, bundleText));
        views.put("categorias", new Categorias(bundleText.getString("Texto_categorias"), parentPanel, views, bundleText));

        return views;
    }
}
