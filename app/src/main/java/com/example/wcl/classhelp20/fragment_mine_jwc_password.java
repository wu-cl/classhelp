package com.example.wcl.classhelp20;


import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wcl.jwc.jwc_Login;
import com.example.wcl.jwc.jwc_pass_set;
import com.example.wcl.other_activities.login;

public class fragment_mine_jwc_password extends Fragment {

    public static Fragment switch_from=null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       main_fragment.text_main_title.setText("预设教务处密码");
    }


    @Override
    public void onHiddenChanged(boolean hidden){

        if (hidden) {

        }else{
            main_fragment.text_main_title.setText("预设教务处密码");
        }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine_jwc_password, container, false);

        final EditText jwc_pass_input=(EditText)view.findViewById(R.id.jwc_password_input);
        final String[] input_password = {""};

        final Button jwc_pass_button=(Button)view.findViewById(R.id.jwc_pass_button);
        switch(login.color_select){
            case 0:
                jwc_pass_button.setBackgroundDrawable(getResources().getDrawable(R.drawable.login_button_style_1));
                break;
            case 1:
                jwc_pass_button.setBackgroundDrawable(getResources().getDrawable(R.drawable.login_button_style_2));
                break;
            case 2:
                jwc_pass_button.setBackgroundDrawable(getResources().getDrawable(R.drawable.login_button_style_3));
                break;
            case 3:
                jwc_pass_button.setBackgroundDrawable(getResources().getDrawable(R.drawable.login_button_style_4));
                break;
        }

        jwc_pass_button.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    switch (login.color_select) {
                        case 0:
                            jwc_pass_button.setBackgroundDrawable(getResources().getDrawable(R.drawable.login_button_style_1_pressed));
                            break;
                        case 1:
                            jwc_pass_button.setBackgroundDrawable(getResources().getDrawable(R.drawable.login_button_style_2_pressed));
                            break;
                        case 2:
                            jwc_pass_button.setBackgroundDrawable(getResources().getDrawable(R.drawable.login_button_style_3_pressed));
                            break;
                        case 3:
                            jwc_pass_button.setBackgroundDrawable(getResources().getDrawable(R.drawable.login_button_style_4_pressed));
                            break;
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    switch (login.color_select) {
                        case 0:
                            jwc_pass_button.setBackgroundDrawable(getResources().getDrawable(R.drawable.login_button_style_1));
                            break;
                        case 1:
                            jwc_pass_button.setBackgroundDrawable(getResources().getDrawable(R.drawable.login_button_style_2));
                            break;
                        case 2:
                            jwc_pass_button.setBackgroundDrawable(getResources().getDrawable(R.drawable.login_button_style_3));
                            break;
                        case 3:
                            jwc_pass_button.setBackgroundDrawable(getResources().getDrawable(R.drawable.login_button_style_4));
                            break;
                    }
                }

                return false;
            }

        });
        final Context this_context=view.getContext();
        final Handler jwc_pass_handler=new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                Bundle data = msg.getData();
                String result =data.getString("result");
                Toast.makeText(this_context.getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                if(switch_from==null||result.equals("密码错误")) {
                    jwc_pass_button.setVisibility(View.VISIBLE);
                    jwc_pass_input.setText("");
                }
                else if(result.equals("设置成功")){
                    main_fragment.switchContent(main_fragment.mContent, switch_from);
                    switch_from=null;
                }
            }
        };


        jwc_pass_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                jwc_pass_button.setVisibility(View.INVISIBLE);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        input_password[0] =jwc_pass_input.getText().toString();
                        Message msg = new Message();
                        Bundle data = new Bundle();
                        if(input_password[0].equals("")){
                            data.putString("result","密码为空");
                        }else{
                            jwc_Login jwc = new jwc_Login(this_context);
                            String result = null;
                            try {
                                result = jwc.login(login.username, input_password[0]);
                                data.putString("result","设置成功");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            if (result.equals("success")) {
                                jwc_pass_set.Set(login.username,input_password[0]);
                            } else if (result.equals("WrongPassword")) {
                               data.putString("result","密码错误");
                            }

                        }
                        msg.setData(data);
                        jwc_pass_handler.sendMessage(msg);
                    }
                }).start();




            }
        });


        return view;
    }
}
