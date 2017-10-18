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
public  class ContentBean {
    @Id
    public long id;
    public String checkcontentname;
    public String checkdetailid;
    public String checkid;
    public String checkresult;
    public String contentid;
    public String descstr;
    public String deviceflag;
    public String deviceid;
    public String doresult;
    public String endingvalue;
    public String orderno;
    public String partsid;
    public String positionid;
    public String projectid;
    public String riskassesstype;
    public String riskjudge;
    public String riskresult;
    public String standardtype;
    public String standardvalue;
    public String startingvalue;
    public String takephoto;
    public String unittype;
    @Backlink
    public ToMany<ContentPhotoBean> photo;
    @Backlink
    public ToMany<RiskdetailjsonBean> riskdetailjson;


    @Backlink
    public ToOne<ProjectBean> projectBean;








}
