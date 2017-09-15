package auto.com.rn.ui;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import auto.com.rn.preload.PreRnActivity;
import auto.com.rn.preload.PreLoadRn;

/**
 * Copyright (C) 2016, Xiaomi Inc. All rights reserved.
 */
public class RnListActivity extends PreRnActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected String getMainComponentName() {
        return "flatList";
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        PreLoadRn.deatchView("flatList");
    }
}
