package com.anton111111.daggerplayground.ui.home;

import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anton111111.daggerplayground.common.LogLifecycleObserver;
import com.anton111111.daggerplayground.databinding.HomeFragmentBinding;
import com.anton111111.daggerplayground.di.Injectable;
import com.anton111111.daggerplayground.ui.subfragment.SubFragment;

import javax.inject.Inject;
import javax.inject.Named;

public class HomeFragment extends Fragment implements Injectable, HasSupportFragmentInjector {

    public static final String TAG = "HomeFragment";

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private HomeViewModel mViewModel;
    private HomeFragmentBinding mBinding;

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        getLifecycle().addObserver(new LogLifecycleObserver(TAG));
        mBinding = HomeFragmentBinding.inflate(inflater, container, false);
        mBinding.setMFragment(this);
        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel.class);
    }

    public void openSubFragment() {
        SubFragment subFragment = SubFragment.newInstance();
        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        ft.replace(mBinding.container.getId(), subFragment, SubFragment.TAG);
        ft.commit();
    }

    @Override
    public DispatchingAndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }
}
