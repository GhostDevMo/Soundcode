package com.soundcode.chat.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public abstract class SignInActBinding extends ViewDataBinding {
  @NonNull
  public final EditText phoneNumberEditText;

  @NonNull
  public final LayoutSpinnerBinding spinner;

  @NonNull
  public final TextView text;

  @NonNull
  public final TextView text2;

  protected SignInActBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, EditText phoneNumberEditText, LayoutSpinnerBinding spinner,
      TextView text, TextView text2) {
    super(_bindingComponent, _root, _localFieldCount);
    this.phoneNumberEditText = phoneNumberEditText;
    this.spinner = spinner;
    setContainedBinding(this.spinner);;
    this.text = text;
    this.text2 = text2;
  }

  @NonNull
  public static SignInActBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static SignInActBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<SignInActBinding>inflate(inflater, com.soundcode.chat.R.layout.sign_in_act, root, attachToRoot, component);
  }

  @NonNull
  public static SignInActBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static SignInActBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<SignInActBinding>inflate(inflater, com.soundcode.chat.R.layout.sign_in_act, null, false, component);
  }

  public static SignInActBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static SignInActBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (SignInActBinding)bind(component, view, com.soundcode.chat.R.layout.sign_in_act);
  }
}
