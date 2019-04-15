package com.example.registrationapp.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.registrationapp.R;
import com.example.registrationapp.model.RegistrationResponse;
import com.example.registrationapp.model.User;
import com.example.registrationapp.rest.ApiService;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.etUserName)
    EditText etUserName;
    @BindView(R.id.etPassword)
    EditText etPassword;
    @BindView(R.id.etConfirmPassword)
    EditText etConfirmPassword;
    @BindView(R.id.btnSubmit)
    Button btnSubmit;

    String userName, userPassword, token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnSubmit)
    public void onViewClicked() {

        if(!TextUtils.isEmpty(etUserName.getText())
                && (!TextUtils.isEmpty(etPassword.getText()))
                &&(!TextUtils.isEmpty(etConfirmPassword.getText()))) {
            userName = etUserName.getText().toString();

            if(etPassword.getText().toString().equals(etConfirmPassword.getText().toString())) {
                userPassword = etPassword.getText().toString();

                User user = new User();
                user.setUserName(userName);
                user.setUserPassword(userPassword);

                ApiService.getInstance().registerUser(user).enqueue(new Callback<RegistrationResponse>() {
                    @Override
                    public void onResponse(Call<RegistrationResponse> call, Response<RegistrationResponse> response) {
                        token = response.body().getToken();
                        Toast.makeText(MainActivity.this, "Token : " + token, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<RegistrationResponse> call, Throwable t) {

                    }
                });

            } else {
                Toast.makeText(this, "Password and confirm password should be same", Toast.LENGTH_SHORT).show();
            }

        }

    }
}
