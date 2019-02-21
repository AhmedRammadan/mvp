package com.example.mvp.ui_Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvp.R;
import com.example.mvp.presenter.LoginPresenter;
import com.example.mvp.view.LoginViewInterface;

public class MainActivity extends AppCompatActivity implements LoginViewInterface {
    EditText et_email,et_password;
    String email,password;
    Button btn_login;
    LoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
        btn_login = findViewById(R.id.btn_login);
        loginPresenter = new LoginPresenter(this);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = et_email.getText().toString();
                password = et_password.getText().toString();
                loginPresenter.onLogin(email,password);
            }
        });
    }

    @Override
    public void onLoginSuccess(String massage) {
        Toast.makeText(this, massage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginError(String massage) {
        Toast.makeText(this, massage, Toast.LENGTH_SHORT).show();
    }

    public void anther_Activity(View view) {
        startActivity(new Intent(this,Main2Activity.class));
    }
}
