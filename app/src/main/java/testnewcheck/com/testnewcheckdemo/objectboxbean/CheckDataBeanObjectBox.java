package testnewcheck.com.testnewcheckdemo.objectboxbean;

import java.util.List;

import io.objectbox.annotation.Backlink;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;
import io.objectbox.annotation.Relation;
import io.objectbox.relation.ToMany;
import io.objectbox.relation.ToOne;
import testnewcheck.com.testnewcheckdemo.*;

/**
 * Created by xiao on 2017/7/20.
 */
@Entity
public class CheckDataBeanObjectBox {
    @Id
    public long id;
    public boolean optag;
    public String opmsg;
    @Backlink
    public ToMany<OpjsonBean> opjson;

}
