package auto.com.rn;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactPackage;
import com.facebook.react.ReactRootView;
import com.facebook.react.shell.MainReactPackage;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.widget.LinearLayout;

import java.util.Arrays;
import java.util.List;

/**
 * Copyright (C) 2016, Xiaomi Inc. All rights reserved.
 */
public class RnActivity extends ReactActivity {
    @Override
    protected String getMainComponentName() {
        return "helloReact";
    }

}
