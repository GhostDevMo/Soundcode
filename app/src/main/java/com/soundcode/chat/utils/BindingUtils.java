package com.soundcode.chat.utils;

import android.databinding.BindingAdapter;

import com.soundcode.chat.utils.custom_spinner.SearchableSpinner;

/**
 * Created by Muhammad Noamany on 03,February,2019
 */
public class BindingUtils {
    @BindingAdapter("bind:setSpinnerTitle")
    public static void setSpinnerTitle(SearchableSpinner view, String hint) {
        if (view != null) {
            view.setHintText(hint);
            view.setTitle(hint);
        }
    }

    @BindingAdapter("bind:setSpinnerPositiveBtn")
    public static void setSpinnerPositiveBtn(SearchableSpinner view, String string) {
        if (view != null)
            view.setPositiveButton(string);
    }

}
