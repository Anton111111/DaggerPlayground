package com.anton111111.daggerplayground.ui.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.anton111111.daggerplayground.R;
import com.anton111111.daggerplayground.databinding.AppActivityBinding;
import com.anton111111.daggerplayground.ui.home.HomeFragment;
import com.anton111111.daggerplayground.ui.second.SecondFragment;

import javax.inject.Inject;

public class AppActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    private static final String TAG = "AppActivity";
    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private SharedViewModel mSharedViewModel;
    private AppActivityBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSharedViewModel = ViewModelProviders.of(this, viewModelFactory).get(SharedViewModel.class);
        mBinding = DataBindingUtil.setContentView(this, R.layout.app_activity);
        mBinding.setAppActivity(this);

        if (savedInstanceState == null) {
            openFragment(HomeFragment.class);
        }
    }

    private void openFragment(Class<? extends Fragment> fClass) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        String tag = fClass.getName();
        Fragment fragment = fragmentManager.findFragmentByTag(tag);
        if (fragment == null) {
            if (fClass.isAssignableFrom(HomeFragment.class)) {
                fragment = HomeFragment.newInstance();
            }
            if (fClass.isAssignableFrom(SecondFragment.class)) {
                fragment = SecondFragment.newInstance();
            }
            if (fragment == null) {
                throw new IllegalArgumentException("Fragment " + fClass.getCanonicalName() + " is not supported");
            }
        }
        if (!fragment.isVisible()) {
            fragmentManager.beginTransaction()
                    .replace(mBinding.container.getId(), fragment, tag)
                    .commit();
        }
    }

    public void openHomeFragment() {
        openFragment(HomeFragment.class);
    }

    public void openSecondFragment() {
        openFragment(SecondFragment.class);
    }

    @Override
    public DispatchingAndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }

}
