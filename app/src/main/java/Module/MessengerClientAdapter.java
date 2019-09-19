package Module;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class MessengerClientAdapter implements JsonSerializer<TcpClient>, JsonDeserializer<TcpClient> {
    private static final String Classname = "CLASSNAME";
    private static final String Instance = "INSTANCE";
    @Override
    public TcpClient deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        JsonPrimitive prim = (JsonPrimitive) jsonObject.get(Classname);
        String classname = prim.getAsString();
        Class<?> klass = null;
        try {
            klass = Class.forName(classname);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new JsonParseException(e.getMessage());
        }
        return context.deserialize(jsonObject.get(Instance), klass);
    }

    @Override
    public JsonElement serialize(TcpClient src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        String classname = src.getClass().getName();
        jsonObject.addProperty(Classname,classname);
        JsonElement elem = context.serialize(src);
        jsonObject.add(Instance,elem);
        return jsonObject;
    }

}
