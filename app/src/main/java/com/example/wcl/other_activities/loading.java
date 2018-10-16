package com.example.wcl.other_activities;

/**
 * Created by wcl on 2016/8/9.
 */


        import android.app.Activity;
        import android.content.Intent;
        import android.graphics.drawable.Drawable;
        import android.os.Bundle;
        import android.view.Window;
        import android.view.WindowManager;
        import android.view.animation.AlphaAnimation;
        import android.view.animation.Animation;
        import android.widget.ImageView;

        import com.example.wcl.classhelp20.R;

public class loading extends Activity {
    /** Called when the activity is first created. */
    ImageView loadingIv;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.loading);
        loadingIv = (ImageView) this.findViewById(R.id.loading_pic);
        // 从浅到深,从百分之10到百分之百
        AlphaAnimation animation = new AlphaAnimation(0.1f, 1.0f);
        animation.setDuration(1000);
        loadingIv.setAnimation(animation);
        // 给animation设置监听器

        animation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // TODO Auto-generated method stub

                Intent it = new Intent(loading.this, login.class);
                startActivity(it);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }
    @Override

    protected void onStop() {
        super.onStop();
        Drawable d = loadingIv.getDrawable();
        if (d != null)
            d.setCallback(null);
        loadingIv.setImageDrawable(null);
        loadingIv.setBackgroundDrawable(null);
    }

}
