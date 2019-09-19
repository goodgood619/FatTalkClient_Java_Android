package Model;
import java.util.*;

import com.google.common.base.Utf8;

import java.nio.ByteBuffer;
import java.io.*;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
public class TcpMessage {
    public Command command;
    public int tempcommand;
    public int check;
    public String message;
    public int usernumber;
    public int friendcount;
    public int chatnumber;
    public TcpMessage() {
        command = Command.Null;
        check = 0;
        message = "";
        usernumber = 0;
        friendcount = 0;
        chatnumber = 0;
    }

    public TcpMessage(ByteBuffer buffer) throws Exception{

        buffer.order(ByteOrder.BIG_ENDIAN);
        byte[] receive = buffer.array();
        tempcommand = Model.Endian.getBigEndian(receive,0);
        command = Command.valueof(tempcommand);
        check = Model.Endian.getBigEndian(receive,4);
        usernumber = Model.Endian.getBigEndian(receive, 8);
        friendcount = Model.Endian.getBigEndian(receive, 12);
        chatnumber = Model.Endian.getBigEndian(receive, 16);
        int melength = Model.Endian.getBigEndian(receive, 20);
        if(melength >0) message = new String(receive, 24, melength,"UTF-8");


    }
    public byte[] tobytedata() throws Exception{
        ByteBuffer buffer = ByteBuffer.allocate(32000);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        int command1 = command.getValue();
        buffer.putInt(command1);
        buffer.putInt(check);
        buffer.putInt(usernumber);
        buffer.putInt(friendcount);
        buffer.putInt(chatnumber);
        buffer.putInt(Utf8.encodedLength(message));
        buffer.put(message.getBytes("UTF-8"));
        return buffer.array();
    }
    public enum Command{
        Null(0),login(1),logout(2),Join(3),Idcheck(4),Findid(5),Makechat(6),Outchat(7),Joinchat(8),Refresh(9),Plusfriend(10),
        Removefriend(11),Sendchat(12),Nicknamecheck(13),ReceiveJoinchat(14),Blockfriend(15),NotBlockfriend(16),Refreshchatnickarray(17),
        Changeroomname(18);
        private final int value;
        private static Map<Object, Object> map = new HashMap<>();
        private Command(int value) {
            this.value = value;
        }
        static {
            for(Command command : Command.values()) {
                map.put(command.value,command);
            }
        }
        public static Command valueof(int value) {
            return (Command)map.get(value);
        }
        public int getValue() {
            return value;
        }
    }

}
