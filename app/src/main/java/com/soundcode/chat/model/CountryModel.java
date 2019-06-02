package com.soundcode.chat.model;

/**
 * Created by Muhammad Noamany on 03,February,2019
 */
public class CountryModel {
    private String code, countryName;

    public CountryModel(String countryName, String code) {
        this.code = code;
        this.countryName = countryName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
