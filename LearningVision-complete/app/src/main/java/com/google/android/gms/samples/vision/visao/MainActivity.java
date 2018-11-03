package com.google.android.gms.samples.vision.visao;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*Lucas 03/11/2018*/
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        //btns
        Button QrButton = (Button) findViewById( R.id.QrButton );
        Button OcrButton = (Button) findViewById( R.id.OcrButton );

        QrButton.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v)
            {
                //Chamada para nova Activity
                Intent it = new Intent( MainActivity.this, BarcodeCaptureActivity.class);
                startActivity( it );
            }
        } );

        OcrButton.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v)
            {
                //Chamada para nova Activity
                Intent it = new Intent( MainActivity.this, OcrCaptureActivity.class );
                startActivity( it );
            }
        } );

    }
}
