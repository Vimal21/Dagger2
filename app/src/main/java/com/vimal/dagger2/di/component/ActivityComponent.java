package com.vimal.dagger2.di.component;

import com.vimal.dagger2.MainActivity;
import com.vimal.dagger2.di.PerActivity;
import com.vimal.dagger2.di.module.ActivityModule;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void Inject(MainActivity mainActivity);
}
