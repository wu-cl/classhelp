package com.example.wcl.other_activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.wcl.DB_Connection.DB_Login_Connection;
import com.example.wcl.classhelp20.R;
import com.example.wcl.classhelp20.main_fragment;
import com.example.wcl.jwc.jwc_calendar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;

public class login extends Activity {
    public static int color[]={0xff69bee0,0xffef7800,0xffafaef9,0xffe72653};//蓝 橙 紫 红
    public static int color_select=0;
    public static boolean Is_login=false;
    public static String username="";
    private String InputPassword="";
    public static String name="";
    public static int week;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    week = jwc_calendar.current_week_get();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }) {

        }.start();

        color_select=(int)(0+Math.random()*(3-0+1));

        setContentView(R.layout.login);


        Typeface font1 = Typeface.createFromAsset(getAssets(), "fonts/MFYUEYUAN_NONCOMMERCIAL-REGULAR.OTF");
        Typeface font2 = Typeface.createFromAsset(getAssets(), "fonts/SIMLI.TTF");

        final EditText login_username=(EditText)findViewById(R.id.login_username);
        final EditText login_password=(EditText)findViewById(R.id.login_password);

        login_username.setTypeface(font1);
        login_password.setTypeface(font1);

        final CheckBox login_check=(CheckBox)findViewById(R.id.login_check);
        login_check.setTypeface(font1);

        ImageView login_icon=(ImageView)findViewById(R.id.login_icon);
        switch(color_select){
            case 0:
                login_icon.setBackgroundDrawable(getResources().getDrawable(R.drawable.login_icon_style_1));
                break;
            case 1:
                login_icon.setBackgroundDrawable(getResources().getDrawable(R.drawable.login_icon_style_2));
                break;
            case 2:
                login_icon.setBackgroundDrawable(getResources().getDrawable(R.drawable.login_icon_style_3));
                break;
            case 3:
                login_icon.setBackgroundDrawable(getResources().getDrawable(R.drawable.login_icon_style_4));
                break;
        }

        final Button login_button=(Button)findViewById(R.id.login_button);
        login_button.setTypeface(font2);
        switch(color_select){
            case 0:
                login_button.setBackgroundDrawable(getResources().getDrawable(R.drawable.login_button_style_1));
                break;
            case 1:
                login_button.setBackgroundDrawable(getResources().getDrawable(R.drawable.login_button_style_2));
                break;
            case 2:
                login_button.setBackgroundDrawable(getResources().getDrawable(R.drawable.login_button_style_3));
                break;
            case 3:
                login_button.setBackgroundDrawable(getResources().getDrawable(R.drawable.login_button_style_4));
                break;
        }
        final ProgressBar progress=(ProgressBar)findViewById(R.id.login_progressBar);
        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                Bundle data = msg.getData();
                String result = data.getString("value");
                String get_name=data.getString("name");
                // TODO


                if(result.equals("ConnectionError")){
                    Toast.makeText(getApplicationContext(), "网络连接失败", Toast.LENGTH_SHORT).show();
                    login_button.setVisibility(View.VISIBLE);
                    progress.setVisibility(View.INVISIBLE);
                }
                else
                if(result.equals("user_not_found")) {
                    Toast.makeText(getApplicationContext(), "用户名不存在", Toast.LENGTH_SHORT).show();
                    login_button.setVisibility(View.VISIBLE);
                    progress.setVisibility(View.INVISIBLE);
                }
                else
                if(result.equals("success")) {
                    Toast.makeText(getApplicationContext(), "登陆成功", Toast.LENGTH_SHORT).show();
                    Is_login=true;
                    name=get_name;
                    Intent page1=new Intent(getApplicationContext(),main_fragment.class);
                    startActivity(page1);
                    finish();
                }
                else if(result.equals("WrongPassword")){
                    Toast.makeText(getApplicationContext(), "密码错误", Toast.LENGTH_SHORT).show();
                    login_button.setVisibility(View.VISIBLE);
                    progress.setVisibility(View.INVISIBLE);
                }
                else {
                    Toast.makeText(getApplicationContext(), "其他错误", Toast.LENGTH_SHORT).show();
                    login_button.setVisibility(View.VISIBLE);
                    progress.setVisibility(View.INVISIBLE);
                }

            }
        };

        final Runnable networkTask = new Runnable() {
            @Override
            public void run() {
                // TODO
                Message msg = new Message();
                Bundle data = new Bundle();


                String result =  DB_Login_Connection.CheckPassword(username,InputPassword);
                data.putString("value", result);
                result=DB_Login_Connection.GetName(username);
                data.putString("name",result);
                msg.setData(data);
                handler.sendMessage(msg);

            }
        };

        login_button.setOnTouchListener(new View.OnTouchListener(){

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    //更改为按下时的背景图片
                    switch(color_select){
                        case 0:
                            login_button.setBackgroundDrawable(getResources().getDrawable(R.drawable.login_button_style_1_pressed));
                            break;
                        case 1:
                            login_button.setBackgroundDrawable(getResources().getDrawable(R.drawable.login_button_style_2_pressed));
                            break;
                        case 2:
                            login_button.setBackgroundDrawable(getResources().getDrawable(R.drawable.login_button_style_3_pressed));
                            break;
                        case 3:
                            login_button.setBackgroundDrawable(getResources().getDrawable(R.drawable.login_button_style_4_pressed));
                            break;
                    }
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    //改为抬起时的图片
                    switch(color_select){
                        case 0:
                            login_button.setBackgroundDrawable(getResources().getDrawable(R.drawable.login_button_style_1));
                            break;
                        case 1:
                            login_button.setBackgroundDrawable(getResources().getDrawable(R.drawable.login_button_style_2));
                            break;
                        case 2:
                            login_button.setBackgroundDrawable(getResources().getDrawable(R.drawable.login_button_style_3));
                            break;
                        case 3:
                            login_button.setBackgroundDrawable(getResources().getDrawable(R.drawable.login_button_style_4));
                            break;
                    }
                }
                return false;
            }

        });
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username=login_username.getText().toString();
                InputPassword=login_password.getText().toString();


                if(login_check.isChecked()) {
                    File sdcDir = Environment.getExternalStorageDirectory();
                    File file = new File(sdcDir,"password.txt");
                    try {
                        FileOutputStream out = new FileOutputStream(file);
                        String temp=username;
                        out.write(temp.getBytes());
                        out.write("\r\n".getBytes());
                        out.write(InputPassword.getBytes());
                        out.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

                if(!username.equals("")) {
                    login_button.setVisibility(View.INVISIBLE);
                    progress.setVisibility(View.VISIBLE);

                   new Thread(networkTask).start();
                }
                else{
                    Toast.makeText(getApplicationContext(), "用户名为空", Toast.LENGTH_SHORT).show();
                }



            }
        });


        File sdcDir = Environment.getExternalStorageDirectory();
        File file = new File(sdcDir,"password.txt");
        try {
            InputStream instream = new FileInputStream(file);
            if (instream != null)
            {
                login_check.setChecked(true);
                InputStreamReader inputreader = new InputStreamReader(instream);
                BufferedReader buffreader = new BufferedReader(inputreader);
                String saved_username;
                String saved_password;
                saved_username = buffreader.readLine();
                saved_password = buffreader.readLine();
                login_username.setText(saved_username);
                login_password.setText(saved_password);
                instream.close();
            }
        }
        catch (java.io.FileNotFoundException e)
        {
        }
        catch (IOException e)
        {
        }




    }
}
