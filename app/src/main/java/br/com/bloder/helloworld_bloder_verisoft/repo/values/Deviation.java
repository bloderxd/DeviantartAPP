package br.com.bloder.helloworld_bloder_verisoft.repo.values;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by denis on 25/11/15.
 */
public class Deviation {

    @SerializedName("title") public String title;
    @SerializedName("url") public String url;
    @SerializedName("author") public Author author;
    @SerializedName("thumbs") public final List<Thumbs> thumbs;
    @SerializedName("content") public Content content;

    public Deviation(List<Thumbs> thumbs, String title, String url, Author author, Content content) {
        this.thumbs = thumbs;
        this.title = title;
        this.url = url;
        this.author = author;
        this.content = content;
    }
}
