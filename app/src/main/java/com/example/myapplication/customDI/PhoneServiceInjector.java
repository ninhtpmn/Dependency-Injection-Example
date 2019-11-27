package com.example.myapplication.customDI;

public class PhoneServiceInjector implements IPhoneServiceInjector {
    private static PhoneServiceInjector instance = new PhoneServiceInjector();

    public static PhoneServiceInjector getInstance() {
        return instance;
    }

    @Override
    public IPhoneService buildPhoneService() {
        return new PhoneService(new VN_SMSService(), new VN_VoiceService());
    }
}
