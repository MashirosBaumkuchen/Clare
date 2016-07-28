package com.egooo.clare.model.e;

import com.egooo.clare.bean.User;
import com.egooo.clare.model.IBaseModel;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Cherie_No.47 on 2016/7/8 00:49.
 * Email jascal@163.com
 */
public class RegisterModel implements IBaseModel {
    private OnRegisterResult onRegisterResult;

    public static RegisterModel initRegisterModel(OnRegisterResult onRegisterResult){
        RegisterModel registerModel = new RegisterModel();
        registerModel.onRegisterResult = onRegisterResult;
        return registerModel;
    }

    public boolean register(String userName,String userPassword) {
        User user = new User();
        user.setUsername(userName);
        user.setPassword(userPassword);
        user.signUp(new SaveListener<User>() {
            @Override
            public void done(User user, BmobException e) {
                if(user!=null){
                    onRegisterResult.onSuccess();
                }else{
                    onRegisterResult.onFail();
                }
            }
        });
        return false;
    }

    public interface OnRegisterResult{
        void onSuccess();
        void onFail();
    }
}
