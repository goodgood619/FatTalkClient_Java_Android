package ViewModel;

import android.provider.ContactsContract;
import android.view.View;

import androidx.lifecycle.ViewModel;

import Model.TcpMessage;
import Service.ImessangerTest;
import Service.MessangerService;

public class ChatViewModel extends ViewModel {

    public ChatViewModel(MessangerService messangerService){
        messangerService.addtomethod(new ImessangerTest() {
            @Override
            public void ResponseMessage(TcpMessage message) {

            }
        });
    }


}
