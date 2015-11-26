package br.com.bloder.helloworld_bloder_verisoft.repo.values;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by denis on 25/11/15.
 */
public class DeviationList {

   @SerializedName("results") public final List<Deviation> deviationList;

    public DeviationList(List<Deviation> deviationList) {
        this.deviationList = deviationList;
    }

}
