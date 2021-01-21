package org.thoughtcrime.securesms;

import android.content.Context;

import org.thoughtcrime.securesms.util.TextSecurePreferences;

import java.util.Map;

public class AppCustomResources {

    private final Map<String, Integer> customResources;
    private static AppCustomResources appCustomResources;
    private static String currTheme = AppCustomResourceDefs.DEFAULT_THEME;

    public AppCustomResources(String currTheme) {
        customResources = AppCustomResourceDefs.getCustomResourceDefs().get(currTheme);
    }

    public static boolean initialize(Context context) {
        if (appCustomResources == null) {
            currTheme = TextSecurePreferences.getStringPreference(context, TextSecurePreferences.ACCENT_PREF,  AppCustomResourceDefs.DEFAULT_THEME);
            appCustomResources = new AppCustomResources(currTheme);
        }
        return !currTheme.equals(AppCustomResourceDefs.DEFAULT_THEME);
    }

    private static Map<String, Integer> getCustomResources() {
        return appCustomResources.customResources;
    }

    public static int getStyle() {
        return getCustomResources().get("custom_theme");
    }

    public static int getAccentColorId() {
        return getCustomResources().get("custom_color");
    }

    public static int getLightThemeId() {
        return getCustomResources().get("custom_theme_base_light");
    }

    public static int getDarkThemeId() {
        return getCustomResources().get("custom_theme_base_dark");
    }
}
