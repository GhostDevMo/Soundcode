package com.soundcode.chat.activities.authentication;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.soundcode.chat.R;
import com.soundcode.chat.databinding.SignInActBinding;
import com.soundcode.chat.model.CountryModel;
import com.soundcode.chat.utils.Constants;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.kaopiz.kprogresshud.KProgressHUD;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignInAct extends AppCompatActivity {
    private SignInActBinding binding;
    private ArrayList<CountryModel> modelList;
    private String phoneNumber;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
    private KProgressHUD progressHUD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.sign_in_act);
        setAdapterCodesOfCountries();
        setCallBackOfPhoneAuth();
    }

    private void setCallBackOfPhoneAuth() {
        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                Toast.makeText(SignInAct.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                progressHUD.dismiss();


            }

            @Override
            public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                progressHUD.dismiss();
                PhoneVerifyAct.start(SignInAct.this, s, phoneNumber);

            }

            @Override
            public void onCodeAutoRetrievalTimeOut(String s) {
                super.onCodeAutoRetrievalTimeOut(s);
            }
        };
    }

    private void setAdapterCodesOfCountries() {
        JSONObject root = null;
        List<String> countryWithCodeText = new ArrayList<>();
        modelList = new ArrayList<>();
        try {
            root = new JSONObject(Constants.countriesWithCodes);
            JSONArray array = root.getJSONArray("countries");
            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
                modelList.add(new CountryModel(object.getString("name"), object.getString("code")));
                countryWithCodeText.add(object.getString("name") + "  " + object.getString("code"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ArrayAdapter<String> namesAA = new ArrayAdapter<String>(this, R.layout.spinner_list_item, countryWithCodeText);
        namesAA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinner.spinner.setAdapter(namesAA);
    }

    public void sendOtp(View view) {
        for (int i = 0; i < modelList.size(); i++) {
            if (binding.spinner.spinner.getSelectedItem() != null && binding.spinner.spinner.getSelectedItem().toString().contains(modelList.get(i).getCode())) {
                StringBuilder builder = new StringBuilder();
                builder.append(modelList.get(i).getCode());
                builder.append(binding.phoneNumberEditText.getText().toString().trim());
                phoneNumber = builder.toString();
            }
        }
        if (phoneNumber != null && isValidPhone(phoneNumber)) {
            handleSendOtp();

        } else {
            Toast.makeText(this, "please enter valid phone number", Toast.LENGTH_SHORT).show();
        }
    }

    private void handleSendOtp() {
        progressHUD = KProgressHUD.create(SignInAct.this)
                .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setLabel("Please wait")
                .setDetailsLabel("sending otp ...")
                .setCancellable(false)
                .setAnimationSpeed(2)
                .setDimAmount(0.5f)
                .show();
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phoneNumber,
                60,
                TimeUnit.SECONDS,
                this,
                mCallbacks);
    }


    private boolean isValidPhone(String phoneNum) {
        String regex = "^\\+(?:[0-9] ?){6,14}[0-9]$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNum);
        return matcher.matches();
    }
}
