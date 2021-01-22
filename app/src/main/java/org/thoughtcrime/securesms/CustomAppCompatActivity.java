package org.thoughtcrime.securesms;

import android.content.res.Resources;

import androidx.appcompat.app.AppCompatActivity;

public class CustomAppCompatActivity extends AppCompatActivity {

    @Override
    protected void onApplyThemeResource(Resources.Theme theme, int resid, boolean first) {
        super.onApplyThemeResource(theme, resid, first);
        if (AppCustomResources.initialize(getApplicationContext()))
            theme.applyStyle(AppCustomResources.getStyle(), true);
    }

}
