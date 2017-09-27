package testnewcheck.com.testnewcheckdemo;

import android.content.ComponentName;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.amitshekhar.DebugDB;

import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

/**
 * Created by xiao on 2017/7/20.
 */

public class CheckDbHelper {


    private static SQLiteDatabase db;

    //创建并写入以单号为名的数据库
    public static void crateDb(Context context, CheckDataBean checkDataBean, String checkid) {
        db = SQLiteDatabase.openOrCreateDatabase(Environment.getExternalStorageDirectory() + "/" + checkid + ".db", null);//没使用Android自带的helper创建,直接使用SQLiteDatabase创建数据库
        setCustomDatabaseFiles(context, checkid + ".db", Environment.getExternalStorageDirectory() + "/" + checkid + ".db");
        createTable();
        fillData(checkDataBean);
    }

    public static void setCustomDatabaseFiles(Context context, String name, String path) {
        if (BuildConfig.DEBUG) {
            try {
                Class<?> debugDB = Class.forName("com.amitshekhar.DebugDB");
                Class[] argTypes = new Class[]{HashMap.class};
                Method setCustomDatabaseFiles = debugDB.getMethod("setCustomDatabaseFiles", argTypes);
                HashMap<String, File> customDatabaseFiles = new HashMap<>();
                // set your custom database files
                customDatabaseFiles.put(name,
                        new File(path));
                setCustomDatabaseFiles.invoke(null, customDatabaseFiles);

            } catch (Exception ignore) {

            }
        }
    }


    //===============================================================创建表填充数据================================================================
    private static void createTable() {
        //自增主键所用 integer primary key autoincrement
        //创建checklist表
        String createCheckliststr =
                "create table checklist (\n" +
                        "_id                  VARCHAR(100)  primary key       not null,\n" +
                        "ccnt                 INTEGER,\n" +
                        "devicecode           VARCHAR(100),\n" +
                        "deviceid             VARCHAR(100),\n" +
                        "devicelabel          VARCHAR(100),\n" +
                        "devicemodel          VARCHAR(100),\n" +
                        "devicename           VARCHAR(100),\n" +
                        "devicetypeid         VARCHAR(100),\n" +
                        "devicetypename       VARCHAR(100),\n" +
                        "idencode             VARCHAR(100),\n" +
                        "pictureurl           VARCHAR(100),\n" +
                        "placedate            VARCHAR(100),\n" +
                        "producecode          VARCHAR(100),\n" +
                        "recordflag           VARCHAR(100)\n" +

                        ");";

        //创建parts表
        String createPartsstr =
                "create table parts (\n" +
                        "_id                 VARCHAR(100) primary key              not null,\n" +
                        "devicecode           VARCHAR(100),\n" +
                        "devicepartsmodel     VARCHAR(100),\n" +
                        "devicepartsname      VARCHAR(100),\n" +
                        "partsid              VARCHAR(100),\n" +
                        "checklist_id         INTEGER\n" +

                        ");";

        //创建positions表
        String createPositionsstr =
                "create table positions (\n" +
                        "_id                 VARCHAR(100) primary key          not null,\n" +
                        "ccnt                 INTEGER,\n" +
                        "checkpositionname    VARCHAR(100),\n" +
                        "devicemodel          VARCHAR(100),\n" +
                        "devicename           VARCHAR(100),\n" +
                        "positionid           VARCHAR(100),\n" +
                        "part_id              INTEGER\n" +

                        ");";

        //创建projects表
        String crateProjectsstr =
                "create table projects (\n" +
                        "_id                  VARCHAR(100) primary key         not null,\n" +
                        "ccnt                 INTEGER,\n" +
                        "checkprojectname     VARCHAR(100),\n" +
                        "projectid            VARCHAR(100),\n" +
                        "records              VARCHAR(3999),\n" +
                        "position_id          INTEGER\n" +

                        ");";

        //创建contents表
        String createContentsstr =
                "create table contents (\n" +
                        "_id                 VARCHAR(100) primary key         not null,\n" +
                        "checkcontentname     VARCHAR(100),\n" +
                        "checkdetailid        VARCHAR(100),\n" +
                        "checkid              VARCHAR(100),\n" +
                        "checkresult          VARCHAR(100),\n" +
                        "contentid            VARCHAR(100),\n" +
                        "descstr              VARCHAR(100),\n" +
                        "deviceflag           VARCHAR(100),\n" +
                        "deviceid             VARCHAR(100),\n" +
                        "doresult             VARCHAR(100),\n" +
                        "endingvalue          VARCHAR(100),\n" +
                        "orderno              VARCHAR(100),\n" +
                        "partsid              VARCHAR(100),\n" +
                        "photo                VARCHAR(3999),\n" +
                        "positionid           VARCHAR(100),\n" +
                        "projectid            VARCHAR(100),\n" +
                        "riskassesstype       VARCHAR(100),\n" +
                        "riskdetailjson       VARCHAR(3999),\n" +
                        "riskjudge            VARCHAR(100),\n" +
                        "riskresult           VARCHAR(100),\n" +
                        "standardtype         VARCHAR(100),\n" +
                        "standardvalue        VARCHAR(100),\n" +
                        "startingvalue        VARCHAR(100),\n" +
                        "takephoto            VARCHAR(100),\n" +
                        "unittype             VARCHAR(100),\n" +
                        "checklist_id         VARCHAR(100),\n" +
                        "project_id           CHAR(10)\n" +

                        ");";

        //执行SQL语句
        db.execSQL("drop table if  exists checklist;");
        db.execSQL("drop table if  exists parts;");
        db.execSQL("drop table if  exists positions;");
        db.execSQL("drop table if  exists projects;");
        db.execSQL("drop table if  exists contents;");
        db.execSQL(createCheckliststr);
        db.execSQL(createPartsstr);
        db.execSQL(createPositionsstr);
        db.execSQL(crateProjectsstr);
        db.execSQL(createContentsstr);

    }

