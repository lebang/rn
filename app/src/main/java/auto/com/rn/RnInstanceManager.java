package auto.com.rn;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.shell.MainReactPackage;

import android.app.Application;
import android.content.Context;

import auto.com.rn.interfaces.RnPackage;

/**
 * Copyright (C) 2016, Xiaomi Inc. All rights reserved.
 */
public class RnInstanceManager {
    private static volatile ReactInstanceManager sInstanceManager;

    public static ReactInstanceManager getInstance(Application application) {
        if (sInstanceManager == null) {
            synchronized (RnInstanceManager.class) {
                if (sInstanceManager == null) {
                    sInstanceManager = ReactInstanceManager.builder()
                            .setApplication(application)
                            .setBundleAssetName("index.android.bundle")
                            .setJSMainModuleName("index.android")
                            .addPackage(new MainReactPackage())
                            .addPackage(new RnPackage())
                            .setUseDeveloperSupport(BuildConfig.DEBUG)
                            .setInitialLifecycleState(LifecycleState.RESUMED)
                            .build();
                }
            }
        }
        return sInstanceManager;
    }
}
