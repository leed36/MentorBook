package a497g.csci.leedjimin.mentorbook

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val username:String = getUsername.text.toString()
        val password:String = getPassword.text.toString()

        register_button.setOnClickListener{getSignUpActivity()}

        submit_button.setOnClickListener{checkSubmit(username,password)}

    }

    private fun checkSubmit(username:String, password:String){

        var check:Boolean = true;

        if(username.isEmpty() && password.isEmpty()){
            check = false
            Toast.makeText(this, "One login paramenter is empty, please try again", Toast.LENGTH_LONG).show()
        }

        //getUser
        val db = DatabaseManager(this)
        var user = db.getUser(username)


        // If user exists
        if(check/* && password.equals(user.getPASSWORD())*/) {
            val insertIntent = Intent(this, MainActivity::class.java)
            this.startActivity(insertIntent)
        }
        else{
            Toast.makeText(this, "Invalid Login, please try again", Toast.LENGTH_LONG).show()
            resetLogin()
        }


    }

    private fun resetLogin(){
        getUsername.setText("")
        getPassword.setText("")


    }
    private fun getSignUpActivity(){
        val insertIntent = Intent(this, SignUp::class.java)
        this.startActivity(insertIntent)
    }
}
