package com.anton111111.daggerplayground.di.app;

import android.app.Application;
import android.content.Context;

import dagger.Binds;
import dagger.Module;

@Module(includes = {ViewModelModule.class})
abstract class AppModule {

    @Binds
    abstract Context bindContext(Application application);


}
