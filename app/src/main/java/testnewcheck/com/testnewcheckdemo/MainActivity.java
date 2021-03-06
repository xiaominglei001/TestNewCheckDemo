package testnewcheck.com.testnewcheckdemo;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

import io.objectbox.Box;
import io.objectbox.BoxStore;
import io.objectbox.relation.ToMany;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import testnewcheck.com.testnewcheckdemo.objectboxbean.*;
import testnewcheck.com.testnewcheckdemo.serverbean.CheckServerJobBean;

public class MainActivity extends AppCompatActivity {

    private BoxStore boxStore;
    //所构建的需要插入的bean
    private CheckDataBeanObjectBox box;
    private ProgressBar progressBar;
    private Handler mhandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    progressBar.setVisibility(View.GONE);//隐藏
                    Toast.makeText(MainActivity.this, msg.obj + "", Toast.LENGTH_SHORT).show();
                    CheckDataBeanObjectBox temp = boxStore.boxFor(CheckDataBeanObjectBox.class).get(Long.parseLong(msg.obj + ""));//获取某个id值的对象
                    Toast.makeText(MainActivity.this, temp.opjson.get(0).parts.get(0).partsid + "", Toast.LENGTH_SHORT).show();
                    Box<CheckDataBeanObjectBox> boxdb = boxStore.boxFor(CheckDataBeanObjectBox.class);
                    List<CheckDataBeanObjectBox> templist1 = boxdb.query().build().find();
                    Toast.makeText(MainActivity.this, "插入后总数为---" + templist1.size(), Toast.LENGTH_SHORT).show();

