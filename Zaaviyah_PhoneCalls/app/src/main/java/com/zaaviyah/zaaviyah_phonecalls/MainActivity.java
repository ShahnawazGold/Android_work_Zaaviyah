package com.zaaviyah.zaaviyah_phonecalls;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button ;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // id get button here show
        button =  (Button) findViewById( R.id.btnCall);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent callIntent = new  Intent(Intent.ACTION_CALL);
                final Intent intent = callIntent.setData(Uri.parse("tel:03400290456"));


                if (PackageManager.PERMISSION_GRANTED != ActivityCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.CALL_PHONE)) {
                    return;
                }
                startActivity(callIntent);

            }
        });


    }
}
