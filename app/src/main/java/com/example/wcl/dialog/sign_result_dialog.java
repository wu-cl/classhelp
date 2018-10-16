package com.example.wcl.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import com.example.wcl.classhelp20.R;

import org.apache.http.NameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wcl on 2016/8/16.
 */
public class sign_result_dialog extends Dialog{
    String comment=null;
    Context context;
    List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>();
    public sign_result_dialog(Context context) {
        super(context);
        this.context=context;
    }
    public sign_result_dialog(Context context, int theme) {
        super(context, theme);
        if (context instanceof Activity) {
            setOwnerActivity((Activity) context);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_result_dialog);







    }



}
