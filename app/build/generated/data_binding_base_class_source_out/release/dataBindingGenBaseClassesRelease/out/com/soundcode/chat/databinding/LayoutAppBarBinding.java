package com.soundcode.chat.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class LayoutAppBarBinding extends ViewDataBinding {
  @NonNull
  public final Toolbar toolbar;

  protected LayoutAppBarBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Toolbar toolbar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.toolbar = toolbar;
  }

  @NonNull
  public static LayoutAppBarBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static LayoutAppBarBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<LayoutAppBarBinding>inflate(inflater, com.soundcode.chat.R.layout.layout_app_bar, root, attachToRoot, component);
  }

  @NonNull
  public static LayoutAppBarBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static LayoutAppBarBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<LayoutAppBarBinding>inflate(inflater, com.soundcode.chat.R.layout.layout_app_bar, null, false, component);
  }

  public static LayoutAppBarBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static LayoutAppBarBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (LayoutAppBarBinding)bind(component, view, com.soundcode.chat.R.layout.layout_app_bar);
  }
}
