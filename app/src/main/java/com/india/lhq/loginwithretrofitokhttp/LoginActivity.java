package com.india.lhq.loginwithretrofitokhttp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.india.lhq.loginwithretrofitokhttp.networking.model.LoginRequest;
import com.india.lhq.loginwithretrofitokhttp.networking.model.User;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends BaseActivity {

    @BindView(R.id.input_email)
    EditText inputEmail;

    @BindView(R.id.input_password)
    EditText inputPassword;

    @BindView(R.id.loader)
    AVLoadingIndicatorView loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        makeFullScreen();
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        changeStatusBarColor(ContextCompat.getColor(this, R.color.colorAccent));
        hideToolbar();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @OnClick(R.id.btn_login)
    void onLoginClick() {
        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), getString(R.string.msg_enter_credentials), Toast.LENGTH_LONG).show();
            return;
        }

        loader.setVisibility(View.VISIBLE);
        LoginRequest request = new LoginRequest();
        request.LoginId = email;
        request.password = password;
        request.imeno = "358240051111110";
        getApi().login(request).enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                loader.setVisibility(View.INVISIBLE);
                if (!response.isSuccessful()) {
                    handleError(response.errorBody());
                    return;
                }



                for(int i = 0;i<response.body().size();i++){
                    Log.v("status", response.body().get(i).Status );
                }
                Toast.makeText(getApplicationContext(),response.body().get(0).Status +"deepak", Toast.LENGTH_LONG).show();
              //  launchSplash(LoginActivity.this);
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                loader.setVisibility(View.INVISIBLE);
                handleError(t);
            }
        } );
         /*   @Override
            public void onResponse(Call <List<User>> call, Response <List<User>> response) {
                loader.setVisibility(View.INVISIBLE);
                if (!response.isSuccessful()) {
                    handleError(response.errorBody());
                    return;
                }

                launchSplash(LoginActivity.this);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                loader.setVisibility(View.INVISIBLE);
                handleError(t);
            }
        });*/

    }


    @OnClick(R.id.btn_create_account)
    void onCreateAccountClick() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
