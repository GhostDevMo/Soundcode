package com.soundcode.chat.utils;

import android.content.Context;

import com.sinch.android.rtc.Sinch;
import com.sinch.android.rtc.SinchClient;

public class SinchConfig {
    //TODO fill Sinch Config here with yours
    private static final String APP_KEY = "a0beafc2-c82c-45bf-a67a-673dbcf15e16";
    private static final String APP_SECRET = "XQhwUSm5J0WNUWrCoBjeOQ==";
    private static final String DEBUG_ENVIRONMENT = "sandbox.sinch.com";
    private static final String RELEASE_ENVIRONMENT = "clientapi.sinch.com";

    public static SinchClient getSinchClient(Context context) {
        return Sinch.getSinchClientBuilder()
                .context(context.getApplicationContext())
                .userId(FireManager.getUid())
                .applicationKey(APP_KEY)
                .applicationSecret(APP_SECRET)
                .environmentHost(RELEASE_ENVIRONMENT)
                .build();
    }
}
