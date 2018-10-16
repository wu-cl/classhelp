package com.example.wcl.classhelp20;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.wcl.other_activities.login;

public class fragment_main extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public void onHiddenChanged(boolean hidden){
        if(main_fragment.mContent.equals(main_fragment.main)||
                main_fragment.mContent.equals(main_fragment.sign)||
                main_fragment.mContent.equals(main_fragment.work)||
                main_fragment.mContent.equals(main_fragment.mine)) {
            if(main_fragment.mContent.isAdded()) {
                RelativeLayout main_bottom = (RelativeLayout) this.getActivity().findViewById(R.id.main_bottom);
                if (hidden) {
                    main_bottom.setVisibility(View.INVISIBLE);
                } else {
                    main_bottom.setVisibility(View.VISIBLE);
                }
            }
        }else{
            RelativeLayout main_bottom = (RelativeLayout) this.getActivity().findViewById(R.id.main_bottom);
            if (hidden) {
                main_bottom.setVisibility(View.INVISIBLE);
            } else {
                main_bottom.setVisibility(View.VISIBLE);
            }
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        /*
        界面字体设置
         */
        Typeface font1 = Typeface.createFromAsset(this.getActivity().getAssets(), "fonts/MFYUEYUAN_NONCOMMERCIAL-REGULAR.OTF");
        Typeface font2 = Typeface.createFromAsset(this.getActivity().getAssets(), "fonts/SIMLI.TTF");
        //定义字体
        TextView text_main_welcome = (TextView)view.findViewById(R.id.main_welcome_text);
        text_main_welcome.setTypeface(font1);
        //设置字体
      //  TextPaint tp_main_welcome = text_main_welcome.getPaint();
     //   tp_main_welcome.setFakeBoldText(true);
        //加粗
        TextView text_main_user = (TextView)view.findViewById(R.id.main_user);
        text_main_user.setTypeface(font1);
        text_main_user.setText(login.name);
        //设置字体
        //TextPaint tp_main_user = text_main_user.getPaint();
       // tp_main_user.setFakeBoldText(true);
        //加粗

        TextView text_main_calendar=(TextView)view.findViewById(R.id.main_calendar_text);
        text_main_calendar.setTypeface(font2);
        TextView text_main_photo=(TextView)view.findViewById(R.id.main_photo_text);
        text_main_photo.setTypeface(font2);
        TextView text_main_resource=(TextView)view.findViewById(R.id.main_resource_text);
        text_main_resource.setTypeface(font2);
        TextView text_main_score=(TextView)view.findViewById(R.id.main_score_text);
        text_main_score.setTypeface(font2);
        TextView text_main_notice=(TextView)view.findViewById(R.id.main_notice_text);
        text_main_notice.setTypeface(font2);
        TextView text_main_note=(TextView)view.findViewById(R.id.main_note_text);
        text_main_note.setTypeface(font2);
        TextView text_main_table=(TextView)view.findViewById(R.id.main_table_text);
        text_main_table.setTypeface(font2);
        TextView text_main_jwc=(TextView)view.findViewById(R.id.main_jwc_text);
        text_main_jwc.setTypeface(font2);
        TextView text_main_chat=(TextView)view.findViewById(R.id.main_chat_text);
        text_main_chat.setTypeface(font2);


        ImageButton main_jwc=(ImageButton)view.findViewById(R.id.main_jwc);
        main_jwc.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                main_fragment.switchContent(main_fragment.mContent, main_fragment.jwc);

            }
        });
        ImageButton main_table=(ImageButton)view.findViewById(R.id.main_table);
        main_table.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                main_fragment.switchContent(main_fragment.mContent,main_fragment.table);

            }
        });



        return view;
    }

    @Override
    public void onDestroyView() {
        // TODO Auto-generated method stub
        super.onDestroyView();

    }
}
