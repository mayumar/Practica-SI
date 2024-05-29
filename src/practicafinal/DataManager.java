package practicafinal;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * La clase DataManager se encarga de gestionar y proporcionar acceso a los datos almacenados en un archivo JSON.
*/
public class DataManager {
    private JSONObject data;

    /**
     * Crea una instancia de DataManager y carga los datos desde el archivo JSON especificado.
     *
     * @param filePath   La ruta del archivo JSON que contiene los datos.
     * @throws Exception Si ocurre un error al leer o parsear el archivo JSON.
    */
    public DataManager(String filePath) throws Exception {
        JSONParser parser = new JSONParser();
        this.data = (JSONObject) parser.parse(new FileReader(filePath));
    }

    /**
     * Obtiene los datos completos cargados desde el archivo JSON.
     *
     * @return Un objeto JSONObject que contiene todos los datos.
    */
    public JSONObject getData() {
        return this.data;
    }

    /**
     * Obtiene una lista de juegos de una categoría específica.
     *
     * @param category La categoría de la cual se desean obtener los juegos.
     * @return Un ArrayList<JSONObject> que contiene los juegos de la categoría especificada.
    */
    public ArrayList<JSONObject> getGamesFromCategory(String category) {
        JSONArray datalist = (JSONArray) this.data.get(category);
        ArrayList<JSONObject> result = new ArrayList<JSONObject>();

        for(Object o : datalist){
            result.add((JSONObject) o);
        }

        return result;
    }

    /**
     * Obtiene un conjunto de todas las categorías disponibles en los datos.
     *
     * @return Un conjunto de cadenas que representan todas las categorías.
    */
    public Set<String> getAllCategories() {
        Set<String> categories = new HashSet<>();
        for (Object key : this.data.keySet()) {
            if (key instanceof String) {
                categories.add((String) key);
            }
        }
        return categories;
    }

    /**
     * Obtiene una lista de todos los juegos disponibles en todas las categorías.
     *
     * @return Una lista de objetos JSONObject, cada uno representando un juego.
    */
    public ArrayList<JSONObject> getAllGames() {
        ArrayList<JSONObject> games = new ArrayList<JSONObject>();
        Set<String> categorias = this.getAllCategories();

        for(String cat : categorias) {
            JSONArray gameList = (JSONArray) this.getData().get(cat);
            for (Object game : gameList) {
                games.add((JSONObject)game);
            }
        }

        return games;
    }

    /**
     * Obtiene los datos de un juego específico por su nombre.
     *
     * @param name El nombre del juego que se desea buscar.
     * @return Un objeto JSONObject que contiene los datos del juego, o null si no se encuentra.
    */
    public JSONObject getGameFromName(String name) {
        ArrayList<JSONObject> games = this.getAllGames();

        JSONObject game = null;

        for(Object gameListObject : games) {
            JSONObject gameList = (JSONObject) gameListObject;
            if (gameList.get("nombre").equals(name))
                game = gameList;
        }

        return game;
    }

    public static double getRateMean(JSONObject game) {
        JSONArray gameReviews = (JSONArray) game.get("reviews");
        double sum = 0.0;
        
        for (Object review : gameReviews) {
            JSONObject reviewJSON = (JSONObject) review;
            sum += (long) reviewJSON.get("calificacion");
        }

        double mean = sum / gameReviews.size();

        return Math.round(mean * 100.0) / 100.0;
    }
}
