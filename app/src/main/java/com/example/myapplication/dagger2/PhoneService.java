package com.example.myapplication.dagger2;

import com.example.myapplication.common.SMSService;
import com.example.myapplication.common.VoiceService;

import javax.inject.Inject;

public class PhoneService {
    private SMSService smsService;
    private VoiceService voiceService;

    // nếu trong constructor này mà là VNVoiceService thì chỉ cần @Inject ở constructor của VNVoiceService, khi test thì lại ko thay đổi được
    // vì khi gen ra nó sẽ là new VNVoiceService.
    // Nên để là interface
    @Inject
    public PhoneService(SMSService smsService, VoiceService voiceService) {
        this.smsService = smsService;
        this.voiceService = voiceService;
    }

    public void checkServiceOK() {
        System.out.println("PhoneService:16---checkServiceOK----------->>" + smsService.getName());
        System.out.println("PhoneService:17---checkServiceOK----------->>" + voiceService.getName());
    }
}
