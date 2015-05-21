package indival.co.jp.shiftrealmsample.common;

import android.app.Application;


/**
 * Created by Shunsuke Hiratsuka <hiratsukashu@indival.co.jp>
 * Copyright (c) 2015 Indival.inc All Rights Reserved.
 */
public class AppController extends Application
{
    public static final String TAG = AppController.class.getSimpleName();

    private static AppController mInstance;


    public static synchronized AppController getInstance() {
        if(mInstance == null){
            mInstance = new AppController();
        }
        return mInstance;
    }

    public AppController(){
        super();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }



    public static String getStrFromRes(int resId) {
        return mInstance.getString(resId);
    }
}