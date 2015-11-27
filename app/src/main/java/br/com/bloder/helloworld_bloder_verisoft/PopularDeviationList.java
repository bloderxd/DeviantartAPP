package br.com.bloder.helloworld_bloder_verisoft;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import br.com.bloder.helloworld_bloder_verisoft.api.DeviantartAPI;
import br.com.bloder.helloworld_bloder_verisoft.api.json.DeviationJson;
import br.com.bloder.helloworld_bloder_verisoft.api.json.DeviationListJson;
import br.com.bloder.helloworld_bloder_verisoft.details.PopularDeviation_;


@EActivity(R.layout.activity_main)
public class PopularDeviationList extends ActionBarActivity{

    @ViewById(R.id.lst)
    protected ListView photoList;

    @AfterViews
    protected void afterViews(){
        fetchPopularDeviations();
    }

    @ItemClick(R.id.lst)
    protected void listClicked(int position){
        Intent intent = new Intent(getApplication(), PopularDeviation_.class);
        DeviationJson content = (DeviationJson) photoList.getAdapter().getItem(position);
        intent.putExtra("Nome", content.title);
        intent.putExtra("Views", String.valueOf(content.author.username));
        intent.putExtra("Image", content.content.src);
        startActivity(intent);
    }

    @Background
    protected void fetchPopularDeviations(){
        showPopularDeviations(DeviantartAPI.getServices().getPopularDeviations());
    }

    @UiThread
    protected void showPopularDeviations(DeviationListJson popularDeviations) {
       photoList.setAdapter(new ContentAdapter(popularDeviations.deviationList, getApplicationContext()));
    }

}
