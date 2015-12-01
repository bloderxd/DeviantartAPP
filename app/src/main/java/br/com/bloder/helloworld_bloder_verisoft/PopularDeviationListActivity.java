package br.com.bloder.helloworld_bloder_verisoft;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.util.List;

import br.com.bloder.helloworld_bloder_verisoft.api.DeviantartAPI;
import br.com.bloder.helloworld_bloder_verisoft.api.json.DeviationListJson;
import br.com.bloder.helloworld_bloder_verisoft.values.Deviation;
import br.com.bloder.helloworld_bloder_verisoft.values.InsertDeviation;


@EActivity(R.layout.activity_main)
public class PopularDeviationListActivity extends ActionBarActivity{

    @ViewById(R.id.lst)
    protected RecyclerView photoList;

    @AfterViews
    protected void afterViews(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        photoList.setLayoutManager(layoutManager);
        fetchPopularDeviations();
    }

    /*@ItemClick(R.id.lst)
    protected void listClicked(Deviation content) {
        DeviationDetailsActivity_.intent(this)
                .userName(content.authorName)
                .userUrlImage(content.authorImageUrl)
                .deviationImageUrl(content.imageUrl)
                .deviationName(content.title)
                .start();
        }*/

        @Background
        protected void fetchPopularDeviations () {
            String AccessToken = DeviantartAPI.getAccessTokenServices().getAccessToken().access_token;
            showPopularDeviations(DeviantartAPI.getServices().getPopularDeviations(AccessToken));
        }

        @UiThread
        protected void showPopularDeviations (DeviationListJson popularDeviations){
            try {
                List<Deviation> deviationList = new InsertDeviation().InsertDeviation(popularDeviations);
                photoList.setAdapter(new DeviationListAdapter(deviationList,getApplicationContext()));
            }catch (Exception ex){

            }
        }
}
