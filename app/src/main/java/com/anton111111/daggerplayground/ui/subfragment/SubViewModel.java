package com.anton111111.daggerplayground.ui.subfragment;

import android.util.Log;

import com.anton111111.daggerplayground.common.DummyDependence;

import androidx.lifecycle.ViewModel;

public class SubViewModel extends ViewModel {

    private static final String TAG = "SubViewModel";

    public SubViewModel(DummyDependence dummyDependence) {
        Log.e(TAG, "!!!Create: " + dummyDependence.value);
    }

}
