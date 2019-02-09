package com.anton111111.daggerplayground.di.appactivity;

import com.anton111111.daggerplayground.ui.app.AppActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class AppActivityBindModule {

    @ContributesAndroidInjector(modules = {FragmentBuildersModule.class})
    abstract AppActivity contributeAppActivity();


}
