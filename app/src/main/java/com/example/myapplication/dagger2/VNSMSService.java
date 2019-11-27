package com.example.myapplication.dagger2;

import com.example.myapplication.common.SMSService;

import javax.inject.Inject;

public class VNSMSService implements SMSService {

    @Inject
    public VNSMSService() {
    }

    @Override
    public String getName() {
        return "SMS Service";
    }
}
