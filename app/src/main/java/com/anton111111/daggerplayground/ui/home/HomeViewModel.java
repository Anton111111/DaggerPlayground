package com.anton111111.daggerplayground.ui.home;

import android.util.Log;

import com.anton111111.daggerplayground.common.DummyDependence;

import javax.inject.Inject;
import javax.inject.Named;

import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private static final String TAG = "HomeViewModel";

    @Inject
    public HomeViewModel(@Named("HomeFragmentDummyDependence") DummyDependence dummyDependence) {
        Log.e(TAG, "!!!Create: " + dummyDependence.value);
    }

}
