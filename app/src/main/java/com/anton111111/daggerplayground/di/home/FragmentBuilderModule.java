package com.anton111111.daggerplayground.di.home;


import com.anton111111.daggerplayground.di.subfragment.SubFragmentModule;
import com.anton111111.daggerplayground.ui.subfragment.SubFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuilderModule {

    @ContributesAndroidInjector(modules = {SubFragmentModule.class})
    abstract SubFragment contributeHomeFragment();

}
