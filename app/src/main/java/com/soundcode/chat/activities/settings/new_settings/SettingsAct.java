package com.soundcode.chat.activities.settings.new_settings;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.soundcode.chat.R;
import com.soundcode.chat.activities.settings.new_settings.notification_settings.NotificationSettingsAct;
import com.soundcode.chat.activities.settings.new_settings.profile_settings.ProfileSettingsAct;
import com.soundcode.chat.base.BaseAct;
import com.soundcode.chat.databinding.SettingsActBinding;
import com.soundcode.chat.utils.SharedPreferencesManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.io.File;

public class SettingsAct extends BaseAct {
    private SettingsActBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.settings_act);
        setUpToolbar(binding.appBar.toolbar, R.drawable.ic_arrow_back, getString(R.string.settings_toolbar_title));
        final String myPhoto = SharedPreferencesManager.getMyPhoto();
        String userName = SharedPreferencesManager.getUserName();
        String status = SharedPreferencesManager.getStatus();
        Glide.with(this).load(Uri.fromFile(new File(myPhoto)))
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .into(binding.profileImage);
        binding.name.setText(userName);
        binding.status.setText(status);


    }


    public void openProfileSettings(View view) {
        startActivity(new Intent(this, ProfileSettingsAct.class));
    }

    public void openNotificationAct(View view) {
        startActivity(new Intent(this, NotificationSettingsAct.class));
    }
}
