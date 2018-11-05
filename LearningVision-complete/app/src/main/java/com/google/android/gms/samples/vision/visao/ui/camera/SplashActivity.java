package com.google.android.gms.samples.vision.visao.ui.camera;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;

import com.google.android.gms.samples.vision.visao.MainActivity;
import com.google.android.gms.samples.vision.visao.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_splash );
        //ProgressBar p = findViewById(R.id.progressSplash);

        //getSupportActionBar().hide();
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN );

        new Handler( ).postDelayed( new Runnable() {
            @Override
            public void run() {
                startActivity( new Intent( getBaseContext(), MainActivity.class ) );
                findViewById(R.id.splashPanel).setVisibility( View.GONE);
                finish();
            }
        } , 5000);
    }
}
