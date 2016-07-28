package com.egooo.clare.presenter.e;

import android.content.Context;
import android.net.Uri;
import android.support.design.widget.CoordinatorLayout;
import com.egooo.clare.contract.EditMurmurContract;
import com.egooo.clare.model.e.UpLoadMurmurModel;
import com.egooo.clare.model.e.UploadPicModel;

/**
 * Created by Cherie_No.47 on 2016/7/10 08:11.
 * Email jascal@163.com
 */
public class EditMurmurPresenter implements EditMurmurContract.Presenter ,UploadPicModel.OnUpLoadPicResult,UpLoadMurmurModel.OnUpLoadMurResult{
    private EditMurmurContract.View view;
    private Context context;
    private String content;

    public EditMurmurPresenter(Context context,EditMurmurContract.View view) {
        this.context = context;
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void upLoad(Uri imageFile,String content) {
        this.content = content;
        if(null==imageFile){
            UpLoadMurmurModel.initUpLoadMurmurModel(this).upLoad(content);
            return;
        }
        UploadPicModel.initUploadPicModel(context,this).upLoad(imageFile);
    }

    @Override
    public void onSuccessForPic(String fileUrl) {
        UpLoadMurmurModel.initUpLoadMurmurModel(this).upLoad(content,fileUrl);
    }

    @Override
    public void onFailForPic(String errorCode) {
        view.onUpLoadFail();
    }

    @Override
    public void onSuccessForMur() {
        view.onUpLoadSuccess();
    }

    @Override
    public void onFailForMur(String errorCode) {
        view.onUpLoadFail();
    }
}
