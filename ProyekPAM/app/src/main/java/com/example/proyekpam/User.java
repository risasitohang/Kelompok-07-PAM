package com.example.proyekpam;
import com.google.gson.annotations.SerializedName;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey
    @NonNull
    @SerializedName("id_consumer")
    private String id_consumer;
    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;
    @SerializedName("alamat")
    private String alamat;
    @SerializedName("email")
    private String email;

    @NonNull
    public String getId_consumer() {
        return id_consumer;
    }

    public void setId_consumer(@NonNull String id_consumer) {
        this.id_consumer = id_consumer;
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

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(@NonNull String id_consumer, String username) {
        this.id_consumer = id_consumer;
        this.username = username;
    }
}
