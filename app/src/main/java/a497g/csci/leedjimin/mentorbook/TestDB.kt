package a497g.csci.leedjimin.mentorbook

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import java.util.ArrayList
import kotlinx.android.synthetic.main.activity_test_db.*



class TestDB : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_db)

        test.setOnClickListener{
            val db = DatabaseManager(this)
            var user: ArrayList<User> = db.getAllUsers();
            if(user.size == 0){
                Toast.makeText(this, "Nothing in user table", Toast.LENGTH_LONG).show()
                test8.setText("Nothing in user table");
            }else{
                test8.setText(user.size.toString());
            }
            if(user.size > 0) test1.setText(user[0].getUSERNAME());
            if(user.size > 1) test2.setText(user[1].getUSERNAME());
            if(user.size > 2) test3.setText(user[2].getUSERNAME());
            if(user.size > 3) test4.setText(user[3].getUSERNAME());
            if(user.size > 4) test5.setText(user[4].getUSERNAME());
            if(user.size > 5) test6.setText(user[5].getUSERNAME());
            if(user.size > 6) test7.setText(user[6].getUSERNAME());



        }


    }
}