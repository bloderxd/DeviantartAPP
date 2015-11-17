package br.com.bloder.helloworld_bloder_verisoft.repo;

import java.util.ArrayList;
import java.util.List;

import br.com.bloder.helloworld_bloder_verisoft.repo.values.Content;

public class ContentRepo {

    public List<Content> fetchContent() {
        List<Content> list = new ArrayList();
        for (int i = 0; i < 20; i++) list.add(newContent());
        return list;
    }

    private Content newContent() {
        return new Content("This is a content", "", 200);
    }
}
