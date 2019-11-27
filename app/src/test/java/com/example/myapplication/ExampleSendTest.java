package com.example.myapplication;

import com.example.myapplication.common.SMSService;
import com.example.myapplication.customDI.IPhoneService;
import com.example.myapplication.customDI.IPhoneServiceInjector;
import com.example.myapplication.customDI.PhoneService;
import com.example.myapplication.customDI.VN_VoiceService;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExampleSendTest {
    private IPhoneService phoneService;
    private String smsServiceName;
    private String voiceServiceName;

    @Before
    public void setUp() {
        phoneService = new IPhoneServiceInjector() {
            @Override
            public IPhoneService buildPhoneService() {
                return new PhoneService(new SMSService() {
                    @Override
                    public String getName() {
                        return smsServiceName = "I'm test SMSService";
                    }
                }, new VN_VoiceService() {
                    @Override
                    public String getName() {
                        return voiceServiceName = super.getName();
                    }
                });
            }
        }.buildPhoneService();
    }

    @Test
    public void test() {
        phoneService.checkServiceOK();

        Assert.assertNotNull(phoneService);
        Assert.assertEquals(smsServiceName, "I'm test SMSService");
        Assert.assertEquals(voiceServiceName, new VN_VoiceService().getName());
    }
}
