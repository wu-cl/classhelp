package com.example.wcl.classhelp20;



import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.example.wcl.DB_Connection.Address;
import com.example.wcl.DB_Connection.DB_Mac_Get;
import com.example.wcl.dialog.sign_result_dialog;
import com.example.wcl.other_activities.login;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class fragment_sign extends Fragment {
    List<Address> address=null;
    Boolean first_load=true;
    View view;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    address= DB_Mac_Get.Get(login.username);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();



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
        view = inflater.inflate(R.layout.fragment_sign, container, false);

        final Context context=view.getContext();



        final ImageButton sign_search=(ImageButton)view.findViewById(R.id.sign_search);

        sign_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sign_result_dialog dialog = new sign_result_dialog(context, R.style.add_dialog);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.setCanceledOnTouchOutside(true);
                dialog.show();
            }
        });

        return view;
    }
}
