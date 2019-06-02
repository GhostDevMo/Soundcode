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
import android.widget.ImageView;
import com.soundcode.chat.utils.custom_spinner.SearchableSpinner;

public abstract class LayoutSpinnerBinding extends ViewDataBinding {
  @NonNull
  public final ImageView dropdown;

  @NonNull
  public final SearchableSpinner spinner;

  @Bindable
  protected String mHint;

  @Bindable
  protected String mPositiveBtn;

  protected LayoutSpinnerBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ImageView dropdown, SearchableSpinner spinner) {
    super(_bindingComponent, _root, _localFieldCount);
    this.dropdown = dropdown;
    this.spinner = spinner;
  }

  public abstract void setHint(@Nullable String hint);

  @Nullable
  public String getHint() {
    return mHint;
  }

  public abstract void setPositiveBtn(@Nullable String positiveBtn);

  @Nullable
  public String getPositiveBtn() {
    return mPositiveBtn;
  }

  @NonNull
  public static LayoutSpinnerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static LayoutSpinnerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<LayoutSpinnerBinding>inflate(inflater, com.soundcode.chat.R.layout.layout_spinner, root, attachToRoot, component);
  }

  @NonNull
  public static LayoutSpinnerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static LayoutSpinnerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<LayoutSpinnerBinding>inflate(inflater, com.soundcode.chat.R.layout.layout_spinner, null, false, component);
  }

  public static LayoutSpinnerBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static LayoutSpinnerBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (LayoutSpinnerBinding)bind(component, view, com.soundcode.chat.R.layout.layout_spinner);
  }
}
