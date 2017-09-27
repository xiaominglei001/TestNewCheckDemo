package testnewcheck.com.testnewcheckdemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initData();
        Button bt = (Button) findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckDbHelper.queryCheckList();
            }
        });

    }

    public void initData() {

        //http://200.205.200.200:8080/eway_server/check/getcheck?param={"ewaytoken":"990007181050581","loginid":"13255556666","checkid":"14935680020549608","devicetypeid":"","searchname":"","showcompanion":"1"}

        String param = "{\"ewaytoken\":\"866265037858513\",\"loginid\":\"13255556666\",\"checkid\":\"14935680020549608\",\"devicetypeid\":\"\",\"searchname\":\"\",\"showcompanion\":\"1\"}";


        NetService.getmImsGetDataPartsAPI().getData(param).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<CheckDataBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNext(CheckDataBean checkDataBean) {
                if (checkDataBean != null) {
                    Toast.makeText(MainActivity.this, checkDataBean.getOpmsg(), Toast.LENGTH_SHORT).show();
                    if (checkDataBean.isOptag()) {
                        CheckDbHelper.crateDb(MainActivity.this, checkDataBean, "14935680020549608");//成功写入以单号为db名的数据库中
                    }
                }

            }
        });


    }


}
