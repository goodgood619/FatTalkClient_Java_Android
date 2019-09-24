package com.example.fattalkclient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.example.fattalkclient.databinding.ActivityMainBinding;
import com.google.gson.Gson;

import java.util.concurrent.ExecutionException;

import Module.MessengerClient;
import Service.MessangerService;
import ViewModel.LoginViewModel;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        MessengerClient messengerClient = null;
        MessangerService messangerService = new MessangerService();
        LoginAsyncTask loginAsyncTask = new LoginAsyncTask(messangerService);
        try {
            messengerClient = loginAsyncTask.execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LoginViewModel loginViewModel = new LoginViewModel(messangerService,messengerClient,this);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.setLoginviewmodel(loginViewModel);
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
            } catch (Exception e) {
                e.printStackTrace();
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
