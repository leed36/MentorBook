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
    private User userOf;
    //CAN EDIT THESE TVS VVV
    private TextView typeTV, nameTV, emailTV, websiteTV, headlineTV, positionTV, workTV, educationTV, majorTV, coursesTV,
        scholarshipsTV, adviceTV, tagsTV;


    public void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        dbManager = new DatabaseManager(this);
        setContentView(R.layout.activity_viewprofile);

        usernameOfProfile = (String)this.getIntent().getSerializableExtra("usernameOfProfile"); //gets username
        username = (String)this.getIntent().getSerializableExtra("Username");
        Toast.makeText(this, "usernameProfile: " + usernameOfProfile + "        username: " + username, Toast.LENGTH_LONG).show();
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
        adviceTV = (TextView) findViewById(R.id.adviceText);
        tagsTV = (TextView) findViewById(R.id.tagsText);

        typeTV.setText(userOf.getTYPE());
        nameTV.setText(userOf.getNAME());
        emailTV.setText(userOf.getEMAIL());
        websiteTV.setText(userOf.getWEBSITE());
        headlineTV.setText(userOf.getHEADLINE());
        positionTV.setText(userOf.getCURRPOSITION());
        workTV.setText(userOf.getPLACE());
        educationTV.setText(userOf.getSCHOOL());
        majorTV.setText(userOf.getDEGREE_NAME());
        adviceTV.setText(userOf.getADVICE());
        tagsTV.setText(userOf.getTagAsString());
    }

    public void follow(View v) {
        Toast.makeText(this, "usernameProfile: " + usernameOfProfile + "        username: " + username, Toast.LENGTH_LONG).show();
        if(dbManager.getFollower(username, usernameOfProfile).equals("")) {
            dbManager.insertFollower(usernameOfProfile, username);
        }else{
            Toast.makeText(this, "already following" + usernameOfProfile, Toast.LENGTH_LONG).show();

        }
    }

    public void goBack(View v) {
        this.finish();
    }
}
