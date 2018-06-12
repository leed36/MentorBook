package a497g.csci.leedjimin.mentorbook;

import android.content.Intent;
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


public class HomeFragment extends Fragment implements AdapterView.OnItemClickListener{
    @Nullable

    DatabaseManager DB;
    EditText searchEdit;
    ListView listview;
    ArrayList<User> userList;
    ArrayAdapter<String> listAdapter;
//    String userName = MainActivity.username;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
//        DB = new DatabaseManager(getActivity());
//        userList = DB.searchMentors();
//
//        searchEdit = (EditText)rootView.findViewById(R.id.searchEdit);
//        listview = (ListView) rootView.findViewById(R.id.listViewSearch);
//        //listAdapter = new ArrayAdapter(this, R.layout.simplerow, userList);
//        listview.setOnItemClickListener(this);
        return rootView;
    }

    public void updateView() {

    }

    public void onItemClick(AdapterView<?> l, View v, int position, long id) {
//        Log.i("HelloListView", "You clicked Item: " + id + " at position:" + position);
//        // Then you start a new Activity via Intent
//        Intent intent = new Intent(getActivity(), ViewUserActivity.class);
//        intent.putExtra("username", username);
//        getActivity().startActivity(intent);
    }

}
