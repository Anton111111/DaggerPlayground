package com.anton111111.daggerplayground.di.appactivity;

import com.anton111111.daggerplayground.di.home.HomeFragmentModule;
import com.anton111111.daggerplayground.di.second.SecondFragmentModule;
import com.anton111111.daggerplayground.ui.home.HomeFragment;
import com.anton111111.daggerplayground.ui.second.SecondFragment;
import com.anton111111.daggerplayground.ui.subfragment.SubFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector(modules = {HomeFragmentModule.class})
    abstract HomeFragment contributeHomeFragment();

    @ContributesAndroidInjector(modules = {SecondFragmentModule.class})
    abstract SecondFragment contributeSecondFragment();

    @ContributesAndroidInjector
    abstract SubFragment contributeSubFragment();
}