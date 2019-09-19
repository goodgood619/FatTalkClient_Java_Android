package Service;

import android.os.Handler;

import java.util.function.Consumer;
import java.util.function.Function;

import Model.TcpMessage;
import Module.MessengerClient;
@SuppressWarnings("serial") //With this annotation we are going to hide compiler warnings
public class MessangerService {
    private ImessangerQueue imessangerQueue;

    public MessangerService(){
        imessangerQueue = new ImessangerQueue();
    }

    public void addtomethod(ImessangerTest imessangerTest){imessangerQueue.addMethod(imessangerTest);}
    public void removetomethod(ImessangerTest imessangerTest){imessangerQueue.deleteMethod(imessangerTest);}
    public void Responsetomethod(TcpMessage message){
        imessangerQueue.ResponseMethod(message);
    }
}
