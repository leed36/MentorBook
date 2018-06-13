package a497g.csci.leedjimin.mentorbook;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;
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
    private static final String WORK_HISTORY = "workHistory";
    private static final String MAJOR_MINOR = "majorMinor";
    private static final String SCHOLARSHIP = "scholarship";
    private static final String TAG = "tag";


    private static final String SCHOLARSHIP_TABLE = "scholarshipTable";
    private static final String DEGREE_TABLE = "degreeTable";
    private static final String TAG_TABLE = "tagTable";
    private static final String CHAPTER_TABLE = "chapterTable";
    private static final String FOLLOWER_TABLE = "followerTable";



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
        sqlCreateUser = sqlCreateUser + " text, currentposition text, advice text, workHistory text, image BLOB)";

        /** Education table query   **/
        String sqlCreateEducation = "create table " +  EDUCATION_TABLE + "( username";
        sqlCreateEducation = sqlCreateEducation + " text, school";
        sqlCreateEducation = sqlCreateEducation + " text, schoolStart text, schoolEnd";
        sqlCreateEducation = sqlCreateEducation + " text, majorMinor text, foreign key(username) references userTable(username))";

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

        /** Follower table **/
        String sqlCreateFollower = "create table " + FOLLOWER_TABLE + "(username";
        sqlCreateFollower = sqlCreateFollower + " text, following text,";
        sqlCreateFollower = sqlCreateFollower + " foreign key(username) references userTable(username))";

        db.execSQL(sqlCreateUser);
        db.execSQL(sqlCreateEducation);
        db.execSQL(sqlCreateCourse);
        db.execSQL(sqlCreateScholarship);
        db.execSQL(sqlCreateChapter);
        db.execSQL(sqlCreateDegree);
        db.execSQL(sqlCreateTags);
        db.execSQL(sqlCreateFollower);
