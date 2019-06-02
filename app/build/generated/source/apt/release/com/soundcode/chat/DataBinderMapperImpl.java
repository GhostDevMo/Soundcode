package com.soundcode.chat;

import android.databinding.DataBinderMapper;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import com.soundcode.chat.databinding.FileRowBindingImpl;
import com.soundcode.chat.databinding.LayoutAppBarBindingImpl;
import com.soundcode.chat.databinding.LayoutFeedRowBindingImpl;
import com.soundcode.chat.databinding.LayoutSpinnerBindingImpl;
import com.soundcode.chat.databinding.NotificationSettingsActBindingImpl;
import com.soundcode.chat.databinding.PhoneVerifiyActBindingImpl;
import com.soundcode.chat.databinding.PickerDialogBindingImpl;
import com.soundcode.chat.databinding.ProfileSettingsActBindingImpl;
import com.soundcode.chat.databinding.SettingsActBindingImpl;
import com.soundcode.chat.databinding.SignInActBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_FILEROW = 1;

  private static final int LAYOUT_LAYOUTAPPBAR = 2;

  private static final int LAYOUT_LAYOUTFEEDROW = 3;

  private static final int LAYOUT_LAYOUTSPINNER = 4;

  private static final int LAYOUT_NOTIFICATIONSETTINGSACT = 5;

  private static final int LAYOUT_PHONEVERIFIYACT = 6;

  private static final int LAYOUT_PICKERDIALOG = 7;

  private static final int LAYOUT_PROFILESETTINGSACT = 8;

  private static final int LAYOUT_SETTINGSACT = 9;

  private static final int LAYOUT_SIGNINACT = 10;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(10);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.soundcode.chat.R.layout.file_row, LAYOUT_FILEROW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.soundcode.chat.R.layout.layout_app_bar, LAYOUT_LAYOUTAPPBAR);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.soundcode.chat.R.layout.layout_feed_row, LAYOUT_LAYOUTFEEDROW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.soundcode.chat.R.layout.layout_spinner, LAYOUT_LAYOUTSPINNER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.soundcode.chat.R.layout.notification_settings_act, LAYOUT_NOTIFICATIONSETTINGSACT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.soundcode.chat.R.layout.phone_verifiy_act, LAYOUT_PHONEVERIFIYACT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.soundcode.chat.R.layout.picker_dialog, LAYOUT_PICKERDIALOG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.soundcode.chat.R.layout.profile_settings_act, LAYOUT_PROFILESETTINGSACT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.soundcode.chat.R.layout.settings_act, LAYOUT_SETTINGSACT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.soundcode.chat.R.layout.sign_in_act, LAYOUT_SIGNINACT);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_FILEROW: {
          if ("layout/file_row_0".equals(tag)) {
            return new FileRowBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for file_row is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTAPPBAR: {
          if ("layout/layout_app_bar_0".equals(tag)) {
            return new LayoutAppBarBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_app_bar is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTFEEDROW: {
          if ("layout/layout_feed_row_0".equals(tag)) {
            return new LayoutFeedRowBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_feed_row is invalid. Received: " + tag);
        }
        case  LAYOUT_LAYOUTSPINNER: {
          if ("layout/layout_spinner_0".equals(tag)) {
            return new LayoutSpinnerBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for layout_spinner is invalid. Received: " + tag);
        }
        case  LAYOUT_NOTIFICATIONSETTINGSACT: {
          if ("layout/notification_settings_act_0".equals(tag)) {
            return new NotificationSettingsActBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for notification_settings_act is invalid. Received: " + tag);
        }
        case  LAYOUT_PHONEVERIFIYACT: {
          if ("layout/phone_verifiy_act_0".equals(tag)) {
            return new PhoneVerifiyActBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for phone_verifiy_act is invalid. Received: " + tag);
        }
        case  LAYOUT_PICKERDIALOG: {
          if ("layout/picker_dialog_0".equals(tag)) {
            return new PickerDialogBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for picker_dialog is invalid. Received: " + tag);
        }
        case  LAYOUT_PROFILESETTINGSACT: {
          if ("layout/profile_settings_act_0".equals(tag)) {
            return new ProfileSettingsActBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for profile_settings_act is invalid. Received: " + tag);
        }
        case  LAYOUT_SETTINGSACT: {
          if ("layout/settings_act_0".equals(tag)) {
            return new SettingsActBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for settings_act is invalid. Received: " + tag);
        }
        case  LAYOUT_SIGNINACT: {
          if ("layout/sign_in_act_0".equals(tag)) {
            return new SignInActBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for sign_in_act is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(2);
    result.add(new carbon.DataBinderMapperImpl());
    result.add(new com.android.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(26);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "data");
      sKeys.put(2, "rowViewModel");
      sKeys.put(3, "file");
      sKeys.put(4, "adapter");
      sKeys.put(5, "parentDirectory");
      sKeys.put(6, "viewModel");
      sKeys.put(7, "currentFile");
      sKeys.put(8, "position");
      sKeys.put(9, "fileIconResource");
      sKeys.put(10, "fileList");
      sKeys.put(11, "notificationEnabled");
      sKeys.put(12, "positiveBtn");
      sKeys.put(13, "phoneNumber");
      sKeys.put(14, "hint");
      sKeys.put(15, "isvibrateEnabled");
      sKeys.put(16, "myName");
      sKeys.put(17, "model");
      sKeys.put(18, "finishedTyping5");
      sKeys.put(19, "myNumber");
      sKeys.put(20, "finishedTyping6");
      sKeys.put(21, "finishedTyping3");
      sKeys.put(22, "finishedTyping4");
      sKeys.put(23, "finishedTyping1");
      sKeys.put(24, "finishedTyping2");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(10);

    static {
      sKeys.put("layout/file_row_0", com.soundcode.chat.R.layout.file_row);
      sKeys.put("layout/layout_app_bar_0", com.soundcode.chat.R.layout.layout_app_bar);
      sKeys.put("layout/layout_feed_row_0", com.soundcode.chat.R.layout.layout_feed_row);
      sKeys.put("layout/layout_spinner_0", com.soundcode.chat.R.layout.layout_spinner);
      sKeys.put("layout/notification_settings_act_0", com.soundcode.chat.R.layout.notification_settings_act);
      sKeys.put("layout/phone_verifiy_act_0", com.soundcode.chat.R.layout.phone_verifiy_act);
      sKeys.put("layout/picker_dialog_0", com.soundcode.chat.R.layout.picker_dialog);
      sKeys.put("layout/profile_settings_act_0", com.soundcode.chat.R.layout.profile_settings_act);
      sKeys.put("layout/settings_act_0", com.soundcode.chat.R.layout.settings_act);
      sKeys.put("layout/sign_in_act_0", com.soundcode.chat.R.layout.sign_in_act);
    }
  }
}
