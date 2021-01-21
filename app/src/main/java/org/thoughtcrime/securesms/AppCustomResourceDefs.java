package org.thoughtcrime.securesms;

import java.util.HashMap;
import java.util.Map;

public class AppCustomResourceDefs {

    public static final String DEFAULT_THEME = "DefaultTheme";

    private static AppCustomResourceDefs appCustomResourceDefs;
    private final Map<String, Map<String, Integer>> customResources = new HashMap<>();
    Map<String, Integer> customResource;

    public AppCustomResourceDefs() {

        // DefaultTheme
        customResource = new HashMap<>();
        customResource.put("custom_theme_base_light", R.style.TextSecure_LightTheme);
        customResource.put("custom_theme_base_dark", R.style.TextSecure_DarkTheme);
        customResource.put("custom_color", R.color.core_ultramarine);
        customResource.put("custom_color_light", R.color.core_ultramarine_light);
        customResource.put("custom_color_dark", R.color.core_ultramarine_dark);
        customResource.put("custom_color_33", R.color.core_ultramarine_33);
        customResource.put("custom_color_50", R.color.core_ultramarine_50);
        customResources.put(DEFAULT_THEME, customResource);

        // CrimsonRed
        customResource = new HashMap<>();
        customResource.put("custom_theme", R.style.CrimsonRed);
        customResource.put("custom_theme_base_light", R.style.TextSecure_LightTheme_CrimsonRed);
        customResource.put("custom_theme_base_dark", R.style.TextSecure_DarkTheme_CrimsonRed);
        customResource.put("custom_color", R.color.custom_crimson_red);
        customResource.put("custom_color_light", R.color.custom_crimson_red_light);
        customResource.put("custom_color_dark", R.color.custom_crimson_red_dark);
        customResource.put("custom_color_33", R.color.custom_crimson_red_33);
        customResource.put("custom_color_50", R.color.custom_crimson_red_50);
        customResources.put("CrimsonRed", customResource);

        // RadioactiveGreen
        customResource = new HashMap<>();
        customResource.put("custom_theme", R.style.RadioactiveGreen);
        customResource.put("custom_theme_base_light", R.style.TextSecure_LightTheme_RadioactiveGreen);
        customResource.put("custom_theme_base_dark", R.style.TextSecure_DarkTheme_RadioactiveGreen);
        customResource.put("custom_color", R.color.custom_radioactive_green);
        customResource.put("custom_color_light", R.color.custom_radioactive_green_light);
        customResource.put("custom_color_dark", R.color.custom_radioactive_green_dark);
        customResource.put("custom_color_33", R.color.custom_radioactive_green_33);
        customResource.put("custom_color_50", R.color.custom_radioactive_green_50);
        customResources.put("RadioactiveGreen", customResource);

        // SunnyYellow
        customResource = new HashMap<>();
        customResource.put("custom_theme", R.style.SunnyYellow);
        customResource.put("custom_theme_base_light", R.style.TextSecure_LightTheme_SunnyYellow);
        customResource.put("custom_theme_base_dark", R.style.TextSecure_DarkTheme_SunnyYellow);
        customResource.put("custom_color", R.color.custom_sunny_yellow);
        customResource.put("custom_color_light", R.color.custom_sunny_yellow_light);
        customResource.put("custom_color_dark", R.color.custom_sunny_yellow_dark);
        customResource.put("custom_color_33", R.color.custom_sunny_yellow_33);
        customResource.put("custom_color_50", R.color.custom_sunny_yellow_50);
        customResources.put("SunnyYellow", customResource);

        // DeepPurple
        customResource = new HashMap<>();
        customResource.put("custom_theme", R.style.DeepPurple);
        customResource.put("custom_theme_base_light", R.style.TextSecure_LightTheme_DeepPurple);
        customResource.put("custom_theme_base_dark", R.style.TextSecure_DarkTheme_DeepPurple);
        customResource.put("custom_color", R.color.custom_deep_purple);
        customResource.put("custom_color_light", R.color.custom_deep_purple_light);
        customResource.put("custom_color_dark", R.color.custom_deep_purple_dark);
        customResource.put("custom_color_33", R.color.custom_deep_purple_33);
        customResource.put("custom_color_50", R.color.custom_deep_purple_50);
        customResources.put("DeepPurple", customResource);

    }

    public static Map<String, Map<String, Integer>> getCustomResourceDefs() {
        if (appCustomResourceDefs == null) appCustomResourceDefs = new AppCustomResourceDefs();
        return appCustomResourceDefs.customResources;
    }
}
