package br.com.bloder.helloworld_bloder_verisoft.preferences;

import org.androidannotations.annotations.sharedpreferences.DefaultInt;
import org.androidannotations.annotations.sharedpreferences.SharedPref;

@SharedPref(SharedPref.Scope.APPLICATION_DEFAULT)
public interface UiModePrefs {

    @DefaultInt(0) int mode();

}
