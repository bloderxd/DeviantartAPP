package br.com.bloder.helloworld_bloder_verisoft.api.json;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bloder on 29/11/15.
 */
public class AccessTokenJson {

    @SerializedName("access_token") public final String access_token;

    public AccessTokenJson(String access_token) {
        this.access_token = access_token;
    }
}
