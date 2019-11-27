package com.example.myapplication;

import com.example.myapplication.dagger2.DaggerPhoneServiceComponent;
import com.example.myapplication.dagger2.PhoneService;
import com.example.myapplication.common.SMSService;
import com.example.myapplication.dagger2.ServiceModule;
import com.example.myapplication.dagger2.VNVoiceService;
import com.example.myapplication.common.VoiceService;

import org.junit.Assert;
import org.junit.Test;

public class DaggerTest {
    private String smsServiceName, voiceServiceName;
    private PhoneService phoneService;

    @Test
    public void testPhoneService() {
        phoneService = DaggerPhoneServiceComponent.builder().setModule(new ServiceModule() {
            @Override
            public SMSService provideSMSService() {
                return new SMSService() {
                    @Override
                    public String getName() {
                        return smsServiceName = "I'm Test SMSService";
                    }
                };
            }

            @Override
            public VoiceService provideVoiceService() {
                VoiceService service = new VNVoiceService();
                voiceServiceName = service.getName();
                return service;
            }
        }).build().buildPhoneService();

        phoneService.checkServiceOK();

        Assert.assertNotNull(phoneService);
        Assert.assertEquals(smsServiceName, "I'm Test SMSService");
        Assert.assertEquals(voiceServiceName, new VNVoiceService().getName());
    }
}