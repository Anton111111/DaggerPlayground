package com.anton111111.daggerplayground.di.home;

import android.os.Bundle;

import com.anton111111.daggerplayground.common.DummyDependence;
import com.anton111111.daggerplayground.ui.home.HomeFragment;
import com.anton111111.daggerplayground.ui.home.HomeViewModel;

import javax.inject.Named;
import javax.inject.Provider;

import androidx.lifecycle.ViewModelProvider;
import dagger.Module;
import dagger.Provides;

@Module(includes = {FragmentBuilderModule.class})
public class HomeFragmentModule {

//
//    @Provides
//    HomeViewModel provideHomeViewModel(@Named("HomeFragment") DummyDependence dummyDependence) {
//        return new HomeViewModel(dummyDependence);
//    }

//    @Provides
//    @Named("HomeFragment")
//    ViewModelProvider.Factory provideViewModelFactory(Provider<HomeViewModel> provider) {
//        return new HomeViewModel.Factory(provider);
//    }

    @Provides
    @Named("HomeFragment")
    DummyDependence provideDummyDependence(HomeFragment homeFragment) {
        Bundle arguments = homeFragment.getArguments();
        if (arguments != null) {
            return (DummyDependence) arguments.get(HomeFragment.ARG_DUMMY_DEPENDENCE);
        }
        return null;
    }
}
