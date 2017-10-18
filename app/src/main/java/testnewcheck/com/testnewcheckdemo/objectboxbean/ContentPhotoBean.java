package testnewcheck.com.testnewcheckdemo.objectboxbean;

import io.objectbox.annotation.Backlink;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToOne;

/**
 * Created by xiao on 2017/10/18.
 */

@Entity
public class ContentPhotoBean {

    /**
     * descstr :
     * dodate : 2017-07-21 09:40:31
     * photofile : upload/sys/CheckContent5054592199054851500601240812.jpg
     * photoid : 1495166122366155718
     * photoname : CheckContent5054592199054851500601240812.jpg
     */
    @Id
    public long id;
    public String descstr;
    public String dodate;
    public String photofile;
    public String photoid;
    public String photoname;
    @Backlink
    public ToOne<ContentBean> contentBean;

}
