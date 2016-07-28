package com.egooo.clare.presenter.e;

import com.egooo.clare.contract.UserLoginContract;
import com.egooo.clare.model.e.LoginModel;

/**
 * Created by Cherie_No.47 on 2016/6/14 20:39.
 * Email jascal@163.com
 */
public class UserLoginPresenter implements UserLoginContract.Presenter, LoginModel.OnLoginResult {
    private UserLoginContract.View view;

    public UserLoginPresenter(UserLoginContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void login(String userName, String userPassword) {
        LoginModel.initLoginModel(this).Login(userName, userPassword);
    }

    @Override
    public void onSuccess() {
        view.onLoginSuccess();
    }

    @Override
    public void onFail() {
        view.onLoginFail();
    }

}
