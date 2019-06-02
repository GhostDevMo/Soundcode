package com.soundcode.chat.activities.settings.new_settings.profile_settings;

import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.soundcode.chat.R;
import com.soundcode.chat.activities.ProfilePhotoActivity;
import com.soundcode.chat.base.BaseAct;
import com.soundcode.chat.databinding.ProfileSettingsActBinding;
import com.soundcode.chat.utils.BitmapUtils;
import com.soundcode.chat.utils.CropImageRequest;
import com.soundcode.chat.utils.DirManager;
import com.soundcode.chat.utils.FireManager;
import com.soundcode.chat.utils.IntentUtils;
import com.soundcode.chat.utils.NetworkHelper;
import com.soundcode.chat.utils.SharedPreferencesManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.theartofdev.edmodo.cropper.CropImage;

import java.io.File;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileSettingsAct extends BaseAct {
    public static final int PICK_IMAGE_REQUEST = 4951;
    private ProfileSettingsActBinding binding;
    private CircleImageView imageViewUserProfile;
    private ImageButton imageButtonChangeUserProfile;
    private ImageButton imageButtonEditUsername;
    private TextView tvUsername;
    private TextView tvStatus;
    private TextView tvPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.profile_settings_act);
        setUpToolbar(binding.appBar.toolbar, R.drawable.ic_arrow_back, getString(R.string.profile_settings_toolbar_title));

        imageViewUserProfile = findViewById(R.id.image_view_user_profile);
        imageButtonChangeUserProfile = findViewById(R.id.image_button_change_user_profile);
        tvUsername = findViewById(R.id.tv_username);
        imageButtonEditUsername = findViewById(R.id.image_button_edit_username);
        tvStatus = findViewById(R.id.tv_status);
        tvPhoneNumber = findViewById(R.id.tv_phone_number);


        String userName = SharedPreferencesManager.getUserName();
        String status = SharedPreferencesManager.getStatus();
        String phoneNumber = SharedPreferencesManager.getPhoneNumber();
        final String myPhoto = SharedPreferencesManager.getMyPhoto();
        tvStatus.setText(status);
        tvUsername.setText(userName);
        tvPhoneNumber.setText(phoneNumber);


        imageViewUserProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileSettingsAct.this, ProfilePhotoActivity.class);
                String transName = "profile_photo_trans";

                intent.putExtra(IntentUtils.EXTRA_PROFILE_PATH, myPhoto);
                startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(ProfileSettingsAct.this, v, transName).toBundle());
            }
        });

        imageButtonChangeUserProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickImages();
            }
        });

        imageButtonEditUsername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEditTextDialog(getString(R.string.enter_your_name), new EditTextDialogListener() {
                    @Override
                    public void onOk(final String text) {
                        if (TextUtils.isEmpty(text)) {
                            Toast.makeText(ProfileSettingsAct.this, R.string.username_is_empty, Toast.LENGTH_SHORT).show();
                            return;
                        }

                        if (NetworkHelper.isConnected(ProfileSettingsAct.this)) {
                            FireManager.updateMyUserName(text, new FireManager.OnComplete() {
                                @Override
                                public void onComplete(boolean isSuccessful) {
                                    if (isSuccessful) {
                                        SharedPreferencesManager.saveMyUsername(text);
                                        tvUsername.setText(text);
                                    } else {
                                        Toast.makeText(ProfileSettingsAct.this, R.string.no_internet_connection, Toast.LENGTH_SHORT).show();

                                    }
                                }
                            });

                        } else {
                            Toast.makeText(ProfileSettingsAct.this, R.string.no_internet_connection, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        tvStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEditTextDialog(getString(R.string.enter_your_status), new EditTextDialogListener() {
                    @Override
                    public void onOk(final String text) {
                        if (TextUtils.isEmpty(text)) {
                            Toast.makeText(ProfileSettingsAct.this, R.string.status_is_empty, Toast.LENGTH_SHORT).show();
                            return;
                        }

                        if (NetworkHelper.isConnected(ProfileSettingsAct.this)) {
                            FireManager.updateMyStatus(text, new FireManager.OnComplete() {
                                @Override
                                public void onComplete(boolean isSuccessful) {
                                    if (isSuccessful) {

                                        SharedPreferencesManager.saveMyStatus(text);
                                        tvStatus.setText(text);
                                    } else {
                                        Toast.makeText(ProfileSettingsAct.this, R.string.no_internet_connection, Toast.LENGTH_SHORT).show();

                                    }
                                }
                            });

                        } else {
                            Toast.makeText(ProfileSettingsAct.this, R.string.no_internet_connection, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        Glide.with(this).load(Uri.fromFile(new File(myPhoto)))
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .into(imageViewUserProfile);

    }

    private void pickImages() {
        CropImageRequest.getCropImageRequest().start(this);
    }

    private void showEditTextDialog(String message, final EditTextDialogListener listener) {
        AlertDialog.Builder alert = new AlertDialog.Builder(ProfileSettingsAct.this);
        final EditText edittext = new EditText(ProfileSettingsAct.this);
        alert.setMessage(message);


        alert.setView(edittext);

        alert.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {


                if (listener != null)
                    listener.onOk(edittext.getText().toString());


            }
        });

        alert.setNegativeButton(R.string.cancel, null);

        alert.show();


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                Uri resultUri = result.getUri();


                final File file = DirManager.getMyPhotoPath();
                BitmapUtils.compressImage(resultUri.getPath(), file, 30);


                FireManager.updateMyPhoto(file.getPath(), new FireManager.OnComplete() {
                    @Override
                    public void onComplete(boolean isSuccessful) {
                        if (isSuccessful) {
                            try {
                                Glide.with(ProfileSettingsAct.this)
                                        .load(file)
                                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                                        .skipMemoryCache(true)
                                        .into(imageViewUserProfile);
                                Toast.makeText(ProfileSettingsAct.this, R.string.image_changed, Toast.LENGTH_SHORT).show();

                            } catch (Exception e) {
                                e.printStackTrace();
                            }


//

                        }
                    }
                });


            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }
    }

    private interface EditTextDialogListener {
        void onOk(String text);
    }

    public interface ImageSelectedListener {
        void onSelect(String imagePath);
    }

}
