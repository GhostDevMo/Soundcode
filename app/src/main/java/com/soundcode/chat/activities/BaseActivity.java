package com.soundcode.chat.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.soundcode.chat.utils.MyApp;
import com.soundcode.chat.utils.PresenceUtil;

public abstract class BaseActivity extends AppCompatActivity {

    private PresenceUtil presenceUtil;

    abstract boolean enablePresence();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (enablePresence())
            presenceUtil = new PresenceUtil();


    }

    @Override
    protected void onResume() {
        super.onResume();
        if (enablePresence()) {
            presenceUtil.onResume();
            MyApp.baseActivityResumed();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (enablePresence()) {
            presenceUtil.onPause();
            MyApp.baseActivityPaused();
        }
    }




}
