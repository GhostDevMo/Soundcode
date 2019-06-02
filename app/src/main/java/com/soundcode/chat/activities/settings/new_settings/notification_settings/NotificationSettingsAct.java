package com.soundcode.chat.activities.settings.new_settings.notification_settings;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.soundcode.chat.R;
import com.soundcode.chat.base.BaseAct;
import com.soundcode.chat.databinding.NotificationSettingsActBinding;
import com.soundcode.chat.utils.SharedPreferencesManager;

public class NotificationSettingsAct extends BaseAct {
    private static final int FILE_REQUEST_CODE = 123;
    private NotificationSettingsActBinding binding;
    private NotificationModel notificationModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.notification_settings_act);
        notificationModel = new NotificationModel();
        setUpToolbar(binding.appBar.toolbar, R.drawable.ic_arrow_back, getString(R.string.notification_settings_toolbar_title));
        notificationModel.setNotificationEnabled(SharedPreferencesManager.isNotificationEnabled());
        notificationModel.setIsvibrateEnabled(SharedPreferencesManager.isVibrateEnabled());
        binding.setModel(notificationModel);
        binding.vibrateSwitchButton.setChecked(SharedPreferencesManager.isVibrateEnabled());
        binding.notificationSwitchButton.setChecked(SharedPreferencesManager.isNotificationEnabled());
        binding.notificationSwitchButton.setOnCheckedChangeListener((view, isChecked) -> {
                    SharedPreferencesManager.setNotificationEnabled(isChecked);
                    notificationModel.setNotificationEnabled(isChecked);
                }

        );

        binding.vibrateSwitchButton.setOnCheckedChangeListener((view, isChecked) -> {
                    SharedPreferencesManager.setVibrateEnabled(isChecked);
                    notificationModel.setIsvibrateEnabled(isChecked);
                }

        );

    }

//    public void chooseRingtone(View view) {
////        Intent intent = new Intent(this, FilePickerActivity.class);
////        intent.putExtra(FilePickerActivity.CONFIGS, new Configurations.Builder()
////                .setCheckPermission(true)
////                .setShowAudios(true)
////                .setShowVideos(false)
////                .setShowFiles(false)
////                .setShowImages(false)
////                .setSingleChoiceMode(true)
////                .setMaxSelection(1)
////                .setSkipZeroSizeFiles(true)
////                .build());
////        startActivityForResult(intent, FILE_REQUEST_CODE);
////        new FilePicker.Builder(this, new OnSelectFileListener() {
////            @Override
////            public void onSelect(File file) {
////                SharedPreferencesManager.setRingtone(Uri.fromFile(new File(file.getPath())).toString());
////            }
////        })
////                .fileType(FileType.MUSIC)
////                .show();
//    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
////        if (resultCode == RESULT_OK) {
////            switch (requestCode) {
////                case FILE_REQUEST_CODE:
////                    ArrayList<MediaFile> files = data.getParcelableArrayListExtra(FilePickerActivity.MEDIA_FILES);
////                    //Do something with files
////                    SharedPreferencesManager.setRingtone(Uri.fromFile(new File(files.get(0).getPath())).toString());
////                    break;
////            }
////        }
//    }
}
