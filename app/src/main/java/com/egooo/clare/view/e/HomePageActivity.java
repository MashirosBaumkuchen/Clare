package com.egooo.clare.view.e;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.egooo.clare.R;
import com.egooo.clare.cons.Constant;
import com.facebook.drawee.backends.pipeline.Fresco;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Cherie_No.47 on 2016/7/7 11:18.
 * Email jascal@163.com
 */
public class HomePageActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;
    private  FragmentTransaction fragmentTransaction;

    public static Intent getInstance(Context context) {
        Intent intent = new Intent(context, HomePageActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(getApplicationContext());
        setContentView(R.layout.activity_home_page);
        ButterKnife.bind(this);
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.fragment_slide_left_enter, R.anim.fragment_slide_left_exit);
        fragmentTransaction.replace(R.id.home_page_content,new MurmurFragment(), Constant.TAG_MURMUR);
        fragmentTransaction.commit();
    }

}
