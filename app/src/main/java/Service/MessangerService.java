package Service;

import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.function.Consumer;
import java.util.function.Function;

import Model.TcpMessage;
import Module.MessengerClient;
@SuppressWarnings("serial") //With this annotation we are going to hide compiler warnings
public class MessangerService {
    private ImessangerQueue imessangerQueue;
    //private LinkedHashMap linkedHashMap;
    public MessangerService(){
        imessangerQueue = new ImessangerQueue();
        //linkedHashMap = new LinkedHashMap();
    }

    public void addtomethod(ImessangerTest imessangerTest){imessangerQueue.addMethod(imessangerTest);}
    public void removetomethod(ImessangerTest imessangerTest){imessangerQueue.deleteMethod(imessangerTest);}
    public void Responsetomethod(TcpMessage message){
        imessangerQueue.ResponseMethod(message);
    }


}
