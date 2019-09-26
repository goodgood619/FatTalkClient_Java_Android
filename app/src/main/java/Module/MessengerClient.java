package Module;

import Model.TcpMessage;
import Model.TcpMessage.Command;
import Service.MessangerService;

import java.util.*;
@SuppressWarnings("serial") //With this annotation we are going to hide compiler warnings
public class MessengerClient extends TcpClient{
    private static MessengerClient messengerClient  = null;

    static {
        try {
            messengerClient = new MessengerClient();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MessangerService messangerService;
    private JsonHelper jsonHelper = null;
    public Set<String> checkdelegate = null;
    private MessengerClient() throws Exception {
        super();
        messangerService = new MessangerService();
       jsonHelper = new JsonHelper();
       checkdelegate = new HashSet<>();
        // TODO Auto-generated constructor stub
    }
    public static MessengerClient getMessengerClient(){
        return messengerClient;
    }
    public boolean requestLogin(String id,String password){
        TcpMessage message = new TcpMessage();
        message.command = Command.login;
        message.message = jsonHelper.logininfo(id,password);
        return Send(message);
    }
    public boolean requestLogout(String Usernickname){
        TcpMessage message = new TcpMessage();
        message.command = Command.logout;
        message.message = jsonHelper.nicknamecheckinfo(Usernickname);
        return Send(message);
    }
    public void Response(TcpMessage message) throws Exception {
        messangerService.Responsetomethod(message);
    }


}
