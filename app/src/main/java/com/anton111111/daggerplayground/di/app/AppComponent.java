package com.anton111111.daggerplayground.di.app;

import android.app.Application;

import com.anton111111.daggerplayground.App;
import com.anton111111.daggerplayground.di.appactivity.AppActivityBindModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(
        modules = {
                AndroidInjectionModule.class,
                AppActivityBindModule.class,
                AppModule.class
        }
)
public interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(App app);
}
