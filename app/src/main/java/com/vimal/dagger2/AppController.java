package com.vimal.dagger2;

import android.app.Application;
import android.content.Context;

import com.vimal.dagger2.data.DataManager;
import com.vimal.dagger2.di.component.ApplicationComponent;
import com.vimal.dagger2.di.component.DaggerApplicationComponent;
import com.vimal.dagger2.di.module.ApplicationModule;

import javax.inject.Inject;

public class AppController extends Application {
    protected ApplicationComponent applicationComponent;

    @Inject
    DataManager dataManager;

    public static AppController get(Context context){
        return (AppController) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent
                                    .builder()
                                    .applicationModule(new ApplicationModule(this))
                                    .build();
        applicationComponent.Inject(this);
    }

    public ApplicationComponent getApplicationComponent(){
        return applicationComponent;
    }
}
