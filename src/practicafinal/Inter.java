package practicafinal;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 
 * La clase Inter gestiona la localización de la aplicación mediante un singleton.
 * Proporciona métodos para obtener y establecer la configuración regional actual y para obtener el ResourceBundle correspondiente.
 * 
 */
public class Inter {
    private static Inter instance;
    private Locale currentLocale;

    /**
     * Constructor privado para implementar el patrón Singleton.
     * Inicializa la configuración regional actual con la configuración regional predeterminada del sistema.
     */
    private Inter() {
        this.currentLocale = Locale.getDefault();
        // this.currentLocale = new Locale("en", "GB");
    }

    /**
     * Devuelve la instancia única de la clase Inter.
     * Si la instancia aún no ha sido creada, la crea.
     *
     * @return La instancia única de la clase Inter.
     */
    public static Inter getInstance() {
        if (instance == null) {
            instance = new Inter();
        }
        return instance;
    }

    /**
     *
     * Establece la configuración regional actual.
     *
     * @param currentLocale La nueva configuración regional.
     */
    public void setCurrentLocale(Locale currentLocale) {
        this.currentLocale = currentLocale;
    }


    /**
     * Obtiene el ResourceBundle correspondiente a la configuración regional actual.
     * 
     * @return El ResourceBundle correspondiente a la configuración regional actual.
     */
    public ResourceBundle getBundle() {
        return ResourceBundle.getBundle("bundles.Bundle", this.currentLocale);
    }
}
