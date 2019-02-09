package com.anton111111.daggerplayground.di.subfragment;

import android.os.Bundle;

import com.anton111111.daggerplayground.common.DummyDependence;
import com.anton111111.daggerplayground.ui.subfragment.SubFragment;
import com.anton111111.daggerplayground.ui.subfragment.SubViewModel;

import javax.inject.Named;
import javax.inject.Provider;

import androidx.lifecycle.ViewModelProvider;
import dagger.Module;
import dagger.Provides;

@Module
public class SubFragmentModule {

    @Provides
    SubViewModel provideHomeViewModel(@Named("SubFragment") DummyDependence dummyDependence) {
        return new SubViewModel(dummyDependence);
    }

    @Provides
    @Named("SubFragment")
    ViewModelProvider.Factory provideViewModelFactory(Provider<SubViewModel> provider) {
        return new SubViewModel.Factory(provider);
    }

    @Provides
    @Named("SubFragment")
    DummyDependence provideDummyDependence(SubFragment fragment) {
        Bundle arguments = fragment.getArguments();
        if (arguments != null) {
            return (DummyDependence) arguments.get(SubFragment.ARG_DUMMY_DEPENDENCE);
        }
        return null;
    }

}
