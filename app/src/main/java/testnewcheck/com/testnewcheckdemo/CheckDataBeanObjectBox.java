package testnewcheck.com.testnewcheckdemo;

import java.util.List;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * Created by xiao on 2017/7/20.
 */
public class CheckDataBeanObjectBox {
    private boolean optag;
    private String opmsg;
    private List<OpjsonBean> opjson;

    public boolean isOptag() {
        return optag;
    }

    public void setOptag(boolean optag) {
        this.optag = optag;
    }

    public String getOpmsg() {
        return opmsg;
    }

    public void setOpmsg(String opmsg) {
        this.opmsg = opmsg;
    }

    public List<OpjsonBean> getOpjson() {
        return opjson;
    }

    public void setOpjson(List<OpjsonBean> opjson) {
        this.opjson = opjson;
    }

    @Entity
    public static class OpjsonBean {
        @Id
        private long id;
        private int ccnt;
        private String devicecode;
        private String deviceid;
        private String devicelabel;
        private String devicemodel;
        private String devicename;
        private String devicetypeid;
        private String devicetypename;
        private String idencode;
        private String pictureurl;
        private String placedate;
        private String producecode;
        private String recordflag;
        private List<PartsBean> parts;

        public int getCcnt() {
            return ccnt;
        }

        public void setCcnt(int ccnt) {
            this.ccnt = ccnt;
        }

        public String getDevicecode() {
            return devicecode;
        }

        public void setDevicecode(String devicecode) {
            this.devicecode = devicecode;
        }

        public String getDeviceid() {
            return deviceid;
        }

        public void setDeviceid(String deviceid) {
            this.deviceid = deviceid;
        }

        public String getDevicelabel() {
            return devicelabel;
        }

        public void setDevicelabel(String devicelabel) {
            this.devicelabel = devicelabel;
        }

        public String getDevicemodel() {
            return devicemodel;
        }

        public void setDevicemodel(String devicemodel) {
            this.devicemodel = devicemodel;
        }

        public String getDevicename() {
            return devicename;
        }

        public void setDevicename(String devicename) {
            this.devicename = devicename;
        }

        public String getDevicetypeid() {
            return devicetypeid;
        }

        public void setDevicetypeid(String devicetypeid) {
            this.devicetypeid = devicetypeid;
        }

        public String getDevicetypename() {
            return devicetypename;
        }

        public void setDevicetypename(String devicetypename) {
            this.devicetypename = devicetypename;
        }

        public String getIdencode() {
            return idencode;
        }

        public void setIdencode(String idencode) {
            this.idencode = idencode;
        }

        public String getPictureurl() {
            return pictureurl;
        }

        public void setPictureurl(String pictureurl) {
            this.pictureurl = pictureurl;
        }

        public String getPlacedate() {
            return placedate;
        }

        public void setPlacedate(String placedate) {
            this.placedate = placedate;
        }

        public String getProducecode() {
            return producecode;
        }

        public void setProducecode(String producecode) {
            this.producecode = producecode;
        }

        public String getRecordflag() {
            return recordflag;
        }

        public void setRecordflag(String recordflag) {
            this.recordflag = recordflag;
        }

        public List<PartsBean> getParts() {
            return parts;
        }

        public void setParts(List<PartsBean> parts) {
            this.parts = parts;
        }

        @Entity
        public static class PartsBean {
            @Id
            private long id;
            private String devicecode;
            private String devicepartsmodel;
            private String devicepartsname;
            private String partsid;
            private List<PositionBean> position;

            public String getDevicecode() {
                return devicecode;
            }

            public void setDevicecode(String devicecode) {
                this.devicecode = devicecode;
            }

            public String getDevicepartsmodel() {
                return devicepartsmodel;
            }

            public void setDevicepartsmodel(String devicepartsmodel) {
                this.devicepartsmodel = devicepartsmodel;
            }

            public String getDevicepartsname() {
                return devicepartsname;
            }

            public void setDevicepartsname(String devicepartsname) {
                this.devicepartsname = devicepartsname;
            }

            public String getPartsid() {
                return partsid;
            }

            public void setPartsid(String partsid) {
                this.partsid = partsid;
            }

            public List<PositionBean> getPosition() {
                return position;
            }

            public void setPosition(List<PositionBean> position) {
                this.position = position;
            }

