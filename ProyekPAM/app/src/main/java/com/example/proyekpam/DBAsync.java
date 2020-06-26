package com.example.proyekpam;

import android.os.AsyncTask;

public class DBAsync extends AsyncTask<Void, Void, Void> {

    UserDao mDao;
    String[] mahasiswas = {"ITDel"};

    public DBAsync(RoomDB db) {
        mDao = db.userDao();
    }

    @Override
    protected Void doInBackground(final Void... params) {
        mDao.deleteAll();
        for (int i = 0; i <= mahasiswas.length-1; i++) {
            User user = new User(String.valueOf(i),mahasiswas[i]);
            mDao.insert(user);
        }
        return null;
    }
}
