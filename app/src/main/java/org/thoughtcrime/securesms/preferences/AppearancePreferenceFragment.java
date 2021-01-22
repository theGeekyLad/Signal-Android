package org.thoughtcrime.securesms.preferences;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.preference.ListPreference;

import org.thoughtcrime.securesms.AppCustomResourceDefs;
import org.thoughtcrime.securesms.ApplicationPreferencesActivity;
import org.thoughtcrime.securesms.R;
import org.thoughtcrime.securesms.util.ActivityTransitionUtil;
import org.thoughtcrime.securesms.preferences.widgets.SignalListPreference;
import org.thoughtcrime.securesms.util.TextSecurePreferences;
import org.thoughtcrime.securesms.wallpaper.ChatWallpaperActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class AppearancePreferenceFragment extends ListSummaryPreferenceFragment {

  private static final String WALLPAPER_PREF = "pref_wallpaper";

  @Override
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);

    this.findPreference(TextSecurePreferences.THEME_PREF).setOnPreferenceChangeListener(new ListSummaryListener());
    this.findPreference(TextSecurePreferences.LANGUAGE_PREF).setOnPreferenceChangeListener(new ListSummaryListener());
    this.findPreference(TextSecurePreferences.ACCENT_PREF).setOnPreferenceChangeListener(new ListSummaryListener());
    this.findPreference(WALLPAPER_PREF).setOnPreferenceClickListener(preference -> {
      startActivity(ChatWallpaperActivity.createIntent(requireContext()));
      ActivityTransitionUtil.setSlideInTransition(requireActivity());
      return true;
    });
    initializeListSummary((ListPreference)findPreference(TextSecurePreferences.THEME_PREF));
    initializeListSummary((ListPreference)findPreference(TextSecurePreferences.LANGUAGE_PREF));
    initializeListSummary((ListPreference)findPreference(TextSecurePreferences.ACCENT_PREF));
  }

  @Override
  public void onCreatePreferences(@Nullable Bundle savedInstanceState, String rootKey) {
    addPreferencesFromResource(R.xml.preferences_appearance);
    getPreferenceScreen().addPreference(getAccentPreference());
  }

  @Override
  public void onStart() {
    super.onStart();
    getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener((ApplicationPreferencesActivity)getActivity());
  }

  @Override
  public void onResume() {
    super.onResume();
    ((ApplicationPreferencesActivity) getActivity()).getSupportActionBar().setTitle(R.string.preferences__appearance);
  }

  @Override
  public void onStop() {
    super.onStop();
    getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener((ApplicationPreferencesActivity) getActivity());
  }

  public static CharSequence getSummary(Context context) {
    String[] languageEntries     = context.getResources().getStringArray(R.array.language_entries);
    String[] languageEntryValues = context.getResources().getStringArray(R.array.language_values);
    String[] themeEntries        = context.getResources().getStringArray(R.array.pref_theme_entries);
    String[] themeEntryValues    = context.getResources().getStringArray(R.array.pref_theme_values);

    int langIndex  = Arrays.asList(languageEntryValues).indexOf(TextSecurePreferences.getLanguage(context));
    int themeIndex = Arrays.asList(themeEntryValues).indexOf(TextSecurePreferences.getTheme(context));

    if (langIndex == -1)  langIndex = 0;
    if (themeIndex == -1) themeIndex = 0;

    return context.getString(R.string.ApplicationPreferencesActivity_appearance_summary,
                             themeEntries[themeIndex],
                             languageEntries[langIndex]);
  }

  private SignalListPreference getAccentPreference() {
    SignalListPreference customAccentPreference = new SignalListPreference(getContext());
    customAccentPreference.setKey(TextSecurePreferences.ACCENT_PREF);
    customAccentPreference.setTitle(R.string.preferences__accent);
    ArrayList<String[]> accentEntriesValuesList = getAccentThemeEntries();
    customAccentPreference.setEntries(accentEntriesValuesList.get(0));
    customAccentPreference.setEntryValues(accentEntriesValuesList.get(1));
    return customAccentPreference;
  }

  public ArrayList<String[]> getAccentThemeEntries() {
    Map<String, Map<String, Integer>> customResources = AppCustomResourceDefs.getCustomResourceDefs();
    ArrayList<String[]> accentEntriesValuesList = new ArrayList<>();
    String[] accentThemeEntryValues = customResources.keySet().toArray(new String[] {});
    ArrayList<String> accentThemeEntriesList = new ArrayList<>();
    for (String accentThemeEntryValue : accentThemeEntryValues)
      accentThemeEntriesList.add(separateWordsWithSpace(accentThemeEntryValue));
    accentEntriesValuesList.add(accentThemeEntriesList.toArray(new String[] {}));
    accentEntriesValuesList.add(accentThemeEntryValues);
    return accentEntriesValuesList;
  }

  public static String separateWordsWithSpace(String text) {
    StringBuilder outputText = new StringBuilder();
    for (int i = 0; i < text.length(); i++) {
      char ch = text.charAt(i);
      if (Character.isUpperCase(ch) && i != 0)
        outputText.append(" ").append(ch);
      else
        outputText.append(ch);
    }
    return outputText.toString();
  }

}
