package com.anton111111.daggerplayground.ui.home;

import android.util.Log;

import com.anton111111.daggerplayground.common.DummyDependence;


import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private static final String TAG = "HomeViewModel";

    public HomeViewModel(DummyDependence dummyDependence) {
        Log.e(TAG, "!!!Create: " + dummyDependence.value);
    }

}