    //填充数据
    public static void fillData(CheckDataBean checkDataBean) {
        List<CheckDataBean.OpjsonBean> opjson = checkDataBean.getOpjson();
        if (opjson != null && opjson.size() > 0) {
            for (int i = 0; i < opjson.size(); i++) {//--------------------------------checklist表数据--------------------
                CheckDataBean.OpjsonBean opjsonBean = opjson.get(i);
                String checklist_id = insertChecklist(opjsonBean); //插入checklist表数据返回主键
                List<CheckDataBean.OpjsonBean.PartsBean> parts = opjsonBean.getParts();
                for (int j = 0; j < parts.size(); j++) {//------------------------------parts表数据-----------------------
                    CheckDataBean.OpjsonBean.PartsBean partsbean = parts.get(j);
                    String part_id = insertpartslist(partsbean, checklist_id);//插入parts表数据返回主键
                    List<CheckDataBean.OpjsonBean.PartsBean.PositionBean> positions = parts.get(j).getPosition();
                    for (int k = 0; k < positions.size(); k++) {//----------------------positions表数据-------------------
                        CheckDataBean.OpjsonBean.PartsBean.PositionBean positionbean = positions.get(k);
                        String position_id = insertpositionList(positionbean, part_id);//插入positons表返回主键
                        List<CheckDataBean.OpjsonBean.PartsBean.PositionBean.ProjectBean> projects = positionbean.getProject();
                        for (int l = 0; l < projects.size(); l++) { //-------------------projects表数据----------------------
                            CheckDataBean.OpjsonBean.PartsBean.PositionBean.ProjectBean projectbean = projects.get(l);
                            String project_id = insertProjectslist(projectbean, position_id);//插入project表返回主键
                            List<CheckDataBean.OpjsonBean.PartsBean.PositionBean.ProjectBean.ContentBean> contents = projectbean.getContent();
                            for (int m = 0; m < contents.size(); m++) { //---------------contents表数据-----------------------
                                CheckDataBean.OpjsonBean.PartsBean.PositionBean.ProjectBean.ContentBean contentbean = contents.get(m);
                                insertContentslist(contentbean, checklist_id, project_id); //插入contents表数据返回主键,多插入一个checklist表主键
                            }
                        }
                    }
                }
            }
        }


    }


    //插入checklist表返回主键
    public static String insertChecklist(CheckDataBean.OpjsonBean opjsonBean) {
        String _id = IDGenerator.simple();
        //插入数据SQL语句
        String sql = "insert into checklist(_id,ccnt,devicecode,deviceid,devicelabel,devicemodel,devicename,devicetypeid,devicetypename,idencode,pictureurl,placedate,producecode,recordflag) values(" + conF(_id) +
                opjsonBean.getCcnt() + "," + conF(opjsonBean.getDevicecode()) + conF(opjsonBean.getDeviceid()) + conF(opjsonBean.getDevicelabel()) + conF(opjsonBean.getDevicemodel()) + conF(opjsonBean.getDevicename()) + conF(opjsonBean.getDevicetypeid()) +
                conF(opjsonBean.getDevicetypename()) + conF(opjsonBean.getIdencode()) + conF(opjsonBean.getPictureurl()) + conF(opjsonBean.getPlacedate()) + conF(opjsonBean.getProducecode()) + conNF(opjsonBean.getRecordflag()) + ");";

        //执行SQL语句
        Log.e("EWayHttp", sql);
        db.execSQL(sql);
        return _id;
    }

