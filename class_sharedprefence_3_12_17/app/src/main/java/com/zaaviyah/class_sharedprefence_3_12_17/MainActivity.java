package com.zaaviyah.class_sharedprefence_3_12_17;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1login;
    EditText etNAME,etEmail,etPH;

    public static final String Mysharedpfrefnce = "mySharedprefance";

    public static final String Name = "keyname";
    public static final String Email = "keynEmail";
    public static final String PHone = "keyPHone";

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1login= (Button)findViewById(R.id.btLogin);
        etNAME = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPH = (EditText) findViewById(R.id.etPphone);


        b1login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sharedPreferences =getSharedPreferences(Mysharedpfrefnce, Context.MODE_PRIVATE);

                String NameS =etNAME.getText().toString();
                String PhoneS =etPH.getText().toString();
                String EmailS =etEmail.getText().toString();

                SharedPreferences.Editor editor =sharedPreferences.edit();
                editor.putString(Name,NameS);
                editor.putString(Email,EmailS);
                editor.putString(PHone,PhoneS);

                Toast.makeText(MainActivity.this,"thank you login",Toast.LENGTH_SHORT).show();

            }
        });




    }
}
