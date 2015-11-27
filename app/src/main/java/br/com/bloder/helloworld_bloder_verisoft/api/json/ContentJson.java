package br.com.bloder.helloworld_bloder_verisoft.api.json;

import com.google.gson.annotations.SerializedName;

/**
 * Created by denis on 26/11/15.
 */
public class ContentJson {

    @SerializedName("src") public String src;

    public ContentJson(String src) {
        this.src = src;
    }
}
