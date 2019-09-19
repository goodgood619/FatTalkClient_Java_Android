package ViewModel;

import androidx.lifecycle.ViewModel;

import Model.TcpMessage;
import Service.ImessangerTest;
import Service.MessangerService;

public class FindlogininfoViewModel extends ViewModel {
    public FindlogininfoViewModel(MessangerService messangerService){
        messangerService.addtomethod(new ImessangerTest() {
            @Override
            public void ResponseMessage(TcpMessage message) {

            }
        });
    }
}
