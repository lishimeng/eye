package com.thingple.library.view;

import android.content.Intent;

/**
 * activity result回调
 * Created by lism on 2017/8/18.
 */

public interface ActionResultListener {

    void onResponse(int requestCode, int resultCode, Intent data);
}
