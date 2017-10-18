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
public  class PositionBean {
    @Id
    public long id;
    public int ccnt;
    public String checkpositionname;
    public String devicemodel;
    public String devicename;
    public String positionid;
    @Backlink
    public ToMany<ProjectBean> project;
    @Backlink
    public ToOne<PartsBean> partsBean;



}
