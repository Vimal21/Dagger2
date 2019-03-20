package com.vimal.dagger2.di.module;

import android.app.Activity;
import android.content.Context;

import com.vimal.dagger2.di.ActivityContext;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private Activity activity;

    public ActivityModule(Activity activity){
        this.activity = activity;
    }

    @ActivityContext
    @Provides
    Context provideContext(){
        return activity;
    }

    @Provides
    Activity provideActivity(){
        return activity;
    }
}
