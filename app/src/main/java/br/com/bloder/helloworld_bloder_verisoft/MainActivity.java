package br.com.bloder.helloworld_bloder_verisoft;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import br.com.bloder.helloworld_bloder_verisoft.repo.ContentRepo;
import br.com.bloder.helloworld_bloder_verisoft.repo.values.Content;


@EActivity(R.layout.activity_main)
public class MainActivity extends ActionBarActivity{

    @ViewById(R.id.lst)
    ListView photoList;

    @AfterViews
    void afterViews(){
        insertData();
    }

    @ItemClick(R.id.lst)
    public void listClicked(int position){
        Intent intent = new Intent(getApplication(), DataActivity_.class);
        Content content = (Content) photoList.getAdapter().getItem(position);
        intent.putExtra("Nome", content.title);
        intent.putExtra("Views", String.valueOf(content.views));
        intent.putExtra("Image", content.photoUrl);
        startActivity(intent);
    }

    public void insertData(){
        List<Content> ContList = ContentRepo.fetchContent();
        ContentAdapter ContAdapter = new ContentAdapter(ContList, this);
        photoList.setAdapter(ContAdapter);
    }

}
