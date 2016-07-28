package com.egooo.clare.model.e;

import com.egooo.clare.bean.User;
import com.egooo.clare.model.IBaseModel;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Cherie_No.47 on 2016/7/7 10:17.
 * Email jascal@163.com
 */
public class LoginModel implements IBaseModel{
    private OnLoginResult onLoginResult;

    public static LoginModel initLoginModel(OnLoginResult onLoginResult){
        LoginModel loginModel = new LoginModel();
        loginModel.onLoginResult = onLoginResult;
        return loginModel;
    }

    public boolean Login(String userName,String userPassword){
        User user = new User();
        user.setUsername(userName);
        user.setPassword(userPassword);
        user.login(new SaveListener<User>() {
            @Override
            public void done(User user, BmobException e) {
                if(user!=null){
                    onLoginResult.onSuccess();
                }else{
                    onLoginResult.onFail();
                }
            }
        });
        return false;
    }

    public interface OnLoginResult{
        void onSuccess();
        void onFail();
    }
}
