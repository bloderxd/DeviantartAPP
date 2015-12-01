package br.com.bloder.helloworld_bloder_verisoft.api.json;

import com.google.gson.annotations.SerializedName;

public class AuthorJson {

    @SerializedName("userName") public String userName;
    @SerializedName("usericon") public String userIcon;

    public AuthorJson(String username, String usericon) {
        this.userName = username;
        this.userIcon = usericon;
    }

}
