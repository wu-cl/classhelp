package com.example.wcl.classhelp20;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.wcl.jwc.Lesson;
import com.example.wcl.jwc.jwc_Login;
import com.example.wcl.jwc.jwc_calendar;
import com.example.wcl.jwc.jwc_pass_set;
import com.example.wcl.other_activities.login;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class fragment_table extends Fragment {

    Runnable jwc_runnable;
    private static String jwc_password=null;
    String cookie=null;

    @Override
    public void onHiddenChanged(boolean hidden){

        if (hidden) {

        }else{

                main_fragment.text_main_title.setText("课程表(第"+ login.week+"周）");

        }

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            main_fragment.text_main_title.setText("课程表(第"+ login.week+"周）");

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_table, container, false);

        final TextView text[][]=new TextView[7][13];
        text[1][1]=(TextView)view.findViewById(R.id.table_1_1);
        text[1][2]=(TextView)view.findViewById(R.id.table_1_2);
        text[1][3]=(TextView)view.findViewById(R.id.table_1_3);
        text[1][4]=(TextView)view.findViewById(R.id.table_1_4);
        text[1][5]=(TextView)view.findViewById(R.id.table_1_5);
        text[1][6]=(TextView)view.findViewById(R.id.table_1_6);
        text[1][7]=(TextView)view.findViewById(R.id.table_1_7);
        text[1][8]=(TextView)view.findViewById(R.id.table_1_8);
        text[1][9]=(TextView)view.findViewById(R.id.table_1_9);
        text[1][10]=(TextView)view.findViewById(R.id.table_1_10);
        text[1][11]=(TextView)view.findViewById(R.id.table_1_11);
        text[1][12]=(TextView)view.findViewById(R.id.table_1_12);

        text[2][1]=(TextView)view.findViewById(R.id.table_2_1);
        text[2][2]=(TextView)view.findViewById(R.id.table_2_2);
        text[2][3]=(TextView)view.findViewById(R.id.table_2_3);
        text[2][4]=(TextView)view.findViewById(R.id.table_2_4);
        text[2][5]=(TextView)view.findViewById(R.id.table_2_5);
        text[2][6]=(TextView)view.findViewById(R.id.table_2_6);
        text[2][7]=(TextView)view.findViewById(R.id.table_2_7);
        text[2][8]=(TextView)view.findViewById(R.id.table_2_8);
        text[2][9]=(TextView)view.findViewById(R.id.table_2_9);
        text[2][10]=(TextView)view.findViewById(R.id.table_2_10);
        text[2][11]=(TextView)view.findViewById(R.id.table_2_11);
        text[2][12]=(TextView)view.findViewById(R.id.table_2_12);

        text[3][1]=(TextView)view.findViewById(R.id.table_3_1);
        text[3][2]=(TextView)view.findViewById(R.id.table_3_2);
        text[3][3]=(TextView)view.findViewById(R.id.table_3_3);
        text[3][4]=(TextView)view.findViewById(R.id.table_3_4);
        text[3][5]=(TextView)view.findViewById(R.id.table_3_5);
        text[3][6]=(TextView)view.findViewById(R.id.table_3_6);
        text[3][7]=(TextView)view.findViewById(R.id.table_3_7);
        text[3][8]=(TextView)view.findViewById(R.id.table_3_8);
        text[3][9]=(TextView)view.findViewById(R.id.table_3_9);
        text[3][10]=(TextView)view.findViewById(R.id.table_3_10);
        text[3][11]=(TextView)view.findViewById(R.id.table_3_11);
        text[3][12]=(TextView)view.findViewById(R.id.table_3_12);

        text[4][1]=(TextView)view.findViewById(R.id.table_4_1);
        text[4][2]=(TextView)view.findViewById(R.id.table_4_2);
        text[4][3]=(TextView)view.findViewById(R.id.table_4_3);
        text[4][4]=(TextView)view.findViewById(R.id.table_4_4);
        text[4][5]=(TextView)view.findViewById(R.id.table_4_5);
        text[4][6]=(TextView)view.findViewById(R.id.table_4_6);
        text[4][7]=(TextView)view.findViewById(R.id.table_4_7);
        text[4][8]=(TextView)view.findViewById(R.id.table_4_8);
        text[4][9]=(TextView)view.findViewById(R.id.table_4_9);
        text[4][10]=(TextView)view.findViewById(R.id.table_4_10);
        text[4][11]=(TextView)view.findViewById(R.id.table_4_11);
        text[4][12]=(TextView)view.findViewById(R.id.table_4_12);

        text[5][1]=(TextView)view.findViewById(R.id.table_5_1);
        text[5][2]=(TextView)view.findViewById(R.id.table_5_2);
        text[5][3]=(TextView)view.findViewById(R.id.table_5_3);
        text[5][4]=(TextView)view.findViewById(R.id.table_5_4);
        text[5][5]=(TextView)view.findViewById(R.id.table_5_5);
        text[5][6]=(TextView)view.findViewById(R.id.table_5_6);
        text[5][7]=(TextView)view.findViewById(R.id.table_5_7);
        text[5][8]=(TextView)view.findViewById(R.id.table_5_8);
        text[5][9]=(TextView)view.findViewById(R.id.table_5_9);
        text[5][10]=(TextView)view.findViewById(R.id.table_5_10);
        text[5][11]=(TextView)view.findViewById(R.id.table_5_11);
        text[5][12]=(TextView)view.findViewById(R.id.table_5_12);

        text[6][1]=(TextView)view.findViewById(R.id.table_6_1);
        text[6][2]=(TextView)view.findViewById(R.id.table_6_2);
        text[6][3]=(TextView)view.findViewById(R.id.table_6_3);
        text[6][4]=(TextView)view.findViewById(R.id.table_6_4);
        text[6][5]=(TextView)view.findViewById(R.id.table_6_5);
        text[6][6]=(TextView)view.findViewById(R.id.table_6_6);
        text[6][7]=(TextView)view.findViewById(R.id.table_6_7);
        text[6][8]=(TextView)view.findViewById(R.id.table_6_8);
        text[6][9]=(TextView)view.findViewById(R.id.table_6_9);
        text[6][10]=(TextView)view.findViewById(R.id.table_6_10);
        text[6][11]=(TextView)view.findViewById(R.id.table_6_11);
        text[6][12]=(TextView)view.findViewById(R.id.table_6_12);

        final RelativeLayout bg[][]=new RelativeLayout[7][13];
        bg[1][1]=(RelativeLayout)view.findViewById(R.id.table_1_1_bg);
        bg[1][2]=(RelativeLayout)view.findViewById(R.id.table_1_2_bg);
        bg[1][3]=(RelativeLayout)view.findViewById(R.id.table_1_3_bg);
        bg[1][4]=(RelativeLayout)view.findViewById(R.id.table_1_4_bg);
        bg[1][5]=(RelativeLayout)view.findViewById(R.id.table_1_5_bg);
        bg[1][6]=(RelativeLayout)view.findViewById(R.id.table_1_6_bg);
        bg[1][7]=(RelativeLayout)view.findViewById(R.id.table_1_7_bg);
        bg[1][8]=(RelativeLayout)view.findViewById(R.id.table_1_8_bg);
        bg[1][9]=(RelativeLayout)view.findViewById(R.id.table_1_9_bg);
        bg[1][10]=(RelativeLayout)view.findViewById(R.id.table_1_10_bg);
        bg[1][11]=(RelativeLayout)view.findViewById(R.id.table_1_11_bg);
        bg[1][12]=(RelativeLayout)view.findViewById(R.id.table_1_12_bg);

        bg[2][1]=(RelativeLayout)view.findViewById(R.id.table_2_1_bg);
        bg[2][2]=(RelativeLayout)view.findViewById(R.id.table_2_2_bg);
        bg[2][3]=(RelativeLayout)view.findViewById(R.id.table_2_3_bg);
        bg[2][4]=(RelativeLayout)view.findViewById(R.id.table_2_4_bg);
        bg[2][5]=(RelativeLayout)view.findViewById(R.id.table_2_5_bg);
        bg[2][6]=(RelativeLayout)view.findViewById(R.id.table_2_6_bg);
        bg[2][7]=(RelativeLayout)view.findViewById(R.id.table_2_7_bg);
        bg[2][8]=(RelativeLayout)view.findViewById(R.id.table_2_8_bg);
        bg[2][9]=(RelativeLayout)view.findViewById(R.id.table_2_9_bg);
        bg[2][10]=(RelativeLayout)view.findViewById(R.id.table_2_10_bg);
        bg[2][11]=(RelativeLayout)view.findViewById(R.id.table_2_11_bg);
        bg[2][12]=(RelativeLayout)view.findViewById(R.id.table_2_12_bg);

        bg[3][1]=(RelativeLayout)view.findViewById(R.id.table_3_1_bg);
        bg[3][2]=(RelativeLayout)view.findViewById(R.id.table_3_2_bg);
        bg[3][3]=(RelativeLayout)view.findViewById(R.id.table_3_3_bg);
        bg[3][4]=(RelativeLayout)view.findViewById(R.id.table_3_4_bg);
        bg[3][5]=(RelativeLayout)view.findViewById(R.id.table_3_5_bg);
        bg[3][6]=(RelativeLayout)view.findViewById(R.id.table_3_6_bg);
        bg[3][7]=(RelativeLayout)view.findViewById(R.id.table_3_7_bg);
        bg[3][8]=(RelativeLayout)view.findViewById(R.id.table_3_8_bg);
        bg[3][9]=(RelativeLayout)view.findViewById(R.id.table_3_9_bg);
        bg[3][10]=(RelativeLayout)view.findViewById(R.id.table_3_10_bg);
        bg[3][11]=(RelativeLayout)view.findViewById(R.id.table_3_11_bg);
        bg[3][12]=(RelativeLayout)view.findViewById(R.id.table_3_12_bg);

        bg[4][1]=(RelativeLayout)view.findViewById(R.id.table_4_1_bg);
        bg[4][2]=(RelativeLayout)view.findViewById(R.id.table_4_2_bg);
        bg[4][3]=(RelativeLayout)view.findViewById(R.id.table_4_3_bg);
        bg[4][4]=(RelativeLayout)view.findViewById(R.id.table_4_4_bg);
        bg[4][5]=(RelativeLayout)view.findViewById(R.id.table_4_5_bg);
        bg[4][6]=(RelativeLayout)view.findViewById(R.id.table_4_6_bg);
        bg[4][7]=(RelativeLayout)view.findViewById(R.id.table_4_7_bg);
        bg[4][8]=(RelativeLayout)view.findViewById(R.id.table_4_8_bg);
        bg[4][9]=(RelativeLayout)view.findViewById(R.id.table_4_9_bg);
        bg[4][10]=(RelativeLayout)view.findViewById(R.id.table_4_10_bg);
        bg[4][11]=(RelativeLayout)view.findViewById(R.id.table_4_11_bg);
        bg[4][12]=(RelativeLayout)view.findViewById(R.id.table_4_12_bg);

        bg[5][1]=(RelativeLayout)view.findViewById(R.id.table_5_1_bg);
        bg[5][2]=(RelativeLayout)view.findViewById(R.id.table_5_2_bg);
        bg[5][3]=(RelativeLayout)view.findViewById(R.id.table_5_3_bg);
        bg[5][4]=(RelativeLayout)view.findViewById(R.id.table_5_4_bg);
        bg[5][5]=(RelativeLayout)view.findViewById(R.id.table_5_5_bg);
        bg[5][6]=(RelativeLayout)view.findViewById(R.id.table_5_6_bg);
        bg[5][7]=(RelativeLayout)view.findViewById(R.id.table_5_7_bg);
        bg[5][8]=(RelativeLayout)view.findViewById(R.id.table_5_8_bg);
        bg[5][9]=(RelativeLayout)view.findViewById(R.id.table_5_9_bg);
        bg[5][10]=(RelativeLayout)view.findViewById(R.id.table_5_10_bg);
        bg[5][11]=(RelativeLayout)view.findViewById(R.id.table_5_11_bg);
        bg[5][12]=(RelativeLayout)view.findViewById(R.id.table_5_12_bg);

        bg[6][1]=(RelativeLayout)view.findViewById(R.id.table_6_1_bg);
        bg[6][2]=(RelativeLayout)view.findViewById(R.id.table_6_2_bg);
        bg[6][3]=(RelativeLayout)view.findViewById(R.id.table_6_3_bg);
        bg[6][4]=(RelativeLayout)view.findViewById(R.id.table_6_4_bg);
        bg[6][5]=(RelativeLayout)view.findViewById(R.id.table_6_5_bg);
        bg[6][6]=(RelativeLayout)view.findViewById(R.id.table_6_6_bg);
        bg[6][7]=(RelativeLayout)view.findViewById(R.id.table_6_7_bg);
        bg[6][8]=(RelativeLayout)view.findViewById(R.id.table_6_8_bg);
        bg[6][9]=(RelativeLayout)view.findViewById(R.id.table_6_9_bg);
        bg[6][10]=(RelativeLayout)view.findViewById(R.id.table_6_10_bg);
        bg[6][11]=(RelativeLayout)view.findViewById(R.id.table_6_11_bg);
        bg[6][12]=(RelativeLayout)view.findViewById(R.id.table_6_12_bg);


        final jwc_Login jwc_test=new jwc_Login(this.getActivity().getApplicationContext());
        final Handler handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                // TODO
                Bundle data = msg.getData();
                String result = data.getString("value");

                List<Lesson> lessons=new ArrayList<Lesson>();

                int lesson_1=result.indexOf("第1节");
                int lesson_2=result.indexOf("第2节");
                int lesson_3=result.indexOf("第3节");
                int lesson_4=result.indexOf("第4节");
                int lesson_6=result.indexOf("第6节");
                int lesson_7=result.indexOf("第7节");
                int lesson_8=result.indexOf("第8节");
                int lesson_9=result.indexOf("第9节");
                int lesson_10=result.indexOf("第10节");
                int lesson_11=result.indexOf("第11节");

                String lesson_raw[]=new String[5];
                lesson_raw[0]=result.substring(lesson_1+3,lesson_2);
                lesson_raw[1]=result.substring(lesson_3+3,lesson_4);
                lesson_raw[2]=result.substring(lesson_6+3,lesson_7);
                lesson_raw[3]=result.substring(lesson_8+3,lesson_9);
                lesson_raw[4]=result.substring(lesson_10+4,lesson_11);


                for(int i=0;i<5;i++) {


                    if(lesson_raw[i].indexOf("align=\"Center\" rowspan")!=-1) {

                        result=lesson_raw[i];
                        int week_count=0;
                        while(true){
                            Lesson lesson = new Lesson();
                            switch(i){
                                case 0:
                                    lesson.start_number=1;
                                    break;
                                case 1:
                                    lesson.start_number=3;
                                    break;
                                case 2:
                                    lesson.start_number=6;
                                    break;
                                case 3:
                                    lesson.start_number=8;
                                    break;
                                case 4:
                                    lesson.start_number=10;
                                    break;
                            }

                            int week_index=result.indexOf("align=\"Center\"");
                            if(week_index==-1)
                                break;
                            else
                                week_count++;
                            result=result.substring(week_index);
                            String test=result.substring(0,25);
                            if(test.indexOf("rowspan")!=-1){
                                lesson.start_week=week_count;


                                int end=result.indexOf("</td>");
                                String temp_lesson=result.substring(0, end);

                                lesson.number=Integer.parseInt(temp_lesson.substring(temp_lesson.indexOf("rowspan=\"") + 9, temp_lesson.indexOf("rowspan=\"") + 10));

                                int name_index=temp_lesson.indexOf(">");
                                temp_lesson=temp_lesson.substring(name_index+1);

                                int week_inf_index=temp_lesson.indexOf("<br>");

                                lesson.name=temp_lesson.substring(0,week_inf_index);

                                int j;
                                for(j=0;j<lessons.size();j++) {
                                    if(lessons.get(j).name.equals(lesson.name)) {
                                        lesson.color = lessons.get(j).color;
                                        break;
                                    }
                                }
                                if(j==lessons.size())
                                    lesson.color=getcolor();



                                temp_lesson=temp_lesson.substring(temp_lesson.indexOf("{")+1);

                                int teacher_index=temp_lesson.indexOf("}");

                                lesson.week=temp_lesson.substring(0,teacher_index);

                                temp_lesson=temp_lesson.substring(teacher_index+5);

                                int classroom_index=temp_lesson.indexOf("<br>");

                                lesson.teacher=temp_lesson.substring(0,classroom_index);

                                lesson.classroom=temp_lesson.substring(classroom_index+4);

                                if(!lesson.classroom.equals(""))
                                    lesson.classroom=lesson.classroom.substring(1);


                                lessons.add(lesson);

                                result=result.substring(end+9);

                            }else
                                result=result.substring(result.indexOf("</td>")+9);
                        }

                    }
                }




                for(int i=0;i<lessons.size();i++){
                    text[lessons.get(i).start_week][lessons.get(i).start_number].setText(lessons.get(i).name);
                    if(lessons.get(i).week.indexOf("单周")>0)
                    text[lessons.get(i).start_week][lessons.get(i).start_number+1].setText(lessons.get(i).classroom+"\n单周");
                    else if(lessons.get(i).week.indexOf("双周")>0)
                        text[lessons.get(i).start_week][lessons.get(i).start_number+1].setText(lessons.get(i).classroom+"\n双周");
                    else
                        text[lessons.get(i).start_week][lessons.get(i).start_number+1].setText(lessons.get(i).classroom);
                    text[lessons.get(i).start_week][lessons.get(i).start_number].setTextColor(Color.WHITE);

                    text[lessons.get(i).start_week][lessons.get(i).start_number+1].setTextColor(Color.WHITE);
                    final Lesson current_lesson=lessons.get(i);


                    int color=lessons.get(i).color;
                    if(lessons.get(i).number==2){
                        bg[lessons.get(i).start_week][lessons.get(i).start_number].setBackgroundColor(color);
                        bg[lessons.get(i).start_week][lessons.get(i).start_number+1].setBackgroundColor(color);
                        bg[lessons.get(i).start_week][lessons.get(i).start_number].setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog(current_lesson);
                            }
                        });
                        bg[lessons.get(i).start_week][lessons.get(i).start_number+1].setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog(current_lesson);
                            }
                        });
                    }else{
                        bg[lessons.get(i).start_week][lessons.get(i).start_number].setBackgroundColor(color);
                        bg[lessons.get(i).start_week][lessons.get(i).start_number+1].setBackgroundColor(color);
                        bg[lessons.get(i).start_week][lessons.get(i).start_number+2].setBackgroundColor(color);
                        bg[lessons.get(i).start_week][lessons.get(i).start_number].setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog(current_lesson);
                            }
                        });
                        bg[lessons.get(i).start_week][lessons.get(i).start_number+1].setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog(current_lesson);
                            }
                        });
                        bg[lessons.get(i).start_week][lessons.get(i).start_number+2].setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog(current_lesson);
                            }
                        });
                    }
                }






            }
        };
        jwc_runnable =new Runnable() {
            @Override
            public void run() {
                Message msg = new Message();
                Bundle data = new Bundle();
                jwc_password = jwc_pass_set.Get(login.username);
                if(jwc_password.equals("")){
                    fragment_mine_jwc_password.switch_from=main_fragment.mContent;
                    main_fragment.ReplaceSwitchContent(main_fragment.mContent,main_fragment.mine_jwc_password);
                }else {
                    try {


                        jwc_test.login(login.username, jwc_password);
                        String result = jwc_test.GetTable();
                        data.putString("value", result);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    msg.setData(data);
                    handler.sendMessage(msg);
                }
            }
        };

        new Thread(jwc_runnable).start();


        return view;
    }
    int exist[]={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    int getcolor() {
        int color[]={Color.argb(200,254,67, 101),Color.argb(200,252,157,154),Color.argb(200,249,205, 173),Color.argb(200,200,200, 169),
                Color.argb(200,131,175, 155),Color.argb(200,69,137,148),Color.argb(200,114,83,52),Color.argb(200,222,156,83),
                Color.argb(200,101,147,74),Color.argb(200,38,188,213),Color.argb(200,159,125,80),Color.argb(200,254,67, 101),
                Color.argb(200,252,157,154),Color.argb(200,249,205, 173),Color.argb(200,200,200, 169), Color.argb(200,131,175, 155),
                Color.argb(200,69,137,148),Color.argb(200,114,83,52),Color.argb(200,222,156,83), Color.argb(200,101,147,74),
                Color.argb(200,38,188,213),Color.argb(200,159,125,80)};
        int selected;
        do {
            selected = (int) (Math.random() * 22);
        }while(exist[selected]==1);
        exist[selected]=1;

        return color[selected];
    }
    protected void dialog(Lesson class_inf) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("课程名称："+class_inf.name+"\n"+"教室："+class_inf.classroom+"\n"+"任课教师："+class_inf.teacher+"\n"+"周次："+class_inf.week);
        builder.create().show();
    }

}
