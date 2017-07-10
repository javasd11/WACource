package com.example.classwork11;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;
import android.support.annotation.Nullable;

/**
 * Created by ReznichenkoV on 08.07.2017.
 */

public class PrefActivity extends PreferenceActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref);

        PreferenceScreen screen = getPreferenceScreen();
        Preference pref = getPreferenceManager().findPreference("check_box_preference_2");
        screen.removePreference(pref);
    }

}
