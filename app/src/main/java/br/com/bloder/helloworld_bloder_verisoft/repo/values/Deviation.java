package br.com.bloder.helloworld_bloder_verisoft.repo.values;

/**
 * Created by denis on 25/11/15.
 */
public class Deviation {

    public String title;
    public Author author;
    public Image content;

    public Deviation(String title, Author author, Image content) {
        this.title = title;
        this.author = author;
        this.content = content;
    }
}
