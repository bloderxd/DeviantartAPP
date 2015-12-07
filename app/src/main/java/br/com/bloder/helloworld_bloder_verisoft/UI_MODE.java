package br.com.bloder.helloworld_bloder_verisoft;

import br.com.bloder.helloworld_bloder_verisoft.preferences.UiModePrefs_;

public enum UI_MODE {
    SIMPLE,
    COMPLEX;

    public static void switchMode(UiModePrefs_ prefs) {
        prefs.edit()
                .mode()
                .put(current(prefs) == UI_MODE.SIMPLE ? UI_MODE.COMPLEX.ordinal() : UI_MODE.SIMPLE.ordinal())
                .apply();
    }

    public static UI_MODE current(UiModePrefs_ prefs) {
        return UI_MODE.values()[prefs.mode().get()];
    }
}
