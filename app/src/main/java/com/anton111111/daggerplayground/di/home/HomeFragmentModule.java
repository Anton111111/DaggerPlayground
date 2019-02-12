package com.anton111111.daggerplayground.di.home;

import android.os.Bundle;

import com.anton111111.daggerplayground.common.DummyDependence;
import com.anton111111.daggerplayground.di.app.ViewModelKey;
import com.anton111111.daggerplayground.ui.home.HomeFragment;
import com.anton111111.daggerplayground.ui.home.HomeViewModel;
import com.anton111111.daggerplayground.viewmodel.ViewModelFactory;

import javax.inject.Named;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;

@Module(includes = {HomeFragmentModule.HomeFragmentBindModule.class, FragmentBuilderModule.class})
public class HomeFragmentModule {

    @Provides
    @Named("HomeFragmentDummyDependence")
    DummyDependence provideDummyDependence(HomeFragment homeFragment) {
        Bundle arguments = homeFragment.getArguments();
        if (arguments != null) {
            return (DummyDependence) arguments.get(HomeFragment.ARG_DUMMY_DEPENDENCE);
        }
        return null;
    }

    @Module
    public abstract class HomeFragmentBindModule {
        @Binds
        @Named("HomeFragmentViewModelFactory")
        abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);

        @Binds
        @IntoMap
        @ViewModelKey(HomeViewModel.class)
        abstract ViewModel bindHomeViewModel(HomeViewModel viewModel);
    }
}
