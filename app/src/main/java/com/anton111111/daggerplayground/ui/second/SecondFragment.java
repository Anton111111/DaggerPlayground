package com.anton111111.daggerplayground.ui.second;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anton111111.daggerplayground.common.LogLifecycleObserver;
import com.anton111111.daggerplayground.databinding.SecondFragmentBinding;
import com.anton111111.daggerplayground.di.Injectable;

import javax.inject.Inject;
import javax.inject.Named;

public class SecondFragment extends Fragment implements Injectable {

    public static final String TAG = "SecondFragment";

    @Inject
    ViewModelProvider.Factory viewModelFactory;
    private SecondViewModel mViewModel;
    private SecondFragmentBinding mBinding;

    public static SecondFragment newInstance() {
        return new SecondFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        getLifecycle().addObserver(new LogLifecycleObserver(TAG));
        mBinding = SecondFragmentBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this, viewModelFactory).get(SecondViewModel.class);
    }

}
