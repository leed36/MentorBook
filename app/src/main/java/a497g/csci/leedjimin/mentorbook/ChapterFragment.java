package a497g.csci.leedjimin.mentorbook;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.view.ViewGroup.LayoutParams;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.app.Activity;
import android.content.Context;



public class ChapterFragment extends Fragment {
    @Nullable

    private android.support.v7.widget.AppCompatImageButton button;
    private EditText newChapter;
    private TextView newChapterNum;
    private TextView chapt1;
    private RelativeLayout myLayout = null;
    private Button buttonAdd;
    private LinearLayout myContainer;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_chapter, container, false);
        button = (android.support.v7.widget.AppCompatImageButton)view.findViewById(R.id.addChapter);
        myLayout = (RelativeLayout) view.findViewById(R.id.fragmentchapter);
        myContainer = (LinearLayout) view.findViewById(R.id.container);
        newChapter = view.findViewById(R.id.newChapter);


        button.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View arg0) {
                LayoutInflater layoutInflater =
                        (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View addView = layoutInflater.inflate(R.layout.chapterrow, null);
                TextView textOut = (TextView)addView.findViewById(R.id.textout);
                textOut.setText(newChapter.getText().toString());
                Button buttonRemove = (Button)addView.findViewById(R.id.remove);
                buttonRemove.setOnClickListener(new OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        ((LinearLayout)addView.getParent()).removeView(addView);
                    }});

                myContainer.addView(addView);
            }});
        return view;
    }

    private void getNewChapter(View view){
        String chapter = newChapter.getText().toString();
        String chapterNum = newChapterNum.getText().toString();
        if(!chapter.equals("")){

            TextView newTextView = new TextView(null);

            myLayout = (RelativeLayout) view.findViewById(R.id.fragmentchapter);

            newTextView.setLayoutParams(new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
            ));

            newTextView.setText(chapter);
            myLayout.addView(newTextView);
            Toast.makeText(getActivity(), chapter + " Success", Toast.LENGTH_LONG).show();


        }
    }
}


//import android.os.Bundle;
//        import android.view.LayoutInflater;
//        import android.view.View;
//        import android.view.View.OnClickListener;
//        import android.widget.Button;
//        import android.widget.EditText;
//        import android.widget.LinearLayout;
//        import android.widget.TextView;
//        import android.app.Activity;
//        import android.content.Context;
//
//public class MainActivity extends Activity {
//
//    EditText textIn;
//    Button buttonAdd;
//    LinearLayout container;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        textIn = (EditText)findViewById(R.id.textin);
//        buttonAdd = (Button)findViewById(R.id.add);
//        container = (LinearLayout)findViewById(R.id.container);
//
//        buttonAdd.setOnClickListener(new OnClickListener(){
//
//            @Override
//            public void onClick(View arg0) {
//                LayoutInflater layoutInflater =
//                        (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//                final View addView = layoutInflater.inflate(R.layout.row, null);
//                TextView textOut = (TextView)addView.findViewById(R.id.textout);
//                textOut.setText(textIn.getText().toString());
//                Button buttonRemove = (Button)addView.findViewById(R.id.remove);
//                buttonRemove.setOnClickListener(new OnClickListener(){
//
//                    @Override
//                    public void onClick(View v) {
//                        ((LinearLayout)addView.getParent()).removeView(addView);
//                    }});
//
//                container.addView(addView);
//            }});
//
//    }
//
//}