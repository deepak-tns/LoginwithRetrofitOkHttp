package com.india.lhq.loginwithretrofitokhttp.networking;

import android.text.TextUtils;

import com.india.lhq.loginwithretrofitokhttp.app.Constants;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

public class ApiService {
    private static Retrofit retrofit = null;

        public static Retrofit getClient() {

            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

            if (retrofit == null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(Constants.BASE_URL_LHQ)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(client)
                        .build();

            }

            return retrofit;

        }

    }