            @Entity
            public static class PositionBean {
                @Id
                private long id;
                private int ccnt;
                private String checkpositionname;
                private String devicemodel;
                private String devicename;
                private String positionid;
                private List<ProjectBean> project;

                public int getCcnt() {
                    return ccnt;
                }

                public void setCcnt(int ccnt) {
                    this.ccnt = ccnt;
                }

                public String getCheckpositionname() {
                    return checkpositionname;
                }

                public void setCheckpositionname(String checkpositionname) {
                    this.checkpositionname = checkpositionname;
                }

                public String getDevicemodel() {
                    return devicemodel;
                }

                public void setDevicemodel(String devicemodel) {
                    this.devicemodel = devicemodel;
                }

                public String getDevicename() {
                    return devicename;
                }

                public void setDevicename(String devicename) {
                    this.devicename = devicename;
                }

                public String getPositionid() {
                    return positionid;
                }

                public void setPositionid(String positionid) {
                    this.positionid = positionid;
                }

                public List<ProjectBean> getProject() {
                    return project;
                }

                public void setProject(List<ProjectBean> project) {
                    this.project = project;
                }

                @Entity
                public static class ProjectBean {
                    @Id
                    private long id;
                    private int ccnt;
                    private String checkprojectname;
                    private String projectid;
                    private List<ContentBean> content;
                    private List<RecordBean> record;

                    public int getCcnt() {
                        return ccnt;
                    }

                    public void setCcnt(int ccnt) {
                        this.ccnt = ccnt;
                    }

                    public String getCheckprojectname() {
                        return checkprojectname;
                    }

                    public void setCheckprojectname(String checkprojectname) {
                        this.checkprojectname = checkprojectname;
                    }

                    public String getProjectid() {
                        return projectid;
                    }

                    public void setProjectid(String projectid) {
                        this.projectid = projectid;
                    }

                    public List<ContentBean> getContent() {
                        return content;
                    }

                    public void setContent(List<ContentBean> content) {
                        this.content = content;
                    }

                    public List<RecordBean> getRecord() {
                        return record;
                    }

                    public void setRecord(List<RecordBean> record) {
                        this.record = record;
                    }

                    @Entity
                    public static class ContentBean {
                        @Id
                        private long id;
                        private String checkcontentname;
                        private String checkdetailid;
                        private String checkid;
                        private String checkresult;
                        private String contentid;
                        private String descstr;
                        private String deviceflag;
                        private String deviceid;
                        private String doresult;
                        private String endingvalue;
                        private String orderno;
                        private String partsid;
                        private String positionid;
                        private String projectid;
                        private String riskassesstype;
                        private String riskjudge;
                        private String riskresult;
                        private String standardtype;
                        private String standardvalue;
                        private String startingvalue;
                        private String takephoto;
                        private String unittype;
                        private List<ContentPhotoBean> photo;
                        private List<RiskdetailjsonBean> riskdetailjson;

                        public String getCheckcontentname() {
                            return checkcontentname;
                        }

                        public void setCheckcontentname(String checkcontentname) {
                            this.checkcontentname = checkcontentname;
                        }

                        public String getCheckdetailid() {
                            return checkdetailid;
                        }

                        public void setCheckdetailid(String checkdetailid) {
                            this.checkdetailid = checkdetailid;
                        }

                        public String getCheckid() {
                            return checkid;
                        }

                        public void setCheckid(String checkid) {
                            this.checkid = checkid;
                        }

                        public String getCheckresult() {
                            return checkresult;
                        }

                        public void setCheckresult(String checkresult) {
                            this.checkresult = checkresult;
                        }

                        public String getContentid() {
                            return contentid;
                        }

                        public void setContentid(String contentid) {
                            this.contentid = contentid;
                        }

                        public String getDescstr() {
                            return descstr;
                        }

                        public void setDescstr(String descstr) {
                            this.descstr = descstr;
                        }

                        public String getDeviceflag() {
                            return deviceflag;
                        }

                        public void setDeviceflag(String deviceflag) {
                            this.deviceflag = deviceflag;
                        }

                        public String getDeviceid() {
                            return deviceid;
                        }

                        public void setDeviceid(String deviceid) {
                            this.deviceid = deviceid;
                        }

                        public String getDoresult() {
                            return doresult;
                        }

                        public void setDoresult(String doresult) {
                            this.doresult = doresult;
                        }

