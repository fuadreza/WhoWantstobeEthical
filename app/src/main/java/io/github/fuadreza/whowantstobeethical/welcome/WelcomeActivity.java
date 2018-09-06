package io.github.fuadreza.whowantstobeethical.welcome;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import io.github.fuadreza.whowantstobeethical.R;

/**
 * Dibuat dengan kerjakerasbagaiquda oleh Shifu pada tanggal 16/08/2018.
 */
public class WelcomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // Toolbar title dan back button
        Toolbar toolbar = findViewById(R.id.toolbare);
        toolbar.setTitle("Before we get started");
        setSupportActionBar(toolbar);

        FragmentManager mFragmentManager = getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        IntroFragment mIntroFragment = new IntroFragment();
        mFragmentTransaction.add(R.id.layout_starter, mIntroFragment, IntroFragment.class.getSimpleName());

        mFragmentTransaction.commit();
    }

}
