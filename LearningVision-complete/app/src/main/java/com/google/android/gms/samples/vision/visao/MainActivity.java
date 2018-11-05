package com.google.android.gms.samples.vision.visao;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        TextToSpeech.OnInitListener listener =
                new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(final int status) {
                        if (status == TextToSpeech.SUCCESS) {
                            Log.d( "OnInitListener", "Text to speech engine started successfully." );
                            tts.setLanguage( Locale.getDefault());
                            String initialText = "Seja bem vindo ao Auxílio Visual. Para leitura de contas, clique na parte inferior da tela. " +
                                    "Para leitura de textos, clique na parte superior";
                            tts.speak(initialText, TextToSpeech.QUEUE_ADD, null, "KEY_PARAM_UTTERANCE_ID");
                        } else {
                            Log.d( "OnInitListener", "Error starting the text to speech engine." );
                        }
                    }
                };

        tts = new TextToSpeech( this.getApplicationContext(), listener );

        Button QrButton = (Button) findViewById( R.id.QrButton );
        Button OcrButton = (Button) findViewById( R.id.OcrButton );
        QrButton.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v)
            {
                Intent it = new Intent( MainActivity.this, BarcodeCaptureActivity.class);
                startActivity( it );
            }
        } );
        OcrButton.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v)
            {
                Intent it = new Intent( MainActivity.this, OcrCaptureActivity.class );
                startActivity( it );
            }
        } );
    }
    protected void onPause() {
        super.onPause();
        if (tts.isSpeaking()) {
            tts.stop();
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (tts.isSpeaking()) {
            tts.stop();
        }
    }
}
