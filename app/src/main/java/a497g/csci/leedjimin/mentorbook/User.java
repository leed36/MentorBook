package a497g.csci.leedjimin.mentorbook;

import android.support.constraint.Placeholder;

public class User {
    private String TYPE = "";
    private String USERNAME = "";
    private String NAME = "";
    private String EMAIL = "";
    private String PASSWORD = "";
    private String AGE = "";
    private String DATE = "";
    private String PROFILE_PHOTO;
    private String SCHOOL_START = "";
    private String SCHOOL_END = "";
    private String PLACE = "";
    private String START_WORK_YR = "";
    private String END_WORK_YR = "";
    private String SCHOOL = "";
    private String DEGREE_TYPE = "";
    private String DEGREE_NAME = "";
    private String CLASSNAME = "";
    private String YEAR_TAKE = "";
    private String WEBSITE = "";
    private String HEADLINE = "";
    private String PHONE = "";
    private String CURRPOSITION = "";
    private String ADVICE = "";
    private String WORKHISTORY = "";
    private String MAJORMINOR = "";
    private String SCHOLARSHIP = "";
    private String TAG = "";


    //Constructor used in MentorSignUp & MenteeSignUp kt files
    public User(){

    }

    public User(String username, String email, String password, String type) {
        this.USERNAME = username;
        this.EMAIL = email;
        this.PASSWORD = password;
        this.TYPE = type;
    }
    public User(String username){
        this.USERNAME = username;
    }

    //SETTERS
    public void setTAG(String t) { this.TAG = t; }

    public void setSCHOLARSHIP(String s) { this.SCHOLARSHIP = s;}

    public void setWORKHISTORY(String wh) { this.WORKHISTORY = wh; }

    public void setMAJORMINOR (String mm){ this.MAJORMINOR = mm; }

    public void setTYPE(String ty) {
        this.TYPE = ty;
    }

    public void setUSERNAME(String un) { this.USERNAME = un; }

    public void setAGE(String AGE) {
        this.AGE = AGE;
    }

    public void setNAME(String NAME){ this.NAME = NAME; }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public void setDATE(String DATE) { this.DATE = DATE; }

    public void setSCHOOL_START(String DATE_STARTED) {
        this.SCHOOL_START = DATE_STARTED;
    }

    public void setSCHOOL_END(String SCHOOL_END) {
        this.SCHOOL_END = SCHOOL_END;
    }

    public void setPLACE(String PLACE) {
        this.PLACE = PLACE;
    }

    public void setSTART_WORK_YR(String START_WORK_YR) {
        this.START_WORK_YR = START_WORK_YR;
    }

    public void setEND_WORK_YR(String END_WORK_YR) {
        this.END_WORK_YR = END_WORK_YR;
    }

    public void setSCHOOL(String SCHOOL) {
        this.SCHOOL = SCHOOL;
    }

    public void setDEGREE_TYPE(String DEGREE_TYPE) {
        this.DEGREE_TYPE = DEGREE_TYPE;
    }

    public void setDEGREE_NAME(String DEGREE_NAME) {
        this.DEGREE_NAME = DEGREE_NAME;
    }

    public void setCLASSNAME(String CLASSNAME) {
        this.CLASSNAME = CLASSNAME;
    }

    public void setWEBSITE(String WEBSITE) { this.WEBSITE = WEBSITE; }

    public void setHEADLINE(String HEADLINE) { this.HEADLINE = HEADLINE; }

    public void setPHONE(String PHONE) { this.PHONE = PHONE; }

    public void setCURRPOSITION(String CURRPOSITION) { this.CURRPOSITION = CURRPOSITION; }

    public void setADVICE(String ADVICE) { this.ADVICE = ADVICE; }

    //GETTERS
    public String getTAG() { return TAG; }

    public String getSCHOLARSHIP() {return SCHOLARSHIP;}

    public String getWORKHISTORY() {return WORKHISTORY;}

    public String getMAJORMINOR() {return MAJORMINOR;}

    public String getTYPE() {return TYPE; }

    public String getUSERNAME() {
        return USERNAME;
    }

    public String getNAME(){ return NAME; }

    public String getAGE() {
        return AGE;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public String getDATE(){ return DATE; }

    public String getSCHOOL_START() {
        return SCHOOL_START;
    }

    public String getSCHOOL_END() {
        return SCHOOL_END;
    }

    public String getPLACE() {
        return PLACE;
    }

    public String getSTART_WORK_YR() {
        return START_WORK_YR;
    }

    public String getEND_WORK_YR() {
        return END_WORK_YR;
    }

    public String getSCHOOL() {
        return SCHOOL;
    }

    public String getDEGREE_TYPE() {
        return DEGREE_TYPE;
    }

    public String getDEGREE_NAME() {
        return DEGREE_NAME;
    }

    public String getCLASSNAME() {
        return CLASSNAME;
    }

    public String getWEBSITE() {
        return WEBSITE;
    }

    public String getHEADLINE() {
        return HEADLINE;
    }

    public String getPHONE() {
        return PHONE;
    }

    public String getCURRPOSITION() {
        return CURRPOSITION;
    }

    public String getADVICE() {
        return ADVICE;
    }
}
