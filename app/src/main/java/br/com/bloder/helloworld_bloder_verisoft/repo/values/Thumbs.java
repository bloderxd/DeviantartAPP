package br.com.bloder.helloworld_bloder_verisoft.repo.values;

import com.google.gson.annotations.SerializedName;

/**
 * Created by denis on 26/11/15.
 */
public class Thumbs {

    @SerializedName("src") public String src;


    public Thumbs(String src) {
        this.src = src;
    }
}
