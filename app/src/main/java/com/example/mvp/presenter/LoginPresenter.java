package com.example.mvp.presenter;

import com.example.mvp.model.User;
import com.example.mvp.view.LoginViewInterface;

public class LoginPresenter implements LoginPresenterInterface {
    LoginViewInterface loginViewInterface;

    public LoginPresenter(LoginViewInterface loginViewInterface) {
        this.loginViewInterface = loginViewInterface;
    }

    @Override
    public void onLogin(String email, String password) {
        User user = new User(email, password);
        int isSuccess = user.isValidateDate();
        switch (isSuccess) {
            case -1:
                loginViewInterface.onLoginSuccess("isSuccess");
                break;
            case 0:
                loginViewInterface.onLoginError("email is Empty");
                break;
            case 1:
                loginViewInterface.onLoginError("email don't matches");
                break;
            case 2:
                loginViewInterface.onLoginError("password is too short");
                break;
        }
    }
}
