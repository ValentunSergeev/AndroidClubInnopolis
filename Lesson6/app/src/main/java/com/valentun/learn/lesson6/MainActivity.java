package com.valentun.learn.lesson6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> data = new ArrayList<>();

    private static final String DATA_KEY = "MainActivity.Data";

    private StringAdapter adapter;

    private EditText contentField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null && savedInstanceState.containsKey(DATA_KEY)) {
            data = savedInstanceState.getStringArrayList(DATA_KEY);
        }

        adapter = new StringAdapter(new ArrayList<>(data));

        RecyclerView list = findViewById(R.id.list);
        list.setHasFixedSize(true);
        list.setAdapter(adapter);

        contentField = findViewById(R.id.content_field);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putStringArrayList(DATA_KEY, data);

        super.onSaveInstanceState(outState);
    }

    public void addClicked(View view) {
        String content = contentField.getText().toString();

        if (content.isEmpty()) {
            Toast.makeText(this, R.string.empty_content, Toast.LENGTH_SHORT)
                    .show();
            return;
        }

        data.add(content);
        adapter.addItem(content);
    }
}
