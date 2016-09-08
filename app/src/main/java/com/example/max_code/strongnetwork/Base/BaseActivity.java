package com.example.max_code.strongnetwork.Base;

import android.app.Activity;

import rx.Subscription;

/**
 * Created by max-code on 2016/9/4.
 */
public class BaseActivity extends Activity {
    protected Subscription subscription;
    protected void UnSubscript(){
        if(subscription!=null&&!subscription.isUnsubscribed()){
            subscription.unsubscribe();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        subscription.unsubscribe();
    }
}
