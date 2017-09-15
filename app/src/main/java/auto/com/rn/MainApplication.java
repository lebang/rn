package auto.com.rn;

import android.app.Application;
import android.content.Context;

import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.react.modules.network.ReactCookieJarContainer;
import com.facebook.soloader.SoLoader;
import com.facebook.stetho.Stetho;

import auto.com.rn.hotupdate.RnConstants;
import auto.com.rn.interfaces.RnPackage;
import auto.com.rn.preload.PreLoadRn;
import auto.com.rn.ui.RegisterActivity;
import auto.com.rn.ui.RnListActivity;
import okhttp3.OkHttpClient;
import com.facebook.react.modules.network.OkHttpClientProvider;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Nullable;

public class MainApplication extends Application implements ReactApplication {

    private static MainApplication instance;
    public static Context appContext;
    //APP中所有的RN页面（key是注册名，value是context）
    public static HashMap<String, Class<?>> RNMAP = new HashMap();
    //传递到RN页的参数
    public static String prams = "";

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
        this.initRNMAP();
        SoLoader.init(this, false);
    }

    /**
     * 此处手动添加APP中的所有RN页面对应的注册名和Activity
     */
    private void initRNMAP() {
        MainApplication.RNMAP.put("register", RegisterActivity.class);
        MainApplication.RNMAP.put("flatList", RnListActivity.class);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();// 程序终止的时候执行
        PreLoadRn.clear();
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
