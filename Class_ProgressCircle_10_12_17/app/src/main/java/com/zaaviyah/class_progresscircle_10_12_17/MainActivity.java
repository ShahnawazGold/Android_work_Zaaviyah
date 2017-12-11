package com.zaaviyah.class_progresscircle_10_12_17;

import android.app.ProgressDialog;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button b1Download ;
    private  ProgressDialog progressBar;
    private  int progressBarStatus = 0;
    private Handler progressBarHendler = new Handler();
    private  long fileSize = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1Download= (Button)findViewById(R.id.btDownload);


        b1Download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressBar = new ProgressDialog(v.getContext());
                progressBar.setCancelable(true);
                progressBar.setMessage("download..");
                progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressBar.setMax(100);
                progressBar.show();
                progressBarStatus = 0;

                fileSize = 0;

                new Thread(new Runnable() {
                    @Override
                    public void run() {


                        //create while loop
                        while (progressBarStatus< 100){
                         progressBarStatus = downLoadFile();

                            try {
                               Thread.sleep(5000);

                            }catch (InterruptedException e){
                            e.printStackTrace();
                            }
                            progressBarHendler.post(new Runnable() {
                                @Override
                                public void run() {
                                    progressBar.setProgress(progressBarStatus);
                                }
                            });
                        }
                        /// while end

                        /// if condition
                        if (progressBarStatus >= 100){
                          try {
                              Thread.sleep(5000);
                          }catch ( InterruptedException e) {
                              e.printStackTrace();
                          }
                          progressBar.dismiss();
                        }
                        /// if condition end
                    }
                }).start();

            }
        });
    }

    public int downLoadFile (){
        while (fileSize <= 100000){
            fileSize++;
            if (fileSize ==200000){
                return  20;
            }else  if (fileSize ==300000){
                return 30;
            }
            else if (fileSize == 400000) {
                return 40;
            }else if (fileSize == 500000) {
                return 50;
            }else if (fileSize == 700000) {
                return 70;
            }else if (fileSize == 800000) {
                return 80;
            }

        }
        return 100 ;
    }
}
