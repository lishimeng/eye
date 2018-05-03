package com.thingple.library.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

/**
 *
 * Created by lism on 2017/8/18.
 */

public class BaseActivity extends AppCompatActivity {

    private ActionResultListener actionResultListener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Window window = getWindow();
        //隐藏标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //隐藏状态栏
        //定义全屏参数
        int flag= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        //设置当前窗体为全屏显示
        window.setFlags(flag, flag);
    }

    public void startActivityForResult(Intent intent, int requestCode, ActionResultListener listener) {
        this.actionResultListener = listener;
        super.startActivityForResult(intent, requestCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(getClass().getName() + "#onActivityResult", "requestCode:" + requestCode + "\tresultCode:" + resultCode + "\tdata:" + data);
        if (actionResultListener != null) {
            actionResultListener.onResponse(requestCode, resultCode, data);
        }
    }
}
