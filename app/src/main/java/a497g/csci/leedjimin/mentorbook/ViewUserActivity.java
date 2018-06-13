package a497g.csci.leedjimin.mentorbook;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ViewUserActivity extends AppCompatActivity {
    DatabaseManager dbManager;
    private String username;
    //CAN EDIT THESE TVS VVV
    private TextView typeTV, nameTV, emailTV, websiteTV, headlineTV, positionTV, workTV, educationTV, majorTV, coursesTV,
        scholarshipsTV, adviceText, tagsTV;


    public void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        dbManager = new DatabaseManager(this);
        setContentView(R.layout.activity_viewprofile);

        username = (String)this.getIntent().getSerializableExtra("Username"); //gets username

        typeTV = (TextView) findViewById(R.id.mentorOrMentee);
    }

    public void follow(View v) {

    }

    public void goBack(View v) {
        this.finish();
    }
}
