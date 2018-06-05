package a497g.csci.leedjimin.mentorbook

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {

    var username:String = ""
    var password:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)


        register_button.setOnClickListener{getSignUpActivity()}

        submit_button.setOnClickListener{checkSubmit()}

    }

    private fun checkSubmit() {

        username = getUsername.text.toString()
        password = getPassword.text.toString()

        var check:Boolean = true;
        Log.d("ADebugTag", "username: " + username);
        Log.d("ADebugTag", "password: " + password);
        if(username.isEmpty() && password.isEmpty()){
            check = false
            Toast.makeText(this, "One login paramenter is empty, please try again", Toast.LENGTH_LONG).show()
        }

        //getUser
        val db = DatabaseManager(this)
        var user: (String)->User = fun(username) = db.getUser(username)


        // If user exists
        Log.d("ADebugTag", "password1: " + password);
        Log.d("ADebugTag", "password: " + user.getPassword());
        if(check && password.equals(user.getPASSWORD())) {
            val insertIntent = Intent(this, MainActivity::class.java)
            insertIntent.putExtra("Username", user.username)
            this.startActivity(insertIntent)
        }
        else{
            Toast.makeText(this, "Invalid Login, please try again", Toast.LENGTH_LONG).show()
            resetLogin()
        }


    }

    private fun resetLogin(){ //resets the password textbox
        getPassword.setText("")


    }
    private fun getSignUpActivity(){
        val insertIntent = Intent(this, SignUp::class.java)
        this.startActivity(insertIntent)
    }
}
