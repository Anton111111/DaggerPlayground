package com.anton111111.daggerplayground.ui.home;

import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.HasSupportFragmentInjector;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anton111111.daggerplayground.common.DummyDependence;
import com.anton111111.daggerplayground.common.LogLifecycleObserver;
import com.anton111111.daggerplayground.databinding.HomeFragmentBinding;
import com.anton111111.daggerplayground.ui.subfragment.SubFragment;

import javax.inject.Inject;
import javax.inject.Named;

public class HomeFragment extends Fragment implements HasSupportFragmentInjector {

    public static final String TAG = "HomeFragment";
    public static final String ARG_DUMMY_DEPENDENCE = "dummy_dep";

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    @Inject
    @Named("HomeFragment")
    ViewModelProvider.Factory viewModelFactory;

    private HomeViewModel mViewModel;
    private HomeFragmentBinding mBinding;

    public static HomeFragment newInstance(DummyDependence dummyDependence) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_DUMMY_DEPENDENCE, dummyDependence);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        Bundle arguments = getArguments();
        DummyDependence dummyDependence = null;
        if (arguments != null) {
            dummyDependence = (DummyDependence) arguments.get(ARG_DUMMY_DEPENDENCE);
        }
        getLifecycle().addObserver(
                new LogLifecycleObserver(TAG + " (" +
                        (dummyDependence != null ? dummyDependence.value : "null") + ")"
                )
        );
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
        SubFragment subFragment = SubFragment.newInstance(new DummyDependence());
        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        ft.replace(mBinding.container.getId(), subFragment, SubFragment.TAG);
        ft.commit();
    }

    @Override
    public DispatchingAndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }

}
