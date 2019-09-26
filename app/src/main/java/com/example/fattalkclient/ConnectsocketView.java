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
        Gson gson;
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(TcpClient.class,new MessengerClientAdapter());
        gson = gsonBuilder.create();
        Intent intent = new Intent(ConnectsocketView.this,MainActivity.class);
        intent.putExtra("MessengerService", gson.toJson(messangerService));
        intent.putExtra("MessengerClient", gson.toJson(messengerClient,TcpClient.class));
        startActivity(intent);
    }


}
