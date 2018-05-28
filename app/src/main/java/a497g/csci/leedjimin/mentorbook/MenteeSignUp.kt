package a497g.csci.leedjimin.mentorbook



/*


----------------- This should be mentee signup -----------------------------

 */
import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.annotation.TargetApi
import android.content.pm.PackageManager
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.app.LoaderManager.LoaderCallbacks
import android.content.CursorLoader
import android.content.Loader
import android.database.Cursor
import android.net.Uri
import android.os.AsyncTask
import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract
import android.text.TextUtils
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.ArrayAdapter
import android.widget.TextView

import java.util.ArrayList
import android.Manifest.permission.READ_CONTACTS
import android.content.Intent

import kotlinx.android.synthetic.main.activity_mentee_signup.*

/**
 * A login screen that offers login via email/password.
 */
class MenteeSignUp : AppCompatActivity(){
    val db = DatabaseManager(this)
    val user = User()
    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */
//    private var mAuthTask: UserLoginTask? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mentee_signup)

        var username: String = mentee_user_input.text.toString()
        var password: String = mentee_pass.text.toString()
        var password2: String = mentee_pass2.text.toString()

        mentee_signup_button.setOnClickListener { attemptLogin(username, password, password2) }
    }

    fun attemptLogin(username: String, password:String, password2:String){
        var check: Boolean = true

        /** Check password authenticity **/
        if(!TextUtils.isEmpty(password) && !isPasswordValid(password)){
            check = false
        }

        if(!password.equals(password2)){
            check = false
        }

        /** Check Username **/
        // Check for a valid email address.
        if (TextUtils.isEmpty(username)) {
            check = false
        } else if (!isEmailValid(username)) {
            check = false
        }

        if(check == false){
            resetSignUp()
        }else{

            /*
             *  Registration is complete, save info in database and go to main activity
             */
            //INSERT USER FIELDS HERE

            db.insertWithEmailAndPW(user)

            val insertIntent = Intent(this, MainActivity::class.java)
            this.startActivity(insertIntent)
        }
    }

    fun resetSignUp(){
        mentee_user_input.setText("")
        mentee_pass2.setText("")
        mentee_pass.setText("")

    }

    fun isEmailValid(username:String):Boolean{
        return username.contains("@")
    }

    fun isPasswordValid(password:String):Boolean{
        return true
    }

}
