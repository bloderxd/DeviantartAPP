package br.com.bloder.helloworld_bloder_verisoft.repo.values;

import com.google.gson.annotations.SerializedName;

/**
 * Created by denis on 25/11/15.
 */
public class Deviation {

    @SerializedName("title") public String title;
    @SerializedName("url") public String url;
    @SerializedName("author") public Author author;
    @SerializedName("content") public Content content;

    public Deviation(String title, Author author, Content content) {
        this.title = title;
        this.author = author;
        this.content = content;
    }
}
