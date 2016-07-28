package com.egooo.clare.contract;

import com.egooo.clare.bean.Murmur;
import com.egooo.clare.presenter.IBasePresenter;
import com.egooo.clare.view.IBaseView;

import java.util.List;

/**
 * Created by Cherie_No.47 on 2016/7/11 14:10.
 * Email jascal@163.com
 */
public class MurmurContract {
    public interface View extends IBaseView<Presenter> {
        void onGetMurmurSuccess(List<Murmur> list);
        void onGetMurmurFail();
    }

    public interface Presenter extends IBasePresenter {
        void getMurmurData();
    }
}
