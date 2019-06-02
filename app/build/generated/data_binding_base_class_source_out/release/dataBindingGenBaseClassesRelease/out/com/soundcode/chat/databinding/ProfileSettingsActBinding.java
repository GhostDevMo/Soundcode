package com.soundcode.chat.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import de.hdodenhof.circleimageview.CircleImageView;

public abstract class ProfileSettingsActBinding extends ViewDataBinding {
  @NonNull
  public final LayoutAppBarBinding appBar;

  @NonNull
  public final ImageButton imageButtonChangeUserProfile;

  @NonNull
  public final ImageButton imageButtonEditUsername;

  @NonNull
  public final CircleImageView imageViewUserProfile;

  @NonNull
  public final TextView tvPhoneNumber;

  @NonNull
  public final TextView tvStatus;

  @NonNull
  public final TextView tvUsername;

  protected ProfileSettingsActBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, LayoutAppBarBinding appBar, ImageButton imageButtonChangeUserProfile,
      ImageButton imageButtonEditUsername, CircleImageView imageViewUserProfile,
      TextView tvPhoneNumber, TextView tvStatus, TextView tvUsername) {
    super(_bindingComponent, _root, _localFieldCount);
    this.appBar = appBar;
    setContainedBinding(this.appBar);;
    this.imageButtonChangeUserProfile = imageButtonChangeUserProfile;
    this.imageButtonEditUsername = imageButtonEditUsername;
    this.imageViewUserProfile = imageViewUserProfile;
    this.tvPhoneNumber = tvPhoneNumber;
    this.tvStatus = tvStatus;
    this.tvUsername = tvUsername;
  }

  @NonNull
  public static ProfileSettingsActBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ProfileSettingsActBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ProfileSettingsActBinding>inflate(inflater, com.soundcode.chat.R.layout.profile_settings_act, root, attachToRoot, component);
  }

  @NonNull
  public static ProfileSettingsActBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ProfileSettingsActBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ProfileSettingsActBinding>inflate(inflater, com.soundcode.chat.R.layout.profile_settings_act, null, false, component);
  }

  public static ProfileSettingsActBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ProfileSettingsActBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ProfileSettingsActBinding)bind(component, view, com.soundcode.chat.R.layout.profile_settings_act);
  }
}