                        public String getEndingvalue() {
                            return endingvalue;
                        }

                        public void setEndingvalue(String endingvalue) {
                            this.endingvalue = endingvalue;
                        }

                        public String getOrderno() {
                            return orderno;
                        }

                        public void setOrderno(String orderno) {
                            this.orderno = orderno;
                        }

                        public String getPartsid() {
                            return partsid;
                        }

                        public void setPartsid(String partsid) {
                            this.partsid = partsid;
                        }

                        public String getPositionid() {
                            return positionid;
                        }

                        public void setPositionid(String positionid) {
                            this.positionid = positionid;
                        }

                        public String getProjectid() {
                            return projectid;
                        }

                        public void setProjectid(String projectid) {
                            this.projectid = projectid;
                        }

                        public String getRiskassesstype() {
                            return riskassesstype;
                        }

                        public void setRiskassesstype(String riskassesstype) {
                            this.riskassesstype = riskassesstype;
                        }

                        public String getRiskjudge() {
                            return riskjudge;
                        }

                        public void setRiskjudge(String riskjudge) {
                            this.riskjudge = riskjudge;
                        }

                        public String getRiskresult() {
                            return riskresult;
                        }

                        public void setRiskresult(String riskresult) {
                            this.riskresult = riskresult;
                        }

                        public String getStandardtype() {
                            return standardtype;
                        }

                        public void setStandardtype(String standardtype) {
                            this.standardtype = standardtype;
                        }

                        public String getStandardvalue() {
                            return standardvalue;
                        }

                        public void setStandardvalue(String standardvalue) {
                            this.standardvalue = standardvalue;
                        }

                        public String getStartingvalue() {
                            return startingvalue;
                        }

                        public void setStartingvalue(String startingvalue) {
                            this.startingvalue = startingvalue;
                        }

                        public String getTakephoto() {
                            return takephoto;
                        }

                        public void setTakephoto(String takephoto) {
                            this.takephoto = takephoto;
                        }

                        public String getUnittype() {
                            return unittype;
                        }

                        public void setUnittype(String unittype) {
                            this.unittype = unittype;
                        }

                        public List<ContentPhotoBean> getPhoto() {
                            return photo;
                        }

                        public void setPhoto(List<ContentPhotoBean> photo) {
                            this.photo = photo;
                        }

                        public List<RiskdetailjsonBean> getRiskdetailjson() {
                            return riskdetailjson;
                        }

                        public void setRiskdetailjson(List<RiskdetailjsonBean> riskdetailjson) {
                            this.riskdetailjson = riskdetailjson;
                        }

                        @Entity
                        public static class RiskdetailjsonBean {
                            @Id
                            private long id;
                            private String negative;
                            private String positive;
                            private String ristname;
                            private String ristremarks;
                            private String riststatue;

                            public String getNegative() {
                                return negative;
                            }

                            public void setNegative(String negative) {
                                this.negative = negative;
                            }

                            public String getPositive() {
                                return positive;
                            }

                            public void setPositive(String positive) {
                                this.positive = positive;
                            }

                            public String getRistname() {
                                return ristname;
                            }

                            public void setRistname(String ristname) {
                                this.ristname = ristname;
                            }

                            public String getRistremarks() {
                                return ristremarks;
                            }

                            public void setRistremarks(String ristremarks) {
                                this.ristremarks = ristremarks;
                            }

                            public String getRiststatue() {
                                return riststatue;
                            }

                            public void setRiststatue(String riststatue) {
                                this.riststatue = riststatue;
                            }
                        }

                        @Entity
                        public static class ContentPhotoBean {


                            /**
                             * descstr :
                             * dodate : 2017-07-21 09:40:31
                             * photofile : upload/sys/CheckContent5054592199054851500601240812.jpg
                             * photoid : 1495166122366155718
                             * photoname : CheckContent5054592199054851500601240812.jpg
                             */
                            @Id
                            private long id;
                            private String descstr;
                            private String dodate;
                            private String photofile;
                            private String photoid;
                            private String photoname;

                            public String getDescstr() {
                                return descstr;
                            }

                            public void setDescstr(String descstr) {
                                this.descstr = descstr;
                            }

                            public String getDodate() {
                                return dodate;
                            }

                            public void setDodate(String dodate) {
                                this.dodate = dodate;
                            }

                            public String getPhotofile() {
                                return photofile;
                            }

