package com.example.fattalkclient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.fattalkclient.databinding.ActivityMainMenuViewBinding;
import com.google.gson.Gson;

import java.util.HashMap;

import Module.MessengerClient;
import Service.MessangerService;
import ViewModel.MainViewModel;

public class MainMenuViewActivity extends AppCompatActivity {
    private static ActivityMainMenuViewBinding activityMainMenuViewBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MessengerClient messengerClient = null;
        super.onCreate(savedInstanceState);
        //String messengerClient1 = getIntent().getStringExtra("MessengerClient");
        //messengerClient = gson.fromJson(messengerClient1, MessengerClient.class);
        //HashMap<String,MessengerClient> testmap = (HashMap<String, MessengerClient>) getIntent().getSerializableExtra("MessengerClient");
        //String messengerService1 = getIntent().getStringExtra("MessengerService");
        //messangerService = gson.fromJson(messengerService1, MessangerService.class);
        HashMap<String,MessengerClient> testmap = (HashMap<String, MessengerClient>) getIntent().getSerializableExtra("MessengerClient");
        messengerClient = testmap.get("MessengerClient");
        String usernickname = getIntent().getStringExtra("Nickname");
        MainViewModel mainViewModel = new MainViewModel(this,messengerClient,messengerClient.messangerService,usernickname);
        activityMainMenuViewBinding = DataBindingUtil.setContentView(this,R.layout.activity_main_menu_view);
        activityMainMenuViewBinding.setMainViewModel(mainViewModel);
    }
}
