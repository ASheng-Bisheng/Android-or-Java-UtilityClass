package cn.whzwl.xbs.utilityclass.app;

import android.app.Application;
import android.content.Context;

import cn.whzwl.xbs.utilityclass.utils.ToastUtils;

/**
 * Created by Administrator on 2018/3/17.
 */

public class AppApplication extends Application {




    @Override
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override
    public void onCreate()
    {
        super.onCreate();

        //初始化Toast
        ToastUtils.init(this);

    }


}
