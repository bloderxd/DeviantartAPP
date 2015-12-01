package br.com.bloder.helloworld_bloder_verisoft.api.json;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bloder on 29/11/15.
 */
public class AccessTokenJson {

    @SerializedName("access_token") public final String accessToken;

    public AccessTokenJson(String accessToken) {
        this.accessToken = accessToken;
    }
}
