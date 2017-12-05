package com.zaaviyah.class_login_2_12_17;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1Login, b2Cancel;
    EditText etNAME ,etEmail;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1Login = (Button) findViewById(R.id.btLogin);
        b2Cancel = (Button) findViewById(R.id.btCancel);
        etNAME = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        textView = (TextView) findViewById(R.id.tvView);

        b1Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(etNAME.getText().toString().equals("admin") && etEmail.getText().toString().equals("admin@yahoo.com"))
                {
                    Toast.makeText(getApplicationContext(),"yes login",Toast.LENGTH_SHORT).show();
                    Intent homeINTENT = new Intent(MainActivity.this,Home.class);
                    startActivity(homeINTENT);
                }else{
                    Toast.makeText(getApplicationContext(),"NO login",Toast.LENGTH_SHORT).show();
                }

            }
        });



        b2Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
