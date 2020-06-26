package com.example.proyekpam;

import android.content.Context;

import com.example.proyekpam.DBAsync;
import com.example.proyekpam.User;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {User.class,DataDiriEntu.class}, version = 1, exportSchema = false)
public abstract class RoomDB extends RoomDatabase {

    public abstract UserDao userDao();
    public abstract DataDiriDao dataDiriDao();

    private static volatile RoomDB INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static RoomDB getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (Room.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),RoomDB.class, "Absensi")
                            .fallbackToDestructiveMigration()
                            .addCallback(RoomDBCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static Callback RoomDBCallback = new Callback(){
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db){
            super.onOpen(db);
            new DBAsync(INSTANCE).execute();
        }
    };

}
