package br.com.bloder.helloworld_bloder_verisoft.repo.values;

/**
 * Created by denis on 25/11/15.
 */
public class Deviation {

    public String title;
    public Author author;
    public Image image;

    public Deviation(String title, Author author, Image image) {
        this.title = title;
        this.author = author;
        this.image = image;
    }
}
