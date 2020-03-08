package com.elgindy.blood.view.fragment;


import androidx.fragment.app.Fragment;

import com.elgindy.blood.view.activity.BaseActivity;

public class BaseFragment extends Fragment {

    public BaseActivity baseActivity;

    public void setUpActivity() {
        baseActivity = (BaseActivity) getActivity();

        baseActivity.baseFragment = this;
    }

    public void onBack() {
        baseActivity.superBackPressed();
    }

}
