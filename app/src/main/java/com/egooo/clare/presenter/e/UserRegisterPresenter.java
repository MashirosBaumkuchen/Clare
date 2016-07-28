package com.egooo.clare.presenter.e;

import android.widget.LinearLayout;
import com.egooo.clare.contract.UserRegisterContract;
import com.egooo.clare.model.e.RegisterModel;

/**
 * Created by Cherie_No.47 on 2016/7/8 00:47.
 * Email jascal@163.com
 */
public class UserRegisterPresenter implements UserRegisterContract.Presenter, RegisterModel.OnRegisterResult {
    private UserRegisterContract.View view;
    private LinearLayout rootView;

    public UserRegisterPresenter(UserRegisterContract.View view, LinearLayout register_layout) {
        this.view = view;
        this.rootView = register_layout;
        view.setPresenter(this);
    }

    @Override
    public void register(String userName, String userPassword) {
        RegisterModel.initRegisterModel(this).register(userName, userPassword);
    }

    @Override
    public void onSuccess() {
        view.onRegisterSuccess();
    }

    @Override
    public void onFail() {view.onRegisterFail(); }
}
