package com.example.proyekpam;

import java.util.List;

public class DriverOutput {
    private String error;
    private List<Driver> driver;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Driver> getDriver() {
        return driver;
    }

    public void setDriver(List<Driver> driver) {
        this.driver = driver;
    }
}