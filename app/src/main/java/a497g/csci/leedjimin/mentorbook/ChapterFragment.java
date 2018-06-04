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
                String chapter = newChapter.getText().toString();
                if(!chapter.equals("")) {

                    LayoutInflater layoutInflater =
                            (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    /** Create chapter row using chapterrow.xml **/
                    final View addView = layoutInflater.inflate(R.layout.chapterrow, null);

                    /** Add new TextView && Edit text formatting    **/
                    TextView newText = (TextView) addView.findViewById(R.id.textout);
                    newText.setText(chapter);
                    newText.setTextSize(20);

                    /** Add remove button for added TextView    **/
                    Button buttonRemove = (Button) addView.findViewById(R.id.remove);

                    /** Remove functionality for NEW remove button  **/
                    buttonRemove.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ((LinearLayout) addView.getParent()).removeView(addView);
                        }
                    });

                    /** Clear addChapter EditText   **/
                    newChapter.setText("");

                    /** Add new TextView to current xml layout  **/
                    myContainer.addView(addView);
                }
            }});
        return view;
    }
}