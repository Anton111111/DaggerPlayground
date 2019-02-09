package com.anton111111.daggerplayground.ui.subfragment;

import android.util.Log;

import com.anton111111.daggerplayground.common.DummyDependence;

import javax.inject.Provider;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class SubViewModel extends ViewModel {

    private static final String TAG = "SubViewModel";

    public SubViewModel(DummyDependence dummyDependence) {
        Log.e(TAG, "!!!Create: " + dummyDependence.value);
    }


    public static class Factory implements ViewModelProvider.Factory {

        private final Provider<SubViewModel> provider;

        public Factory(Provider<SubViewModel> provider) {
            Log.e(TAG, "!!!Create factory");
            this.provider = provider;
        }

        @SuppressWarnings("unchecked")
        @Override
        public SubViewModel create(@NonNull Class modelClass) {
            return provider.get();
        }
    }
}
