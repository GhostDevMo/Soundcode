package com.soundcode.chat.activities.authentication;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.soundcode.chat.R;
import com.soundcode.chat.activities.MainActivity;
import com.soundcode.chat.activities.SetupUserActivity;
import com.soundcode.chat.databinding.PhoneVerifiyActBinding;
import com.soundcode.chat.utils.SharedPreferencesManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.kaopiz.kprogresshud.KProgressHUD;

public class PhoneVerifyAct extends AppCompatActivity {
    private PhoneVerifiyActBinding binding;
    private VerifyModel model;
    private String phoneCredentials, phoneNumber;
    private String otp;
    private FirebaseAuth mAuth;
    private KProgressHUD progressHUD;


    public static void start(SignInAct context, String credentials, String phoneNumber) {
        Intent i = new Intent(context, PhoneVerifyAct.class);
        i.putExtra("CREDENTIALS", credentials);
        i.putExtra("phoneNumber", phoneNumber);
        context.startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkExtras();
        binding = DataBindingUtil.setContentView(this, R.layout.phone_verifiy_act);
        model = new VerifyModel();
        model.setPhoneNumber(phoneNumber);
        binding.setModel(model);
        mAuth = FirebaseAuth.getInstance();
        listenToOtp();
    }

    private void listenToOtp() {
        binding.editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                model.setFinishedTyping1(false);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 1) model.setFinishedTyping1(true);
                else model.setFinishedTyping1(false);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                model.setFinishedTyping2(false);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 1) model.setFinishedTyping2(true);
                else model.setFinishedTyping2(false);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.editText3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                model.setFinishedTyping3(false);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 1) model.setFinishedTyping3(true);
                else model.setFinishedTyping3(false);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.editText4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                model.setFinishedTyping4(false);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 1) model.setFinishedTyping4(true);
                else model.setFinishedTyping4(false);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        binding.editText5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                model.setFinishedTyping5(false);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 1) model.setFinishedTyping5(true);
                else model.setFinishedTyping5(false);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        binding.editText6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                model.setFinishedTyping6(false);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 1) model.setFinishedTyping6(true);
                else model.setFinishedTyping6(false);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    private void checkExtras() {
        phoneCredentials = getIntent().getStringExtra("CREDENTIALS");
        phoneNumber = getIntent().getStringExtra("phoneNumber");
    }

    public void verifyPhone(View view) {
        if (phoneCredentials != null)
            signInPhone(phoneCredentials);
    }

    private void signInPhone(String phoneCredentials) {
        if (!correctOtpFormat())
            return;
        progressHUD = KProgressHUD.create(PhoneVerifyAct.this)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setLabel("Please wait")
                .setDetailsLabel("verifying phone ...")
                .setCancellable(false)
                .setAnimationSpeed(2)
                .setDimAmount(0.5f)
                .show();
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(phoneCredentials, otp);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        if (progressHUD.isShowing())
                            progressHUD.dismiss();
                        startTheActivity();
                    } else {
                        if (progressHUD.isShowing())
                            progressHUD.dismiss();
                        Toast.makeText(PhoneVerifyAct.this, "signInWithCredential:failure --> " + task.getException(), Toast.LENGTH_SHORT).show();

                        if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                            if (progressHUD.isShowing())
                                progressHUD.dismiss();
                            Toast.makeText(PhoneVerifyAct.this, "you entered invalid otp code", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


    private boolean correctOtpFormat() {
        StringBuilder builder = new StringBuilder();
        builder.append(binding.editText1.getText().toString().trim());
        builder.append(binding.editText2.getText().toString().trim());
        builder.append(binding.editText3.getText().toString().trim());
        builder.append(binding.editText4.getText().toString().trim());
        builder.append(binding.editText5.getText().toString().trim());
        builder.append(binding.editText6.getText().toString().trim());
        otp = builder.toString();
        if (!model.getFinishedTyping1() && !model.getFinishedTyping2() && !model.getFinishedTyping3() && !model.getFinishedTyping4() && !model.getFinishedTyping5() && !model.getFinishedTyping6() && otp.trim().length() < 6) {
            Toast.makeText(this, "Please enter otp in correct format", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

    private void startTheActivity() {
        if (SharedPreferencesManager.isUserInfoSaved()) {
            Intent intent = new Intent(PhoneVerifyAct.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        } else {
            Intent intent = new Intent(PhoneVerifyAct.this, SetupUserActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        }
    }
}
