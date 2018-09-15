package com.valentun.learn.lesson3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static String TAG = "MainActivity";

    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "OnCreate");

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchSecond();
            }
        });
    }

    private void launchSecond() {
        String string = editText.getText().toString();

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(SecondActivity.KEY, string);
        startActivity(intent);

        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG, "OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "OnResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d(TAG, "OnRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(TAG, "OnPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d(TAG, "OnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "OnDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.d(TAG, "OnSaveState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Log.d(TAG, "OnRestore");
    }
}
