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
import com.egooo.clare.contract.UserRegisterContract;
import com.egooo.clare.presenter.e.UserRegisterPresenter;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Cherie_No.47 on 2016/7/8 00:33.
 * Email jascal@163.com
 */
public class UserRegisterFragment extends Fragment implements UserRegisterContract.View {
    private OnTurnListener onTurnListener;
    private UserRegisterContract.Presenter presenter;
    @Bind(R.id.register_layout)
    LinearLayout register_layout;
    @Bind(R.id.input_account_register)
    EditText account;
    @Bind(R.id.input_password_register)
    EditText password;
    @Bind(R.id.register_progressbar)
    ProgressBar progressBar;

    @OnClick(R.id.act_register)
    void register() {
        progressBar.setVisibility(View.VISIBLE);
        new UserRegisterPresenter(this, register_layout);
        presenter.register(account.getText().toString(), password.getText().toString());
    }

    @OnClick(R.id.act_back)
    void toLogin() {
        onTurnListener.turnToLogin();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void setPresenter(UserRegisterContract.Presenter presenter) {
        this.presenter = presenter;
    }

    public void setOnTurnListener(OnTurnListener onTurnListener) {
        this.onTurnListener = onTurnListener;
    }

    @Override
    public void onRegisterSuccess() {
        progressBar.setVisibility(View.INVISIBLE);
        onTurnListener.turnToBFromR();
    }

    @Override
    public void onRegisterFail() {
        progressBar.setVisibility(View.INVISIBLE);
        Snackbar.make(register_layout, "failed", Snackbar.LENGTH_SHORT).show();
    }

    public interface OnTurnListener {
        void turnToLogin();
        void turnToBFromR();
    }
}
