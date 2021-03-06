package com.zaaviyah.zaaviyah_autocomplete;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {


    AutoCompleteTextView text;
    MultiAutoCompleteTextView text1;
    String [] languages = {"Android ","java","IOS","SQL","JDBC","Web services"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //// on create method
        text =  (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        text1 = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView);

        ArrayAdapter adapter = new  ArrayAdapter(this,android.R.layout.simple_list_item_1,languages);

        text.setAdapter(adapter);
        text.setThreshold(1);

        text1.setAdapter(adapter);

        text1.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());


    }
}
