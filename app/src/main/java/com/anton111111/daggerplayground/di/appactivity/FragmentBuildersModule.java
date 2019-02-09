package com.anton111111.daggerplayground.di.appactivity;

import com.anton111111.daggerplayground.di.home.HomeFragmentModule;
import com.anton111111.daggerplayground.ui.home.HomeFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector(modules = {HomeFragmentModule.class})
    abstract HomeFragment contributeHomeFragment();
}