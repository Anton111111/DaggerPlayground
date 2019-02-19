package com.anton111111.daggerplayground.ui.subfragment;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anton111111.daggerplayground.common.DummyDependence;
import com.anton111111.daggerplayground.common.LogLifecycleObserver;
import com.anton111111.daggerplayground.databinding.SubFragmentBinding;

public class SubFragment extends Fragment  {

    public static final String TAG = "SubFragment";
    public static final String ARG_DUMMY_DEPENDENCE = "dummy_dep";

    ViewModelProvider.Factory viewModelFactory;

    private SubFragmentBinding mBinding;
    private SubViewModel mViewModel;

    public static SubFragment newInstance(DummyDependence dummyDependence) {
        SubFragment fragment = new SubFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_DUMMY_DEPENDENCE, dummyDependence);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        getLifecycle().addObserver(new LogLifecycleObserver(TAG));
        mBinding = SubFragmentBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this, viewModelFactory).get(SubViewModel.class);
    }


}