    //插入parts表数据返回主键
    public static String insertpartslist(CheckDataBean.OpjsonBean.PartsBean partsbean, String checklist_id) {
        String _id = IDGenerator.simple();
        //插入数据SQL语句
        String sql = "insert into parts(_id,devicecode,devicepartsmodel,devicepartsname,partsid,checklist_id) values(" + conF(_id) +
                conF(partsbean.getDevicecode()) + conF(partsbean.getDevicepartsmodel()) + conF(partsbean.getDevicepartsname()) + conF(partsbean.getPartsid()) + checklist_id +
                ");";
        //执行SQL语句
        Log.e("EWayHttp", sql);
        db.execSQL(sql);
        return _id;
    }

    //插入positions表返回主键
    public static String insertpositionList(CheckDataBean.OpjsonBean.PartsBean.PositionBean positionbean, String part_id) {
        String _id = IDGenerator.simple();
        //插入数据SQL语句
        String sql = "insert into positions(_id,ccnt,checkpositionname,devicemodel,devicename,positionid,part_id) values(" +
                conF(_id) + positionbean.getCcnt() + "," + conF(positionbean.getCheckpositionname()) + conF(positionbean.getDevicemodel()) + conF(positionbean.getDevicename()) + conF(positionbean.getPositionid()) + part_id +
                ");";
        //执行SQL语句
        Log.e("EWayHttp", sql);
        db.execSQL(sql);
        return _id;

    }

    //插入projects表数据返回主键
    public static String insertProjectslist(CheckDataBean.OpjsonBean.PartsBean.PositionBean.ProjectBean projectbean, String position_id) {
        String _id = IDGenerator.simple();
        //插入数据SQL语句
        String sql = "insert into projects(_id,ccnt,checkprojectname,projectid,records,position_id) values(" + conF(_id) +
                projectbean.getCcnt() + "," + conF(projectbean.getCheckprojectname()) + conF(projectbean.getProjectid()) + conF(JSON.toJSONString(projectbean.getRecord())) + position_id +
                ");";
        //执行SQL语句
        Log.e("EWayHttp", sql);
        db.execSQL(sql);
        return _id;
    }

    //插入contents表返回主键,多插入一条用来存设置列表的主键
    public static String insertContentslist(CheckDataBean.OpjsonBean.PartsBean.PositionBean.ProjectBean.ContentBean contentbean, String checklist_id, String project_id) {
        String _id = IDGenerator.simple();
        //插入数据SQL语句
        String sql = "insert into contents" +
                "(_id,checkcontentname,checkdetailid,checkid,checkresult,contentid,descstr,deviceflag,deviceid,doresult,endingvalue,orderno,partsid,positionid,projectid,riskassesstype,riskjudge,riskresult,standardtype,standardvalue,startingvalue,takephoto,unittype,photo,riskdetailjson,checklist_id,project_id) " +
                "values(" + conF(_id) +
                conF(contentbean.getCheckcontentname()) + conF(contentbean.getCheckdetailid()) + conF(contentbean.getCheckid()) + conF(contentbean.getCheckresult()) + conF(contentbean.getContentid()) + conF(contentbean.getDescstr()) +
                conF(contentbean.getDeviceflag()) + conF(contentbean.getDeviceid()) + conF(contentbean.getDoresult()) + conF(contentbean.getEndingvalue()) + conF(contentbean.getOrderno()) + conF(contentbean.getPartsid()) + conF(contentbean.getPositionid()) +
                conF(contentbean.getProjectid()) + conF(contentbean.getRiskassesstype()) + conF(contentbean.getRiskjudge()) + conF(contentbean.getRiskresult()) + conF(contentbean.getStandardtype()) + conF(contentbean.getStandardvalue()) + conF(contentbean.getStartingvalue()) +
                conF(contentbean.getTakephoto()) + conF(contentbean.getUnittype()) + conF(JSON.toJSONString(contentbean.getPhoto())) + conF(JSON.toJSONString(contentbean.getRiskdetailjson())) + conF(checklist_id) + project_id +
                ");";
        //执行SQL语句
        Log.e("EWayHttp", sql);
        db.execSQL(sql);
        return _id;
    }


    //转换字段带上''和逗号(如果字符串需加上'')
    public static String conF(String str) {
        str = "'" + str + "',";
        return str;
    }

    //最后一条不需要逗号所用
    public static String conNF(String str) {
        str = "'" + str + "'";
        return str;
    }


    //===============================================================查询数据================================================================

    //根据checklist表数据
    public static void queryCheckList() {
        //查询获得游标
        Cursor cursor = db.query("checklist", null, null, null, null, null, null);
        //判断游标是否为空
        if (cursor.moveToFirst()) {
            //遍历游标
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.move(i);
                //获得ID
                String _id = cursor.getString(0);
                //获取ccnt
                String str1 = cursor.getString(1);
                //获取idencode
                String str2 = cursor.getString(9);
                //输出用户信息
                Log.e("EWayHttp", _id + "---" + str1 + "***" + str2);
            }
        }
    }


}
