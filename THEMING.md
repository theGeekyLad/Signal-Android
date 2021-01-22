# _Guide:_ Creating Themes

If you're reading this and are driven to contribute new themes, you're awesome!

It's indeed a straightforward process to add new themes and all you need to know is the HEX value of your color of choice. This guide is all you need to create new themes that would be listed on the app appearance settings.

For illustration, I'm going to pick **deep purple: #651fff** as my color of choice. There are 4 files you're required to edit so let's get started!

```
!! DISCLAIMER !!

This process is as simple as changing the values in each of the sample blocks below, so if you're looking for something advanced then you're at the wrong place :D
```

## 1. `src/main/res/values/custom_colors.xml`

As you'd have guessed, here's where your color of choice and a few of its shades go. For my deep purple, here's what I have:

```XML
<!-- deep purple -->
<color name="custom_deep_purple">#651fff</color>
<color name="custom_deep_purple_light">#8F5BFF</color>
<color name="custom_deep_purple_dark">#3E08C8</color>
<color name="custom_deep_purple_33">#55651fff</color>
<color name="custom_deep_purple_50">#80651fff</color>
```

Just for the sake of it, I'm also going to call this theme _Deep Purple_ (very innovative).

_**Note:** For posterity, it's essential to include the name of your theme as a comment at the top of the lines you add across all files you edit._

## 2. `src/main/res/values/custom_light_themes.xml`

Here's where you'll put those colors into use: your **custom theme**. My _"DeepPurple"_ theme looks like so:

```XML
<!-- DeepPurple -->
<style name="DeepPurple">
    <item name="colorPrimary">@color/custom_deep_purple</item>
    <item name="colorPrimaryDark">@color/custom_deep_purple</item>
    <item name="colorAccent">@color/custom_deep_purple</item>
    <item name="colorAccentMedium">@color/custom_deep_purple</item>
    <item name="colorAccentLight">@color/custom_deep_purple_light</item>
    <item name="colorAccentDark">@color/custom_deep_purple_dark</item>
    <item name="colorAccent33">@color/custom_deep_purple_33</item>
    <item name="colorAccent50">@color/custom_deep_purple_50</item>
    <item name="colorControlActivated">@color/custom_deep_purple</item>
    <item name="colorControlHighlight">@color/custom_deep_purple</item>
    <item name="android:colorControlHighlight" tools:ignore="NewApi">@color/custom_deep_purple</item>
</style>
<style name="TextSecure.LightTheme.DeepPurple" parent="DeepPurple" />
```

_**Note:** The last style definition has the word "light" in it -> TextSecure.**Light**Theme.DeepPurple._

## 3. `src/main/res/values-night/custom_dark_themes.xml`

Quite intuitively, here's where the "dark theme" counterpart of your custom theme goes. In this section, ideally, you should use the lighter variant of your chosen color that goes best with dark backgrounds. Perhaps `colorAccent` could be `custom_deep_purple_light`? 

Nevertheless, I'm just going to paste the same definitions as my light theme above:

```XML
<!-- DeepPurple -->
<style name="DeepPurple">
    <item name="colorPrimary">@color/custom_deep_purple</item>
    <item name="colorPrimaryDark">@color/custom_deep_purple</item>
    <item name="colorAccent">@color/custom_deep_purple</item>
    <item name="colorAccentMedium">@color/custom_deep_purple</item>
    <item name="colorAccentLight">@color/custom_deep_purple_light</item>
    <item name="colorAccentDark">@color/custom_deep_purple_dark</item>
    <item name="colorAccent33">@color/custom_deep_purple_33</item>
    <item name="colorAccent50">@color/custom_deep_purple_50</item>
    <item name="colorControlActivated">@color/custom_deep_purple</item>
    <item name="colorControlHighlight">@color/custom_deep_purple</item>
    <item name="android:colorControlHighlight" tools:ignore="NewApi">@color/custom_deep_purple</item>
</style>
<style name="TextSecure.LightTheme.DeepPurple" parent="DeepPurple" />
```

_**Note:** The last style definition has the word "dark" in it -> TextSecure.**Dark**Theme.DeepPurple. Also, this section CANNOT be skipped._

## 4. `src/main/java/org/thoughtcrime/securesms/AppCustomResourceDefs.java`

As the name suggests, this is where all theme definitions go and here's where you make your theme discoverable to the app settings. My deep purple theme definition looks like so:

```Java
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
```

This section is what shows the _"Deep Purple"_ listing in the in-app accent picker.

_**Note:** Don't forget to replace "DeepPurple" with your theme name in the last line above -> customResources.put("**DeepPurple**", customResource);_

## Are we done yet?

Wait, you just built a new theme! Run the app with these changes and head over to, `Settings -> Appearance -> Accent` and you should see the theme you just created appear as an option. **Ensure you restart the app _(clear from recents too)_ to see the changes.**

Congrats! Would love to see what you've got.

---

With :heart: from `theGeekyLad`