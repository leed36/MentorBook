package a497g.csci.leedjimin.mentorbook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

import java.util.ArrayList;


public final class DatabaseManager extends SQLiteOpenHelper {
    private static final String ID = "id";
    private static final String DATABASE_NAME = "mentorBookDB";
    private static final int DATABASE_VERSION = 1;
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


    public DatabaseManager (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCreateUser = "create table " + TABLE_USER + "( username";
        sqlCreateUser = sqlCreateUser + " text primary key, email text, password";
        sqlCreateUser = sqlCreateUser + " text, age integer, date text, name text, website text, headline text, phone text, position text, advice text)";

        String sqlCreateEducation = "create table eduHistTable( username";
        sqlCreateEducation = sqlCreateEducation + " text foreign key, school";
        sqlCreateEducation = sqlCreateEducation + " text, schoolStart text, schoolEnd";
        sqlCreateEducation = sqlCreateEducation + "text, deg_name text, ";
        sqlCreateEducation = sqlCreateEducation + "deg_type text)";

        String sqlCreateCourse = "create table courseTable( ";
        sqlCreateCourse = sqlCreateCourse + "username text foreign key, classname text,";
        sqlCreateCourse = sqlCreateCourse + " yeartake integer";

        String sqlCreateWork = "create table careerTable( ";
        sqlCreateWork = sqlCreateWork + "email text foreign key, place ";
        sqlCreateWork = sqlCreateWork + "text, workstart integer, ";
        sqlCreateWork = sqlCreateWork + "workend integer)";

        db.execSQL(sqlCreateUser);
//        db.execSQL(sqlCreateEducation);
//        db.execSQL(sqlCreateCourse);
//        db.execSQL(sqlCreateWork);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + EDUCATION_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + COURSE_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + CAREER_TABLE);
        onCreate(db);
    }

    public void insertWithEmailAndPW(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(USERNAME,user.getUSERNAME());
        values.put(EMAIL, user.getEMAIL());
        values.put(PASSWORD, user.getEMAIL());
        db.insert(TABLE_USER,null,values);
//        String sqlInsert = "INSERT INTO " + TABLE_USER + " (username, password)";
//        sqlInsert += "VALUES (" + user.getUSERNAME() +", " + user.getPASSWORD() + ")";
//        db.execSQL(sqlInsert);
        db.close();
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

     /*   SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sqlQuery, null);

        if(cursor.moveToFirst()) {
            user.setUSERNAME(cursor.getColumnIndex(1).toString())
        }*/

        return user;
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
        return users;
    }

    public void updateProfile(String nam, String userNam, String web, String headLine, String Phone){
        SQLiteDatabase db = this.getWritableDatabase();
        String profileUpdate;
    }
    public void retrieveProfile(String userName){
        SQLiteDatabase db = this.getWritableDatabase();
        String profileRetrieve = "select name,username,website,headline,phone from " + TABLE_USER;
        profileRetrieve += " where username = " + userName;
    }


    public void updateBio(){

    }
}
