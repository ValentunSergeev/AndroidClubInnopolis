package com.valentun.learn.lesson2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "MainActivity.Name";
    public static final String EXTRA_EMAIL = "MainActivity.Email";
    public static final String EXTRA_NOTIFICATIONS = "MainActivity.Notifications";
    public static final String EXTRA_GENDER = "MainActivity.GENDER";

    private TextView nameView;
    private TextView emailView;
    private TextView notificationsView;
    private TextView genderView;

    private Button changeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AuthManager authManager = AuthManager.getInstance(this);

        if (!authManager.isAuthenticated()) {
            launchLogin();
            finish();
            return;
        }

        setContentView(R.layout.activity_main);

        nameView = findViewById(R.id.main_name);
        emailView = findViewById(R.id.main_email);
        genderView = findViewById(R.id.main_gender);
        notificationsView = findViewById(R.id.main_notifications);

        changeButton = findViewById(R.id.main_change);

        AuthData data = authManager.getAuthData();

        String name = data.getName();
        String email = data.getEmail();
        int gender = data.getGender();
        boolean notifications = data.isNotificationsEnabled();

        String[] genders = getResources().getStringArray(R.array.genders);
        String genderString = genders[gender];

        int notificationsRes = notifications ? R.string.notifications_enabled : R.string.notifications_disabled;


        nameView.setText(getString(R.string.name_format, name));
        emailView.setText(getString(R.string.email_format, email));
        notificationsView.setText(notificationsRes);
        genderView.setText(getString(R.string.gender_format, genderString));

        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchLogin();
                finish();
            }
        });
    }

    private void launchLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
