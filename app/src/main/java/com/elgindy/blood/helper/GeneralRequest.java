package com.elgindy.blood.helper;

import android.app.Activity;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.elgindy.blood.data.model.auth.Auth;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.elgindy.blood.data.local.SharedPreferencesManger.REMEMBER_ME;
import static com.elgindy.blood.data.local.SharedPreferencesManger.USER_DATA;
import static com.elgindy.blood.data.local.SharedPreferencesManger.USER_PASSWORD;
import static com.elgindy.blood.data.local.SharedPreferencesManger.saveData;
import static com.elgindy.blood.helper.Constant.EDIT_PROFILE;
import static com.elgindy.blood.helper.Constant.LOGIN;

public class GeneralRequest {


    public static void onAuth(Call<Auth> call, String password, boolean rememberMe, Activity activity
            , String actionType, String apiToken) {
        call.enqueue(new Callback<Auth>() {
            @Override
            public void onResponse(Call<Auth> call, Response<Auth> response) {
                try {
                    if (response.body().getStatus() == 1) {

                        if (actionType.equals(EDIT_PROFILE)) {
                            response.body().getData().setApiToken(apiToken);
                        }

                        saveData( activity, USER_DATA, response.body().getData());
                        saveData( activity, REMEMBER_ME, rememberMe);
                        saveData( activity, USER_PASSWORD, password);

                        if (actionType.equals(LOGIN)) {

                        }

                    }

                    Toast.makeText(activity, response.body().getMsg(), Toast.LENGTH_SHORT).show();

                } catch (Exception e) {

                }
            }

            @Override
            public void onFailure(Call<Auth> call, Throwable t) {

            }
        });
    }
}
