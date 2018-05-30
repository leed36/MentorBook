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


public class ChapterFragment extends Fragment {
    @Nullable

    private android.support.v7.widget.AppCompatImageButton button;
    private EditText newChapter;
    private TextView newChapterNum;
    private TextView chapt1;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_chapter, container, false);

        newChapter = (EditText) view.findViewById(R.id.newChapter);
        newChapterNum = (TextView) view.findViewById(R.id.newChapterNum);
        chapt1 = (TextView) view.findViewById(R.id.chapt1);


        button = (android.support.v7.widget.AppCompatImageButton) view.findViewById(R.id.buttonNewChapter);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                getNewChapter(view);
            }
        });
        return view;
    }

    private void getNewChapter(View view){
        String chapter = newChapter.getText().toString();
        String chapterNum = newChapterNum.getText().toString();
        if(!chapter.equals("")){
            /*
                This is the building blocks of the chapter fragment
                Here we will create new textview to add chapters to this page.
                Very Barebones!!

                In the Future:
                    We want to add more description so that users can "view" the chapter and seek
                    more detail.

             */

            Toast.makeText(getActivity(), chapter + " Success", Toast.LENGTH_LONG).show();
            chapt1.setText(chapter);

            //RelativeLayout linearLayout = view.findViewById(R.id.fragmentchapter);

//            /** Add textView**/
//            TextView textView = new TextView(getActivity());
//            textView.setId(Integer.parseInt(chapterNum));
//            textView.setLayoutParams(
//                    new LayoutParams(LayoutParams.MATCH_PARENT,
//                        LayoutParams.WRAP_CONTENT));
//            textView.setText(chapter);
////            textView.setBackground();
//            textView.setPadding(16,16,16,16);



           // linearLayout.addView(textView);


        }
    }
}
