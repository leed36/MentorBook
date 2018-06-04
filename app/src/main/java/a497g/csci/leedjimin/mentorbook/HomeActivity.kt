package a497g.csci.leedjimin.mentorbook

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        button.setOnClickListener {
            val insertIntent = Intent(this, MainActivity::class.java)
            this.startActivity(insertIntent)
        }
    }
}
