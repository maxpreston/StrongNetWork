package com.example.max_code.strongnetwork.Base;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;

import rx.Subscription;

/**
 * Created by max-code on 2016/9/4.
 */
public class BaseFragment extends Fragment {
    protected Activity mactivity;
    protected Subscription sb;
    protected void unsubscribe() {
        if (sb != null && !sb.isUnsubscribed()) {
            sb.unsubscribe();
        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if(sb!=null){
            sb.unsubscribe();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mactivity = (Activity) context;
    }
}
