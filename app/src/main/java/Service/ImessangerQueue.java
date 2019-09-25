package Service;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Model.TcpMessage;

public class ImessangerQueue implements Serializable {
    private List<ImessangerTest> testList;
    public ImessangerQueue(){
        testList = new ArrayList<>();
    }

    public void addMethod(ImessangerTest imessangerTest){testList.add(imessangerTest);}
    public void deleteMethod(ImessangerTest imessangerTest){testList.remove(imessangerTest);}
    public void ResponseMethod(TcpMessage message){
        for(ImessangerTest imessangerTest : testList){
            imessangerTest.ResponseMessage(message);
        }
    }
}
