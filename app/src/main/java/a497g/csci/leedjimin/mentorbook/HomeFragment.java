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
    String un;
    String userName;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        searchBtn = (Button)view.findViewById(R.id.searchBtn);
        DB = new DatabaseManager(getActivity());
        userName = MainActivity.username;
        Log.w("username from home", userName);
        //userList = DB.getAllFollowing(MainActivity.username); //changed to followers query

        searchEdit = (EditText) view.findViewById(R.id.searchEdit);
        myLayout = (RelativeLayout) view.findViewById(R.id.fragmentHome);
        myContainer = (LinearLayout) view.findViewById(R.id.container);

        //updateView(userList);

        searchBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String search = searchEdit.getText().toString().toLowerCase();
                myContainer.removeAllViewsInLayout();
                if (search.equals("followers")) {
                    userList = DB.getAllFollowing(MainActivity.username);
                }
                else if (search.equals("mentor")) {
                    userList = convertUsers(DB.searchByType("mentor"));
                }
                else if (search.equals("mentee")) {
                    userList = convertUsers(DB.searchByType("mentee"));
                }
                else if (!search.equals("")) {
                    userList = convertUsers(DB.searchTag(search));
                    /** look in DB for the search keyword  and use updateview **/
                }
                if (userList.size() != 0) updateView(userList);
            }
        });
        return view;
    }

    public void updateView(ArrayList<String> listArg) {
        for (String s: listArg) {
            final String un = getUsername(s);
            LayoutInflater layoutInflater =
                    (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            /** Create chapter row using chapterrow.xml **/
            final View addView = layoutInflater.inflate(R.layout.simplerow, null);

            /** Add new TextView && Edit text formatting    **/
            TextView newText = (TextView) addView.findViewById(R.id.rowTextView);
            newText.setText(s);
            newText.setTextSize(25);

            /** Add profile button for added TextView    **/

            Button profileBtn;
            profileBtn = (Button) addView.findViewById(R.id.viewProf);

            /** View functionality for button  **/
            profileBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(getActivity(), ViewUserActivity.class);
                    intent.putExtra("usernameOfProfile", un);
                    intent.putExtra("Username", MainActivity.username);

                    startActivity(intent);
                }
            });

            /** Add new TextView to current xml layout  **/
            myContainer.addView(addView);
        }
    }

    public String getUsername(String st) {
        String[] str2 = st.split(" ");
        return str2[0];
    }

    public ArrayList<String> convertUsers(ArrayList<User> ul) {
        ArrayList<String> newUl = new ArrayList<String>();
        Log.w("convertusers", ul.get(0).getUSERNAME());
        for (User user : ul) {
            newUl.add(user.getUSERNAME() + " - " + user.getTYPE());
        }
        return newUl;
    }

}
