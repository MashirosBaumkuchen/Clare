package com.egooo.clare.contract;

import android.net.Uri;

import com.egooo.clare.presenter.IBasePresenter;
import com.egooo.clare.view.IBaseView;

/**
 * Created by Cherie_No.47 on 2016/7/10 08:07.
 * Email jascal@163.com
 */
public class EditMurmurContract {
    public interface View extends IBaseView<Presenter> {
        void onUpLoadFail();
        void onUpLoadSuccess();
    }

    public interface Presenter extends IBasePresenter {
        void upLoad(Uri imageFile,String content);
    }
}
