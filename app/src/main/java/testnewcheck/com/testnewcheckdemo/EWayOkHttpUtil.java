package testnewcheck.com.testnewcheckdemo;

import android.text.TextUtils;
import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Administrator on 2017-03-24.
 */

public class EWayOkHttpUtil {
    public static OkHttpClient getOkHttpClient() { // JSONObject mjson = new JSONObject(map);注意传参的话可以通过map转json调用，也可以直接在如getUserInfo方法中加参数调用。
        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        Log.e("EWayHttp", request.url().toString());
                        return chain.proceed(request);
                    }
                })//添加请求拦截
                .connectTimeout(10, TimeUnit.SECONDS)//设置超时时间,10s后没响应算超时。
                .retryOnConnectionFailure(true);


        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(
                new HttpLoggingInterceptor.Logger() {
                    @Override
                    public void log(final String message) {
                        if (TextUtils.isEmpty(message)) return;
                        String s = message.substring(0, 1);
                        //如果收到响应是json才打印
                        if ("{".equals(s) || "[".equals(s)) {
                            Log.e("EWayHttp", message);
                        }
                    }
                });

        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        client.addInterceptor(logging);

        return client.build();
    }


}
