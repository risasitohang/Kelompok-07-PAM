package com.example.proyekpam;

import android.app.Application;

import com.example.proyekpam.User;

import java.util.List;

import androidx.lifecycle.LiveData;

public class LocalRepository {
    private UserDao userDao;
    private LiveData<List<com.example.proyekpam.User>> userData;

    LocalRepository(Application application) {
        RoomDB db = RoomDB.getDatabase(application);
        userDao = db.userDao();
        userData = userDao.getAlphabetizedWords();
    }

    LiveData<List<com.example.proyekpam.User>> getAllUsers() {
        return userData;
    }

//    void insert(User user) {
//        RoomDB.databaseWriteExecutor.execute(() -> {
//            userDao.insert(user);
//        });
//    }
}
