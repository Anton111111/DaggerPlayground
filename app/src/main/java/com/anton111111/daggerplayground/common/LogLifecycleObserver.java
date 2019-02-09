package com.anton111111.daggerplayground.common;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

import static androidx.lifecycle.Lifecycle.Event.ON_ANY;

public class LogLifecycleObserver implements LifecycleObserver {
    private final String tag;

    public LogLifecycleObserver(String tag) {
        this.tag = tag;
    }

    @OnLifecycleEvent(ON_ANY)
    void onAny(LifecycleOwner source, Lifecycle.Event event) {
        Log.e(tag, "!!!"+event);
    }
}
