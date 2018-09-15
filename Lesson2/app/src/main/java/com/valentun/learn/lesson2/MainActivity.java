package com.valentun.learn.lesson2;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
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

    private String error;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        error = getString(R.string.error);

        email = findViewById(R.id.email);
        name = findViewById(R.id.name);
        password = findViewById(R.id.password);

        emailContainer = findViewById(R.id.email_container);
        passwordContainer = findViewById(R.id.password_container);
        nameContainer = findViewById(R.id.name_container);

        alias = findViewById(R.id.alias_view);

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
    }

    private boolean isNameValid(String name) {
        return TextUtils.isEmpty(name) || name.length() > MIN_NAME_LENGTH;
    }

    private boolean isEmailValid(String email) {
        return TextUtils.isEmpty(email) || emailPattern.matcher(email).matches();
    }

    private boolean isPasswordValid(String password) {
        return TextUtils.isEmpty(password) || password.length() > MIN_PASSWORD_LENGTH;
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
