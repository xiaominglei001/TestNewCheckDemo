package testnewcheck.com.testnewcheckdemo.objectboxbean;

import io.objectbox.annotation.Backlink;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.relation.ToOne;

/**
 * Created by xiao on 2017/10/18.
 */

@Entity
public class RiskdetailjsonBean {
    @Id
    public long id;
    public String negative;
    public String positive;
    public String ristname;
    public String ristremarks;
    public String riststatue;

    @Backlink
    public ToOne<ContentBean> contentBean;


}
