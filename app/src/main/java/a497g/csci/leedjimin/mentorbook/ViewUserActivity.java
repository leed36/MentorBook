package a497g.csci.leedjimin.mentorbook;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ViewUserActivity extends AppCompatActivity {
    DatabaseManager dbManager;
    private String username = "";
    private String usernameOfProfile = "";
    //CAN EDIT THESE TVS VVV
    private TextView typeTV, nameTV, emailTV, websiteTV, headlineTV, positionTV, workTV, educationTV, majorTV, coursesTV,
        scholarshipsTV, adviceText, tagsTV;


    public void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        dbManager = new DatabaseManager(this);
        setContentView(R.layout.activity_viewprofile);

        usernameOfProfile = (String)this.getIntent().getSerializableExtra("usernameOfProfile"); //gets username
        username = (String)this.getIntent().getSerializableExtra("Username");
        typeTV = (TextView) findViewById(R.id.mentorOrMentee);
        nameTV = (TextView) findViewById(R.id.nameText);
        emailTV = (TextView) findViewById(R.id.emailText);
        websiteTV = (TextView) findViewById(R.id.websiteText);
        headlineTV = (TextView) findViewById(R.id.headlineText);
        positionTV = (TextView) findViewById(R.id.positionText);
        workTV = (TextView) findViewById(R.id.workHistText);
        educationTV = (TextView) findViewById(R.id.educationText);
        majorTV = (TextView) findViewById(R.id.majorText);
        coursesTV = (TextView) findViewById(R.id.coursesText);
        scholarshipsTV = (TextView) findViewById(R.id.scholarshipsText);
       // adviceTV = (TextView) findViewById(R.id.adviceText);
        tagsTV = (TextView) findViewById(R.id.tagsText);
    }

    public void follow(View v) {
        Toast.makeText(this, dbManager.getFollowing(username, usernameOfProfile) + "!!", Toast.LENGTH_LONG).show();

        if(dbManager.getFollowing(username, usernameOfProfile).equals("")) {
            Toast.makeText(this, "You are now following "  + usernameOfProfile, Toast.LENGTH_LONG).show();
            dbManager.insertFollower(username, usernameOfProfile);

        }else{
            Toast.makeText(this, "You are already following "  + usernameOfProfile, Toast.LENGTH_LONG).show();
        }
    }

    public void goBack(View v) {
        this.finish();
    }
}
