package com.soundcode.chat.activities.intro;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.soundcode.chat.R;
import com.soundcode.chat.activities.MainActivity;
import com.soundcode.chat.activities.SetupUserActivity;
import com.soundcode.chat.activities.authentication.SignInAct;
import com.soundcode.chat.utils.FireManager;
import com.soundcode.chat.utils.PermissionsUtil;
import com.soundcode.chat.utils.SharedPreferencesManager;

public class IntroAct extends AppCompatActivity {
    private static final int PERMISSION_REQUEST_CODE = 159;

    private void requestPermissions() {
        ActivityCompat.requestPermissions(this, PermissionsUtil.permissions, PERMISSION_REQUEST_CODE);
    }

    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.missing_permissions)
                .setMessage(R.string.you_have_to_grant_permissions)
                .setPositiveButton(R.string.ok, (dialogInterface, i) -> requestPermissions()).setNegativeButton(R.string.no_close_the_app,
                (dialogInterface, i) -> finish());
        builder.show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (PermissionsUtil.permissionsGranted(grantResults)) {
            if (!FireManager.isLoggedIn()) {
                startActivity(new Intent(this, SignInAct.class));
            } else
                startTheActivity();
        } else {
            showAlertDialog();
        }
    }

    private void startTheActivity() {
        if (SharedPreferencesManager.isUserInfoSaved()) {
            Intent intent = new Intent(IntroAct.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        } else {
            Intent intent = new Intent(IntroAct.this, SetupUserActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_act);
        if (FireManager.isLoggedIn()) startTheActivity();

    }

    public void openActivity(View view) {
        requestPermissions();
    }
}
