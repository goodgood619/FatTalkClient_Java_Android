package ViewModel;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.lifecycle.ViewModel;

import com.example.fattalkclient.BlockFriendActivity;
import com.example.fattalkclient.ChatRoomsActivity;
import com.example.fattalkclient.DeleteFriendActivity;
import com.example.fattalkclient.FriendListActivity;
import com.example.fattalkclient.ModifyUserinfoActivity;
import com.example.fattalkclient.NotBlockFriendActivity;
import com.example.fattalkclient.PlusFriendActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import Model.TcpMessage;
import Module.MessengerClient;
import Service.Imessanger;
import Service.ImessangerTest;
import Service.MessangerService;

public class MainViewModel extends BaseObservable {
    private Context context;
    private MessengerClient messengerClient;
    private MessangerService messangerService;
    private String usernickname = "";
    public MainViewModel(Context context, MessengerClient messengerClient,MessangerService messangerService,String usernickname) {
        this.context = context;
        this.messangerService = messangerService;
        this.messengerClient = messengerClient;
        this.usernickname = usernickname;

        messangerService.addtomethod(new ImessangerTest() {
            @Override
            public void ResponseMessage(TcpMessage message) {
                switch (message.command){
                    case logout:

                        break;
                }
            }
        });
    }

    public void FriendlistBinding(){
        FriendListViewAsyncTask friendListViewAsyncTask = new FriendListViewAsyncTask();
        friendListViewAsyncTask.execute();
    }
    public class FriendListViewAsyncTask extends AsyncTask<Void,Void,Integer>{

        @Override
        protected Integer doInBackground(Void... voids) {
            return 0;
        }
        @Override
        protected void onPostExecute(Integer result){
            Intent intent = new Intent(context, FriendListActivity.class);
            context.startActivity(intent);
        }
    }

    public void ChatRoomsBinding(){
        ChatRoomsViewAsyncTask chatRoomsViewAsyncTask = new ChatRoomsViewAsyncTask();
        chatRoomsViewAsyncTask.execute();
    }
    public class ChatRoomsViewAsyncTask extends AsyncTask<Void,Void,Integer>{

        @Override
        protected Integer doInBackground(Void... voids) {
            return 0;
        }
        @Override
        protected void onPostExecute(Integer result){
            Intent intent = new Intent(context, ChatRoomsActivity.class);
            context.startActivity(intent);
        }
    }

    public void PlusFriendBinding(){
        PlusFriendViewAsyncTask plusFriendViewAsyncTask = new PlusFriendViewAsyncTask();
        plusFriendViewAsyncTask.execute();
    }
    public class PlusFriendViewAsyncTask extends AsyncTask<Void,Void,Integer>{

        @Override
        protected Integer doInBackground(Void... voids) {
            return 0;
        }
        @Override
        protected void onPostExecute(Integer result){
            Intent intent = new Intent(context, PlusFriendActivity.class);
            context.startActivity(intent);
        }
    }

    public void DeleteFriendBinding(){
        DeleteFriendViewAsyncTask deleteFriendViewAsyncTask = new DeleteFriendViewAsyncTask();
        deleteFriendViewAsyncTask.execute();
    }
    public class DeleteFriendViewAsyncTask extends AsyncTask<Void,Void,Integer>{

        @Override
        protected Integer doInBackground(Void... voids) {
            return 0;
        }
        @Override
        protected void onPostExecute(Integer result){
            Intent intent = new Intent(context, DeleteFriendActivity.class);
            context.startActivity(intent);
        }
    }


    public void BlockFriendBinding(){
        BlockFriendViewAsyncTask blockFriendViewAsyncTask = new BlockFriendViewAsyncTask();
        blockFriendViewAsyncTask.execute();
    }
    public class BlockFriendViewAsyncTask extends AsyncTask<Void,Void,Integer>{

        @Override
        protected Integer doInBackground(Void... voids) {
            return 0;
        }
        @Override
        protected void onPostExecute(Integer result){
            Intent intent = new Intent(context, BlockFriendActivity.class);
            context.startActivity(intent);
        }
    }



    public void NotBlockFriendBinding(){
        NotBlockFriendViewAsyncTask notBlockFriendViewAsyncTask = new NotBlockFriendViewAsyncTask();
        notBlockFriendViewAsyncTask.execute();
    }
    public class NotBlockFriendViewAsyncTask extends AsyncTask<Void,Void,Integer>{

        @Override
        protected Integer doInBackground(Void... voids) {
            return 0;
        }
        @Override
        protected void onPostExecute(Integer result){
            Intent intent = new Intent(context, NotBlockFriendActivity.class);
            context.startActivity(intent);
        }
    }

    public void ModifyUserinfoBinding(){
        ModifyUserInfoViewAsyncTask modifyUserInfoViewAsyncTask = new ModifyUserInfoViewAsyncTask();
        modifyUserInfoViewAsyncTask.execute();
    }
    public class ModifyUserInfoViewAsyncTask extends AsyncTask<Void,Void,Integer>{

        @Override
        protected Integer doInBackground(Void... voids) {
            return 0;
        }
        @Override
        protected void onPostExecute(Integer result){
            Intent intent = new Intent(context, ModifyUserinfoActivity.class);
            context.startActivity(intent);
        }
    }



    public void LogoutBinding(){
        messengerClient.requestLogout(usernickname);
        LogoutViewAsyncTask logoutViewAsyncTask = new LogoutViewAsyncTask();
        logoutViewAsyncTask.execute();
    }
    public class LogoutViewAsyncTask extends AsyncTask<Void,Void,Integer>{

        @Override
        protected Integer doInBackground(Void... voids) {
            return 0;
        }
        @Override
        protected void onPostExecute(Integer result){
            //Test
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage("로그아웃하시겠습니까?");
            builder.setCancelable(true);
            builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel(); //취소
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
    }
}
