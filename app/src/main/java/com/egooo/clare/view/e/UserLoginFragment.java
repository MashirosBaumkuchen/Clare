package com.egooo.clare.view.e;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.egooo.clare.R;
import com.egooo.clare.contract.UserLoginContract;
import com.egooo.clare.presenter.e.UserLoginPresenter;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Cherie_No.47 on 2016/7/7 23:42.
 * Email jascal@163.com
 */
public class UserLoginFragment extends Fragment implements UserLoginContract.View{
    private UserLoginContract.Presenter presenter;
    private OnTurnListener onTurnListener;
    @Bind(R.id.login_layout)
    LinearLayout login_layout;
    @Bind(R.id.input_account)
    EditText account;
    @Bind(R.id.input_password)
    EditText password;
    @Bind(R.id.login_progressbar)
    ProgressBar progressBar;

    @OnClick(R.id.act_login)
    void login(){
        progressBar.setVisibility(View.VISIBLE);
        new UserLoginPresenter(this);
        presenter.login(account.getText().toString(),password.getText().toString());
    }

    @OnClick(R.id.act_register)
    void toRegister(){
        onTurnListener.turnToRegister();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)    {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onLoginSuccess() {
        progressBar.setVisibility(View.INVISIBLE);
        onTurnListener.turnToB();
    }

    @Override
    public void onLoginFail() {
        progressBar.setVisibility(View.INVISIBLE);
        Snackbar.make(login_layout, "failed", Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(UserLoginContract.Presenter presenter) {
        this.presenter = presenter;
    }

    public void setOnTurnListener(OnTurnListener onTurnListener) {
        this.onTurnListener = onTurnListener;
    }

    public interface OnTurnListener{
        void turnToRegister();
        void turnToB();
    }
}
