package com.example.proyekpam;

import java.util.List;

public class UserOutput {
    private String error;
    private List<User> user;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }
}
