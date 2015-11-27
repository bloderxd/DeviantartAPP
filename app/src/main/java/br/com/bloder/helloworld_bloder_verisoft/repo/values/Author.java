package br.com.bloder.helloworld_bloder_verisoft.repo.values;

import com.google.gson.annotations.SerializedName;

/**
 * Created by denis on 25/11/15.
 */
public class Author {

    @SerializedName("username") public String username;
    @SerializedName("usericon") public String usericon;

    public Author(String username, String usericon) {
        this.username = username;
        this.usericon = usericon;
    }
}
