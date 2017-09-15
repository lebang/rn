package auto.com.rn.ui;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

import auto.com.rn.R;
import auto.com.rn.RnInstanceManager;
import auto.com.rn.preload.PreLoadRn;

public class MainActivity extends Activity implements DefaultHardwareBackBtnHandler {
    private ReactRootView mReactRootView;
    private ReactInstanceManager mReactInstanceManager;

    boolean hasPermissions = false;
    boolean first = true;

    String[] permissions = new String[]{ Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest
            .permission.SYSTEM_ALERT_WINDOW };
    List<String> mPermissionList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mReactRootView = (ReactRootView) findViewById(R.id.rnview);
        mReactInstanceManager = RnInstanceManager.getInstance(getApplication());
        mReactRootView.startReactApplication(mReactInstanceManager, "mainApp", null);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkPermissionList() > 0) {
            this.verifyStoragePermissions();
        }
    }

    private int checkPermissionList() {
        mPermissionList.clear();
        for (int i = 0; i < permissions.length; i++) {
            if (ContextCompat.checkSelfPermission(MainActivity.this, permissions[i]) != PackageManager.PERMISSION_GRANTED) {
                mPermissionList.add(permissions[i]);
            }
        }
        return mPermissionList.size();
    }



    /**
     * 首次执行方法
     * onCreate方法中只是用来申请权限，当权限申请成功后才会执行本方法
     */
    protected void onCreateTrue() {
        this.hasPermissions = true;
        PreLoadRn.proload(MainActivity.this);
    }

    // 申请读写权限后回调
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1://写权限
               for (int i=0; i<grantResults.length; i++) {
                   if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                       this.verifyStoragePermissions();
                   }
               }
               this.onCreateTrue();
            break;
        }
    }

    //申请读写权限
    public void verifyStoragePermissions() {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (mPermissionList.isEmpty()) {
                    this.onCreateTrue();
                } else {
                    String[] permissions = mPermissionList.toArray(new String[mPermissionList.size()]);
                    ActivityCompat.requestPermissions(MainActivity.this, permissions, 1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void invokeDefaultOnBackPressed() {
        super.onBackPressed();
    }


}
