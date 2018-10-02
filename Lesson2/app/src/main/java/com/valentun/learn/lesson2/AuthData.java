package com.valentun.learn.lesson2;

public class AuthData {
    private String name;
    private String email;
    private String password;

    private boolean isNotificationsEnabled;

    private int gender;

    public String getName() {
        return name;
    }

    public AuthData setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public AuthData setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public AuthData setPassword(String password) {
        this.password = password;
        return this;
    }

    public boolean isNotificationsEnabled() {
        return isNotificationsEnabled;
    }

    public AuthData setNotificationsEnabled(boolean notificationsEnabled) {
        isNotificationsEnabled = notificationsEnabled;
        return this;
    }

    public int getGender() {
        return gender;
    }

    public AuthData setGender(int gender) {
        this.gender = gender;
        return this;
    }
}
