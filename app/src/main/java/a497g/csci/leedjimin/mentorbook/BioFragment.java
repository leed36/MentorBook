package a497g.csci.leedjimin.mentorbook;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class BioFragment extends Fragment {
    DatabaseManager myDB;
    Button done;
    Button cancel;
    EditText CP;
    EditText WH;
    EditText E;
    EditText MM;
    EditText C;
    EditText S;
    EditText ATM;
    EditText T;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootV = inflater.inflate(R.layout.fragment_bio, container, false);
        myDB = new DatabaseManager(getActivity());
        done = (Button) rootV.findViewById(R.id.doneButton1);
        cancel = (Button) rootV.findViewById(R.id.cancelButton1);
        CP = (EditText) rootV.findViewById(R.id.positionInput);
        WH = (EditText) rootV.findViewById(R.id.historyInput);
        E = (EditText) rootV.findViewById(R.id.educationInput);
        MM = (EditText) rootV.findViewById(R.id.majorMinorInput);
        C = (EditText) rootV.findViewById(R.id.courseInput);
        S = (EditText) rootV.findViewById(R.id.scholarshipInput);
        ATM = (EditText) rootV.findViewById(R.id.adviceInput);
        T = (EditText) rootV.findViewById(R.id.tagInput);

        addData();
        return rootV;
    }

    public void addData(){
        done.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //insert datas...
            }
        });
    }
}

