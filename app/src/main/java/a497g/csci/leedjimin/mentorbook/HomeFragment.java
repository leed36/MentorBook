package a497g.csci.leedjimin.mentorbook;

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
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class HomeFragment extends Fragment{
    @Nullable

    DatabaseManager DB;
    EditText searchEdit;
    ListView listview;
    ArrayList<User> userList;
//    String userName = MainActivity.username;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        DB = new DatabaseManager(getActivity());
        userList = DB.searchByType("mentor");

        searchEdit = (EditText)rootView.findViewById(R.id.searchEdit);
        listview = (ListView) rootView.findViewById(R.id.listViewSearch);

        ArrayList<String> userArrList = new ArrayList<String>(convertUsers(userList));

        // Create an ArrayAdapter from List
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (getContext(), android.R.layout.simple_list_item_1, userArrList);

        return rootView;
    }

    public ArrayList<String> convertUsers(ArrayList<User> ul) {
        ArrayList<String> newUl = new ArrayList<String>();
        for (User user : ul) {
            newUl.add(user.getNAME() + "-" + user.getCURRPOSITION());
        }
        return newUl;
    }

}
