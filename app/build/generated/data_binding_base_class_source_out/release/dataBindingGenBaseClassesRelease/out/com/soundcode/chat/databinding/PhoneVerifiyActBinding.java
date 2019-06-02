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
import android.widget.EditText;
import android.widget.TextView;
import com.soundcode.chat.activities.authentication.VerifyModel;

public abstract class PhoneVerifiyActBinding extends ViewDataBinding {
  @NonNull
  public final EditText editText1;

  @NonNull
  public final EditText editText2;

  @NonNull
  public final EditText editText3;

  @NonNull
  public final EditText editText4;

  @NonNull
  public final EditText editText5;

  @NonNull
  public final EditText editText6;

  @NonNull
  public final TextView text;

  @NonNull
  public final TextView text2;

  @Bindable
  protected VerifyModel mModel;

  protected PhoneVerifiyActBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, EditText editText1, EditText editText2, EditText editText3,
      EditText editText4, EditText editText5, EditText editText6, TextView text, TextView text2) {
    super(_bindingComponent, _root, _localFieldCount);
    this.editText1 = editText1;
    this.editText2 = editText2;
    this.editText3 = editText3;
    this.editText4 = editText4;
    this.editText5 = editText5;
    this.editText6 = editText6;
    this.text = text;
    this.text2 = text2;
  }

  public abstract void setModel(@Nullable VerifyModel model);

  @Nullable
  public VerifyModel getModel() {
    return mModel;
  }

  @NonNull
  public static PhoneVerifiyActBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static PhoneVerifiyActBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<PhoneVerifiyActBinding>inflate(inflater, com.soundcode.chat.R.layout.phone_verifiy_act, root, attachToRoot, component);
  }

  @NonNull
  public static PhoneVerifiyActBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static PhoneVerifiyActBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<PhoneVerifiyActBinding>inflate(inflater, com.soundcode.chat.R.layout.phone_verifiy_act, null, false, component);
  }

  public static PhoneVerifiyActBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static PhoneVerifiyActBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (PhoneVerifiyActBinding)bind(component, view, com.soundcode.chat.R.layout.phone_verifiy_act);
  }
}
