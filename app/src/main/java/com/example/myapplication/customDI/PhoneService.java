package com.example.myapplication.customDI;

import com.example.myapplication.common.SMSService;
import com.example.myapplication.common.VoiceService;

public class PhoneService implements IPhoneService{
    private final SMSService smsService;
    private final VoiceService voiceService;

    public PhoneService(SMSService smsService, VoiceService voiceService) {
        this.smsService = smsService;
        this.voiceService = voiceService;
    }

    public void checkServiceOK() {
        System.out.println("PhoneService:16---checkServiceOK----------->>" + smsService.getName());
        System.out.println("PhoneService:17---checkServiceOK----------->>" + voiceService.getName());
    }
}
