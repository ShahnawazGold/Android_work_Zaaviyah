package com.zaaviyah.class_304_24_12_17;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    String msg = "wellcome apptron";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("zaaviyah  onCreate() ",msg);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("zaaviyah  onStart() ",msg);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("zaaviyah  onDestroy() ",msg);
    }
}
