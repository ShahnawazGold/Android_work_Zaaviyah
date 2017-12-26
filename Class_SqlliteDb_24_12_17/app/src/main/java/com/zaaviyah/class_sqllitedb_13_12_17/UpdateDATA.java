package com.zaaviyah.class_sqllitedb_13_12_17;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateDATA extends AppCompatActivity {

    Button b1Upadte;
    EditText etUPnam,etupEmail,etupNumber;
  DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_dat);

        databaseHelper = new DatabaseHelper(this);

        b1Upadte =(Button)findViewById(R.id.btUpdateDATAB);
        etUPnam = (EditText)findViewById(R.id.updateNAME);
        etupEmail = (EditText)findViewById(R.id.updateEmail);
        etupNumber = (EditText)findViewById(R.id.updateNumber);

        b1Upadte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(UpdateDATA.this,"yes update",Toast.LENGTH_SHORT).show();
                databaseHelper.updateData(etupNumber.getText().toString(),etUPnam.getText().toString(),etupEmail.getText().toString());

            }
        });



    }
}
