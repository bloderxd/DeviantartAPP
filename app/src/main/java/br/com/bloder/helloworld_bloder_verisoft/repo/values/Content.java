package br.com.bloder.helloworld_bloder_verisoft.repo.values;

/**
 * Created by denis on 17/11/15.
 */
public class Content {

    public final String title;
    public final String photoUrl;
    public final int views;

    public Content(String title, String photoUrl, int views) {
        this.title = title;
        this.photoUrl = photoUrl;
        this.views = views;
    }
}
