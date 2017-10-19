package testnewcheck.com.testnewcheckdemo.objectboxbean;

import java.util.List;

import io.objectbox.annotation.Backlink;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.annotation.Relation;
import io.objectbox.relation.ToMany;
import io.objectbox.relation.ToOne;

/**
 * Created by xiao on 2017/10/18.
 */

@Entity
public  class OpjsonBean {
    @Id
    public long id;
    public int ccnt;
    public String devicecode;
    public String deviceid;
    public String devicelabel;
    public String devicemodel;
    public String devicename;
    public String devicetypeid;
    public String devicetypename;
    public String idencode;
    public String pictureurl;
    public String placedate;
    public String producecode;
    public String recordflag;
    @Backlink
    public ToMany<PartsBean> parts;
    @Backlink
    public ToOne<CheckDataBeanObjectBox> checkDataBeanObjectBox;


    @Override
    public String toString() {
        return "OpjsonBean{" +
                "id=" + id +
                ", ccnt=" + ccnt +
                ", devicecode='" + devicecode + '\'' +
                ", deviceid='" + deviceid + '\'' +
                ", devicelabel='" + devicelabel + '\'' +
                ", devicemodel='" + devicemodel + '\'' +
                ", devicename='" + devicename + '\'' +
                ", devicetypeid='" + devicetypeid + '\'' +
                ", devicetypename='" + devicetypename + '\'' +
                ", idencode='" + idencode + '\'' +
                ", pictureurl='" + pictureurl + '\'' +
                ", placedate='" + placedate + '\'' +
                ", producecode='" + producecode + '\'' +
                ", recordflag='" + recordflag + '\'' +
                ", parts=" + parts +
                ", checkDataBeanObjectBox=" + checkDataBeanObjectBox +
                '}';
    }
}
