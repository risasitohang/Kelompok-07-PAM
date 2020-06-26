package com.example.proyekpam;

import com.example.proyekpam.User;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(User user);

    @Query("SELECT * FROM user")
    LiveData<List<User>> getAllMahasiswa();

    @Query("DELETE FROM user")
    void deleteAll();

    @Query("SELECT * from user ORDER BY username ASC")
    LiveData<List<com.example.proyekpam.User>> getAlphabetizedWords();
}
