package com.jroaes.colectiapptest.splash;

import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.jroaes.colectiapptest.Constants;
import com.jroaes.colectiapptest.R;
import com.jroaes.colectiapptest.base.BaseActivity;
import com.jroaes.colectiapptest.ui.map.MapsActivity;

public class SplashActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            public void run() {
                go(SplashActivity.this, MapsActivity.class);
                finish();
            }

            ;
        }, Constants.SPLASH_DURATION);
    }
}
