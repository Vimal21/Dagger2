package com.vimal.dagger2.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.vimal.dagger2.data.SharedPrefsHelper;
import com.vimal.dagger2.di.ApplicationContext;
import com.vimal.dagger2.di.DatabaseInfo;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application){
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context providesContext(){
        return mApplication;
    }

    @Provides
    Application providesApplication(){
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName(){
        return "demo-dagger.db";
    }

    @Provides
    @DatabaseInfo
    Integer provideDatabaseVersion(){
        return 2;
    }

    @Provides
    SharedPreferences provideSharedPreferences(){
        return mApplication.getSharedPreferences("demo-prefs", Context.MODE_PRIVATE);
    }
}
