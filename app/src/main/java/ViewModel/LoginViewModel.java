package ViewModel;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import com.example.fattalkclient.FindUserInfoActivity;
import com.example.fattalkclient.JoinMemberActivity;
import com.example.fattalkclient.MainMenuViewActivity;

import java.util.HashMap;

import Model.TcpMessage;
import Module.JsonHelper;
import Module.MessengerClient;
import Service.ImessangerTest;
import Service.MessangerService;

public class LoginViewModel extends BaseObservable{ //BaseObservable이 @Bindable을 쓰기위한 필수조건
    private String id="";
    private String password = "";
    private Context context;
    @Bindable
    public String getId(){return id;}
    public void setId(String id){
        this.id = id;
        notifyPropertyChanged(BR.id);
    }
    @Bindable
    public String getPassword(){return password;}
    public void setPassword(String password){
        this.password = password;
        notifyPropertyChanged(BR.password);
    }
    private MessengerClient messengerClient = null;
    private MessangerService messangerService = null;
    public LoginViewModel(MessangerService messangerService,MessengerClient messengerClient,Context context){
        this.context = context;
        this.messengerClient = messengerClient;
        this.messangerService = messangerService;
        if(messengerClient.checkdelegate.contains("LoginViewModel")== false) {
            messengerClient.checkdelegate.add("LoginViewModel");
            messangerService.addtomethod(new ImessangerTest() {
                @Override
                public void ResponseMessage(TcpMessage message) {
                    switch (message.command) {
                        case login:
                            Validate(message, message.check, message.usernumber, message.message);
                            break;
                    }
                }
            });
        }
    }
    public void Validate(TcpMessage message,int check,int usernumber,String nickname){
        LoginViewAsyncTask loginViewAsyncTask = new LoginViewAsyncTask();
        loginViewAsyncTask.execute(message);
    }

    public class LoginViewAsyncTask extends AsyncTask<TcpMessage,Void,TcpMessage>{

        @Override
        protected TcpMessage doInBackground(TcpMessage... tcpMessages) {
            return tcpMessages[0];
        }

        @Override
        protected void onPostExecute(TcpMessage message){
            switch (message.check){
                case 0:
                    Toast.makeText(context,"ID가 틀렸습니다.",Toast.LENGTH_LONG).show();
                    setId("");
                    setPassword("");
                    break;
                case 1:
                    Toast.makeText(context,"비밀번호가 틀렸습니다.",Toast.LENGTH_LONG).show();
                    setId("");
                    setPassword("");
                    break;
                case 2:
                    Toast.makeText(context,"뚱톡에 오신걸 환영합니다",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(context, MainMenuViewActivity.class);
                    JsonHelper jsonHelper = new JsonHelper();
                    HashMap<String,String> hashMap = null;
                    try {
                        hashMap = jsonHelper.getnickinfo(message.message);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    String nickname = hashMap.get("Nickname");
                    intent.putExtra("Nickname",nickname);
                    setId("");
                    setPassword("");
                    context.startActivity(intent);
                    break;
                case 3:
                    Toast.makeText(context,"ID 그리고 비밀번호 둘다 틀렸습니다",Toast.LENGTH_LONG).show();
                    setId("");
                    setPassword("");
                    break;
                case 4:
                    Toast.makeText(context,"현재 이 계정은 중복 로그인 되었습니다.",Toast.LENGTH_LONG).show();
                    setId("");
                    setPassword("");
                    break;
            }
        }
    }

    public void LoginClick() {
      messengerClient.requestLogin(id,password);
    }
    public void JoinMemberClick(){
        JoinViewAsyncTask joinViewAsyncTask = new JoinViewAsyncTask();
        joinViewAsyncTask.execute();
    }
    public class JoinViewAsyncTask extends AsyncTask<Void,Void,Integer>{

        @Override
        protected Integer doInBackground(Void... voids) {
            return 0;
        }

        @Override
        protected void onPostExecute(Integer result){
            Intent intent = new Intent(context, JoinMemberActivity.class);
            context.startActivity(intent);
        }

    }

    public void FindMemberClick(){
        FindUserViewAsyncTask findUserViewAsyncTask = new FindUserViewAsyncTask();
        findUserViewAsyncTask.execute();
    }
    public class FindUserViewAsyncTask extends AsyncTask<Void,Void,Integer>{

        @Override
        protected Integer doInBackground(Void... voids) {
            return 0;
        }
        @Override
        protected void onPostExecute(Integer result){
            Intent intent = new Intent(context, FindUserInfoActivity.class);
            context.startActivity(intent);
        }

    }
}
