package com.example.beijingnews;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.beijingnews.activity.GuideActivity;
import com.example.beijingnews.activity.MainActivity;
import com.example.beijingnews.utils.CacheUtils;

public class SplashActivity extends Activity {

    // static constance
    public static final String ENTER_MAIN = "enter_main";
    private RelativeLayout rl_splash_root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        rl_splash_root = (RelativeLayout) findViewById(R.id.rl_splash_root);
        
        //TweenAnimation, ScaleAnimation, RotateAnimation
        AlphaAnimation aa = new AlphaAnimation(0,1);
//        aa.setDuration(500);
        aa.setFillAfter(true);

        ScaleAnimation sa = new ScaleAnimation(0,1,0,1,
                ScaleAnimation.RELATIVE_TO_SELF, 0.5f,
                ScaleAnimation.RELATIVE_TO_SELF,0.5f);
//        sa.setDuration(500);
        sa.setFillAfter(true);

        RotateAnimation ra = new RotateAnimation(0,360,
                RotateAnimation.RELATIVE_TO_SELF,0.5f,
                RotateAnimation.RELATIVE_TO_SELF,0.5f);
//        ra.setDuration(500);
        ra.setFillAfter(true);

        //no frequency to add sa,ra,aa, display these animations at one time
        AnimationSet set = new AnimationSet(false);
        set.addAnimation(aa);
        set.addAnimation(ra);
        set.addAnimation(sa);
        set.setDuration(2000);

        rl_splash_root.startAnimation(set);

        set.setAnimationListener(new MyAnimationListener());
    }

    class MyAnimationListener implements Animation.AnimationListener{

        /**
         * invoke this method when animation starts
         * @param animation
         */
        @Override
        public void onAnimationStart(Animation animation) {

        }

        /**
         *  invoke this method when animation ends
         * @param animation
         */
        @Override
        public void onAnimationEnd(Animation animation) {

            // judge if had entered the main page
            boolean isEnterMain = CacheUtils.getBoolean(SplashActivity.this, ENTER_MAIN);

            Intent intent;
            if(isEnterMain){
                // if had, enter the main page
                intent = new Intent(SplashActivity.this, MainActivity.class);
            }else {
                // if not, enter the guide page
                intent = new Intent(SplashActivity.this, GuideActivity.class);
            }
            startActivity(intent);


            // close SplashActivity
            finish();

//            Toast.makeText(SplashActivity.this,"动画播放完成了", Toast.LENGTH_SHORT).show();
        }

        /**
         *  invoke this method when animation repeats
         * @param animation
         */
        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}
