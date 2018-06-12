package a497g.csci.leedjimin.mentorbook;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static a497g.csci.leedjimin.mentorbook.MainActivity.username;


public class HomeFragment extends Fragment {
    @Nullable

    private Button searchBtn;
    DatabaseManager DB;
    EditText searchEdit;
    ListView listview;
    ArrayList<String> userList;
    RelativeLayout myLayout;
    LinearLayout myContainer;
    Button profileBtn;
//    String userName = MainActivity.username;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        searchBtn = (Button)view.findViewById(R.id.searchBtn);
        DB = new DatabaseManager(getActivity());
        userList = convertUsers(DB.searchMentors());

        searchEdit = (EditText) view.findViewById(R.id.searchEdit);
        myLayout = (RelativeLayout) view.findViewById(R.id.fragmentHome);
        myContainer = (LinearLayout) view.findViewById(R.id.container);

        for (String s: userList) {

            LayoutInflater layoutInflater =
                    (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            /** Create chapter row using chapterrow.xml **/
            final View addView = layoutInflater.inflate(R.layout.simplerow, null);

            /** Add new TextView && Edit text formatting    **/
            TextView newText = (TextView) addView.findViewById(R.id.rowTextView);
            newText.setText(s);
            newText.setTextSize(25);

            /** Add remove button for added TextView    **/
            profileBtn = (Button) addView.findViewById(R.id.viewProf);

            /** View functionality for button  **/
            profileBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), ViewUserActivity.class);
                    startActivity(intent);
                }
            });

            /** Add new TextView to current xml layout  **/
            myContainer.addView(addView);
        }

        searchBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                String search = searchEdit.getText().toString();
                if(!search.equals("")) {
                    /** Add text to database    **/
                    DB = new DatabaseManager(getActivity());

                    /** Add chapter to chapter fragment**/
                    LayoutInflater layoutInflater =
                            (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                    /** Create chapter row using chapterrow.xml **/
                    final View addView = layoutInflater.inflate(R.layout.chapterrow, null);

                    /** Add new TextView && Edit text formatting    **/
                    TextView newText = (TextView) addView.findViewById(R.id.textout);
                    newText.setText("hi");
                    newText.setTextSize(20);

                    /** Remove functionality for NEW remove button  **/
                    profileBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //start the new intent
                        }
                    });

                    /** Add new TextView to current xml layout  **/
                    myContainer.addView(addView);
                }
            }
        });

        return view;
    }

    public ArrayList<String> convertUsers(ArrayList<User> ul) {
        ArrayList<String> newUl = new ArrayList<String>();
        Log.w("convertusers", "in the function");
        for (User user : ul) {
            Log.w("convertusers",user.getNAME());
            newUl.add(user.getNAME() + "-" + user.getCURRPOSITION());
        }
        return newUl;
    }

}
