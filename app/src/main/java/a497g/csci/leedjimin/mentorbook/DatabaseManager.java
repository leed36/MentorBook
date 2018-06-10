package a497g.csci.leedjimin.mentorbook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.widget.Toast;

import java.util.ArrayList;


public final class DatabaseManager extends SQLiteOpenHelper {
    private static final String ID = "id";
    private static final String DATABASE_NAME = "mentorBookDB";
    private static final int DATABASE_VERSION = 1;
    private static final String TYPE = "type";
    private static final String TABLE_USER = "userTable";
    private static final String PASSWORD = "password";
    private static final String EMAIL = "email";
    private static final String AGE = "age";
    private static final String PROFILE_PHOTO = "profilePhoto";

    private static final String EDUCATION_TABLE = "eduHistTable";
    private static final String PLACE = "place";
    private static final String SCHOOL_STARTED = "schoolStart";
    private static final String SCHOOL_END = "schoolEnd";

    private static final String CAREER_TABLE = "careerTable";
    private static final String CURRENT_POSITION = "currentPosition";
    private static final String START_WORK_YR = "workStart";
    private static final String END_WORK_YR = "workEnd";
    private static final String SCHOOL = "school";
    private static final String DEGREE_TYPE = "deg_type";
    private static final String DEGREE_NAME = "deg_name";

    private static final String COURSE_TABLE = "courseTable";
    private static final String CLASSNAME = "className";
    private static final String QUARTER = "quarter";
    private static final String YEAR_TAKE = "yearTake";


    private static final String NAME = "name";
    private static final String USERNAME = "username";
    private static final String WEBSITE = "website";
    private static final String HEADLINE = "headline";
    private static final String PHONE = "phone";
    private static final String DATE = "date";
    private static final String ADVICE = "advice";


    private static final String SCHOLARSHIP_TABLE = "scholarshipTable";
    private static final String DEGREE_TABLE = "degreeTable";
    private static final String TAG_TABLE = "tagTable";
    private static final String CHAPTER_TABLE = "chapterTable";



    public DatabaseManager (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        /** User table query    **/
        String sqlCreateUser = "create table " + TABLE_USER + "(username" ;
        sqlCreateUser = sqlCreateUser + " text primary key, email text, password";
        sqlCreateUser = sqlCreateUser + " text, type text, age text, date text, name";
        sqlCreateUser = sqlCreateUser + " text, website text, headline text, phone";
        sqlCreateUser = sqlCreateUser + " text, currentposition text, advice text)";

        /** Education table query   **/
        String sqlCreateEducation = "create table " +  EDUCATION_TABLE + "( username";
        sqlCreateEducation = sqlCreateEducation + " text, school";
        sqlCreateEducation = sqlCreateEducation + " text, schoolStart text, schoolEnd";
        sqlCreateEducation = sqlCreateEducation + " text, foreign key(username) references userTable(username))";

        /** Course Table query  **/
        String sqlCreateCourse = "create table " + COURSE_TABLE + "( ";
        sqlCreateCourse = sqlCreateCourse + "username text, classname text,";
        sqlCreateCourse = sqlCreateCourse + " yeartake integer,";
        sqlCreateCourse += "foreign key(username) references userTable(username))";

        /** Scholarship table query **/
        String sqlCreateScholarship = "create table " + SCHOLARSHIP_TABLE + "( username";
        sqlCreateScholarship = sqlCreateScholarship + " text, scholarship text,";
        sqlCreateScholarship += " foreign key(username) references userTable(username))";

        /** Chapter table query **/
        String sqlCreateChapter = "create table " + CHAPTER_TABLE + "(username";
        sqlCreateChapter = sqlCreateChapter + " text, chapter text,";
        sqlCreateChapter += " foreign key(username) references userTable(username))";

        /** Degree Table query  **/
        String sqlCreateDegree = "create table " + DEGREE_TABLE + "(username";
        sqlCreateDegree = sqlCreateDegree + " text, degreename text,";
        sqlCreateDegree += " foreign key(username) references userTable(username))";

        /** Tag table query **/
        String sqlCreateTags = "create table " + TAG_TABLE + "(username";
        sqlCreateTags = sqlCreateTags + " text, tag text,";
        sqlCreateTags += " foreign key(username) references userTable(username))";

        db.execSQL(sqlCreateUser);
        db.execSQL(sqlCreateEducation);
        db.execSQL(sqlCreateCourse);
        db.execSQL(sqlCreateScholarship);
        db.execSQL(sqlCreateChapter);
        db.execSQL(sqlCreateDegree);
        db.execSQL(sqlCreateTags);
//        db.execSQL(sqlCreateWork);
        //fake account
//        db.execSQL("insert into " + TABLE_USER + " (username, email, password, mentor, age, date, name, website, " +
//                "headline, phone, currentposition, advice) values(John123, johnatemail.com, john123, 22, 06/04/2018, John, " +
//                "john.com, here, 1234567889, SWEng, 'work hard')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + EDUCATION_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + COURSE_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + SCHOLARSHIP_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + CHAPTER_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + DEGREE_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + TAG_TABLE);
        onCreate(db);
    }

