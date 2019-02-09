package com.anton111111.daggerplayground.ui.subfragment;

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
import com.anton111111.daggerplayground.databinding.SubFragmentBinding;
import com.anton111111.daggerplayground.di.Injectable;

import javax.inject.Inject;

public class SubFragment extends Fragment implements Injectable {

    public static final String TAG = "SubFragment";
    private SubViewModel mViewModel;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private SubFragmentBinding mBinding;

    public static SubFragment newInstance() {
        return new SubFragment();
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
