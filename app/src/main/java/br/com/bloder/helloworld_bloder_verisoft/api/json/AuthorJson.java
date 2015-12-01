package br.com.bloder.helloworld_bloder_verisoft.api.json;

import com.google.gson.annotations.SerializedName;

/**
 * Created by denis on 25/11/15.
 */
public class AuthorJson {

    @SerializedName("username") public String username;
    @SerializedName("usericon") public String usericon;

    public AuthorJson(String username, String usericon) {
        this.username = username;
        this.usericon = usericon;
    }

    public String usernameToDeviation(){
        return username;
    }

    public String usericonToDeviation(){
        return usericon;
    }
}
