package com.zaaviyah.zaaviyah_sendingsms;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;

    Button  btnSend;
    EditText txtPhoneNo ;
    EditText txtMassage ;
    String phonNo;
    String message ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnSend = (Button) findViewById(R.id.btn1);
        txtPhoneNo = (EditText) findViewById(R.id.editText);
        txtMassage = (EditText) findViewById(R.id.editText2);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendSMSMessage();
            }
        });

    }


        protected void sendSMSMessage() {

            phonNo = txtPhoneNo.getText().toString();
            message = txtMassage.getText().toString();

            if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {

                if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                        Manifest.permission.SEND_SMS)) {
                } else {
                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.SEND_SMS},
                            MY_PERMISSIONS_REQUEST_SEND_SMS);
                }
            }
        }



        @Override
        public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults) {
            switch (requestCode) {
                case MY_PERMISSIONS_REQUEST_SEND_SMS: {
                    if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                        SmsManager smsManager = SmsManager.getDefault();

                        smsManager.sendTextMessage(phonNo, null, message, null, null);
                        Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();

                    } else {

                        Toast.makeText(getApplicationContext(),  "SMS faild, please try again.", Toast.LENGTH_LONG).show();
                        return;
                    }
                }
            }

        }
}
