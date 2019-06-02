package com.soundcode.chat.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import de.hdodenhof.circleimageview.CircleImageView;

public abstract class SettingsActBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout BtnAbout;

  @NonNull
  public final LinearLayout BtnChat;

  @NonNull
  public final LinearLayout BtnNotifications;

  @NonNull
  public final LinearLayout BtnProfile;

  @NonNull
  public final LinearLayout BtnProfileStatus;

  @NonNull
  public final TextView about;

  @NonNull
  public final LayoutAppBarBinding appBar;

  @NonNull
  public final TextView chat;

  @NonNull
  public final TextView name;

  @NonNull
  public final TextView notifications;

  @NonNull
  public final TextView profile;

  @NonNull
  public final CircleImageView profileImage;

  @NonNull
  public final TextView status;

  protected SettingsActBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, LinearLayout BtnAbout, LinearLayout BtnChat,
      LinearLayout BtnNotifications, LinearLayout BtnProfile, LinearLayout BtnProfileStatus,
      TextView about, LayoutAppBarBinding appBar, TextView chat, TextView name,
      TextView notifications, TextView profile, CircleImageView profileImage, TextView status) {
    super(_bindingComponent, _root, _localFieldCount);
    this.BtnAbout = BtnAbout;
    this.BtnChat = BtnChat;
    this.BtnNotifications = BtnNotifications;
    this.BtnProfile = BtnProfile;
    this.BtnProfileStatus = BtnProfileStatus;
    this.about = about;
    this.appBar = appBar;
    setContainedBinding(this.appBar);;
    this.chat = chat;
    this.name = name;
    this.notifications = notifications;
    this.profile = profile;
    this.profileImage = profileImage;
    this.status = status;
  }

  @NonNull
  public static SettingsActBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static SettingsActBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<SettingsActBinding>inflate(inflater, com.soundcode.chat.R.layout.settings_act, root, attachToRoot, component);
  }

  @NonNull
  public static SettingsActBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static SettingsActBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<SettingsActBinding>inflate(inflater, com.soundcode.chat.R.layout.settings_act, null, false, component);
  }

  public static SettingsActBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static SettingsActBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (SettingsActBinding)bind(component, view, com.soundcode.chat.R.layout.settings_act);
  }
}
