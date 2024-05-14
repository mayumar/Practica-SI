package practicafinal;

import java.io.FileReader;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataManager {
    private JSONObject data;

    public DataManager(String filePath) throws Exception {
        JSONParser parser = new JSONParser();
        this.data = (JSONObject) parser.parse(new FileReader(filePath));
    }

    public JSONObject getData() {
        return this.data;
    }

    public JSONArray getGamesFromCategory(String category) {
        return (JSONArray) this.data.get(category);
    }

    public ArrayList<JSONObject> getAllGames() {
        ArrayList<JSONObject> games = new ArrayList<>();
        String categorias[] = {
            "fps",
            "mundo_abierto",
            "terror",
            "indie",
            "supervivencia",
            "plataformas"
        };

        for(String cat : categorias) {
            JSONArray gameList = (JSONArray) this.getData().get(cat);
            for (Object game : gameList) {
                games.add((JSONObject) game);
            }
        }

        return games;
    }

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
