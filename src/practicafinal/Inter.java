package practicafinal;

import java.util.Locale;
import java.util.ResourceBundle;

public class Inter {
    public static ResourceBundle getBundle() {
        Locale currentLocale = Locale.getDefault();

        if (!(
            (currentLocale.getLanguage().equals("es") && currentLocale.getCountry().equals("ES")) || 
            (currentLocale.getLanguage().equals("en") && currentLocale.getCountry().equals("GB")
        ))) {
            currentLocale = new Locale("es", "ES");
        }

        currentLocale = new Locale("en", "GB");
        return ResourceBundle.getBundle("bundles.Bundle", currentLocale);
    }
}
