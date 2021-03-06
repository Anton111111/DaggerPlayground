package com.anton111111.daggerplayground.ui.app;

import android.util.Log;

import javax.inject.Inject;

import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.CompositeDisposable;

public class SharedViewModel extends ViewModel {

    private static final String TAG = "SharedViewModel";

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Inject
    public SharedViewModel() {
        Log.e(TAG, "!!!Constructor");
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        if (compositeDisposable != null) {
            compositeDisposable.dispose();
        }
    }
}
