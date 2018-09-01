package com.valentun.learn.myapplication;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private int count = 0;

    private TextView countView;
    private Button increment;
    private View container;

    private static String STATE_KEY = "COUNT_STATE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null && savedInstanceState.containsKey(STATE_KEY)) {
            count = savedInstanceState.getInt(STATE_KEY);
        }

        countView = findViewById(R.id.count);
        increment = findViewById(R.id.incerement);

        container = findViewById(R.id.main_container);

        countView.setText(String.valueOf(count));

        increment.setOnClickListener(this);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(STATE_KEY, count);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.incerement:
                increment();
                break;
        }
    }

    private void increment() {
        count++;

        countView.setText(String.valueOf(count));

        if (count % 2 == 0) {
            showToast();
        } else {
            showSnackBar();
        }
    }

    private void showSnackBar() {
        Snackbar.make(container, "Current count: " + count, Snackbar.LENGTH_SHORT)
                .show();
    }

    private void showToast() {
        Toast.makeText(this, "Current count: " + count, Toast.LENGTH_SHORT)
                .show();
    }
}
