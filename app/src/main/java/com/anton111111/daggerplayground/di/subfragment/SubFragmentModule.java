package com.anton111111.daggerplayground.di.subfragment;

import android.os.Bundle;

import com.anton111111.daggerplayground.common.DummyDependence;
import com.anton111111.daggerplayground.di.app.ViewModelKey;
import com.anton111111.daggerplayground.ui.subfragment.SubFragment;
import com.anton111111.daggerplayground.ui.subfragment.SubViewModel;
import com.anton111111.daggerplayground.viewmodel.ViewModelFactory;

import javax.inject.Named;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;

@Module(includes = {SubFragmentModule.SubFragmentBindModule.class})
public class SubFragmentModule {

    @Provides
    @Named("SubFragmentDummyDependence")
    DummyDependence provideDummyDependence(SubFragment subFragment) {
        Bundle arguments = subFragment.getArguments();
        if (arguments != null) {
            return (DummyDependence) arguments.get(SubFragment.ARG_DUMMY_DEPENDENCE);
        }
        return null;
    }

    @Module
    public abstract class SubFragmentBindModule {
        @Binds
        @Named("SubFragmentViewModelFactory")
        abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);

        @Binds
        @IntoMap
        @ViewModelKey(SubViewModel.class)
        abstract ViewModel bindHomeViewModel(SubViewModel viewModel);
    }

}
