package Module;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import java.io.Serializable;
import java.util.HashMap;
import java.util.*;
public class JsonHelper implements Serializable {
    private JsonParser jsonParser;
    private Jsonname jsonname;
    public JsonHelper(){
        jsonname = new Jsonname();
    }

    public String logininfo(String id,String password){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(jsonname.ID,id);
        jsonObject.put(jsonname.Password,password);
        return jsonObject.toString();
    }

    public String passwordcheckinfo(String password){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(jsonname.Password,password);
        return jsonObject.toString();
    }
    public String idcheckinfo(String id){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(jsonname.ID,id);
        return jsonObject.toString();
    }
    public String plusidcheckinfo(String plusid,String id){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(jsonname.FID,plusid);
        jsonObject.put(jsonname.ID,id);
        return jsonObject.toString();
    }

    public String joininfo(String id,String password,String nickname,String phone) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(jsonname.ID,id);
        jsonObject.put(jsonname.Password,password);
        jsonObject.put(jsonname.Nickname,nickname);
        jsonObject.put(jsonname.Phone,phone);
        return jsonObject.toString();
    }
    public String nicknamecheckinfo(String nickname){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(jsonname.Nickname,nickname);
        return jsonObject.toString();
    }
    public String Findidphoneinfo(String id,String phone) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(jsonname.ID,id);
        jsonObject.put(jsonname.Phone,phone);
        return jsonObject.toString();
    }


    public HashMap<String,String> getlogininfo(String data) throws Exception{
        HashMap<String,String> HashMap = new HashMap<String,String>();
        jsonParser = new JsonParser(data);
        HashMap.put(jsonname.ID,jsonParser.GetstringValue(jsonname.ID));
        HashMap.put(jsonname.Password,jsonParser.GetstringValue(jsonname.Password));
        return HashMap;
    }
    public HashMap<String,String> getidinfo(String data) throws Exception{
        HashMap<String,String> hashMap = new HashMap<String,String>();
        jsonParser = new JsonParser(data);
        hashMap.put(jsonname.ID,jsonParser.GetstringValue(jsonname.ID));
        return hashMap;
    }

    public HashMap<String,String> getnickinfo(String data) throws Exception{
        HashMap<String,String> hashMap = new HashMap<String,String>();
        jsonParser = new JsonParser(data);
        hashMap.put(jsonname.Nickname,jsonParser.GetstringValue(jsonname.Nickname));
        return hashMap;
    }

    public HashMap<String,String> getmessageinfo(String data) throws Exception{
        HashMap<String,String> hashMap = new HashMap<String,String>();
        jsonParser = new JsonParser(data);
        hashMap.put(jsonname.Message,jsonParser.GetstringValue(jsonname.Message));
        return hashMap;
    }

    public HashMap<String,String> getchangeroomnameinfo(String data) throws Exception{
        HashMap<String,String> hashMap = new HashMap<String,String>();
        jsonParser = new JsonParser(data);
        hashMap.put(jsonname.Roomname,jsonParser.GetstringValue(jsonname.Roomname));
        return hashMap;
    }

    public String[] getRefreshnickarray(String data) throws Exception{
        jsonParser = new JsonParser(data);
        String[] strings = jsonParser.getstringArrayValue("refreshnickarray");
        return strings;
    }

    public String[] getRefreshchatnickarray(String data) throws Exception{
        jsonParser = new JsonParser(data);
        String[] strings = jsonParser.getstringArrayValue("refreshchatnickarray");
        return strings;
    }
    public String deletenickinfo(String[] removenickarray,String nickname){
        JSONObject jsonObject = new JSONObject();
        JSONObject nickObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        jsonObject.put(jsonname.Nickname,nickname);
        for(int i = 0 ; i<removenickarray.length;i++){
            nickObject.put(null,removenickarray[i]);
        }
        jsonObject.put("deletenickarray",nickObject);
        return jsonObject.toString();
    }

    public String makechatnickinfo(String[] makechatarray,String nickname){
        JSONObject jsonObject = new JSONObject();
        JSONObject nickObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        jsonObject.put(jsonname.Nickname,nickname);
        for(int i=0;i<makechatarray.length;i++){
            nickObject.put(null,makechatarray[i]);
        }
        jsonObject.put("makechatarray",nickObject);
        return jsonObject.toString();
    }

    public String sendchatinfo(String message,String sendnickname){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(jsonname.Nickname,sendnickname);
        jsonObject.put(jsonname.Message,message);
        return jsonObject.toString();
    }

    public String sendjoinchatinfo(String id,String nickname){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(jsonname.ID,id);
        jsonObject.put(jsonname.Nickname,nickname);
        return jsonObject.toString();
    }


    public class Jsonname implements Serializable{
        public final String ID = "ID";
        public final String FID = "Fid";
        public final String Password = "Password";
        public final String Nickname = "Nickname";
        public final String Phone = "Phone";
        public final String Usernumber = "Usernumber";
        public final String Message = "Message";
        public final String Roomname = "Roomname";
    }
}

