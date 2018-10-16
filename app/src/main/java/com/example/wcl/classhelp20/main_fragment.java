package com.example.wcl.classhelp20;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.wcl.jwc.jwc_Login;
import com.example.wcl.other_activities.login;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class main_fragment extends FragmentActivity {
    public static fragment_main main;
    public static fragment_sign sign;
    public static fragment_work work;
    public static fragment_mine mine;

    public static fragment_jwc jwc;
    public static fragment_table table;

    public static fragment_mine_jwc_password mine_jwc_password;

    public static FragmentManager fragmentManager;

    public static Fragment mContent=null;

    public static TextView text_main_title;


    public static String test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_fragment);




        //--------test--------



        //-------test---------





        fragmentManager = getSupportFragmentManager();

        main = new fragment_main();
        sign=new fragment_sign();
        work=new fragment_work();
        mine=new fragment_mine();

        jwc=new fragment_jwc();
        table=new fragment_table();

        mine_jwc_password=new fragment_mine_jwc_password();

        FragmentTransaction ftransaction=fragmentManager.beginTransaction();
        //fragmentTransaction.add(R.id.fragment_main, sign);
        //fragmentTransaction.add(R.id.fragment_main, work);
       // fragmentTransaction.add(R.id.fragment_main, mine);
        ftransaction.add(R.id.fragment_main, main);
        ftransaction.commit();
        mContent=main;

        /*
        界面字体设置
         */
        Typeface font1 = Typeface.createFromAsset(getAssets(), "fonts/MFYUEYUAN_NONCOMMERCIAL-REGULAR.OTF");
        Typeface font2 = Typeface.createFromAsset(getAssets(), "fonts/SIMLI.TTF");
        //定义字体
        text_main_title= (TextView) findViewById(R.id.main_title);
        text_main_title.setTypeface(font1);
        //设置字体
     //   TextPaint tp_main_title = text_main_title.getPaint();
      //  tp_main_title.setFakeBoldText(true);
        //加粗
        final TextView main_bottom_main_text=(TextView)findViewById(R.id.main_bottom_main_text);
        main_bottom_main_text.setTypeface(font2);
        final TextView main_bottom_sign_text=(TextView)findViewById(R.id.main_bottom_sign_text);
        main_bottom_sign_text.setTypeface(font2);
        final TextView main_bottom_work_text=(TextView)findViewById(R.id.main_bottom_work_text);
        main_bottom_work_text.setTypeface(font2);
        final TextView main_bottom_mine_text=(TextView)findViewById(R.id.main_bottom_mine_text);
        main_bottom_mine_text.setTypeface(font2);

        final ImageButton main_bottom_main=(ImageButton)findViewById(R.id.main_bottom_main);
        final ImageButton main_bottom_sign=(ImageButton)findViewById(R.id.main_bottom_sign);
        final ImageButton main_bottom_work=(ImageButton)findViewById(R.id.main_bottom_work);
        final ImageButton main_bottom_mine=(ImageButton)findViewById(R.id.main_bottom_mine);

        switch(login.color_select){
            case 0:
                main_bottom_main.setBackgroundResource(R.drawable.main_bottom_main_selected_1);
                break;
            case 1:
                main_bottom_main.setBackgroundResource(R.drawable.main_bottom_main_selected_2);
                break;
            case 2:
                main_bottom_main.setBackgroundResource(R.drawable.main_bottom_main_selected_3);
                break;
            case 3:
                main_bottom_main.setBackgroundResource(R.drawable.main_bottom_main_selected_4);
                break;
        }
        main_bottom_main_text.setTextColor(login.color[login.color_select]);

        main_bottom_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //页面切换
                switchContent(mContent,main);
                /*
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_main, main);
                fragmentTransaction.commit();*/
                text_main_title.setText("课堂辅助");
                //底部按钮图标改变
                switch(login.color_select){
                    case 0:
                        main_bottom_main.setBackgroundResource(R.drawable.main_bottom_main_selected_1);
                        break;
                    case 1:
                        main_bottom_main.setBackgroundResource(R.drawable.main_bottom_main_selected_2);
                        break;
                    case 2:
                        main_bottom_main.setBackgroundResource(R.drawable.main_bottom_main_selected_3);
                        break;
                    case 3:
                        main_bottom_main.setBackgroundResource(R.drawable.main_bottom_main_selected_4);
                        break;
                }

                main_bottom_sign.setBackgroundResource(R.drawable.main_bottom_sign);
                main_bottom_work.setBackgroundResource(R.drawable.main_bottom_work);
                main_bottom_mine.setBackgroundResource(R.drawable.main_bottom_mine);
                //底部按钮文字改变
                main_bottom_main_text.setTextColor(login.color[login.color_select]);
                main_bottom_sign_text.setTextColor(0xff717f8b);
                main_bottom_work_text.setTextColor(0xff717f8b);
                main_bottom_mine_text.setTextColor(0xff717f8b);

            }
        });
        main_bottom_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //页面切换
                switchContent(mContent,sign);
                /*
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_main, sign);
                fragmentTransaction.commit();*/
                text_main_title.setText("签到");
                //底部按钮图标改变
                main_bottom_main.setBackgroundResource(R.drawable.main_bottom_main);
                switch(login.color_select){
                    case 0:
                        main_bottom_sign.setBackgroundResource(R.drawable.main_bottom_sign_selected_1);
                        break;
                    case 1:
                        main_bottom_sign.setBackgroundResource(R.drawable.main_bottom_sign_selected_2);
                        break;
                    case 2:
                        main_bottom_sign.setBackgroundResource(R.drawable.main_bottom_sign_selected_3);
                        break;
                    case 3:
                        main_bottom_sign.setBackgroundResource(R.drawable.main_bottom_sign_selected_4);
                        break;
                }
                main_bottom_work.setBackgroundResource(R.drawable.main_bottom_work);
                main_bottom_mine.setBackgroundResource(R.drawable.main_bottom_mine);
                //底部按钮文字改变
                main_bottom_main_text.setTextColor(0xff717f8b);
                main_bottom_sign_text.setTextColor(login.color[login.color_select]);
                main_bottom_work_text.setTextColor(0xff717f8b);
                main_bottom_mine_text.setTextColor(0xff717f8b);

            }
        });
        main_bottom_work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //页面切换
                switchContent(mContent,work);
                /*
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_main, work);
                fragmentTransaction.commit();*/
                text_main_title.setText("作业");
                //底部按钮图标改变
                main_bottom_main.setBackgroundResource(R.drawable.main_bottom_main);
                main_bottom_sign.setBackgroundResource(R.drawable.main_bottom_sign);
                switch(login.color_select){
                    case 0:
                        main_bottom_work.setBackgroundResource(R.drawable.main_bottom_work_selected_1);
                        break;
                    case 1:
                        main_bottom_work.setBackgroundResource(R.drawable.main_bottom_work_selected_2);
                        break;
                    case 2:
                        main_bottom_work.setBackgroundResource(R.drawable.main_bottom_work_selected_3);
                        break;
                    case 3:
                        main_bottom_work.setBackgroundResource(R.drawable.main_bottom_work_selected_4);
                        break;
                }
                main_bottom_mine.setBackgroundResource(R.drawable.main_bottom_mine);
                //底部按钮文字改变
                main_bottom_main_text.setTextColor(0xff717f8b);
                main_bottom_sign_text.setTextColor(0xff717f8b);
                main_bottom_work_text.setTextColor(login.color[login.color_select]);
                main_bottom_mine_text.setTextColor(0xff717f8b);

            }
        });
        main_bottom_mine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //页面切换
                switchContent(mContent,mine);
                /*
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_main, mine);
                fragmentTransaction.commit();*/
                text_main_title.setText("我的");
                //底部按钮图标改变
                main_bottom_main.setBackgroundResource(R.drawable.main_bottom_main);
                main_bottom_sign.setBackgroundResource(R.drawable.main_bottom_sign);
                main_bottom_work.setBackgroundResource(R.drawable.main_bottom_work);
                switch(login.color_select){
                    case 0:
                        main_bottom_mine.setBackgroundResource(R.drawable.main_bottom_mine_selected_1);
                        break;
                    case 1:
                        main_bottom_mine.setBackgroundResource(R.drawable.main_bottom_mine_selected_2);
                        break;
                    case 2:
                        main_bottom_mine.setBackgroundResource(R.drawable.main_bottom_mine_selected_3);
                        break;
                    case 3:
                        main_bottom_mine.setBackgroundResource(R.drawable.main_bottom_mine_selected_4);
                        break;
                }
                //底部按钮文字改变
                main_bottom_main_text.setTextColor(0xff717f8b);
                main_bottom_sign_text.setTextColor(0xff717f8b);
                main_bottom_work_text.setTextColor(0xff717f8b);
                main_bottom_mine_text.setTextColor(login.color[login.color_select]);

            }
        });


    }
    @Override
    public void onBackPressed(){
        if(mContent.equals(jwc)||mContent.equals(table)){
            switchContent(mContent,main);
            text_main_title.setText("课堂辅助");
            }
        if(mContent.equals(mine_jwc_password)){
            switchContent(mContent,mine);
            text_main_title.setText("我的");
        }


    }
    public static void switchContent(Fragment from, Fragment to) {
        if (mContent != to) {
            mContent = to;
            FragmentTransaction transaction= fragmentManager.beginTransaction();
            if (!to.isAdded()) {    // 先判断是否被add过
                transaction.hide(from).add(R.id.fragment_main, to).commit(); // 隐藏当前的fragment，add下一个到Activity中
            } else {
                transaction.hide(from).show(to).commit();// 隐藏当前的fragment，显示下一个
            }
        }
    }
    public static void ReplaceSwitchContent(Fragment from, Fragment to) {
        if (mContent != to) {
            mContent = to;
            FragmentTransaction transaction= fragmentManager.beginTransaction();
            if (!to.isAdded()) {    // 先判断是否被add过
                transaction.remove(from).add(R.id.fragment_main, to).commit(); // 隐藏当前的fragment，add下一个到Activity中
            } else {
                transaction.remove(from).show(to).commit();// 隐藏当前的fragment，显示下一个
            }
        }
    }




    public static String GetCachePath(){
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }



}
