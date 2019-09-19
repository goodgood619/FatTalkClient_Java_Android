package Module;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class JsonParser {
    private JSONParser parser;
    private JSONObject jsonObject;
    public JsonParser(String data) throws ParseException{
        parser = new JSONParser();
        jsonObject = (JSONObject)parser.parse(data);
    }

    public String GetstringValue(String name) {
        String s = "";
        try {
            s = (String)jsonObject.get(name);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return s;
    }
    public String[] getstringArrayValue(String name) {
        String[] array = null;
        try {
            JSONArray jsonArray = (JSONArray)jsonObject.get(name);
            int cnt = jsonArray.size();
            array = new String[cnt];
            for(int i=0 ; i<cnt ; i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                array[i] = (String)jsonObject.get(null);
            }
        }
        catch(Exception e) {

        }
        return array;
    }
}
