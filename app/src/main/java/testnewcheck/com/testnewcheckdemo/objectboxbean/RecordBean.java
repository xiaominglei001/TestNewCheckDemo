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
public  class RecordBean {
    @Id
    public long id;
    public String checkid;
    public String descstr;
    public String devicecode;
    public String deviceid;
    public String devicemodel;
    public String devicename;
    public String devicetypeid;
    public String doidea;
    public String partsid;
    public String positionid;
    public String projectid;
    public String recordid;
    public String riskresult;
    @Backlink
    public ToMany<PhotoBean> photo;
    @Backlink
    public ToOne<ProjectBean> positionBean;

}
