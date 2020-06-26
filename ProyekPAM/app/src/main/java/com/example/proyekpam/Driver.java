package com.example.proyekpam;
import com.google.gson.annotations.SerializedName;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Driver {
    @PrimaryKey
    @NonNull
    @SerializedName("id_driver")
    private String id_driver;
    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;
    @SerializedName("email")
    private String email;

    @NonNull
    public String getId_driver() {
        return id_driver;
    }

    public void setId_driver(@NonNull String id_driver) {
        this.id_driver = id_driver;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}