package com.anton111111.daggerplayground.viewmodel;

import android.util.Log;

import java.util.Map;
import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ViewModelFactory implements ViewModelProvider.Factory {


    private static String TAG = "ViewModelFactory";

    private final Map<Class<? extends ViewModel>, Provider<ViewModel>> viewModels;
    private final UUID uuid;

    @Inject
    public ViewModelFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> viewModels) {
        uuid = UUID.randomUUID();
        TAG = "ViewModelFactory (" + uuid + ")";
        Log.e(TAG, "!!!Constructor:" + viewModels);
        this.viewModels = viewModels;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        Log.e(TAG, "!!!Create model: " + modelClass.getCanonicalName());
        Provider<? extends ViewModel> viewModel = viewModels.get(modelClass);
        if (viewModel == null) {
            for (Map.Entry<Class<? extends ViewModel>, Provider<ViewModel>> entry : viewModels.entrySet()) {
                if (modelClass.isAssignableFrom(entry.getKey())) {
                    viewModel = entry.getValue();
                    break;
                }
            }
        }
        if (viewModel == null) {
            throw new IllegalArgumentException("unknown model class " + modelClass);
        }
        try {
            return (T) viewModel.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
