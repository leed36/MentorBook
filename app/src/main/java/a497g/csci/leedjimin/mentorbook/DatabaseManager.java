package a497g.csci.leedjimin.mentorbook;

import android.content.Context;
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

    private static final String TABLE_LIFE_HISTORY = "lifeHistoryTable";
    private static final String PLACE = "place";
    private static final String SCHOOL_STARTED = "schoolStart";
    private static final String SCHOOL_END = "schoolEnd";
    private static final String START_WORK_YR = "workStart";
    private static final String END_WORK_YR = "workEnd";
    private static final String SCHOOL = "school";
    private static final String DEGREE_TYPE = "deg_type";
    private static final String DEGREE_NAME = "deg_name";
    private static final String CLASSNAME = "className";
    private static final String QUARTER = "quarter";
    private static final String YEAR_TAKE = "yearTake";

    public DatabaseManager (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCreateUser = "create table " + TABLE_USER + "( id";
        sqlCreateUser = sqlCreateUser + " integer primary key autoincrement, username";
        sqlCreateUser = sqlCreateUser + " text, password text, email ";
        sqlCreateUser = sqlCreateUser + "text, age integer,  date text)";

        String sqlCreateEducation = "create table eduHistTable( username";
        sqlCreateEducation = sqlCreateEducation + " text foreign key, school";
        sqlCreateEducation = sqlCreateEducation + " text, schoolStart text, schoolEnd";
        sqlCreateEducation = sqlCreateEducation + "text, deg_name text, ";
        sqlCreateEducation = sqlCreateEducation + "deg_type text)";

        String sqlCreateCourse = "create table coursesTable( ";
        sqlCreateCourse = sqlCreateCourse + "username text foreign key, classname text,";
        sqlCreateCourse = sqlCreateCourse + " yeartake integer";

        String sqlCreateWork = "create table workHistoryTable( ";
        sqlCreateWork = sqlCreateWork + "username text foreign key, place";
        sqlCreateWork = sqlCreateWork + "text, workstart integer, ";
        sqlCreateWork = sqlCreateWork + "workend integer)";

        db.execSQL(sqlCreateUser);
        db.execSQL(sqlCreateEducation);
        db.execSQL(sqlCreateCourse);
        db.execSQL(sqlCreateWork);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LIFE_HISTORY);
        onCreate(db);
    }

    public void insert(User Data) {

    }

    public ArrayList<User> search(String word) {
        ArrayList userList = new ArrayList<User>();
        return userList;
    }
}