package testnewcheck.com.testnewcheckdemo;

import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.fastjson.FastJsonConverterFactory;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;
import testnewcheck.com.testnewcheckdemo.objectboxbean.CheckDataBeanObjectBox;
import testnewcheck.com.testnewcheckdemo.serverbean.CheckServerJobBean;

/**
 * Created by xiao on 2017/7/20.
 */

public class NetService {

    private static OkHttpClient okHttpClient = EWayOkHttpUtil.getOkHttpClient();
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();
    private static Retrofit retrofit = new Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("http://www.yiweiyun.net:8088/")
            .addConverterFactory(FastJsonConverterFactory.create())
            .addCallAdapterFactory(rxJavaCallAdapterFactory)
            .build();


    //http://www.yiweiyun.net:8088/eway_server/check/getcheck?param={"ewaytoken":"990007181050581","loginid":"13255556666","checkid":"14988422700267509","devicetypeid":"","searchname":"","showcompanion":"1"}

    //=============================================
    public static ImsGetDataPartsAPI mImsGetDataPartsAPI;

    public static ImsGetDataPartsAPI getmImsGetDataPartsAPI() {
        if (mImsGetDataPartsAPI == null) {
            mImsGetDataPartsAPI = retrofit.create(ImsGetDataPartsAPI.class);
        }
        return mImsGetDataPartsAPI;
    }

    //=============================================

    public static ImsGetDataPartsBoxAPI mImsGetDataPartsBoxAPI;

    public static ImsGetDataPartsBoxAPI getmImsGetDataPartsBoxAPI() {
        if (mImsGetDataPartsBoxAPI == null) {
            mImsGetDataPartsBoxAPI = retrofit.create(ImsGetDataPartsBoxAPI.class);
        }
        return mImsGetDataPartsBoxAPI;
    }

    //获取列表采用原生sql写入所用
    public interface ImsGetDataPartsAPI {
        @POST("eway_server/check/getcheck")
        Observable<CheckDataBean> getData(@Query("param") String param);

    }

    //获取列表采用objectbox写入所用
    public interface ImsGetDataPartsBoxAPI {
        @POST("eway_server/check/getcheck")
        Observable<CheckServerJobBean> getData(@Query("param") String param);

    }


}
