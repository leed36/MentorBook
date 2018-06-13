package a497g.csci.leedjimin.mentorbook;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.renderscript.ScriptGroup;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import static android.app.Activity.RESULT_OK;

public class ProfileFragment extends Fragment {
    private static final int RESULT_LOAD_IMAGE = 1;
    DatabaseManager DB;
    Button Done;
    Button Cancel;
    EditText N;
    TextView UN;
    EditText W;
    EditText HL;
    EditText P;
    EditText tags;
    String userNam = "";
    User user;
    ImageView userImage;

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
        tags = (EditText) rootView.findViewById(R.id.tagInput);
        userImage = (ImageView) rootView.findViewById((R.id.userImage));

        N.setText(user.getNAME());
        UN.setText(user.getUSERNAME());
        W.setText(user.getWEBSITE());
        HL.setText(user.getHEADLINE());
        P.setText(user.getPHONE());

        /**  fill profile photo if it is saved to db       **/
        byte[] image = DB.getImage(MainActivity.username);
        if(image!= null){
            Bitmap newImage = getImage(image);
            if(userImage!= null) userImage.setImageBitmap(newImage);

        }else{
            Toast.makeText(getContext(), "No profile pick found!", Toast.LENGTH_LONG).show();


        }



        userImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getContext(), "Uploading Image!", Toast.LENGTH_LONG).show();
                Intent getImage = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(getImage, RESULT_LOAD_IMAGE);
            }
        });
        Done.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                DB.updateProfile(N.getText().toString(), UN.getText().toString(), W.getText().toString(), HL.getText().toString(), P.getText().toString());
               // DB.insertTags(tags.getText().toString(), username);
                Toast.makeText(getContext(), "Update Success!", Toast.LENGTH_LONG).show();
            }
        });
        return rootView;
    }

    @Override
    public void onActivityResult(int requestcode, int resultcode, Intent data){
        if(requestcode == RESULT_LOAD_IMAGE && resultcode == RESULT_OK && data != null) {
            Uri uploadedImage = data.getData();
            try {

                final InputStream imageStream = getContext().getContentResolver().openInputStream(uploadedImage);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                userImage.setImageBitmap(selectedImage);

                /** Add to Database**/
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                selectedImage.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                byte[] dataByteArray = baos.toByteArray();
                DB = new DatabaseManager(getActivity());
                DB.insertImage(MainActivity.username, dataByteArray);
                Toast.makeText(getContext(), "image saved to db!", Toast.LENGTH_LONG).show();

            } catch (FileNotFoundException e) {
                Toast.makeText(getContext(), "image could not be saved!", Toast.LENGTH_LONG).show();
            }
        }
    }

    public byte[] getBytes(InputStream inputStream) throws IOException{
        ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();
        int bufferSize =  1024;
        byte[] buffer = new byte[bufferSize];
        int len = 0;
        while((len = inputStream.read(buffer))!= -1){
            byteBuffer.write(buffer, 0, len);
        }
        return byteBuffer.toByteArray();
    }

    // convert from byte array to bitmap
    public static Bitmap getImage(byte[] image) {
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }
}
