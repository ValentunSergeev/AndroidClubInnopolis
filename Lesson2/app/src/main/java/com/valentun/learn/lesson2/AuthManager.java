package com.valentun.learn.lesson2;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class AuthManager {
    private static final String NAME_KEY = "Lesson2.Name";
    private static final String EMAIL_KEY = "Lesson2.Email";
    private static final String PASSWORD_KEY = "Lesson2.Password";
    private static final String GENDER_KEY = "Lesson2.Gender";
    private static final String NOTIFICATIONS_KEY = "Lesson2.Notifications";

    private SharedPreferences preferences;

    private static AuthManager manager;

    private AuthManager(Context context) {
        this.preferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static AuthManager getInstance(Context context) {
        if (manager == null) {
            manager = new AuthManager(context.getApplicationContext());
        }

        return manager;
    }

    public void clearAuthData() {
        preferences.edit()
                    .clear()
                .apply();
    }

    public void saveAuthData(AuthData authData) {
        preferences.edit()
                .putString(NAME_KEY, authData.getName())
                .putString(EMAIL_KEY, authData.getEmail())
                .putString(PASSWORD_KEY, authData.getPassword())
                .putBoolean(NOTIFICATIONS_KEY, authData.isNotificationsEnabled())
                .putInt(GENDER_KEY, authData.getGender())
                .apply();
    }

    public AuthData getAuthData() {
        if (!isAuthenticated())
            return null;

        return new AuthData()
                .setEmail(preferences.getString(EMAIL_KEY, null))
                .setName(preferences.getString(NAME_KEY, null))
                .setPassword(preferences.getString(PASSWORD_KEY, null))
                .setNotificationsEnabled(preferences.getBoolean(NOTIFICATIONS_KEY, false))
                .setGender(preferences.getInt(GENDER_KEY, 0));
    }

    public boolean isAuthenticated() {
        return preferences.contains(NAME_KEY);
    }
}
