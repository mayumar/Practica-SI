package practicafinal;

import java.util.Locale;
import java.util.ResourceBundle;

public class Inter {
    private static Inter instance;
    private Locale currentLocale;

    private Inter() {
        this.currentLocale = Locale.getDefault();
    }

    public static Inter getInstance() {
        if (instance == null) {
            instance = new Inter();
        }
        return instance;
    }

    public void setCurrentLocale(Locale currentLocale) {
        this.currentLocale = currentLocale;
    }

    public ResourceBundle getBundle() {
        return ResourceBundle.getBundle("bundles.Bundle", this.currentLocale);
    }
}
