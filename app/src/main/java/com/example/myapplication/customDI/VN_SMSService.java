package com.example.myapplication.customDI;

import com.example.myapplication.common.SMSService;

public class VN_SMSService implements SMSService {
    @Override
    public String getName() {
        return "VN_SMS Service";
    }
}
