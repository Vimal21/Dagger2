package com.vimal.dagger2.data;

import android.content.Context;
import android.content.res.Resources;

import com.vimal.dagger2.data.DbHelper;
import com.vimal.dagger2.data.SharedPrefsHelper;
import com.vimal.dagger2.data.model.User;
import com.vimal.dagger2.di.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DataManager {
    private Context context;
    private SharedPrefsHelper sharedPrefsHelper;
    private DbHelper dbHelper;

    @Inject
    public DataManager(@ApplicationContext Context context, SharedPrefsHelper sharedPrefsHelper, DbHelper dbHelper) {
        this.context = context;
        this.sharedPrefsHelper = sharedPrefsHelper;
        this.dbHelper = dbHelper;
    }

    public void saveAccessToken(String accessToken){
        sharedPrefsHelper.put(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN, accessToken);
    }

    public String getAccessToken(){
        return sharedPrefsHelper.get(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN, null);
    }

    public Long createUser(User user) throws Exception {
        return dbHelper.insertUser(user);
    }

    public User getUser(Long userId) throws Resources.NotFoundException,NullPointerException {
        return dbHelper.getUser(userId);
    }
}
