package com.soundcode.chat.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.applandeo.viewmodels.PickerDialogViewModel;

public abstract class PickerDialogBinding extends ViewDataBinding {
  @NonNull
  public final AppCompatButton cancelButton;

  @NonNull
  public final RecyclerView fileList;

  @NonNull
  public final AppCompatButton selectButton;

  @NonNull
  public final Toolbar toolbar;

  @Bindable
  protected PickerDialogViewModel mViewModel;

  protected PickerDialogBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, AppCompatButton cancelButton, RecyclerView fileList,
      AppCompatButton selectButton, Toolbar toolbar) {
    super(_bindingComponent, _root, _localFieldCount);
    this.cancelButton = cancelButton;
    this.fileList = fileList;
    this.selectButton = selectButton;
    this.toolbar = toolbar;
  }

  public abstract void setViewModel(@Nullable PickerDialogViewModel viewModel);

  @Nullable
  public PickerDialogViewModel getViewModel() {
    return mViewModel;
  }

  @NonNull
  public static PickerDialogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static PickerDialogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<PickerDialogBinding>inflate(inflater, com.soundcode.chat.R.layout.picker_dialog, root, attachToRoot, component);
  }

  @NonNull
  public static PickerDialogBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static PickerDialogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<PickerDialogBinding>inflate(inflater, com.soundcode.chat.R.layout.picker_dialog, null, false, component);
  }

  public static PickerDialogBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static PickerDialogBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (PickerDialogBinding)bind(component, view, com.soundcode.chat.R.layout.picker_dialog);
  }
}
