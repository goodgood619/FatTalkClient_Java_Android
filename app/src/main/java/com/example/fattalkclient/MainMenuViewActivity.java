package com.example.fattalkclient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.fattalkclient.databinding.ActivityMainMenuViewBinding;
import com.google.gson.Gson;

import Module.MessengerClient;
import Service.MessangerService;
import ViewModel.MainViewModel;

public class MainMenuViewActivity extends AppCompatActivity {
    private ActivityMainMenuViewBinding activityMainMenuViewBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MessengerClient messengerClient = null;
        MessangerService messangerService = null;
        super.onCreate(savedInstanceState);
        Gson gson = new Gson();
        String messengerClient1 = getIntent().getStringExtra("MessengerClient");
        messengerClient = gson.fromJson(messengerClient1, MessengerClient.class);
        String messengerService1 = getIntent().getStringExtra("MessengerService");
        messangerService = gson.fromJson(messengerService1, MessangerService.class);
        String usernickname = getIntent().getStringExtra("Nickname");
        MainViewModel mainViewModel = new MainViewModel(this,messengerClient,messangerService,usernickname);
        activityMainMenuViewBinding = DataBindingUtil.setContentView(this,R.layout.activity_main_menu_view);
        activityMainMenuViewBinding.setMainViewModel(mainViewModel);
    }
}