    public void dropTable(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + EDUCATION_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + COURSE_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + SCHOLARSHIP_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + CHAPTER_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + DEGREE_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + TAG_TABLE);

    }

    /** Created by Sam Baek
     *
     *
     */
    public User findUser(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        User user = new User();
        Cursor cursor = db.rawQuery("SELECT * from " + TABLE_USER +" WHERE username = ?", new String[] {name});
        if(cursor.moveToFirst()){
            user.setUSERNAME(cursor.getString(0));
            user.setEMAIL(cursor.getString(1));
            user.setPASSWORD(cursor.getString(2));
            user.setTYPE(cursor.getString(3));
            user.setAGE(cursor.getString(4));
            user.setDATE(cursor.getString(5));
            user.setNAME(cursor.getString(6));
            user.setWEBSITE(cursor.getString(7));
            user.setHEADLINE(cursor.getString(8));
            user.setPHONE(cursor.getString(9));
            user.setCURRPOSITION(cursor.getString(10));
            user.setADVICE(cursor.getString(11));
        }else{
            user.setUSERNAME("");
            user.setEMAIL("");
            user.setPASSWORD("");
            user.setTYPE("");
            user.setAGE("");
            user.setDATE("");
            user.setNAME("");
            user.setWEBSITE("");
            user.setHEADLINE("");
            user.setPHONE("");
            user.setCURRPOSITION("");
            user.setADVICE("");
        }

        return user;
    }

    /** Created by Trevor Glass
     *
     *
     */
    public User findUserBasic(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        User user = new User();
        Cursor cursor = db.rawQuery("SELECT * from " + TABLE_USER +" WHERE username = ?", new String[] {name});
        if(cursor.moveToFirst()){
            user.setUSERNAME(cursor.getString(0));
            user.setEMAIL(cursor.getString(1));
            user.setPASSWORD(cursor.getString(2));
        }else{
            user.setUSERNAME("");
            user.setEMAIL("");
            user.setPASSWORD("");
        }

        return user;
    }

    /** Created by Trevor Glass
     *
     * Used in MentorSignUp and Mentee SignUp to register user
     */
    public void insertWithEmailAndPW(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(USERNAME,user.getUSERNAME());
        values.put(EMAIL, user.getEMAIL());
        values.put(PASSWORD, user.getPASSWORD());
        db.insert(TABLE_USER,null,values);

        db.close();
    }
    /** Created by Trevor Glass
     *
     *  Used in Chapter Fragment to add chapter into database
     */
    public void insertChapter(String user, String chapter){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(USERNAME,user);
        values.put("chapter", chapter);
        db.insert(CHAPTER_TABLE,null,values);
        db.close();
    }

    public ArrayList<String> getChapters(String username){
        String[] args = {username};
        String sqlQuery = "select * from " + CHAPTER_TABLE;
        sqlQuery += " where " + USERNAME + " = ?";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sqlQuery, args);

        ArrayList<String> chapters = new ArrayList<String>();

         while(cursor.moveToNext()){
             chapters.add(cursor.getString(1));
         }
         cursor.close();

         db.close();
         return chapters;
    }


    public void insertBioWithUN(User user) { //update
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlInsert = "update" + TABLE_USER;
        sqlInsert += "set " +"a";
        sqlInsert += "where " + EMAIL + " = " + user.getEMAIL();
    }

    public void deleteByEmail(String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlDelete = "delete from " + TABLE_USER;
        sqlDelete += " where " + EMAIL + " = " + email;
        db.execSQL(sqlDelete);
        db.close();
    }

    public User getUser(String username){
        User user = new User();
        String sqlQuery = "select * from " + TABLE_USER;
        sqlQuery += " where " + USERNAME + " = " + username + "";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sqlQuery, null);

        if(cursor.moveToFirst()) {
            user.setUSERNAME(cursor.getString(0));
        }

        return user;
    }

    /** Created by Trevor Glass
     * Currently used for testing purposes to see if users can be retreieved from table
     * @return
     */
    public ArrayList<User> getAllUsers(){
        String sqlQuery = "select * from " + TABLE_USER;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sqlQuery, null);
        ArrayList<User> users = new ArrayList<User>();

        while(cursor.moveToNext()){
            User user = new User();
            user.setUSERNAME(cursor.getString(0));
            users.add(user);
        }

        return users;

    }

    public ArrayList<User> search(String word) { //FIX THIS
        String sqlQuery = "select * from " + TABLE_USER;
        sqlQuery += " where " + EMAIL + " = " + word + "";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sqlQuery, null);

        ArrayList<User> users = new ArrayList<User>();

        while (cursor.moveToNext()) {
            User user = new User();
            users.add(user);
        }
        cursor.close();
        return users;
    }

    public ArrayList<User> searchMentors() { //FIX THIS
        String sqlQuery = "select * from " + TABLE_USER;
        sqlQuery += " where " + TYPE + " = mentor";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sqlQuery, null);

        ArrayList<User> users = new ArrayList<User>();

        while (cursor.moveToNext()) {
            User user = new User();
            users.add(user);
        }
        cursor.close();
        return users;
    }

    public void updateProfile(String nam, String userNam, String web, String headLine, String Phone){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, nam);
        contentValues.put(USERNAME, userNam);
        contentValues.put(WEBSITE, web);
        contentValues.put(HEADLINE, headLine);
        contentValues.put(PHONE, Phone);
        db.update(TABLE_USER, contentValues, "username = ?",new String[] {userNam});
    }


    public void updateBio(){

    }
}
