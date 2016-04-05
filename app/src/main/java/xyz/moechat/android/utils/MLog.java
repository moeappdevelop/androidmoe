package com.fengwo.reading.utils;

import android.util.Log;

/**
 * Created by timeloveboy on 16/3/10.
 */
public class MLog{
    public static boolean showLog=true;

    public static void v(String tag,String content){
        if(showLog) {
            Log.v(tag, content);
        }
    }
}
