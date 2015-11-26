package br.com.bloder.helloworld_bloder_verisoft;

import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import br.com.bloder.helloworld_bloder_verisoft.Retrofit.DeviantartAPI;
import br.com.bloder.helloworld_bloder_verisoft.repo.values.DeviationList;


@EActivity(R.layout.activity_main)
public class MainActivity extends ActionBarActivity{

    @ViewById(R.id.lst)
    ListView photoList;

    @AfterViews
    void afterViews(){
        fetchPopularDeviations();
    }

  /*  @ItemClick(R.id.lst)
    public void listClicked(int position){
        Intent intent = new Intent(getApplication(), DataActivity_.class);
        Content content = (Content) photoList.getAdapter().getItem(position);
        intent.putExtra("Nome", content.title);
        intent.putExtra("Views", String.valueOf(content.views));
        intent.putExtra("Image", content.photoUrl);
        startActivity(intent);
    }*/

    @Background
    public void fetchPopularDeviations(){
        showPopularDeviations(DeviantartAPI.getServices().getPopularDeviations());
    }

    @UiThread
    protected void showPopularDeviations(DeviationList popularDeviations) {
       photoList.setAdapter(new ContentAdapter(popularDeviations.deviationList, getApplicationContext()));
    }

}
