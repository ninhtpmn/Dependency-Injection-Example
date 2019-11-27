package com.example.myapplication.dagger2;

import com.example.myapplication.common.VoiceService;

import javax.inject.Inject;

public class VNVoiceService implements VoiceService {

    @Inject
    public VNVoiceService() {
    }

    @Override
    public String getName() {
        return "Voice Service";
    }
}
