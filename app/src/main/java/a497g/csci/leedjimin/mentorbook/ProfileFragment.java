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

public class ProfileFragment extends Fragment {
    DatabaseManager DB;
    User user = new User();
    Button Done;
    Button Cancel;
    EditText N;
    EditText UN;
    EditText W;
    EditText HL;
    EditText P;
    String userNam;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        userNam = user.getUSERNAME();
        DB = new DatabaseManager(getActivity());
        Done = (Button) rootView.findViewById(R.id.doneButton);
        Cancel = (Button) rootView.findViewById(R.id.cancelButton);
        N = (EditText) rootView.findViewById(R.id.nameInput);
        UN = (EditText) rootView.findViewById(R.id.userInput);
        W = (EditText) rootView.findViewById(R.id.websiteInput);
        HL = (EditText) rootView.findViewById(R.id.headlineInput);
        P = (EditText) rootView.findViewById(R.id.phoneInput);
        Done.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                DB.updateProfile(N.toString(), UN.toString(), W.toString(), HL.toString(), P.toString());
            }
        });
        return rootView;
    }

}
