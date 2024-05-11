package practicafinal;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DataManager {
    private JSONObject data;

    public DataManager(String filePath) throws FileNotFoundException, IOException, ParseException {
        JSONParser parser = new JSONParser();
        this.data = (JSONObject) parser.parse(new FileReader(filePath));
    }

    public JSONObject getData() {
        return this.data;
    }

    public JSONArray getGamesFromCategory(String category) {
        return (JSONArray) this.data.get(category);
    }

    public ArrayList<JSONArray> getAllGames() {
        ArrayList<JSONArray> games = new ArrayList<>();
        String categorias[] = {
            "fps",
            "mundo_abierto",
            "terror",
            "indie",
            "supervivencia",
            "plataformas"
        };

        for(String cat : categorias) {
            games.add(getGamesFromCategory(cat));
        }

        return games;
    }
}
