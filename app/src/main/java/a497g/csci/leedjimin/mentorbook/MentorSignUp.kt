package a497g.csci.leedjimin.mentorbook

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

        var username:String = mentor_email.text.toString()
        var password:String = mentor_pass.text.toString()
        var password2:String = mentor_pass2.text.toString()
        // Set up the sign in form, get variables
        mentor_signup_button.setOnClickListener{attemptSignUp(username,password,password2)}

    }

    fun attemptSignUp(username: String, password:String, password2:String){
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

            var user = User(username, password)
            val db = DatabaseManager(this)
            db.insert(user)

            val insertIntent = Intent(this, MainActivity::class.java)
            this.startActivity(insertIntent)
        }
    }

    fun resetSignUp(){
        mentor_email.setText("")
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
