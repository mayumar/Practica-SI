package practicafinal;

import java.io.FileReader;
import java.util.ArrayList;
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
     * @param filePath La ruta del archivo JSON que contiene los datos.
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
     * @return Un JSONArray que contiene los juegos de la categoría especificada.
    */
    public JSONArray getGamesFromCategory(String category) {
        return (JSONArray) this.data.get(category);
    }

    /**
     * Obtiene un conjunto de todas las categorías disponibles en los datos.
     *
     * @return Un conjunto de cadenas que representan todas las categorías.
    */
    @SuppressWarnings("unchecked")
    public Set<String> getAllCategories() {
        return this.data.keySet();
    }

    /**
     * Obtiene una lista de todos los juegos disponibles en todas las categorías.
     *
     * @return Una lista de objetos JSONObject, cada uno representando un juego.
    */
    public ArrayList<JSONObject> getAllGames() {
        ArrayList<JSONObject> games = new ArrayList<>();
        Set<String> categorias = this.getAllCategories();

        for(String cat : categorias) {
            JSONArray gameList = (JSONArray) this.getData().get(cat);
            for (Object game : gameList) {
                games.add((JSONObject) game);
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

        for(JSONObject gameList : games) {
            if (gameList.get("nombre").equals(name))
                game = gameList;
        }

        return game;
    }
}
