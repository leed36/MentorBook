package a497g.csci.leedjimin.mentorbook;

import android.support.constraint.Placeholder;

public class User {
    private int TYPE = 0; //0 for mentee; 1 for mentor
    private String EMAIL = "email";
    private String PASSWORD = "password";
    private String AGE = "age";
    private String PROFILE_PHOTO = "profilePhoto";
    private String SCHOOL_START = "schoolStart";
    private String SCHOOL_END = "schoolEnd";
    private String PLACE = "place";
    private String START_WORK_YR = "workStart";
    private String END_WORK_YR = "workEnd";
    private String SCHOOL = "school";
    private String DEGREE_TYPE = "deg_type";
    private String DEGREE_NAME = "deg_name";
    private String CLASSNAME = "className";
    private String YEAR_TAKE = "yearTake";

    public User() {
    }

    //SETTERS
    public void setTYPE(int i) {
        this.TYPE = i;
    }

    public void setAGE(String AGE) {
        this.AGE = AGE;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

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

    //GETTERS
    public int getTYPE() {return TYPE; }

    public String getAGE() {
        return AGE;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

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
}
