package com.egooo.clare.view.e;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.egooo.clare.R;
import com.egooo.clare.cons.Constant;

import butterknife.ButterKnife;
import cn.bmob.v3.Bmob;

/**
 * Created by Cherie_No.47 on 2016/6/14 20:48.
 * Email jascal@163.com
 */
public class UserAccountActivity extends AppCompatActivity implements UserLoginFragment.OnTurnListener, UserRegisterFragment.OnTurnListener {
    private UserLoginFragment userLoginFragment;
    private UserRegisterFragment userRegisterFragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accout);
        Bmob.initialize(this, Constant.APP_KEY);
        ButterKnife.bind(this);

        if (userLoginFragment == null) {
            userLoginFragment = new UserLoginFragment();
            userLoginFragment.setOnTurnListener(this);
        }
        if (userRegisterFragment == null) {
            userRegisterFragment = new UserRegisterFragment();
            userRegisterFragment.setOnTurnListener(this);
        }
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
        fragmentTransaction.add(R.id.login_layout_content, userLoginFragment, Constant.TAG_LOGIN);
        fragmentTransaction.commitAllowingStateLoss();
    }


    @Override
    public void turnToRegister() {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.fragment_slide_right_enter, R.anim.fragment_slide_right_exit);
        fragmentTransaction.replace(R.id.login_layout_content, userRegisterFragment, Constant.TAG_REGISTER);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commitAllowingStateLoss();
    }

    @Override
    public void turnToB() {
        startActivity(HomePageActivity.getInstance(this));
        finish();
    }

    @Override
    public void turnToLogin() {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
        fragmentTransaction.replace(R.id.login_layout_content, userLoginFragment, Constant.TAG_LOGIN);
        fragmentTransaction.commitAllowingStateLoss();
    }

    @Override
    public void turnToBFromR() {
        turnToB();
    }
}
