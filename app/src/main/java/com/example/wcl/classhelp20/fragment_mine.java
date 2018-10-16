package com.example.wcl.classhelp20;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class
fragment_mine extends Fragment {




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
        View view = inflater.inflate(R.layout.fragment_mine, container, false);

        LinearLayout jwc_pass=(LinearLayout)view.findViewById(R.id.mine_jwc_password);
        jwc_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main_fragment.switchContent(main_fragment.mContent,main_fragment.mine_jwc_password);
            }
        });

        return view;
    }
}