//        db.execSQL(sqlCreateWork);
        //fake account

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
        db.execSQL("DROP TABLE IF EXISTS " + FOLLOWER_TABLE);

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

    public String getFollowing(String user, String following){
        SQLiteDatabase db = this.getWritableDatabase();
        String result = "";
        try{
            Cursor cursor = db.rawQuery("SELECT * from " + FOLLOWER_TABLE +" WHERE username = ? and following = ?", new String[] {user,following});
            if(cursor.moveToFirst())result = cursor.getString(1);
        }catch(IllegalArgumentException e){

        }
        db.close();
        return result;
    }

    public void insertFollower(String user, String following){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username",user);
        values.put("following", following);
        db.insert(FOLLOWER_TABLE,null,values);
        db.close();

    }

    /** Created by Sam Baek
     *
     *
     */
    public User findUser(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        User user = new User();
        ArrayList<String> tags = new ArrayList<>();
        Cursor currrr = db.rawQuery("SELECT * from " + TAG_TABLE + " WHERE username = ?", new String[] {name});
        while(currrr.moveToNext()){
            tags.add(currrr.getString(1));
        }
        user.setTAG(tags);
        currrr.close();

        Cursor currr = db.rawQuery("SELECT * from " + SCHOLARSHIP_TABLE + " WHERE username = ?", new String[] {name});
        if(currr.moveToFirst()){
            user.setSCHOLARSHIP(currr.getString(1));
        }else{
            user.setSCHOLARSHIP("Separate each Scholarships with new line!");
        }
        currr.close();

        Cursor curr = db.rawQuery("SELECT * from " + COURSE_TABLE + " WHERE username = ?", new String[] {name});
        if(curr.moveToFirst()){
            user.setCLASSNAME(curr.getString(1));
        }else{
            user.setCLASSNAME("ex) CSCI 141 - 2018 ");
        }
        curr.close();

        Cursor cur = db.rawQuery("SELECT * from " + EDUCATION_TABLE + " WHERE username = ?", new String[] {name});
        if(cur.moveToFirst()){
            user.setSCHOOL(cur.getString(1));
            user.setMAJORMINOR(cur.getString(4));
        }else{
            user.setSCHOOL("");
            user.setMAJORMINOR("ex) Computer Science / Math");
        }
        cur.close();

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
            user.setWORKHISTORY(cursor.getString(12));
            cursor.close();
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
            user.setWORKHISTORY("");
        }
        cursor.close();

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
        values.put(TYPE, user.getTYPE());
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
        db.close();
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

        cursor.close();
        db.close();
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

        db.close();
        cursor.close();
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
        db.close();
        return users;
    }

    public ArrayList<User> searchByType(String type) { //FIX THIS
        String sqlQuery = "select * from " + TABLE_USER;
        sqlQuery += " where " + TYPE + " = '" + type + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sqlQuery, null);

        ArrayList<User> users = new ArrayList<User>();

        while (cursor.moveToNext()) {
            User user = new User();
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
            Log.w("adding user", user.getUSERNAME());
            users.add(user);
        }
        cursor.close();
        db.close();
        return users;
    }

    public void updateProfile(String nam, String userNam, String web, String headLine, String Phone){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, nam);
        contentValues.put(WEBSITE, web);
        contentValues.put(HEADLINE, headLine);
        contentValues.put(PHONE, Phone);
        db.update(TABLE_USER, contentValues, "username = ?",new String[] {userNam});
        db.close();
    }


    public void updateBioU(String userNam, String currPosition, String workHistory, String advice){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CURRENT_POSITION, currPosition);
        contentValues.put(WORK_HISTORY, workHistory);
        contentValues.put(ADVICE, advice);
        db.update(TABLE_USER, contentValues, "username = ?", new String[] {userNam});
    }
    public void insertBioEM(String userNam, String education, String majorminor){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cur = db.rawQuery("SELECT * FROM " + EDUCATION_TABLE + " WHERE username = ?", new String[] {userNam});
        int count = 0;
        if(cur.moveToFirst()){
            count ++;
        }
        if(count == 0){
            ContentValues values = new ContentValues();
            values.put(USERNAME, userNam);
            values.put(SCHOOL, education);
            values.put(MAJOR_MINOR, majorminor);
            db.insert(EDUCATION_TABLE, null, values);
            db.close();
        }
    }
    public void updateBioE(String userNam, String school, String majorMinor){
        SQLiteDatabase db1 = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put(SCHOOL, school);
        content.put(MAJOR_MINOR, majorMinor);
        db1.update(EDUCATION_TABLE, content, "username = ?", new String[] {userNam});
    }

    public void insertBioC(String userNam, String course){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cur = db.rawQuery("SELECT * FROM " + COURSE_TABLE + " WHERE username = ?", new String[] {userNam});
        int count = 0;
        if(cur.moveToFirst()){
            count ++;
        }
        if(count == 0){
            ContentValues values = new ContentValues();
            values.put(USERNAME, userNam);
            values.put(CLASSNAME, course);
            db.insert(COURSE_TABLE, null, values);
            db.close();
        }
    }
    public void updateBioC(String userNam, String course){
        SQLiteDatabase db2 = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put(CLASSNAME, course);
        db2.update(COURSE_TABLE, content, "username = ?", new String[] {userNam});
    }
    public void insertBioS(String userNam, String scholarship){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cur = db.rawQuery("SELECT * FROM " + SCHOLARSHIP_TABLE + " WHERE username = ?", new String[] {userNam});
        int count = 0;
        if(cur.moveToFirst()){
            count ++;
        }
        if(count == 0){
            ContentValues values = new ContentValues();
            values.put(USERNAME, userNam);
            values.put(SCHOLARSHIP, scholarship);
            db.insert(SCHOLARSHIP_TABLE, null, values);
            db.close();
        }
    }
    public void updateBioS(String userNam, String scholarship){
        SQLiteDatabase db3 = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put(SCHOLARSHIP, scholarship);
        db3.update(SCHOLARSHIP_TABLE, content, "username = ?", new String[] {userNam});
    }
    public void updateBioT(String userNam, ArrayList<String> tag){
        for(int i = 0; i < tag.size(); i ++){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(USERNAME, userNam);
            values.put(TAG, tag.get(i));
            db.insert(TAG_TABLE,null,values);
            db.close();
        }
    }
    public void deleteBioT(String userNam){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cur = db.rawQuery("SELECT * from " + TAG_TABLE + " WHERE username = ?", new String[] {userNam});
        int count = 0;
        while(cur.moveToNext()){
            count ++;
        }
        if(count != 0){
            db.delete(TAG_TABLE, "username = ?", new String[] {userNam});
        }
    }


    public void insertImage( String username, byte[] image) throws SQLiteException {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("image",image);
        db.update(TABLE_USER, cv, USERNAME + " = ?", new String[]{username});
        db.close();
    }

    public byte[] getImage(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        byte[] image;
        Cursor cursor = db.rawQuery("SELECT * from " + TABLE_USER +" WHERE username = ?", new String[] {username});
        if(cursor.moveToFirst()){
            image = cursor.getBlob(12);
        }else{
            image = null;
        }
        db.close();
        return image;
    }

    public ArrayList<String> getFollowers(String username){
        ArrayList<String> followers = new ArrayList<String>();
        String[] args = {username};

        String sqlQuery = "select * from " + FOLLOWER_TABLE + " where username = ?";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sqlQuery, args);
        while(cursor.moveToNext()){
            followers.add(cursor.getString(1));
        }

        db.close();
        cursor.close();
        return followers;

    }

}
