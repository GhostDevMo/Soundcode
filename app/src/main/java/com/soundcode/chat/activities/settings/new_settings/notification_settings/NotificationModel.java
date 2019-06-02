package com.soundcode.chat.activities.settings.new_settings.notification_settings;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.soundcode.chat.BR;

/**
 * Created by Muhammad Noamany on 01,February,2019
 */
public class NotificationModel extends BaseObservable {
    private Boolean isNotificationEnabled, isvibrateEnabled;

    @Bindable
    public Boolean getIsvibrateEnabled() {
        return isvibrateEnabled;
    }

    public void setIsvibrateEnabled(Boolean isvibrateEnabled) {
        this.isvibrateEnabled = isvibrateEnabled;
        notifyPropertyChanged(BR.isvibrateEnabled);
    }

    @Bindable
    public Boolean getNotificationEnabled() {
        return isNotificationEnabled;
    }

    public void setNotificationEnabled(Boolean notificationEnabled) {
        isNotificationEnabled = notificationEnabled;
        notifyPropertyChanged(BR.notificationEnabled);
    }
}
