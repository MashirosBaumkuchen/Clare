package com.egooo.clare.view.e;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.egooo.clare.R;
import com.egooo.clare.utils.ImageUtils;
import com.egooo.clare.cons.Constant;
import com.egooo.clare.contract.EditMurmurContract;
import com.egooo.clare.presenter.e.EditMurmurPresenter;
import com.egooo.clare.widget.ProgressBarDialog;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Cherie_No.47 on 2016/7/9 13:18.
 * Email jascal@163.com
 */
public class EditMurmurActivity extends AppCompatActivity implements EditMurmurContract.View {
    private EditMurmurContract.Presenter presenter;
    private Uri imageFile = null;
    private ProgressBarDialog progressBarDialog;

    @Bind(R.id.layout_edit_murmur)
    CoordinatorLayout layout_edit_murmur;
    @Bind(R.id.edit_murmur_image)
    SimpleDraweeView murmur_image;
    @Bind(R.id.edit_murmur_text)
    AppCompatEditText murmur_content;

    @OnClick(R.id.edit_murmur_image)
    void choicePic() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType(Constant.RESULT_ALBUM_INTENT_TYPE);
        intent.putExtra(Constant.RESULT_ALBUM_INTENT_PARM_0, true);
        intent.putExtra(Constant.RESULT_ALBUM_INTENT_PARM_1, true);
        startActivityForResult(intent, Constant.RESULT_ALBUM);
    }

    @OnClick(R.id.edit_sent)
    void upLoadPic() {
        progressBarDialog = new ProgressBarDialog(this,R.layout.dialog_progressbar,R.style.ProgressBarDialogTheme);
        progressBarDialog.show();
        new EditMurmurPresenter(this, this);
        presenter.upLoad(imageFile, murmur_content.getText().toString());
    }

    @Bind(R.id.edit_murmur_toolbar)
    Toolbar toolbar;

    public static Intent getInstance(Context context) {
        return new Intent(context, EditMurmurActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(getApplicationContext());
        setContentView(R.layout.activity_edit_murmur);
        ButterKnife.bind(this);
        setToolbar();
    }

    private void setToolbar() {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditMurmurActivity.this.finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constant.RESULT_ALBUM && resultCode == RESULT_OK && data != null) {
            imageFile = data.getData();
            ImageUtils.displaySinglePic(murmur_image, imageFile,Constant.IMAGE_SIZE_ON_EDIT_WIDTH,Constant.IMAGE_SIZE_ON_EDIT_HEIGHT);
        }
    }

    @Override
    public void setPresenter(EditMurmurContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onUpLoadFail() {
        progressBarDialog.cancel();
        Snackbar.make(layout_edit_murmur, "发布失败", Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onUpLoadSuccess() {
        progressBarDialog.cancel();
        finish();
    }
}
