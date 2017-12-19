package com.zaaviyah.zaaviyah_sqlite_303_16_12_17;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddContact extends AppCompatActivity {
    Button b1saved;
    EditText etNME,etEmail,EtNumbr;

    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        databaseHelper = new DatabaseHelper(this);

        b1saved = (Button)findViewById(R.id.SAVE);
        etEmail = (EditText)findViewById(R.id.etEmail);
        etNME = (EditText)findViewById(R.id.etNAME);
        EtNumbr = (EditText)findViewById(R.id.etNumber);
        b1saved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean result = databaseHelper.inserContact(etEmail.getText().toString(),etNME.getText().toString(),Integer.parseInt(EtNumbr.getText().toString()));

                if (result)
                {
                    Toast.makeText(AddContact.this, "data inserted", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(AddContact.this, "data not inserted ", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}
