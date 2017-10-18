package testnewcheck.com.testnewcheckdemo.objectboxbean;

import java.util.List;

import io.objectbox.annotation.Backlink;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.annotation.Relation;
import io.objectbox.relation.ToOne;

/**
 * Created by xiao on 2017/10/18.
 */

@Entity
public  class ProjectBean {
    @Id
    public long id;
    public int ccnt;
    public String checkprojectname;
    public String projectid;
    @Backlink
    public List<ContentBean> content;
    @Backlink
    public List<RecordBean> record;

    @Backlink
    public ToOne<PositionBean> positionBean;





}
