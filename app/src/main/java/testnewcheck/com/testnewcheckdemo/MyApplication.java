package testnewcheck.com.testnewcheckdemo;

import android.app.Application;

import com.facebook.stetho.Stetho;

import io.objectbox.BoxStore;
import testnewcheck.com.testnewcheckdemo.objectboxbean.MyObjectBox;

/**
 * Created by xiao on 2017/7/20.
 */

public class MyApplication extends Application {
    public static BoxStore boxStore;

    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        boxStore = MyObjectBox.builder().androidContext(MyApplication.this).build();
    }
}
