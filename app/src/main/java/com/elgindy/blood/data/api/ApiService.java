package com.elgindy.blood.data.api;

import com.elgindy.blood.data.model.auth.Auth;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

    @POST("login")
    @FormUrlEncoded
    Call<Auth> onLogin(@Field("phone") String phone,
                       @Field("password")String password);

}
