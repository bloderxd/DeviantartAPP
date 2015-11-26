package br.com.bloder.helloworld_bloder_verisoft.repo.values;

import com.google.gson.annotations.SerializedName;

/**
 * Created by denis on 25/11/15.
 */
public class Author {

    @SerializedName("username") public String username;

    public Author(String username) {
        this.username = username;
    }
}
