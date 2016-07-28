package com.egooo.clare.contract;

import com.egooo.clare.presenter.IBasePresenter;
import com.egooo.clare.view.IBaseView;

/**
 * Created by Cherie_No.47 on 2016/7/8 00:45.
 * Email jascal@163.com
 */
public class UserRegisterContract {
    public interface View extends IBaseView<Presenter> {
        void onRegisterSuccess();
        void onRegisterFail();
    }

    public interface Presenter extends IBasePresenter {
        void register(String userName,String userPassword);
    }
}
