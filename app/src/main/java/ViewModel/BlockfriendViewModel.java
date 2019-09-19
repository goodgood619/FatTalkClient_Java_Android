package ViewModel;

import androidx.lifecycle.ViewModel;

import Model.TcpMessage;
import Service.ImessangerTest;
import Service.MessangerService;

public class BlockfriendViewModel extends ViewModel {
    public BlockfriendViewModel(MessangerService messangerService){
        messangerService.addtomethod(new ImessangerTest() {
            @Override
            public void ResponseMessage(TcpMessage message) {

            }
        });
    }


}
