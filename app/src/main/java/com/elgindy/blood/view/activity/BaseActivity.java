package com.elgindy.blood.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import com.elgindy.blood.view.fragment.BaseFragment;

public class BaseActivity extends AppCompatActivity {

    public BaseFragment baseFragment;

    public void superBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onBackPressed() {
        baseFragment.onBack();
    }
}
