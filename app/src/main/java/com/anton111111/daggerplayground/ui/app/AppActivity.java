package com.anton111111.daggerplayground.ui.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import dagger.android.AndroidInjection;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

import android.os.Bundle;

import com.anton111111.daggerplayground.R;
import com.anton111111.daggerplayground.common.DummyDependence;
import com.anton111111.daggerplayground.common.LogLifecycleObserver;
import com.anton111111.daggerplayground.databinding.AppActivityBinding;
import com.anton111111.daggerplayground.ui.home.HomeFragment;

import javax.inject.Inject;

public class AppActivity extends AppCompatActivity implements HasSupportFragmentInjector {

    private static final String TAG = "AppActivity";

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

//    @Inject
//    ViewModelProvider.Factory viewModelFactory;

    private SharedViewModel mSharedViewModel;
    private AppActivityBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLifecycle().addObserver(new LogLifecycleObserver(TAG));
        AndroidInjection.inject(this);
        //mSharedViewModel = ViewModelProviders.of(this, viewModelFactory).get(SharedViewModel.class);
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
                fragment = HomeFragment.newInstance(new DummyDependence());
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

    @Override
    public DispatchingAndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }

}