                            public void setPhotofile(String photofile) {
                                this.photofile = photofile;
                            }

                            public String getPhotoid() {
                                return photoid;
                            }

                            public void setPhotoid(String photoid) {
                                this.photoid = photoid;
                            }

                            public String getPhotoname() {
                                return photoname;
                            }

                            public void setPhotoname(String photoname) {
                                this.photoname = photoname;
                            }
                        }


                    }

                    @Entity
                    public static class RecordBean {
                        @Id
                        private long id;
                        private String checkid;
                        private String descstr;
                        private String devicecode;
                        private String deviceid;
                        private String devicemodel;
                        private String devicename;
                        private String devicetypeid;
                        private String doidea;
                        private String partsid;
                        private String positionid;
                        private String projectid;
                        private String recordid;
                        private String riskresult;
                        private List<PhotoBean> photo;

                        public String getCheckid() {
                            return checkid;
                        }

                        public void setCheckid(String checkid) {
                            this.checkid = checkid;
                        }

                        public String getDescstr() {
                            return descstr;
                        }

                        public void setDescstr(String descstr) {
                            this.descstr = descstr;
                        }

                        public String getDevicecode() {
                            return devicecode;
                        }

                        public void setDevicecode(String devicecode) {
                            this.devicecode = devicecode;
                        }

                        public String getDeviceid() {
                            return deviceid;
                        }

                        public void setDeviceid(String deviceid) {
                            this.deviceid = deviceid;
                        }

                        public String getDevicemodel() {
                            return devicemodel;
                        }

                        public void setDevicemodel(String devicemodel) {
                            this.devicemodel = devicemodel;
                        }

                        public String getDevicename() {
                            return devicename;
                        }

                        public void setDevicename(String devicename) {
                            this.devicename = devicename;
                        }

                        public String getDevicetypeid() {
                            return devicetypeid;
                        }

                        public void setDevicetypeid(String devicetypeid) {
                            this.devicetypeid = devicetypeid;
                        }

                        public String getDoidea() {
                            return doidea;
                        }

                        public void setDoidea(String doidea) {
                            this.doidea = doidea;
                        }

                        public String getPartsid() {
                            return partsid;
                        }

                        public void setPartsid(String partsid) {
                            this.partsid = partsid;
                        }

                        public String getPositionid() {
                            return positionid;
                        }

                        public void setPositionid(String positionid) {
                            this.positionid = positionid;
                        }

                        public String getProjectid() {
                            return projectid;
                        }

                        public void setProjectid(String projectid) {
                            this.projectid = projectid;
                        }

                        public String getRecordid() {
                            return recordid;
                        }

                        public void setRecordid(String recordid) {
                            this.recordid = recordid;
                        }

                        public String getRiskresult() {
                            return riskresult;
                        }

                        public void setRiskresult(String riskresult) {
                            this.riskresult = riskresult;
                        }

                        public List<PhotoBean> getPhoto() {
                            return photo;
                        }

                        public void setPhoto(List<PhotoBean> photo) {
                            this.photo = photo;
                        }

                        @Entity
                        public static class PhotoBean {
                            /**
                             * descstr :
                             * dodate : 2017-07-04 16:00:07
                             * photofile : upload/sys/CheckException14591733847857310571499155212675.jpg
                             * photoid : 1499155390688854315
                             * photoname : CheckException14591733847857310571499155212675.jpg
                             */
                            @Id
                            private long id;
                            private String descstr;
                            private String dodate;
                            private String photofile;
                            private String photoid;
                            private String photoname;

                            public String getDescstr() {
                                return descstr;
                            }

                            public void setDescstr(String descstr) {
                                this.descstr = descstr;
                            }

                            public String getDodate() {
                                return dodate;
                            }

                            public void setDodate(String dodate) {
                                this.dodate = dodate;
                            }

                            public String getPhotofile() {
                                return photofile;
                            }

                            public void setPhotofile(String photofile) {
                                this.photofile = photofile;
                            }

                            public String getPhotoid() {
                                return photoid;
                            }

                            public void setPhotoid(String photoid) {
                                this.photoid = photoid;
                            }

                            public String getPhotoname() {
                                return photoname;
                            }

                            public void setPhotoname(String photoname) {
                                this.photoname = photoname;
                            }
                        }
                    }
                }
            }
        }
    }
}
