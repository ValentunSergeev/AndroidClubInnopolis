package com.valentun.learn.practice4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    private static final Integer offset = 228322;

    private ViewGroup container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = findViewById(R.id.main_container);

//        initCheckBoxes();
    }

    private void initCheckBoxes() {
        for (int i = 0; i < 10; i++) {
            addCheckBox();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        for (int i = 0; i < container.getChildCount(); i++) {
            addMenuItem(menu);
        }

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        int size = menu.size();

        for (int i = 0; i < container.getChildCount() - size; i++) {
            addMenuItem(menu);
        }

        for (int i = 0; i < menu.size(); i++) {
            CheckBox checkBox = (CheckBox) container.getChildAt(i);
            menu.getItem(i).setVisible(checkBox.isChecked());
        }

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        invalidateOptionsMenu();
    }

    public void addClicked(View view) {
        addCheckBox();
        invalidateOptionsMenu();
    }

    private void addMenuItem(Menu menu) {
        menu.add(getString(R.string.menu_template, menu.size() + 1));
    }

    private void addCheckBox() {
        int count = container.getChildCount();

        CheckBox checkBox = new CheckBox(this);
        checkBox.setText(getString(R.string.check_template, count + 1));
        checkBox.setChecked(true);
        checkBox.setOnCheckedChangeListener(this);
        container.addView(checkBox);
    }
}
