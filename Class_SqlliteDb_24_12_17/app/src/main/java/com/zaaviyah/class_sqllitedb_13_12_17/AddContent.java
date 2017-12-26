package com.zaaviyah.class_sqllitedb_13_12_17;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddContent extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    Button b1SAVE;
    EditText etName,etPJHONE,etEmial;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_content);

        databaseHelper = new DatabaseHelper (this);

        b1SAVE =(Button) findViewById(R.id.btSave);
        etEmial = (EditText) findViewById(R.id.etEMAIL);
        etName = (EditText) findViewById(R.id.etNAME);
        etPJHONE = (EditText) findViewById(R.id.etPHone);

        b1SAVE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean result = databaseHelper.insertContact (etName.getText().toString(),Integer.parseInt(etPJHONE.getText().toString()) ,etEmial.getText().toString());
                if(result == true){
                    Toast.makeText(AddContent.this,"data insert",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(AddContent.this,"data insert",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
