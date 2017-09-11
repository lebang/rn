package auto.com.rn.ui;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;

import android.app.Activity;
import android.os.Bundle;

import auto.com.rn.R;
import auto.com.rn.RnInstanceManager;

public class MainActivity extends Activity implements DefaultHardwareBackBtnHandler {
    private ReactRootView mReactRootView;
    private ReactInstanceManager mReactInstanceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mReactRootView = (ReactRootView) findViewById(R.id.rnview);
        mReactInstanceManager = RnInstanceManager.getInstance(getApplication());
        mReactRootView.startReactApplication(mReactInstanceManager, "mainApp", null);

    }

    @Override
    public void invokeDefaultOnBackPressed() {
        super.onBackPressed();
    }


}
