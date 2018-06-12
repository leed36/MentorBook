package a497g.csci.leedjimin.mentorbook;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ViewUserActivity extends AppCompatActivity {
    DatabaseManager dbManager;

    public void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        dbManager = new DatabaseManager(this);
        setContentView(R.layout.activity_viewprofile);
    }

    public void follow(View v) {

    }

    public void goBack(View v) {
        this.finish();
    }
}
