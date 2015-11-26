package br.com.bloder.helloworld_bloder_verisoft.repo.values;

import com.google.gson.annotations.SerializedName;

/**
 * Created by denis on 17/11/15.
 */
public class Content {

    @SerializedName("src") public String src;

    public Content(String src) {
        this.src = src;
    }
}
