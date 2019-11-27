package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.customDI.IPhoneService;
import com.example.myapplication.customDI.IPhoneServiceInjector;
import com.example.myapplication.customDI.PhoneServiceInjector;
import com.example.myapplication.dagger2.DaggerPhoneServiceComponent;
import com.example.myapplication.dagger2.PhoneService;
import com.example.myapplication.dagger2.PhoneServiceComponent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onBackPressed() {
        IPhoneServiceInjector phoneServiceInjector = PhoneServiceInjector.getInstance();
        IPhoneService customPhoneService = phoneServiceInjector.buildPhoneService();
        customPhoneService.checkServiceOK();

        PhoneServiceComponent phoneServiceComponent = DaggerPhoneServiceComponent.create();
        PhoneService dagger2PhoneService = phoneServiceComponent.buildPhoneService();
        dagger2PhoneService.checkServiceOK();
    }
}
