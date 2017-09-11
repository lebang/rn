package auto.com.rn.interfaces;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import auto.com.rn.ui.RnListActivity;

/**
 * Copyright (C) 2016, Xiaomi Inc. All rights reserved.
 */
public class RnInterface extends ReactContextBaseJavaModule {

    private static final String TAG = "RnInterface";

    private ReactApplicationContext mRnContext;

    public RnInterface(ReactApplicationContext reactContext) {
        super(reactContext);
        mRnContext = reactContext;
    }

    @Override
    public String getName() {
        return TAG;
    }

    @ReactMethod
    public void HandlerMessage(String message) {
        Log.d(TAG, message);
        Toast.makeText(mRnContext, message, Toast.LENGTH_SHORT).show();
    }

    @ReactMethod
    public void GoListActivity() {
        Intent intent = new Intent();
        intent.setClass(mRnContext, RnListActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mRnContext.startActivity(intent);
    }
}
