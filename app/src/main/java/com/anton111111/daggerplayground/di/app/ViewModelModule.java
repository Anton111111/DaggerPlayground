package com.anton111111.daggerplayground.di.app;

import com.anton111111.daggerplayground.ui.app.SharedViewModel;
import com.anton111111.daggerplayground.ui.home.HomeViewModel;
import com.anton111111.daggerplayground.ui.second.SecondViewModel;
import com.anton111111.daggerplayground.ui.subfragment.SubViewModel;
import com.anton111111.daggerplayground.viewmodel.ViewModelFactory;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SharedViewModel.class)
    abstract ViewModel bindAppActivitySharedViewModel(SharedViewModel model);

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel.class)
    abstract ViewModel bindHomeViewModel(HomeViewModel model);

    @Binds
    @IntoMap
    @ViewModelKey(SecondViewModel.class)
    abstract ViewModel bindSecondViewModel(SecondViewModel model);

    @Binds
    @IntoMap
    @ViewModelKey(SubViewModel.class)
    abstract ViewModel bindSubViewModel(SubViewModel model);


    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);
}