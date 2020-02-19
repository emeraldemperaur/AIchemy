package iot.empiaurhouse.mvvm.view;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import iot.empiaurhouse.mvvm.R;
import iot.empiaurhouse.mvvm.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {

    private ActivitySplashBinding activitySplashBinding;
    private ImageView splashImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        activitySplashBinding = DataBindingUtil.setContentView(this,R.layout.activity_splash);
        splashImage = activitySplashBinding.mekaLogo;
        nextView(3000);

    }



    @Override
    protected void onResume()
    {
        super.onResume();
        Animation fadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
        splashImage.startAnimation(fadeIn);

    }


    @Override
    protected void onPause()
    {
        super.onPause();
        splashImage.clearAnimation();

    }


    private void mainIntent(){
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    private void nextView(int milliSecondsDelay){
        final Handler handler = new Handler();
        handler.postDelayed(this::mainIntent, milliSecondsDelay);
    }

}
