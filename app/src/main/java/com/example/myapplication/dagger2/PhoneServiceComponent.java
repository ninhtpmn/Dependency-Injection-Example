package com.example.myapplication.dagger2;

import androidx.annotation.VisibleForTesting;

import dagger.Component;

@Component(modules = ServiceModule.class)
public interface PhoneServiceComponent {
    PhoneService buildPhoneService();

    @VisibleForTesting
    // để set test module khi unit test
    @Component.Builder
    interface Builder {
        Builder setModule(ServiceModule module);

        PhoneServiceComponent build();
    }
}
