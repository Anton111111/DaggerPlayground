package com.anton111111.daggerplayground.di.app;

import android.app.Application;
import android.content.Context;

import com.anton111111.daggerplayground.ui.app.SharedViewModel;
import com.anton111111.daggerplayground.viewmodel.ViewModelFactory;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
abstract class AppModule {

    @Binds
    abstract Context bindContext(Application application);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);

    @Binds
    @IntoMap
    @ViewModelKey(SharedViewModel.class)
    abstract ViewModel bindHomeViewModel(SharedViewModel viewModel);
}
