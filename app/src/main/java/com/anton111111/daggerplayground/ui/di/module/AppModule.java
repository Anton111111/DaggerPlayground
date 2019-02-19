package com.anton111111.daggerplayground.ui.di.module;

import android.app.Application;
import android.content.Context;

import toothpick.config.Module;

/**
 * Created by Anton Potekhin (Anton.Potekhin@gmail.com) on 19.02.19.
 */
public class AppModule extends Module {

    public AppModule(Application app) {
        bind(Context.class).toInstance(app.getApplicationContext());
    }
}
