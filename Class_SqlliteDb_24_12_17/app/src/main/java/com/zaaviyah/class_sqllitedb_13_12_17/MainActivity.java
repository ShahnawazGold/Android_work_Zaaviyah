package com.zaaviyah.class_sqllitedb_13_12_17;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button b1ADD,b2update, b3DElete, b4SERACH;
    DatabaseHelper databaseHelper ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create data base object
        databaseHelper = new DatabaseHelper(this);

        b1ADD = (Button)findViewById(R.id.btAdd);
        b2update= (Button)findViewById(R.id.btUpdate);
        b3DElete= (Button)findViewById(R.id.btDelete);
        b4SERACH= (Button)findViewById(R.id.btserach);

        b1ADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ADDintent = new Intent(MainActivity.this,AddContent.class);
                startActivity(ADDintent);
            }
        });


        b4SERACH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent serachINTENT = new Intent(MainActivity.this,SerachDATA.class);
               startActivity(serachINTENT);
            }
        });

        b2update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent updateIntent = new Intent(MainActivity.this,UpdateDATA.class);
                startActivity(updateIntent);
            }
        });
        b3DElete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent DeleteINten = new Intent(MainActivity.this,DeleteData.class);
                startActivity(DeleteINten);
            }
        });
    }
}
