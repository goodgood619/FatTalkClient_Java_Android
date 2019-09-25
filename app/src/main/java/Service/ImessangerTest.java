package Service;

import android.os.Parcelable;

import java.io.Serializable;

import Model.TcpMessage;

public interface ImessangerTest extends Serializable {
    void ResponseMessage(TcpMessage message);
}
