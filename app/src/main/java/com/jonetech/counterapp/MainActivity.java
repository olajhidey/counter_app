package com.jonetech.counterapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView fTextCount;
    private EditText fEditText;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fTextCount = (TextView) findViewById(R.id.textView);
        fEditText = (EditText) findViewById(R.id.editText);

        fTextCount.setText(String.valueOf(count));

        if(savedInstanceState != null){
            fTextCount.setText(String.valueOf(savedInstanceState.getInt("count_value")));
            fEditText.setText(savedInstanceState.getString("edit_text"));
        }
    }



    public void increment(View view) {
        count++;
        fTextCount.setText(String.valueOf(count));

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putInt("count_value", count);
        outState.putString("edit_text", fEditText.getText().toString());

        super.onSaveInstanceState(outState);
    }
}
