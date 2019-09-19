package Service;

import android.os.Handler;
import android.telecom.Call;

import androidx.lifecycle.ViewModel;

import java.util.function.Consumer;
import java.util.function.Function;

import javax.security.auth.callback.Callback;

import Model.TcpMessage;
import Module.MessengerClient;

public interface Imessanger<MessengerClient>{
    MessengerClient GetMessenger();
}
