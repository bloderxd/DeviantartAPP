package br.com.bloder.helloworld_bloder_verisoft.api.json;

import com.google.gson.annotations.SerializedName;

import br.com.bloder.helloworld_bloder_verisoft.api.json.AuthorJson;
import br.com.bloder.helloworld_bloder_verisoft.api.json.ContentJson;

/**
 * Created by denis on 25/11/15.
 */
public class DeviationJson {

    @SerializedName("title") public String title;
    @SerializedName("url") public String url;
    @SerializedName("author") public AuthorJson author;
    @SerializedName("content") public ContentJson content;

    public DeviationJson(String title, String url, AuthorJson author, ContentJson content) {
        this.title = title;
        this.url = url;
        this.author = author;
        this.content = content;
    }
}
