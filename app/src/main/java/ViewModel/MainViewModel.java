package ViewModel;

import android.view.View;

import androidx.lifecycle.ViewModel;

import Model.TcpMessage;
import Service.ImessangerTest;
import Service.MessangerService;

public class MainViewModel extends ViewModel {

    public MainViewModel(MessangerService messangerService){
        messangerService.addtomethod(new ImessangerTest() {
            @Override
            public void ResponseMessage(TcpMessage message) {
                switch (message.command){
                    case Removefriend:
                        // show to View
                        break;
                    case Refresh:
                        // show to View
                        break;
                    case Makechat:
                        // show to View
                        break;
                    case ReceiveJoinchat:
                        // show to View
                        break;

                }
            }
        });
    }

    
}
