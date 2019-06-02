package com.soundcode.chat.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.soundcode.chat.activities.settings.new_settings.notification_settings.NotificationModel;
import com.suke.widget.SwitchButton;

public abstract class NotificationSettingsActBinding extends ViewDataBinding {
  @NonNull
  public final LayoutAppBarBinding appBar;

  @NonNull
  public final SwitchButton notificationSwitchButton;

  @NonNull
  public final SwitchButton vibrateSwitchButton;

  @Bindable
  protected NotificationModel mModel;

  protected NotificationSettingsActBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, LayoutAppBarBinding appBar, SwitchButton notificationSwitchButton,
      SwitchButton vibrateSwitchButton) {
    super(_bindingComponent, _root, _localFieldCount);
    this.appBar = appBar;
    setContainedBinding(this.appBar);;
    this.notificationSwitchButton = notificationSwitchButton;
    this.vibrateSwitchButton = vibrateSwitchButton;
  }

  public abstract void setModel(@Nullable NotificationModel model);

  @Nullable
  public NotificationModel getModel() {
    return mModel;
  }

  @NonNull
  public static NotificationSettingsActBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static NotificationSettingsActBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<NotificationSettingsActBinding>inflate(inflater, com.soundcode.chat.R.layout.notification_settings_act, root, attachToRoot, component);
  }

  @NonNull
  public static NotificationSettingsActBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static NotificationSettingsActBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<NotificationSettingsActBinding>inflate(inflater, com.soundcode.chat.R.layout.notification_settings_act, null, false, component);
  }

  public static NotificationSettingsActBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static NotificationSettingsActBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (NotificationSettingsActBinding)bind(component, view, com.soundcode.chat.R.layout.notification_settings_act);
  }
}
