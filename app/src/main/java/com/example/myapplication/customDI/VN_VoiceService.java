package com.example.myapplication.customDI;

import com.example.myapplication.common.VoiceService;

public class VN_VoiceService implements VoiceService {
    @Override
    public String getName() {
        return "VN_Voice Service";
    }
}
