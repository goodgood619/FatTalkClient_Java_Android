package ViewModel;

import androidx.lifecycle.ViewModel;

import Model.TcpMessage;
import Service.ImessangerTest;
import Service.MessangerService;

public class PlusfriendViewModel extends ViewModel {

    public PlusfriendViewModel(MessangerService messangerService){
        messangerService.addtomethod(new ImessangerTest() {
            @Override
            public void ResponseMessage(TcpMessage message) {

            }
        });
    }


}
