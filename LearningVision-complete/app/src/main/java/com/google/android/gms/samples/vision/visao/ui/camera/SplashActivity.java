package com.google.android.gms.samples.vision.visao.ui.camera;

import android.content.Intent;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;

import com.google.android.gms.samples.vision.visao.MainActivity;
import com.google.android.gms.samples.vision.visao.R;

import java.util.Locale;

public class SplashActivity extends AppCompatActivity {
    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_splash );

        TextToSpeech.OnInitListener listener =
                new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(final int status) {
                        if (status == TextToSpeech.SUCCESS) {
                            Log.d( "OnInitListener", "Text to speech engine started successfully." );
                            tts.setLanguage( Locale.getDefault());
                            String initialText = "Seja bem vindo a visão auxiliar ";
                            tts.speak(initialText, TextToSpeech.QUEUE_ADD, null, "KEY_PARAM_UTTERANCE_ID");
                        } else {
                            Log.d( "OnInitListener", "Error starting the text to speech engine." );
                        }
                    }
                };

        tts = new TextToSpeech( this.getApplicationContext(), listener );

        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN );

        new Handler( ).postDelayed( new Runnable() {
            @Override
            public void run() {
                startActivity( new Intent( getBaseContext(), MainActivity.class ) );
                findViewById(R.id.splashPanel).setVisibility( View.GONE);
                finish();
            }
        } , 3000);
    }
}
