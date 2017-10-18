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
public  class PartsBean {
    @Id
    public long id;
    public String devicecode;
    public String devicepartsmodel;
    public String devicepartsname;
    public String partsid;
  @Backlink
    public ToMany<PositionBean> position;

    @Backlink
    public ToOne<OpjsonBean> opjsonBean;



}
