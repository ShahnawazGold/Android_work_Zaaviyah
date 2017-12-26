package com.zaaviyah.class_sqllitedb_13_12_17;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class DeleteData extends AppCompatActivity {
    Button b1DELETED;
    EditText etDEletes;

    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_data);

        databaseHelper = new DatabaseHelper(this);

        b1DELETED = (Button) findViewById(R.id.btDELETEdata);
        etDEletes = (EditText) findViewById(R.id.etDeleteDATA);

        b1DELETED.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.deleteData(etDEletes.getText().toString());

                Toast.makeText(DeleteData.this,"delete",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
