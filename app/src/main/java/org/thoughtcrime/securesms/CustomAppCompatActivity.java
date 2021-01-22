package org.thoughtcrime.securesms;

import android.content.res.Resources;

import androidx.appcompat.app.AppCompatActivity;

/**
 * This activity exists to just override the default system-wide theme with a custom one
 * in order to enable changing accent colors. All classes that earlier extended from
 * `AppCompatActivity` now extend from this one.
 *
 * @author theGeekyLad
 */

public class CustomAppCompatActivity extends AppCompatActivity {

    @Override
    protected void onApplyThemeResource(Resources.Theme theme, int resid, boolean first) {
        super.onApplyThemeResource(theme, resid, first);
        if (AppCustomResources.initialize(getApplicationContext()))
            theme.applyStyle(AppCustomResources.getStyle(), true);
    }

}
