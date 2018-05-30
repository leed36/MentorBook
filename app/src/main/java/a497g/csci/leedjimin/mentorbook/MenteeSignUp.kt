package a497g.csci.leedjimin.mentorbook



/*
----------------- This is mentee signup -----------------------------
 */

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.content.Intent
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_mentee_signup.*


/**
 * A login screen that offers login via email/password.
 */
class MenteeSignUp : AppCompatActivity() {
    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */
//    private var mAuthTask: UserLoginTask? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mentee_signup)

        val username: String = mentee_username.text.toString()
        val email: String = mentee_email.text.toString()
        val password: String = mentee_pass.text.toString()
        val password2: String = mentee_pass2.text.toString()
        // Set up the sign in form, get variables
        mentee_signup_button.setOnClickListener { attemptSignUp(username, email, password, password2) }

    }

    private fun attemptSignUp(username: String, email: String, password: String, password2: String) {
        var check: Boolean = true

        /** Check password authenticity **/
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            check = false
            Toast.makeText(this, "Invalid password, please try again", Toast.LENGTH_LONG).show()
        }

        if (!password.equals(password2)) {
            Toast.makeText(this, "Passwords do not equal, please try again", Toast.LENGTH_LONG).show()
            check = false
        }

        /** Check Username **/

        if (!isUsernameValid(username)) {
            Toast.makeText(this, "Invalid Username, please try again", Toast.LENGTH_LONG).show()

        }


        /** Check for a valid email address **/
        if (!TextUtils.isEmpty(username)) {
            Toast.makeText(this, "Please enter email, try again", Toast.LENGTH_LONG).show()

            check = false
        }
        if (isEmailValid(email)) {
            Toast.makeText(this, "Please enter valid email, try again", Toast.LENGTH_LONG).show()
            check = false
        }

        if (check == false) {
            resetSignUp()
        } else {

            /*
             *  Registration is complete, save info in database and go to main activity
             */
            Toast.makeText(this, "Login Sucessful", Toast.LENGTH_LONG).show()

            val user = User(username, email, password, 0)
            val db = DatabaseManager(this)
            db.insertWithEmailAndPW(user)

            val insertIntent = Intent(this, MainActivity::class.java)
            this.startActivity(insertIntent)
        }
    }

    private fun isUsernameValid(username: String): Boolean {
        return true
    }

    fun resetSignUp() {
        mentee_email.setText("")
        mentee_username.setText("")
        mentee_pass2.setText("")
        mentee_pass.setText("")

    }

    fun isEmailValid(username: String): Boolean {
        return username.contains("@")
    }

    fun isPasswordValid(password: String): Boolean {
        return true
    }
}
