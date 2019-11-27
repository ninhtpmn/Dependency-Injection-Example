package com.example.myapplication.dagger2;

import com.example.myapplication.common.SMSService;
import com.example.myapplication.common.VoiceService;

import dagger.Module;
import dagger.Provides;

@Module
public class ServiceModule {
    // Nếu component inject trong constructor mà không phải là abstract thì không cần provider, chỉ cần @Inject ở constructor của object đó
    @Provides
    public SMSService provideSMSService() {
        return new VNSMSService();
    }

    @Provides
    public VoiceService provideVoiceService() {
        return new VNVoiceService();
    }
}
