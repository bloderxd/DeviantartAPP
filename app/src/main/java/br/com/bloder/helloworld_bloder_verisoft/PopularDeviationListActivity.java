package br.com.bloder.helloworld_bloder_verisoft;

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
import br.com.bloder.helloworld_bloder_verisoft.details.DeviationDetailsActivity_;


@EActivity(R.layout.activity_main)
public class PopularDeviationListActivity extends ActionBarActivity{

    @ViewById(R.id.lst)
    protected ListView photoList;

    @AfterViews
    protected void afterViews(){
        fetchPopularDeviations();
    }

    @ItemClick(R.id.lst)
    protected void listClicked(int position){
        DeviationJson content = (DeviationJson) photoList.getAdapter().getItem(position);
        DeviationDetailsActivity_.intent(this)
                .userName(content.author.username)
                .userUrlImage(content.author.usericon)
                .deviationImageUrl(content.content.src)
                .deviationName(content.title)
                .start();
    }

    @Background
    protected void fetchPopularDeviations(){
        String AccessToken = DeviantartAPI.getAccessTokenServices().getAccessToken().access_token;
        showPopularDeviations(DeviantartAPI.getServices().getPopularDeviations(AccessToken));
    }

    @UiThread
    protected void showPopularDeviations(DeviationListJson popularDeviations) {
       photoList.setAdapter(new ContentAdapter(popularDeviations.deviationList, getApplicationContext()));
    }

}
