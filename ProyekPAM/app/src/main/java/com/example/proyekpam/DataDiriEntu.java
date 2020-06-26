package com.example.proyekpam;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "daftarDiri")
public class DataDiriEntu{
    @PrimaryKey(autoGenerate = true)
    int id;
    @ColumnInfo(name = "email")
    public  String email;
    @ColumnInfo(name = "nama")
    public  String nama;

    public DataDiriEntu() {
    }

    public DataDiriEntu(int id, String email, String nama) {
        this.id = id;
        this.email = email;
        this.nama = nama;
    }

    public DataDiriEntu(String email, String nama) {
        this.email = email;
        this.nama = nama;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
