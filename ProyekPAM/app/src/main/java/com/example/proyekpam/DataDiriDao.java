package com.example.proyekpam;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface DataDiriDao {
    @Insert()
    long insert(DataDiriEntu data);
    @Query("Select * From daftarDiri")
    List<DataDiriEntu> ambilData();
}
