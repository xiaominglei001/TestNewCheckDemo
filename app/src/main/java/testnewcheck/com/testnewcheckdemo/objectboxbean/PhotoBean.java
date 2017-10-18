package testnewcheck.com.testnewcheckdemo.objectboxbean;

import io.objectbox.annotation.Backlink;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToOne;

/**
 * Created by xiao on 2017/10/18.
 */

@Entity
public  class PhotoBean {
    /**
     * descstr :
     * dodate : 2017-07-04 16:00:07
     * photofile : upload/sys/CheckException14591733847857310571499155212675.jpg
     * photoid : 1499155390688854315
     * photoname : CheckException14591733847857310571499155212675.jpg
     */
    @Id
    public long id;
    public String descstr;
    public String dodate;
    public String photofile;
    public String photoid;
    public String photoname;
    @Backlink
    public ToOne<RecordBean> recordBean;


}
