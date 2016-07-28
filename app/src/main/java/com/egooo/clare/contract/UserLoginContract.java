package com.egooo.clare.contract;

import com.egooo.clare.presenter.IBasePresenter;
import com.egooo.clare.view.IBaseView;

/**
 * Created by Cherie_No.47 on 2016/6/14 20:31.
 * Email jascal@163.com
 */
public class UserLoginContract {
    public interface View extends IBaseView<Presenter>{
        void onLoginSuccess();
        void onLoginFail();
    }
    public interface Presenter extends IBasePresenter{
        void login(String userName,String userPassword);
    }
}
