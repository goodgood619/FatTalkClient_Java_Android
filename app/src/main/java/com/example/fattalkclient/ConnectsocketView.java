package com.example.fattalkclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.ExecutionException;

import Module.MessengerClient;
import Module.MessengerClientAdapter;
import Module.TcpClient;
import Service.MessangerService;

public class ConnectsocketView extends AppCompatActivity {
    private MessengerClient messengerClient = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MessangerService messangerService = new MessangerService();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connectsocket_view);
        LoginAsyncTask loginAsyncTask = new LoginAsyncTask(messangerService);
        try {
            messengerClient = loginAsyncTask.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Gson gson;
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(TcpClient.class,new MessengerClientAdapter());
        gson = gsonBuilder.create();
        Intent intent = new Intent(ConnectsocketView.this,MainActivity.class);
        intent.putExtra("MessengerService", gson.toJson(messangerService));
        intent.putExtra("MessengerClient", gson.toJson(messengerClient,TcpClient.class));
        startActivity(intent);
    }
    public class LoginAsyncTask extends AsyncTask<Void, Integer, MessengerClient> {
        private MessangerService messangerService;
        private MessengerClient messengerClient;
        public LoginAsyncTask(MessangerService messangerService){
            this.messangerService = messangerService;
        }
        @Override
        protected MessengerClient doInBackground(Void... voids) {
            try {
                messengerClient = new MessengerClient(messangerService);
                Log.d("ConnectsocketView","ConnectsocketView에서 만들어짐");
            } catch (Exception e) {
                e.printStackTrace();
                Log.d("ConnectsocketView","ConnectsocketView에서 만들기 실패");
            }
            return messengerClient;
        }

        @Override // 확실한 성공
        protected void onPostExecute(MessengerClient messengerClient){
            super.onPostExecute(messengerClient);
        }
        @Override //중간에 실패했을때
        protected void onCancelled(){
        }
    }
}
