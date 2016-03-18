package com.sudocode.processor.utils;

import android.annotation.TargetApi;
import android.os.Build;
import android.util.Size;

import java.util.Comparator;

/**
 * Created by ace on 2/20/16.
 */
public class SizeCompareUtil implements Comparator<Size> {


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public int compare(Size lhs, Size rhs) {
        return Long.signum((long) lhs.getWidth() * lhs.getHeight() - (long) rhs.getWidth() * rhs.getHeight());
    }


}
