package com.india.lhq.loginwithretrofitokhttp.networking;

import com.india.lhq.loginwithretrofitokhttp.networking.model.LoginRequest;
import com.india.lhq.loginwithretrofitokhttp.networking.model.User;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiClient {
   /* @POST("login")
    Call<User> login(@Body LoginRequest loginRequest); */

    @POST("Getlogin")
   // "http://13.126.69.214/lq/api/Login/Getlogin"
    Call<List<User> >login(@Body LoginRequest loginRequest);


}