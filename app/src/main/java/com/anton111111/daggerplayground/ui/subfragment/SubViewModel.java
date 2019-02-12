package com.anton111111.daggerplayground.ui.subfragment;

import android.util.Log;

import com.anton111111.daggerplayground.common.DummyDependence;

import javax.inject.Inject;
import javax.inject.Named;

import androidx.lifecycle.ViewModel;

public class SubViewModel extends ViewModel {

    private static final String TAG = "SubViewModel";

    @Inject
    public SubViewModel(@Named("SubFragmentDummyDependence") DummyDependence dummyDependence) {
        Log.e(TAG, "!!!Create: " + dummyDependence.value);
    }

}
