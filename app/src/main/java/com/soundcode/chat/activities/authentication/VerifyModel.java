package com.soundcode.chat.activities.authentication;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.soundcode.chat.BR;

/**
 * Created by Muhammad Noamany on 02,February,2019
 */
public class VerifyModel extends BaseObservable {

    private Boolean isFinishedTyping1, isFinishedTyping2, isFinishedTyping3, isFinishedTyping4, isFinishedTyping5, isFinishedTyping6;
    private String phoneNumber;

    @Bindable
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        notifyPropertyChanged(BR.phoneNumber);
    }

    @Bindable
    public Boolean getFinishedTyping5() {
        return isFinishedTyping5;
    }

    public void setFinishedTyping5(Boolean finishedTyping5) {
        isFinishedTyping5 = finishedTyping5;
        notifyPropertyChanged(BR.finishedTyping5);
    }

    @Bindable
    public Boolean getFinishedTyping6() {
        return isFinishedTyping6;
    }

    public void setFinishedTyping6(Boolean finishedTyping6) {
        isFinishedTyping6 = finishedTyping6;
        notifyPropertyChanged(BR.finishedTyping6);
    }

    @Bindable
    public Boolean getFinishedTyping1() {
        return isFinishedTyping1;
    }

    public void setFinishedTyping1(Boolean finishedTyping) {
        isFinishedTyping1 = finishedTyping;
        notifyPropertyChanged(BR.finishedTyping1);
    }

    @Bindable
    public Boolean getFinishedTyping2() {
        return isFinishedTyping2;
    }

    public void setFinishedTyping2(Boolean finishedTyping) {
        isFinishedTyping2 = finishedTyping;
        notifyPropertyChanged(BR.finishedTyping2);
    }

    @Bindable
    public Boolean getFinishedTyping3() {
        return isFinishedTyping3;
    }

    public void setFinishedTyping3(Boolean finishedTyping) {
        isFinishedTyping3 = finishedTyping;
        notifyPropertyChanged(BR.finishedTyping3);
    }

    @Bindable
    public Boolean getFinishedTyping4() {
        return isFinishedTyping4;
    }

    public void setFinishedTyping4(Boolean finishedTyping) {
        isFinishedTyping4 = finishedTyping;
        notifyPropertyChanged(BR.finishedTyping4);
    }
}
