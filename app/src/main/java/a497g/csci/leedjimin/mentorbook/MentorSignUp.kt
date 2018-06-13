package a497g.csci.leedjimin.mentorbook


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.content.Intent
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_mentor_signup.*

/**
 * A login screen that offers login via email/password.
 */
class MentorSignUp : AppCompatActivity(){
    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */
//    private var mAuthTask: UserLoginTask? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mentor_signup)
        // Set up the sign in form, get variables
        mentor_signup_button.setOnClickListener{attemptSignUp()}

    }

    private fun attemptSignUp(){
        var check: Boolean = true
        val username:String = mentor_username.text.toString()
        val email:String = mentor_email.text.toString()
        val password:String = mentor_pass.text.toString()
        val password2:String = mentor_pass2.text.toString()

        /** Check password authenticity **/
        if(!TextUtils.isEmpty(password) && !isPasswordValid(password)){
            check = false
            Toast.makeText(this, "Invalid password, please try again", Toast.LENGTH_LONG).show()
        }

        if(!password.equals(password2)){
            Toast.makeText(this, "Passwords do not equal, please try again", Toast.LENGTH_LONG).show()
            check = false
        }

        /** Check Username **/

        if(!isUsernameValid(username)){
            Toast.makeText(this, "Invalid Username, please try again", Toast.LENGTH_LONG).show()

        }


        /** Check for a valid email address **/
        if (TextUtils.isEmpty(username)) {
            Toast.makeText(this, "Please enter username, try again", Toast.LENGTH_LONG).show()

            check = false
        }
        if (!isEmailValid(email)) {
            Toast.makeText(this, "Please enter valid email, try again", Toast.LENGTH_LONG).show()
            check = false
        }

        if(check == false){
            resetSignUp()
        }else{

            /*
             *  Registration is complete, save info in database and go to main activity
             */
            val user = User(username, email, password, "mentor")
            val db = DatabaseManager(this)
            db.insertWithEmailAndPW(user)
            Toast.makeText(this, "Login Sucessful for " + user.getUSERNAME() + ", "+ user.getEMAIL() + ", "+ user.getPASSWORD() , Toast.LENGTH_LONG).show()
            val insertIntent = Intent(this, MainActivity::class.java)
            insertIntent.putExtra("Username", user.getUSERNAME());
            this.startActivity(insertIntent)
        }
    }

    private fun isUsernameValid(username: String): Boolean {
        val db = DatabaseManager(this)
        var check:Boolean = true

        /** Check if username is unique **/
        val checkUser:User = db.findUserBasic(username)
        if(!checkUser.getUSERNAME().equals("")){
            check = false
            Toast.makeText(this, "Username already in use, create unique username", Toast.LENGTH_LONG).show()
        }

        return check
    }

    fun resetSignUp(){
        mentor_email.setText("")
        mentor_username.setText("")
        mentor_pass2.setText("")
        mentor_pass.setText("")

    }

    fun isEmailValid(username:String):Boolean{
        return username.contains("@")
    }

    fun isPasswordValid(password:String):Boolean{
        return true
    }

}
