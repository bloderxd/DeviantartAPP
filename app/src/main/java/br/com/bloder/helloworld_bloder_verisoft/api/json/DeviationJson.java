package br.com.bloder.helloworld_bloder_verisoft.api.json;

import com.google.gson.annotations.SerializedName;

import br.com.bloder.helloworld_bloder_verisoft.values.Deviation;

public class DeviationJson {

    @SerializedName("title") private String title;
    @SerializedName("author") private AuthorJson author;
    @SerializedName("content") private ContentJson content;

    public DeviationJson(String title, AuthorJson author, ContentJson content) {
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public Deviation toDeviation() {
        return new Deviation(title, content.src, author.userName, author.userIcon);
    }
}
