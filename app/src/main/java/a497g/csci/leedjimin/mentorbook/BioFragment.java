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
import android.widget.Toast;

public class BioFragment extends Fragment {
    DatabaseManager myDB;
    Button done;
    EditText CP;
    EditText WH;
    EditText E;
    EditText MM;
    EditText C;
    EditText S;
    EditText ATM;
    EditText T;
    String userNam = "";
    User user;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootV = inflater.inflate(R.layout.fragment_bio, container, false);
        myDB = new DatabaseManager(getActivity());
        done = (Button) rootV.findViewById(R.id.doneButton1);
        userNam = MainActivity.username;
        user = myDB.findUser(userNam);
        CP = (EditText) rootV.findViewById(R.id.positionInput);
        WH = (EditText) rootV.findViewById(R.id.historyInput);
        E = (EditText) rootV.findViewById(R.id.educationInput);
        MM = (EditText) rootV.findViewById(R.id.majorMinorInput);
        C = (EditText) rootV.findViewById(R.id.courseInput);
        S = (EditText) rootV.findViewById(R.id.scholarshipInput);
        ATM = (EditText) rootV.findViewById(R.id.adviceInput);
        T = (EditText) rootV.findViewById(R.id.tagInput);

        CP.setText(user.getCURRPOSITION());
        WH.setText(user.getWORKHISTORY());
        E.setText(user.getSCHOOL());
        MM.setText(user.getMAJORMINOR());
        C.setText(user.getCLASSNAME());
        S.setText(user.getSCHOLARSHIP());
        ATM.setText(user.getADVICE());
        T.setText(user.getTAG());

        done.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                myDB.updateBioU(userNam, CP.getText().toString(), WH.getText().toString(), ATM.getText().toString());
                myDB.updateBioE(userNam, E.getText().toString(), MM.getText().toString());
                myDB.updateBioC(userNam, C.getText().toString());
                myDB.updateBioS(userNam, S.getText().toString());
                myDB.updateBioT(userNam, T.getText().toString());
                Toast.makeText(getContext(), "Update Success!", Toast.LENGTH_LONG).show();
            }
        });
        return rootV;
    }

}

