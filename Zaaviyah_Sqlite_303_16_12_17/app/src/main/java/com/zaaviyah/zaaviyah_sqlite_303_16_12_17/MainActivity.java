package com.zaaviyah.zaaviyah_sqlite_303_16_12_17;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button b1Add, b2SERACH,b3update, b4Delete;
     DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);

        b1Add = (Button)findViewById(R.id.btAdd);
        b2SERACH = (Button)findViewById(R.id.btSerach);
        b3update = (Button)findViewById(R.id.btupdate);

        b4Delete= (Button)findViewById(R.id.btDelete);

        b1Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent AddIntent = new Intent(MainActivity.this,AddContact.class);
                startActivity(AddIntent);
            }
        });

    }
}