                    break;
                default:
                    break;
            }
        }
    };

    private Observer observer1 = new Observer<CheckDataBean>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNext(final CheckDataBean checkDataBean) {
            if (checkDataBean != null) {
                Toast.makeText(MainActivity.this, checkDataBean.getOpmsg(), Toast.LENGTH_SHORT).show();
                new Thread(
                        new Runnable() {
                            @Override
                            public void run() {
                                if (checkDataBean.isOptag()) {
                                    CheckDbHelper.crateDb(MainActivity.this, checkDataBean, "14935680020549608", mhandler);//成功写入以单号为db名的数据库中
                                }
                            }
                        }

                ).start();
            }

        }


    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        boxStore = ((MyApplication) getApplication()).boxStore;

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        Button bt1 = (Button) findViewById(R.id.button1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initData();
            }
        });

        Button bt2 = (Button) findViewById(R.id.button2);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //查询
                Box<CheckDataBeanObjectBox> boxdb = boxStore.boxFor(CheckDataBeanObjectBox.class);
                List<CheckDataBeanObjectBox> templist1 = boxdb.query().equal(CheckDataBeanObjectBox_.id, 1).build().find();
                Toast.makeText(MainActivity.this, templist1.size() + "", Toast.LENGTH_SHORT).show();


                Box<OpjsonBean> boxopjson = boxStore.boxFor(OpjsonBean.class);
                List<OpjsonBean> templist2 = boxopjson.query().equal(OpjsonBean_.deviceid, "1490147248028397846").build().find();
                Toast.makeText(MainActivity.this, templist2.size() + "", Toast.LENGTH_SHORT).show();

            }
        });

        Button bt3 = (Button) findViewById(R.id.button3);

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //修改

                Box<OpjsonBean> boxopjson = boxStore.boxFor(OpjsonBean.class);
                List<OpjsonBean> templist2 = boxopjson.query().equal(OpjsonBean_.deviceid, "1490147248028397846").build().find();
                Toast.makeText(MainActivity.this, templist2.size() + "", Toast.LENGTH_SHORT).show();

                OpjsonBean tempedit = templist2.get(0);
                tempedit.ccnt = 111112;
                boxopjson.put(tempedit);
                Toast.makeText(MainActivity.this, templist2.get(0).ccnt + "", Toast.LENGTH_SHORT).show();


            }
        });

        Button bt4 = (Button) findViewById(R.id.button4);

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Box<CheckDataBeanObjectBox> boxdb = boxStore.boxFor(CheckDataBeanObjectBox.class);
                boxdb.remove(4);//id为标准删除
                List<CheckDataBeanObjectBox> templist1 = boxdb.query().build().find();
                Toast.makeText(MainActivity.this, "删除数据(如果有的话),删除后总数为---" + templist1.size(), Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, "删除后最后一条数据的id为---" + templist1.get(templist1.size() - 1).id, Toast.LENGTH_SHORT).show();


            }
        });


    }

    public void initData() {

        progressBar.setVisibility(View.VISIBLE);

        //http://www.yiweiyun.net:8080/eway_server/check/getcheck?param={"ewaytoken":"990007181050581","loginid":"13255556666","checkid":"14935680020549608","devicetypeid":"","searchname":"","showcompanion":"1"}
        // String param = "{\"ewaytoken\":\"866265037858513\",\"loginid\":\"13255556666\",\"checkid\":\"14935680020549608\",\"devicetypeid\":\"\",\"searchname\":\"\",\"showcompanion\":\"1\"}";
        String param = "{\"ewaytoken\":\"866265037858513\",\"loginid\":\"13255556666\",\"checkid\":\"15015194000332061\",\"devicetypeid\":\"\",\"searchname\":\"\",\"showcompanion\":\"1\"}";
        param = "{\"ewaytoken\":\"866265037858513\",\"loginid\":\"13255556666\",\"checkid\":\"15015194090188248\",\"devicetypeid\":\"\",\"searchname\":\"\",\"showcompanion\":\"1\"}";

        param = "{\"ewaytoken\":\"866265037858513\",\"loginid\":\"13255556666\",\"checkid\":\"15015194000332061\",\"devicetypeid\":\"\",\"searchname\":\"\",\"showcompanion\":\"1\"}";
        //NetService.getmImsGetDataPartsAPI().getData(param).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer1);//原生sql方法

        NetService.getmImsGetDataPartsBoxAPI().getData(param).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer2);//objectbox方法


    }

    private Observer observer2 = new Observer<CheckServerJobBean>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNext(final CheckServerJobBean checkDataBean) {
            if (checkDataBean != null) {
                Toast.makeText(MainActivity.this, checkDataBean.getOpmsg(), Toast.LENGTH_SHORT).show();
                new Thread(
                        new Runnable() {
                            @Override
                            public void run() {
                                if (checkDataBean.isOptag()) {
                                    Box<CheckDataBeanObjectBox> boxdb = boxStore.boxFor(CheckDataBeanObjectBox.class);
                                    box = new CheckDataBeanObjectBox();
                                    box.optag = checkDataBean.isOptag();//拿到服务器返回数据,开始设置到需要插入的bean中
                                    box.opmsg = checkDataBean.getOpmsg();
                                    List<CheckServerJobBean.OpjsonBean> temp1 = checkDataBean.getOpjson();
                                    for (int i = 0; i < temp1.size(); i++) {  //遍历总共有多少设备,循环设置值到需要插入的bean中
                                        OpjsonBean tempob = new OpjsonBean();
                                        CheckServerJobBean.OpjsonBean tempser = temp1.get(i);
                                        tempob.ccnt = tempser.getCcnt();
                                        tempob.devicecode = tempser.getDevicecode();
                                        tempob.deviceid = tempser.getDeviceid();
                                        tempob.devicelabel = tempser.getDevicelabel();
                                        tempob.devicemodel = tempser.getDevicemodel();
                                        tempob.devicename = tempser.getDevicename();
                                        tempob.devicetypeid = tempser.getDevicetypeid();
                                        tempob.devicetypename = tempser.getDevicetypename();
                                        tempob.idencode = tempser.getIdencode();
                                        tempob.pictureurl = tempser.getPictureurl();
                                        tempob.placedate = tempser.getPlacedate();
                                        tempob.producecode = tempser.getProducecode();
                                        tempob.recordflag = tempser.getRecordflag();

                                        for (int j = 0; j < tempser.getParts().size(); j++) {  //多少子设备
                                            PartsBean tempparts = new PartsBean();
                                            CheckServerJobBean.OpjsonBean.PartsBean temppartsser = tempser.getParts().get(j);
                                            tempparts.devicecode = temppartsser.getDevicecode();
                                            tempparts.devicepartsmodel = temppartsser.getDevicepartsmodel();
                                            tempparts.devicepartsname = temppartsser.getDevicepartsname();
                                            tempparts.partsid = temppartsser.getPartsid();


                                            for (int k = 0; k < temppartsser.getPosition().size(); k++) {  //多少部位
                                                PositionBean tempPositionBean = new PositionBean();
                                                CheckServerJobBean.OpjsonBean.PartsBean.PositionBean tempPositionBeanser = temppartsser.getPosition().get(k);
                                                tempPositionBean.ccnt = tempPositionBeanser.getCcnt();
                                                tempPositionBean.checkpositionname = tempPositionBeanser.getCheckpositionname();
                                                tempPositionBean.devicemodel = tempPositionBeanser.getDevicemodel();
                                                tempPositionBean.devicename = tempPositionBeanser.getDevicename();
                                                tempPositionBean.positionid = tempPositionBeanser.getPositionid();


                                                for (int l = 0; l < tempPositionBeanser.getProject().size(); l++) { //多少项目
                                                    ProjectBean tempProjectBean = new ProjectBean();
                                                    CheckServerJobBean.OpjsonBean.PartsBean.PositionBean.ProjectBean tempProjectBeanser = tempPositionBeanser.getProject().get(l);
                                                    tempProjectBean.ccnt = tempProjectBeanser.getCcnt();
                                                    tempProjectBean.checkprojectname = tempProjectBeanser.getCheckprojectname();
                                                    tempProjectBean.projectid = tempProjectBeanser.getProjectid();
                                                    addContent(tempProjectBean, tempProjectBeanser);
                                                    addRecord(tempProjectBean, tempProjectBeanser);
                                                    tempPositionBean.project.add(tempProjectBean);
                                                }

                                                tempparts.position.add(tempPositionBean);
                                            }

                                            tempob.parts.add(tempparts);

                                        }
                                        box.opjson.add(tempob);
                                    }

                                    long id = boxdb.put(box);
                                    Message msg = Message.obtain();
                                    msg.what = 1;
                                    msg.obj = id;
                                    mhandler.sendMessage(msg);//发送消息停止动画

                                }
                            }
                        }

                ).start();
            }

        }


    };


    private void addContent(ProjectBean tempProjectBean, CheckServerJobBean.OpjsonBean.PartsBean.PositionBean.ProjectBean tempProjectBeanser) {

        for (int m = 0; m < tempProjectBeanser.getContent().size(); m++) {  //多少内容
            ContentBean contentBean = new ContentBean();
            CheckServerJobBean.OpjsonBean.PartsBean.PositionBean.ProjectBean.ContentBean contentbeanser = tempProjectBeanser.getContent().get(m);
            contentBean.checkcontentname = contentbeanser.getCheckcontentname();
            contentBean.checkdetailid = contentbeanser.getCheckdetailid();
            contentBean.checkid = contentbeanser.getCheckid();
            contentBean.checkresult = contentbeanser.getCheckresult();
            contentBean.contentid = contentbeanser.getContentid();
            contentBean.descstr = contentbeanser.getDescstr();
            contentBean.deviceflag = contentbeanser.getDeviceflag();
            contentBean.deviceid = contentbeanser.getDeviceid();
            contentBean.doresult = contentbeanser.getDoresult();
            contentBean.endingvalue = contentbeanser.getEndingvalue();
            contentBean.orderno = contentbeanser.getOrderno();

            contentBean.partsid = contentbeanser.getPartsid();
            contentBean.positionid = contentbeanser.getPositionid();
            contentBean.projectid = contentbeanser.getProjectid();
            contentBean.riskassesstype = contentbeanser.getRiskassesstype();
            contentBean.riskjudge = contentbeanser.getRiskjudge();
            contentBean.riskresult = contentbeanser.getRiskresult();

            contentBean.standardtype = contentbeanser.getStandardtype();
            contentBean.standardvalue = contentbeanser.getStandardvalue();
            contentBean.startingvalue = contentbeanser.getStartingvalue();
            contentBean.takephoto = contentbeanser.getTakephoto();
            contentBean.unittype = contentbeanser.getUnittype();


            //添加每个内容的风险计算数据
            addContentRiskdetail(contentBean, contentbeanser);
            //添加每个内容的照片数据
            addContentPhoto(contentBean, contentbeanser);
            tempProjectBean.content.add(contentBean);

        }

    }


    private void addRecord(ProjectBean tempProjectBean, CheckServerJobBean.OpjsonBean.PartsBean.PositionBean.ProjectBean tempProjectBeanser) {

        for (int m = 0; m < tempProjectBeanser.getRecord().size(); m++) {  //多少异常
            RecordBean recordBean = new RecordBean();
            CheckServerJobBean.OpjsonBean.PartsBean.PositionBean.ProjectBean.RecordBean recordbeanser = tempProjectBeanser.getRecord().get(m);
            recordBean.checkid = recordbeanser.getCheckid();
            recordBean.descstr = recordbeanser.getDescstr();
            recordBean.devicecode = recordbeanser.getDevicecode();
            recordBean.deviceid = recordbeanser.getDeviceid();
            recordBean.devicemodel = recordbeanser.getDevicemodel();
            recordBean.devicename = recordbeanser.getDevicename();
            recordBean.devicetypeid = recordbeanser.getDevicetypeid();
            recordBean.doidea = recordbeanser.getDoidea();
            recordBean.partsid = recordbeanser.getPartsid();
            recordBean.positionid = recordbeanser.getPositionid();
            recordBean.projectid = recordbeanser.getProjectid();
            recordBean.recordid = recordbeanser.getRecordid();
            recordBean.riskresult = recordbeanser.getRiskresult();

            //添加每个异常的照片数据
            addRecordPhoto(recordBean, recordbeanser);
            //网数据库中添加异常bean
            tempProjectBean.record.add(recordBean);
        }


    }

    private void addContentRiskdetail(ContentBean contentBean, CheckServerJobBean.OpjsonBean.PartsBean.PositionBean.ProjectBean.ContentBean contentbeanser) {

        //内容风险计算的数据
        for (int n = 0; n < contentbeanser.getRiskdetailjson().size(); n++) {

            RiskdetailjsonBean riskdetailbean = new RiskdetailjsonBean();

            CheckServerJobBean.OpjsonBean.PartsBean.PositionBean.ProjectBean.ContentBean.RiskdetailjsonBean riskdetailjsonser = contentbeanser.getRiskdetailjson().get(n);

            riskdetailbean.negative = riskdetailjsonser.getNegative();
            riskdetailbean.positive = riskdetailjsonser.getPositive();
            riskdetailbean.ristname = riskdetailjsonser.getRistname();
            riskdetailbean.ristremarks = riskdetailjsonser.getRistremarks();
            riskdetailbean.riststatue = riskdetailjsonser.getRiststatue();
            contentBean.riskdetailjson.add(riskdetailbean);

        }

    }

    private void addContentPhoto(ContentBean contentBean, CheckServerJobBean.OpjsonBean.PartsBean.PositionBean.ProjectBean.ContentBean contentbeanser) {

        //内容照片的循环数据
        for (int n = 0; n < contentbeanser.getPhoto().size(); n++) {

            ContentPhotoBean contentPhotoBean = new ContentPhotoBean();
            CheckServerJobBean.OpjsonBean.PartsBean.PositionBean.ProjectBean.ContentBean.PhotoBean photobeanser = contentbeanser.getPhoto().get(n);
            contentPhotoBean.descstr = photobeanser.getDescstr();
            contentPhotoBean.dodate = photobeanser.getDodate();
            contentPhotoBean.photofile = photobeanser.getPhotofile();
            contentPhotoBean.photoid = photobeanser.getPhotoid();
            contentPhotoBean.photoname = photobeanser.getPhotoname();
            contentBean.photo.add(contentPhotoBean);
        }


    }

    private void addRecordPhoto(RecordBean recordBean, CheckServerJobBean.OpjsonBean.PartsBean.PositionBean.ProjectBean.RecordBean recordbeanser) {

        for (int n = 0; n < recordbeanser.getPhoto().size(); n++) {
            testnewcheck.com.testnewcheckdemo.objectboxbean.PhotoBean photobean = new testnewcheck.com.testnewcheckdemo.objectboxbean.PhotoBean();
            CheckServerJobBean.OpjsonBean.PartsBean.PositionBean.ProjectBean.RecordBean.PhotoBeanX photoser = recordbeanser.getPhoto().get(n);
            photobean.descstr = photoser.getDescstr();
            photobean.dodate = photoser.getDodate();
            photobean.photofile = photoser.getPhotofile();
            photobean.photoid = photoser.getPhotoid();
            photobean.photoname = photoser.getPhotoname();
            recordBean.photo.add(photobean);

        }


    }


}

