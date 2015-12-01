package br.com.bloder.helloworld_bloder_verisoft;

import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import br.com.bloder.helloworld_bloder_verisoft.api.DeviantartAPI;
import br.com.bloder.helloworld_bloder_verisoft.api.json.DeviationListJson;
import br.com.bloder.helloworld_bloder_verisoft.details.DeviationDetailsActivity_;
import br.com.bloder.helloworld_bloder_verisoft.values.Deviation;
<<<<<<< HEAD
=======
import br.com.bloder.helloworld_bloder_verisoft.values.InsertDeviation;
>>>>>>> 27d8219759f57888278a9debaa9ec8aefb95e6c0


@EActivity(R.layout.activity_main)
public class PopularDeviationListActivity extends ActionBarActivity{

    @ViewById(R.id.lst)
    protected ListView photoList;

    @AfterViews
    protected void afterViews(){
        fetchPopularDeviations();
    }

    @ItemClick(R.id.lst)
<<<<<<< HEAD
    protected void listClicked(Deviation content){
        DeviationDetailsActivity_.intent(this)
                .userName(content.authorName)
                .userUrlImage(content.authorImageUrl)
                .deviationImageUrl(content.imageUrl)
                .deviationName(content.title)
=======
    protected void listClicked(int position){
        Deviation content = (Deviation) photoList.getAdapter().getItem(position);
        DeviationDetailsActivity_.intent(this)
                .userName(content.title)
                .userUrlImage(content.authorImageUrl)
                .deviationImageUrl(content.imageUrl)
                .deviationName(content.authorName)
>>>>>>> 27d8219759f57888278a9debaa9ec8aefb95e6c0
                .start();
    }

    @Background
    protected void fetchPopularDeviations(){
        String AccessToken = DeviantartAPI.getAccessTokenServices().getAccessToken().access_token;
        showPopularDeviations(DeviantartAPI.getServices().getPopularDeviations(AccessToken));
    }

    @UiThread
<<<<<<< HEAD
    protected void showPopularDeviations(DeviationListJson popularDeviations) {
        photoList.setAdapter(new ContentAdapter(popularDeviations.deviationList, getApplicationContext()));
=======
    protected void showPopularDeviations(DeviationListJson popularDeviations){
        List<Deviation> deviationList = new InsertDeviation().InsertDeviation(popularDeviations);
        photoList.setAdapter(new ContentAdapter(deviationList, getApplicationContext()));
>>>>>>> 27d8219759f57888278a9debaa9ec8aefb95e6c0
    }

}
