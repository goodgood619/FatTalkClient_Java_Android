package ViewModel;

import android.view.View;

import androidx.lifecycle.ViewModel;

import Model.TcpMessage;
import Service.ImessangerTest;
import Service.MessangerService;

public class ChangeroomnameViewModel extends ViewModel {
    public ChangeroomnameViewModel(MessangerService messangerService){
        messangerService.addtomethod(new ImessangerTest() {
            @Override
            public void ResponseMessage(TcpMessage message) {

            }
        });
    }


}
