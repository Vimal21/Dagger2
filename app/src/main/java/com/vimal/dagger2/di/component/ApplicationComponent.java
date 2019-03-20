package com.vimal.dagger2.di.component;

import android.app.Application;
import android.content.Context;

import com.vimal.dagger2.AppController;
import com.vimal.dagger2.data.DataManager;
import com.vimal.dagger2.data.DbHelper;
import com.vimal.dagger2.data.SharedPrefsHelper;
import com.vimal.dagger2.di.ApplicationContext;
import com.vimal.dagger2.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Provides;

@Singleton
@Component( modules = ApplicationModule.class)
public interface ApplicationComponent {

        void Inject(AppController appController);

        @ApplicationContext
        Context getContext();

        Application getApplication();

        DataManager getDataManager();

        SharedPrefsHelper getSharedPrefsHelper();

        DbHelper getDbHelper();
}
