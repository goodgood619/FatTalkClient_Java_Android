package com.example.fattalkclient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.example.fattalkclient.databinding.ActivityMainBinding;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.concurrent.ExecutionException;

import Module.MessengerClient;
import Service.MessangerService;
import ViewModel.LoginViewModel;

public class MainActivity extends AppCompatActivity {
    private static ActivityMainBinding binding;
    private MessengerClient messengerClient;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        LoginAsyncTask loginAsyncTask = new LoginAsyncTask();
        try {
            messengerClient = loginAsyncTask.execute().get();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        LoginViewModel loginViewModel = new LoginViewModel(messengerClient.messangerService,messengerClient,this);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.setLoginviewmodel(loginViewModel);
    }

    public class LoginAsyncTask extends AsyncTask<Void,Void,MessengerClient>{
        @Override
        protected MessengerClient doInBackground(Void... voids) {
            try {
                messengerClient = MessengerClient.getMessengerClient();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return messengerClient;
        }
        @Override
        protected void onPostExecute(MessengerClient messengerClient){
            super.onPostExecute(messengerClient);
        }
    }


}
