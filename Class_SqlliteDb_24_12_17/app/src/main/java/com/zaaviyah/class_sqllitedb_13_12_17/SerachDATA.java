package com.zaaviyah.class_sqllitedb_13_12_17;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SerachDATA extends AppCompatActivity {

    Button b1SerachDATA;
    EditText SERACH;
    TextView tvNames, tvEmails;

     private  DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serach_dat);

        databaseHelper = new DatabaseHelper(this);

        b1SerachDATA = (Button) findViewById(R.id.btSearchData);
        SERACH = (EditText) findViewById(R.id.etSearchdata);
        tvNames = (TextView) findViewById(R.id.tvName);
        tvEmails = (TextView) findViewById(R.id.tvEmail);

        b1SerachDATA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(SerachDATA.this,"yes here know",Toast.LENGTH_SHORT).show();


                Cursor cursor = databaseHelper.getData(SERACH.getText().toString());

                tvNames.setText("   ");
                tvEmails.setText("  ");

                while (cursor.moveToNext())
                {
                    tvNames.setText(cursor.getString(1));
                    tvEmails.setText(cursor.getString(3));
                }

            }
        });


    }
}
