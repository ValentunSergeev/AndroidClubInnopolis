package com.valentun.learn.lesson2;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
    public static final int MIN_NAME_LENGTH = 4;
    public static final int MIN_PASSWORD_LENGTH = 7;

    private static final String EMPTY_STRING = "";

    private Pattern emailPattern = Patterns.EMAIL_ADDRESS;

    private TextInputLayout emailContainer;
    private TextInputLayout nameContainer;
    private TextInputLayout passwordContainer;

    private EditText email;
    private EditText name;
    private EditText password;

    private TextView alias;

    private CheckBox notifications;
    private RadioGroup gender;

    private Button submit;

    private String error;

    private View container;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        error = getString(R.string.error);

        email = findViewById(R.id.email);
        name = findViewById(R.id.name);
        password = findViewById(R.id.password);

        emailContainer = findViewById(R.id.email_container);
        passwordContainer = findViewById(R.id.password_container);
        nameContainer = findViewById(R.id.name_container);

        alias = findViewById(R.id.alias_view);

        notifications = findViewById(R.id.login_notifications);
        gender = findViewById(R.id.login_gender);

        submit = findViewById(R.id.login_submit);

        container = findViewById(R.id.login_container);

        name.addTextChangedListener(new SimpleTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (isNameValid(s.toString())) {
                    nameContainer.setError(EMPTY_STRING);
                } else {
                    nameContainer.setError(error);
                }

                alias.setText(getString(R.string.alias, s));
            }
        });

        email.addTextChangedListener(new SimpleTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (isEmailValid(s.toString())) {
                    emailContainer.setError(EMPTY_STRING);
                } else {
                    emailContainer.setError(error);
                }
            }
        });

        password.addTextChangedListener(new SimpleTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (isPasswordValid(s.toString())) {
                    passwordContainer.setError(EMPTY_STRING);
                } else {
                    passwordContainer.setError(error);
                }
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isDataValid()) {
                    openMain();
                    finish();
                } else {
                    showError();
                }
            }
        });
    }

    private void openMain() {
        String nameData = name.getText().toString();
        String emailData = email.getText().toString();
        String passwordData = password.getText().toString();

        boolean notificationsEnabled = notifications.isChecked();
        int genderId = gender.getCheckedRadioButtonId();
        View genderView = findViewById(genderId);
        int genderData = gender.indexOfChild(genderView);

        AuthData data = new AuthData()
                .setNotificationsEnabled(notificationsEnabled)
                .setGender(genderData)
                .setPassword(passwordData)
                .setName(nameData)
                .setEmail(emailData);

        AuthManager authManager = AuthManager.getInstance(this);
        authManager.saveAuthData(data);

        startActivity(new Intent(this, MainActivity.class));
    }

    private void showError() {
        Snackbar.make(container, R.string.login_error, Snackbar.LENGTH_LONG)
                .show();
    }

    private boolean isDataValid() {
        return isNameValid(name.getText().toString())
                && isEmailValid(email.getText().toString())
                && isPasswordValid(password.getText().toString());
    }

    private boolean isNameValid(String name) {
        return name.length() > MIN_NAME_LENGTH;
    }

    private boolean isEmailValid(String email) {
        return emailPattern.matcher(email).matches();
    }

    private boolean isPasswordValid(String password) {
        return password.length() > MIN_PASSWORD_LENGTH;
    }

    private abstract class SimpleTextWatcher implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }
}
