package testnewcheck.com.testnewcheckdemo;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by xiao on 2017/7/20.
 */

public class MyApplication extends Application {
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
