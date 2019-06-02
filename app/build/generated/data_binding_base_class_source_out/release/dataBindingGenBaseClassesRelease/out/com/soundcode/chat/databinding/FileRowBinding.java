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
import com.applandeo.viewmodels.FileRowViewModel;

public abstract class FileRowBinding extends ViewDataBinding {
  @Bindable
  protected FileRowViewModel mRowViewModel;

  protected FileRowBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount) {
    super(_bindingComponent, _root, _localFieldCount);
  }

  public abstract void setRowViewModel(@Nullable FileRowViewModel rowViewModel);

  @Nullable
  public FileRowViewModel getRowViewModel() {
    return mRowViewModel;
  }

  @NonNull
  public static FileRowBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FileRowBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FileRowBinding>inflate(inflater, com.soundcode.chat.R.layout.file_row, root, attachToRoot, component);
  }

  @NonNull
  public static FileRowBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FileRowBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FileRowBinding>inflate(inflater, com.soundcode.chat.R.layout.file_row, null, false, component);
  }

  public static FileRowBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FileRowBinding bind(@NonNull View view, @Nullable DataBindingComponent component) {
    return (FileRowBinding)bind(component, view, com.soundcode.chat.R.layout.file_row);
  }
}
