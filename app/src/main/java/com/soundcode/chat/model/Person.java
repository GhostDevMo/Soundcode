package com.soundcode.chat.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.soundcode.chat.BR;

/**
 * Created by Muhammad Noamany on 23,December,2018
 */
public class Person extends BaseObservable {
    String myName;
    String myNumber;

    public Person(String myName, String myNumber) {
        this.myName = myName;
        this.myNumber = myNumber;
    }

    public Person() {
    }

@Bindable
    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
        notifyPropertyChanged(BR.myName);
    }
    @Bindable
    public String getMyNumber() {
        return myNumber;
    }

    public void setMyNumber(String myNumber) {
        this.myNumber = myNumber;
        notifyPropertyChanged(BR.myNumber);
    }
}
