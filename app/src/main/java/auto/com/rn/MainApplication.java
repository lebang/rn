package auto.com.rn;

import android.app.Application;
import android.content.Context;

import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.react.modules.network.ReactCookieJarContainer;
import com.facebook.stetho.Stetho;

import auto.com.rn.hotupdate.RnConstants;
import auto.com.rn.interfaces.RnPackage;
import okhttp3.OkHttpClient;
import com.facebook.react.modules.network.OkHttpClientProvider;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.io.File;
import java.util.concurrent.TimeUnit;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Nullable;

public class MainApplication extends Application implements ReactApplication {

    private static MainApplication instance;
    public static Context appContext;

    private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {

        @Nullable
        @Override
        protected String getJSBundleFile() {
            File file = new File(RnConstants.JS_BUNDLE_PATH);
            if (file != null && file.exists()) {
                // 如果在SD卡的bundle存储路径下存在bundle文件就加载该文件
                return RnConstants.JS_BUNDLE_PATH;
            } else {
                // 如果不存在就去assets中加载
                return super.getJSBundleFile();
            }
        }

        @Override
        public boolean getUseDeveloperSupport() {
            return BuildConfig.DEBUG;
        }

        @Override
        protected List<com.facebook.react.ReactPackage> getPackages() {
            return Arrays.<com.facebook.react.ReactPackage>asList(
                    new MainReactPackage(),
                    new RnPackage()
            );
        }
    };

    @Override
    public ReactNativeHost getReactNativeHost() {
        return mReactNativeHost;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initStetho();
        instance = this;
        appContext = getApplicationContext();
    }

    public String getAppPackageName() {
        return this.getPackageName();
    }

    public static MainApplication getInstance() {
        return instance;
    }

    private void initStetho() {
        Stetho.initializeWithDefaults(this);
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(0, TimeUnit.MILLISECONDS)
                .readTimeout(0, TimeUnit.MILLISECONDS)
                .writeTimeout(0, TimeUnit.MILLISECONDS)
                .cookieJar(new ReactCookieJarContainer())
                .addNetworkInterceptor(new StethoInterceptor())
                .build();
        OkHttpClientProvider.replaceOkHttpClient(client);
    }
}
