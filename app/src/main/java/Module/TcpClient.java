package Module;
import android.util.Log;

import java.io.*;
import java.nio.*;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.Executors;

import Model.TcpMessage;
public abstract class TcpClient implements Serializable{
    private static AsynchronousSocketChannel asynchronousSocketChannel;
    private static AsynchronousChannelGroup channelGroup;
    public TcpClient() throws Exception{
        // CPU 코어 수만큼 스레드를 관리하는 스레드풀 생성하고 이것을 이용하느

        try {
            channelGroup = AsynchronousChannelGroup.withFixedThreadPool(
                    Runtime.getRuntime().availableProcessors(),
                    Executors.defaultThreadFactory()
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            asynchronousSocketChannel = AsynchronousSocketChannel.open(channelGroup);
        } catch (IOException e) {
            e.printStackTrace();
        }

        asynchronousSocketChannel.connect(new InetSocketAddress("10.0.2.2", 3300), asynchronousSocketChannel, new CompletionHandler<Void, AsynchronousSocketChannel>() {
            @Override
            public void completed(Void result, AsynchronousSocketChannel attachment) {
                // TODO Auto-generated method stub
                Log.d("TcpClient", "서버와 연결에 성공하였습니다");
                Receive(asynchronousSocketChannel);
            }

            @Override
            public void failed(Throwable exc, AsynchronousSocketChannel attachment) {
                // TODO Auto-generated method stub
                Log.d("TcpClient", "서버와 연결에 실패하였습니다.");
            }
        });
    }
    protected Boolean Send(TcpMessage message) {
        Boolean ok = true;
        // TODO Auto-generated method stub
        try {
            byte[] bytesend = message.tobytedata();
            ByteBuffer buffer = ByteBuffer.wrap(bytesend);
            asynchronousSocketChannel.write(buffer, null, new CompletionHandler<Integer, Object>() {

                @Override
                public void completed(Integer result, Object attachment) {
                    Log.d("TcpClient","Write 성공");
                }

                @Override
                public void failed(Throwable exc, Object attachment) {
                        Log.e("TcpClient","Write 실패 "+exc.toString());
                }
            });
            Log.d("TcpClient","메시지 보내기 성공");
            Log.e("TcpClient","아직 asynchronousSocketChannel이 열려있는가? "+asynchronousSocketChannel.isOpen());
        }
        catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            ok = false;
        }
        return ok;
    }
    private void Receive(AsynchronousSocketChannel asynchronousSocketChannel) {
        ByteBuffer receiveBuffer = ByteBuffer.allocate(32000);
        Log.d("TcpClient", "Receive진입");
        boolean connected = asynchronousSocketChannel.isOpen();
        if(connected) {
            asynchronousSocketChannel.read(receiveBuffer,asynchronousSocketChannel,new CompletionHandler<Integer,AsynchronousSocketChannel>() {

                @Override
                public void completed(Integer result, AsynchronousSocketChannel attachment) {
                    // TODO Auto-generated method stub
                    try {
                        Log.d("TcpClient","읽기 성공");
                        TcpMessage tcpMessage = new TcpMessage(receiveBuffer);
                        Response(tcpMessage);
                        receiveBuffer.flip();
                        asynchronousSocketChannel.read(receiveBuffer, asynchronousSocketChannel, this);
                    }
                    catch (Exception e) {
                        // TODO: handle exception
                        e.printStackTrace();
                    }
                }

                @Override
                public void failed(Throwable exc, AsynchronousSocketChannel attachment) {
                    // TODO Auto-generated method stub
                    Log.d("TcpClient","읽기 실패");
                }
            });
        }
    }
    abstract void Response(TcpMessage message) throws Exception;

}
