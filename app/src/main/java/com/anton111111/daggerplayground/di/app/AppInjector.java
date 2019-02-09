package com.anton111111.daggerplayground.di.app;


import com.anton111111.daggerplayground.App;

public class AppInjector {

    private static final String TAG = "AppInjector";

    public static void init(App app) {
        DaggerAppComponent.builder()
                .application(app)
                .build()
                .inject(app);

    }

}