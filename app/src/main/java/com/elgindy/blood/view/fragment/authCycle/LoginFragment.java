package com.elgindy.blood.view.fragment.authCycle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.elgindy.blood.R;
import com.elgindy.blood.helper.GeneralRequest;
import com.elgindy.blood.helper.HelperMethod;
import com.elgindy.blood.view.fragment.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.elgindy.blood.data.api.RetrofitManger.getRetrofitClient;
import static com.elgindy.blood.helper.Constant.LOGIN;

public class LoginFragment extends BaseFragment {

    @BindView(R.id.fragment_login_et_phone)
    EditText fragmentLoginEtPhone;
    @BindView(R.id.fragment_login_et_password)
    EditText fragmentLoginEtPassword;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        setUpActivity();
        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick({R.id.fragment_login_btn_login, R.id.fragment_login_cl_sub_view})
    public void onViewClicked(View view) {
        HelperMethod.disappearKeypad(getActivity(), view);
        switch (view.getId()) {
            case R.id.fragment_login_btn_login:

                String phone = fragmentLoginEtPhone.getText().toString();
                String password = fragmentLoginEtPassword.getText().toString();

                if (validation(phone, password)) {
                    onCall(phone, password);
                }
                break;
            case R.id.fragment_login_cl_sub_view:
                break;
        }
    }

    private boolean validation(String phone, String password) {

        boolean valid = true;

        if (phone.length() != 11) {

            valid = false;
        }

        if (password.length() < 3) {

            valid = false;
        }

        return false;
    }

    private void onCall(String phone, String password) {
        GeneralRequest.onAuth(getRetrofitClient().onLogin(phone, password), password, true,getActivity(), LOGIN , "");
    }
}
