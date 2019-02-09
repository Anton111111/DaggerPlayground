package com.anton111111.daggerplayground.ui.home;

import android.util.Log;

import com.anton111111.daggerplayground.common.DummyDependence;

import javax.inject.Provider;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class HomeViewModel extends ViewModel {

    private static final String TAG = "HomeViewModel";


    public HomeViewModel(DummyDependence dummyDependence) {
        Log.e(TAG, "!!!Create: " + dummyDependence.value);
    }


    public static class Factory implements ViewModelProvider.Factory {

        private final Provider<HomeViewModel> provider;

        public Factory(Provider<HomeViewModel> provider) {
            Log.e(TAG, "!!!Create factory");
            this.provider = provider;
        }

        @SuppressWarnings("unchecked")
        @Override
        public HomeViewModel create(@NonNull Class modelClass) {
            return provider.get();
        }
    }
}
