package com.example.poojavenkatran.simpletodoapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity {
    TextView tv;
    MainActivity parent;
    protected static String MESSAGE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        parent = new MainActivity();

        setContentView(R.layout.activity_edit);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        tv = (TextView) findViewById(R.id.editText);
        tv.setText(message);

    }

    public void editItem(View v){
        MESSAGE = tv.getText().toString();
        setResult(Activity.RESULT_OK);
        finish();
    }
}
