package auto.com.rn.preload;

import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

import javax.annotation.Nullable;

import auto.com.rn.MainApplication;

/**
 * Copyright (C) 2016, Xiaomi Inc. All rights reserved.
 */
public class PreRnActivity extends Activity implements DefaultHardwareBackBtnHandler, PermissionAwareActivity {

    private PreLoadRnDelegate mPreLoadRnDelegate;

    //构造方法中创建PreLoadReactDelegate对象
    protected PreRnActivity() {
        mPreLoadRnDelegate = createPreLoadReactDelegate();
    }

    /**
     * 创建PreLoadReactDelegate对象
     *
     * @return
     */
    private PreLoadRnDelegate createPreLoadReactDelegate() {
        /**
         * getMainComponentName:组件名
         * getPrams：传递到RN页面的参数
         */
        return new PreLoadRnDelegate(this, getMainComponentName());
    }

    /**
     * 获取RN注册也名字的方法需要在RN的Activity中重写方法对应的RN注册名
     */
    protected @Nullable String getMainComponentName() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPreLoadRnDelegate.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPreLoadRnDelegate.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPreLoadRnDelegate.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPreLoadRnDelegate.onDestroy();
    }

    @Override
    public void onNewIntent(Intent intent) {
        if (!mPreLoadRnDelegate.onNewIntent(intent)) {
            super.onNewIntent(intent);
        }
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        return mPreLoadRnDelegate.onKeyUp(keyCode, event) || super.onKeyUp(keyCode, event);
    }

    // 申请悬浮窗权限
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        mPreLoadRnDelegate.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onBackPressed() {
        if (!mPreLoadRnDelegate.onBackPressed()) {
            super.onBackPressed();
        }
    }

    @Override
    public void invokeDefaultOnBackPressed() {
        super.onBackPressed();
    }

    /**
     * 处理权限授权
     */
    @Override
    public void requestPermissions(String[] permissions, int requestCode, PermissionListener listener) {
        mPreLoadRnDelegate.requestPermissions(permissions, requestCode, listener);
    }

    /**
     * 授权结果
     */
    @Override
    public void onRequestPermissionsResult(final int requestCode, final String[] permissions, final int[] grantResults) {
        mPreLoadRnDelegate.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
