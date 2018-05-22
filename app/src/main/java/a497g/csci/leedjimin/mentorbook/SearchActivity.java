package a497g.csci.leedjimin.mentorbook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by danie on 11/6/2017.
 */

public class SearchActivity extends AppCompatActivity {
    private DatabaseManager dbManager;
    private EditText searchEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_main);
        dbManager= new DatabaseManager( this );

        searchEdit = (EditText) findViewById(R.id.searchEdit);
    }

    public void lookUp(View v) { //finds the corresponding tasks to the given email
        String word = searchEdit.getText( ).toString( );
        ArrayList<User> users = dbManager.search(word);
        if (!users.isEmpty()) {
//            String name = tasks.get(0).getName();
//            String listing = "Name is: " + name + "\nTasks:";
            for (User user : users) {
//                listing += "\n-" + user.getInfo();
            }
//            Toast.makeText(SearchActivity.this, listing, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(SearchActivity.this, "Nothing exists", Toast.LENGTH_SHORT).show();
        }
    }

    public void goBack(View v) {
        this.finish();
    }
}