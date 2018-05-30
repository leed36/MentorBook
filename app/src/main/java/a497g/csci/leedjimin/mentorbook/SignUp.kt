package a497g.csci.leedjimin.mentorbook

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        mentor_button.setOnClickListener{
            val mentorIntent = Intent(this, MentorSignUp::class.java)
            this.startActivity(mentorIntent)
        }

        mentee_button.setOnClickListener{
            val menteeIntent = Intent(this, MenteeSignUp::class.java)
            this.startActivity(menteeIntent)
        }

    }
}
