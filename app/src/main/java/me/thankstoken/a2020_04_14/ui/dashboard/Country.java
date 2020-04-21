package me.thankstoken.a2020_04_14.ui.dashboard;

import androidx.annotation.NonNull;

public class Country {

    public String name;
    public String capital;

    public Country() {
    }

    public Country(String name, String capital) {
        this.name = name;
        this.capital = capital;
    }

    @NonNull
    @Override
    public String toString() {
        return "name: " + name + "  |  capital: " + capital;
    }
}
