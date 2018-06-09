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
import android.widget.TextView;
import android.widget.Toast;

public class ProfileFragment extends Fragment {
    DatabaseManager DB;
    Button Done;
    Button Cancel;
    EditText N;
    TextView UN;
    EditText W;
    EditText HL;
    EditText P;
    String userNam = "";
    User user;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        DB = new DatabaseManager(getActivity());
        userNam = MainActivity.username;
        user = DB.findUser(userNam);
        Done = (Button) rootView.findViewById(R.id.doneButton);
        N = (EditText) rootView.findViewById(R.id.nameInput);
        UN = (TextView) rootView.findViewById(R.id.userInput);
        W = (EditText) rootView.findViewById(R.id.websiteInput);
        HL = (EditText) rootView.findViewById(R.id.headlineInput);
        P = (EditText) rootView.findViewById(R.id.phoneInput);

        N.setText(user.getNAME());
        UN.setText(user.getUSERNAME());
        W.setText(user.getWEBSITE());
        HL.setText(user.getHEADLINE());
        P.setText(user.getPHONE());


        Done.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                DB.updateProfile(N.getText().toString(), UN.getText().toString(), W.getText().toString(), HL.getText().toString(), P.getText().toString());
                Toast.makeText(getContext(), "Update Success!", Toast.LENGTH_LONG).show();
            }
        });
        return rootView;
    }

}
