package com.valentun.learn.lesson3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    public static String KEY = "KEY";

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String string = getIntent().getStringExtra(KEY);

        textView = findViewById(R.id.second_title);

        textView.setText(string);
    }
}
