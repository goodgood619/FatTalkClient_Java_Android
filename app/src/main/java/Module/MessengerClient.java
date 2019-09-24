package Module;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Consumer;
import java.util.logging.Handler;

import javax.security.auth.callback.Callback;

import Model.TcpMessage;
import Model.TcpMessage.Command;
import Service.Imessanger;
import Service.ImessangerQueue;
import Service.ImessangerTest;
import Service.MessangerService;

import java.util.*;
@SuppressWarnings("serial") //With this annotation we are going to hide compiler warnings
public class MessengerClient extends TcpClient{

    public MessangerService messangerService;
    private JsonHelper jsonHelper = null;
    public MessengerClient() throws Exception{

    }
    public MessengerClient(MessangerService messangerService) throws Exception {
        super();
        this.messangerService = messangerService;
        // TODO Auto-generated constructor stub
    }
    public boolean requestLogin(String id,String password){
        if(jsonHelper == null) jsonHelper = new JsonHelper();
        TcpMessage message = new TcpMessage();
        message.command = Command.login;
        message.message = jsonHelper.logininfo(id,password);
        return Send(message);
    }
    public boolean requestLogout(String Usernickname){
        if(jsonHelper == null) jsonHelper = new JsonHelper();
        TcpMessage message = new TcpMessage();
        message.command = Command.logout;
        message.message = jsonHelper.nicknamecheckinfo(Usernickname);
        return Send(message);
    }
    public void Response(TcpMessage message) throws Exception {
        messangerService.Responsetomethod(message);
    }

}
