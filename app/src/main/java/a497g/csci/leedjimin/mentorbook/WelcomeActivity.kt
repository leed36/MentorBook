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

        register_button.setOnClickListener{getSignUpActivity()}

        testButton.setOnClickListener{
            val insertIntent = Intent(this, TestDB::class.java)
            this.startActivity(insertIntent)
        }

        submit_button.setOnClickListener{checkSubmit()}

    }

    private fun checkSubmit(){

        var check:Boolean = true;
        val username:String = getUsername.text.toString()
        val password:String = getPassword.text.toString()

        if(username.isEmpty() && password.isEmpty()){
            check = false
            Toast.makeText(this, "One login paramenter is empty, please try again", Toast.LENGTH_LONG).show()
        }

        //getUser
        val db = DatabaseManager(this)
        var user = db.findUserBasic(username);
        
        if(user.getUSERNAME().equals("")){
            check = false
            Toast.makeText(this, "username:" + username + " does not exist", Toast.LENGTH_LONG).show()
        }

        if(!user.getPASSWORD().equals(password)){
            Toast.makeText(this, "DBpass:" + user.getPASSWORD() + " you entered: " + password, Toast.LENGTH_LONG).show()

            check = false
            Toast.makeText(this, "incorrect password", Toast.LENGTH_LONG).show()

        }


        // If user exists
        if(check) {
            Toast.makeText(this, "Login Successful", Toast.LENGTH_LONG).show()
            val insertIntent = Intent(this, MainActivity::class.java)
            insertIntent.putExtra("Username", user.username)
            this.startActivity(insertIntent)
        }
        else{
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
