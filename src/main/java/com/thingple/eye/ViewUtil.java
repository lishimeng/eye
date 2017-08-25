package com.thingple.eye;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 *
 * Created by lism on 2017/8/18.
 */
public class ViewUtil {

    public static void openViewForResponse(Activity context, String packageName, String className, Bundle bundle) {

        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        ComponentName cn = new ComponentName(packageName, className);
        intent.setComponent(cn);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        context.startActivityForResult(intent, 0);
    }

    public static void openViewForResponse(BaseActivity context, String packageName, String className, Bundle bundle, ActionResultListener listener) {

        Intent intent = new Intent();
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        ComponentName cn = new ComponentName(packageName, className);
        intent.setComponent(cn);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        context.startActivityForResult(intent, 0, listener);
    }

    public static void openView(Context context, String packageName, String className, Bundle bundle) {

        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        ComponentName cn = new ComponentName(packageName, className);
        intent.setComponent(cn);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        context.getApplicationContext().startActivity(intent);
    }
}
