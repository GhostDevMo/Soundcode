package com.soundcode.chat.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class LayoutFeedRowBinding extends ViewDataBinding {
  protected LayoutFeedRowBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount) {
    super(_bindingComponent, _root, _localFieldCount);
  }

  @NonNull
  public static LayoutFeedRowBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static LayoutFeedRowBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<LayoutFeedRowBinding>inflate(inflater, com.soundcode.chat.R.layout.layout_feed_row, root, attachToRoot, component);
  }

  @NonNull
  public static LayoutFeedRowBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static LayoutFeedRowBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<LayoutFeedRowBinding>inflate(inflater, com.soundcode.chat.R.layout.layout_feed_row, null, false, component);
  }

  public static LayoutFeedRowBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static LayoutFeedRowBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (LayoutFeedRowBinding)bind(component, view, com.soundcode.chat.R.layout.layout_feed_row);
  }
}
