package com.example.henryzheng.avtivitysourcetest.ipc.applicationHasRepeat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.henryzheng.avtivitysourcetest.R;
import com.example.henryzheng.avtivitysourcetest.ipc.messenager.MessengerService;

public class ServiceTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_test);
        startService(new Intent(this,TestService.class));
        startService(new Intent(this,MessengerService.class));

    }
}
