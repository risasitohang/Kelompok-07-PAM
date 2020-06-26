package com.example.proyekpam;

import com.example.proyekpam.User;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface MahasiswaDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertMahasiswa(User user);

    @Query("SELECT * FROM User")
    LiveData<List<User>> getAllMahasiswa();

    @Query("DELETE FROM User")
    void deleteAll();
}
