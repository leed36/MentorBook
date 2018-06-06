package a497g.csci.leedjimin.mentorbook;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;


public class HomeFragment extends Fragment {
    @Nullable

    DatabaseManager DB;
    EditText searchEdit;
    ListView listView;
//    String userName = MainActivity.username;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        DB = new DatabaseManager(getActivity());

        searchEdit = (EditText)rootView.findViewById(R.id.searchEdit);
        return rootView;
    }


}
