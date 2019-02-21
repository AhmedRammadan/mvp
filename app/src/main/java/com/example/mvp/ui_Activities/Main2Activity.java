package com.example.mvp.ui_Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvp.R;

public class Main2Activity extends AppCompatActivity {
    EditText et_email,et_password;
    String email,password;
    Button btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        et_email = findViewById(R.id.et_email2);
        et_password = findViewById(R.id.et_password2);
        btn_login = findViewById(R.id.btn_login2);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = et_email.getText().toString();
                password = et_password.getText().toString();
                isSuccess(email,password);
            }
        });
    }
    private void isSuccess(String email,String password){
        if (email.isEmpty()){
            Toast.makeText(this, "email is Empty", Toast.LENGTH_SHORT).show();
        }else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Toast.makeText(this, "email don't matches", Toast.LENGTH_SHORT).show();
        }else if (password.isEmpty()){
            Toast.makeText(this, "password is Empty", Toast.LENGTH_SHORT).show();
        }else if (password.length()<6){
            Toast.makeText(this, "password is too short", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "isSuccess", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this,MainActivity.class));
        finish();
        super.onBackPressed();
    }
}
